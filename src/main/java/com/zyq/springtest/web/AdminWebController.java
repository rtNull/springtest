package com.zyq.springtest.web;

import com.zyq.springtest.bean.*;
import com.zyq.springtest.dto.CommentPair;
import com.zyq.springtest.dto.CoursePair;
import com.zyq.springtest.service.*;
import com.zyq.springtest.util.FileUtil;
import com.zyq.springtest.util.IPTimeStamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhanyq on 2017/3/30.
 */
@Controller
@RequestMapping("/adminweb")
public class AdminWebController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * /adminweb/showlogin
     *
     * @return
     */
    @RequestMapping(value = "/showlogin")
    public String showLogin() {
        return "adminweb/showlogin";
    }

    /**
     * /adminweb/accessdeny
     *
     * @return
     */
    @RequestMapping(value = "/accessdeny")
    public String accessDeny() {
        return "adminweb/accessdeny";
    }

    /**
     * /adminweb/accessdeny
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(User user, HttpSession httpSession) {
        //判断登录身份
        logger.info(user.toString());
        user = userService.adminLogin(user);
        if (user != null) {
            httpSession.setAttribute("user", user);
            return "redirect:/adminweb/main";
        } else {
            httpSession.invalidate();
            return "redirect:/adminweb/showlogin";
        }
    }

    @RequestMapping(value = "/main")
    public String mainPage() {
        return "adminweb/main";
    }


    @RequestMapping(value = "/topbar")
    public String showTopBar() {
        return "adminweb/topbar";
    }

    @RequestMapping(value = "/leftmenu")
    public String showLeftMenu(HttpSession httpSession) {
        return "adminweb/leftmenu";
    }

    @RequestMapping(value = "/mycourse")
    public String myCourse(HttpSession httpSession, Model model) {
        //判断登录身份
        User user = (User) httpSession.getAttribute("user");
        List<Course> courseList = courseService.selectBySelective(new Course(null, user.getId(), null));
        List<CoursePair> coursePairList = new ArrayList<CoursePair>();
        if (courseList != null) {
            for (Course course :
                    courseList) {
                Subject subject = subjectService.selectByPrimaryKey(course.getSubjectId());
                CoursePair coursePair = new CoursePair(subject, course, user);
                coursePairList.add(coursePair);
            }
            model.addAttribute("coursePairList", coursePairList);
        }

        return "adminweb/mycourse";
    }

    @RequestMapping(value = "/deletecourse")
    public String deleteCourse(Integer id) {
        List<Chapter> chapterList = chapterService.selectByCourseId(id);
        if (chapterList != null) {
            for (Chapter chapter :
                    chapterList) {
                logger.info(resourceService.deleteByChapterId(chapter.getId()) + "");
                questionService.deleteByChapterId(chapter.getId());
            }
        }
        chapterService.deleteByCourseId(id);
        courseService.deleteCourseById(id);
        return "redirect:/adminweb/mycourse";
    }

    @RequestMapping(value = "/showaddcourse")
    public String showAddCourse(Model model) {
        //添加课程
        List<Subject> subjectList = subjectService.selectAll();
        model.addAttribute("subjectList", subjectList);
        return "adminweb/showaddcourse";
    }

    /**
     * 添加课程
     *
     * @param course
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/addcourse")
    public String addCourse(Course course, HttpSession httpSession) {
        //添加课程
        course.setUserId(((User) httpSession.getAttribute("user")).getId());
        courseService.addCourse(course);
        return "redirect:/adminweb/mycourse";
    }

    /**
     * 课程详情界面，展示所有章节
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/coursedetail")
    public String courseDetail(Integer id, Model model) {
        //展示所有章节
        Course course = courseService.selectById(id);
        List<Chapter> chapterList = chapterService.selectByCourseId(id);
        model.addAttribute("course", course);
        model.addAttribute("chapterList", chapterList);
        return "adminweb/coursedetail";
    }


    /**
     * 课程评论
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/coursecomment")
    public String courseComment(Integer id, Model model) {
        Course course = courseService.selectById(id);
        List<Comment> commentList = commentService.selectBySelective(new Comment(id, null, null, null));
        if (commentList != null && commentList.size() > 0) {
            List<CommentPair> commentPairList = new ArrayList<CommentPair>();
            for (Comment comment :
                    commentList) {
                User user = userService.selectByPrimaryKey(comment.getUserId());
                CommentPair commentPair = new CommentPair(user, comment);
                commentPairList.add(commentPair);
            }
            model.addAttribute("commentPairList", commentPairList);
        }
        model.addAttribute("course", course);
        return "adminweb/coursecomment";
    }

    @RequestMapping(value = "/showreplycomment")
    public String showReplyComment(Integer id, Model model) {
        //添加课程
        Comment comment = commentService.selectById(id);
        User user = userService.selectByPrimaryKey(comment.getUserId());
        model.addAttribute("comment", comment);
        model.addAttribute("user", user);
        return "adminweb/showreplycomment";
    }

    @RequestMapping(value = "/addcomment")
    public String addComment(Comment comment, HttpSession httpSession) {
        //添加课程
        User user = (User) httpSession.getAttribute("user");
        if (comment.getToUserId()!= null) {
            comment.setReaded(false);
        } else {
            comment.setReaded(true);
        }
        comment.setUserId(user.getId());
        comment.setCommentTime(new Date());
        commentService.addComment(comment);
        return "redirect:/adminweb/coursecomment?id=" + comment.getCourseId();
    }

    @RequestMapping(value = "/deletecomment")
    public String deleteComment(Integer id, Integer courseId) {
        //添加课程
        commentService.deleteById(id);
        return "redirect:/adminweb/coursecomment?id=" + courseId;
    }

    /**
     * 展示课程修改界面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/showeditcourse")
    public String showEditCourse(Integer id, Model model) {
        Course course = courseService.selectById(id);
        model.addAttribute("course", course);
        //添加课程
        List<Subject> subjectList = subjectService.selectAll();
        model.addAttribute("subjectList", subjectList);
        return "adminweb/showeditcourse";
    }

    /**
     * 修改课程
     *
     * @param course
     * @return
     */
    @RequestMapping(value = "/editcourse")
    public String editCourse(Course course) {
        courseService.updateByPrimaryKeySelective(course);
        return "redirect:/adminweb/mycourse";
    }


    @RequestMapping(value = "/showaddchapter")
    public String showAddChapter(Integer id, Model model) {
        //添加课程
        Course course = courseService.selectById(id);
        logger.info(course.toString());
        model.addAttribute("course", course);
        return "adminweb/showaddchapter";
    }

    @RequestMapping(value = "/addchapter")
    public String addChapter(Chapter chapter) {
        //添加课程
        chapter.setCreateDate(new Date());
        chapterService.addChapter(chapter);
        return "redirect:/adminweb/coursedetail?id=" + chapter.getCourseId();
    }

    @RequestMapping(value = "/showeditchapter")
    public String showEditChapter(Integer id, Model model) {
        Chapter chapter = chapterService.selectById(id);
        Course course = courseService.selectById(chapter.getCourseId());
        model.addAttribute("chapter", chapter);
        model.addAttribute("course", course);
        return "adminweb/showeditchapter";
    }

    /**
     * 修改章节
     *
     * @param chapter
     * @return
     */
    @RequestMapping(value = "/editchapter")
    public String editChapter(Chapter chapter) {
        chapterService.updateByPrimaryKeySelective(chapter);
        return "redirect:/adminweb/coursedetail?id=" + chapter.getCourseId();
    }

    @RequestMapping(value = "/deletechapter")
    public String deleteChapter(Integer id, Integer courseId) {
        resourceService.deleteByChapterId(id);
        questionService.deleteByChapterId(id);
        chapterService.deleteById(id);
        return "redirect:/adminweb/coursedetail?id=" + courseId;
    }

    @RequestMapping(value = "/chapterdetail")
    public String chapterDetail(Integer id, Model model) {
        List<Resource> resourceList = resourceService.selectBySelective(new Resource(id, null));
        List<Question> questionList = questionService.selectByChapterId(id);
        Chapter chapter = chapterService.selectById(id);
        model.addAttribute("chapter", chapter);
        model.addAttribute("resourceList", resourceList);
        model.addAttribute("questionList", questionList);
        return "adminweb/chapterdetail";
    }

    @RequestMapping(value = "/showaddresource")
    public String showAddResource(Integer id, Model model) {
        Chapter chapter = chapterService.selectById(id);
        model.addAttribute("chapter", chapter);
        return "adminweb/showaddresource";
    }

    @RequestMapping(value = "/addresource")
    public String addResource(@RequestParam MultipartFile[] file, Integer chapterId, String name, HttpServletRequest request) {
        //得到服务器项目发布运行所在地址
        String pathDir = request.getSession().getServletContext().getRealPath("resources");
        File fileDir = new File(pathDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        List<String> urlList = new ArrayList<String>();
        for (MultipartFile multipartFile : file) {
            //此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了
            if (multipartFile.isEmpty()) {
                logger.info("文件未上传!");
            } else {
                //得到上传的文件名
                String fileName = multipartFile.getOriginalFilename();
                String fileExtension = FileUtil.getExtensionName(fileName);
                String serverFileName = new IPTimeStamp().getIPTimeRand()
                        + "." + fileExtension;
                //  此处未使用UUID来生成唯一标识,用日期做为标识
                String path = pathDir + File.separator
                        + serverFileName;
                //查看文件上传路径,方便查找
                logger.info(path);
                logger.info(fileName);
                //把文件上传至path的路径
                File localFile = new File(path);
                try {
                    multipartFile.transferTo(localFile);
                    Resource resource = null;
                    if (name != null && !name.equals("")) {
                        resource = new Resource(chapterId, name, fileExtension, new Date(),
                                "resources/" + serverFileName);
                    } else {
                        resource = new Resource(chapterId, FileUtil.getPrefixion(fileName), fileExtension, new Date(),
                                "resources/" + serverFileName);
                    }
                    if (resourceService.addResource(resource) > 0) {
                        //添加成功
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                urlList.add(path);
            }
        }
        return "redirect:/adminweb/chapterdetail?id=" + chapterId;
    }

    @RequestMapping(value = "/deleteresource")
    public String deleteResource(Integer id, Model model) {
        Resource resource = resourceService.selectById(id);
        resourceService.deleteById(id);
        return "redirect:/adminweb/chapterdetail?id=" + resource.getChapterId();
    }

    @RequestMapping(value = "/showaddquestion")
    public String showAddQuestion(Integer id, Model model) {
        Chapter chapter = chapterService.selectById(id);
        model.addAttribute("chapter", chapter);
        return "adminweb/showaddquestion";
    }

    @RequestMapping(value = "/addquestion")
    public String addQuestion(Question question) {
        //添加课程
        logger.info(question.toString());
        questionService.addQuestion(question);
        return "redirect:/adminweb/chapterdetail?id=" + question.getChapterId();
    }


    @RequestMapping(value = "/deletequestion")
    public String deleteQuestion(Integer id, Integer chapterId) {
        questionService.deleteById(id);
        return "redirect:/adminweb/chapterdetail?id=" + chapterId;
    }

    @RequestMapping(value = "/showeditquestion")
    public String showEditQuestion(Integer id, Model model) {
        Question question = questionService.selectById(id);
        model.addAttribute("question", question);
        return "adminweb/showeditquestion";

    }

    @RequestMapping(value = "/editquestion")
    public String editQuestion(Question question, Model model) {
        questionService.updateByPrimaryKeySelective(question);
        return "redirect:/adminweb/chapterdetail?id=" + question.getChapterId();

    }

    @RequestMapping(value = "/myinfo")
    public String myinfo(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        model.addAttribute("user", user);
        return "adminweb/myinfo";

    }

    @RequestMapping(value = "/editinfo")
    public String savaInfo(@RequestParam MultipartFile[] file, HttpServletRequest request, User user) {
        //得到服务器项目发布运行所在地址
        String pathDir = request.getSession().getServletContext().getRealPath("headimg");
        File fileDir = new File(pathDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        List<String> urlList = new ArrayList<String>();
        for (MultipartFile multipartFile : file) {
            //此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了
            if (multipartFile.isEmpty()) {
                logger.info("文件未上传!");
            } else {
                //得到上传的文件名
                String fileName = multipartFile.getOriginalFilename();
                String serverFileName = new IPTimeStamp().getIPTimeRand()
                        + "." + FileUtil.getExtensionName(fileName);
                //  此处未使用UUID来生成唯一标识,用日期做为标识
                String path = pathDir + File.separator
                        + serverFileName;
                //查看文件上传路径,方便查找
                logger.info(path);
                logger.info(fileName);
                //把文件上传至path的路径
                File localFile = new File(path);
                try {
                    multipartFile.transferTo(localFile);
                    user.setHeadImg("headimg/" + serverFileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                urlList.add(path);
            }
        }
        if (userService.updateByPrimaryKeySelective(user) > 0) {
            user = userService.selectByPrimaryKey(user.getId());
            request.getSession().setAttribute("user", user);
        }
        return "redirect:/adminweb/myinfo";
    }

}