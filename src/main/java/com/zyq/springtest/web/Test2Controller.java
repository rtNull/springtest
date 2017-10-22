package com.zyq.springtest.web;

import com.zyq.springtest.bean.*;
import com.zyq.springtest.dto.CommentPair;
import com.zyq.springtest.dto.CoursePair;
import com.zyq.springtest.dto.Result;
import com.zyq.springtest.service.*;
import com.zyq.springtest.util.Constant;
import com.zyq.springtest.util.FileUtil;
import com.zyq.springtest.util.IPTimeStamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhanyq on 2017/3/30.
 */
@Controller
@RequestMapping("/testmobile")
public class Test2Controller {
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private MyCourseService myCourseService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/showmaincourses")
    public @ResponseBody
    Result<List<CoursePair>> showMainCourses(Integer pageNum) {
        //start=size(pageNum-1)
        List<CoursePair> coursePairList = null;
        List<Course> courseList = courseService.selectByPageNum(pageNum);
        if (courseList != null && courseList.size() > 0) {
            coursePairList = new ArrayList<CoursePair>();
            for (Course course :
                    courseList) {
                User user = userService.selectByPrimaryKey(course.getUserId());
                user.setPassword(null);
                Subject subject = subjectService.selectByPrimaryKey(course.getSubjectId());
                CoursePair coursePair = new CoursePair(subject, course, user);
                coursePairList.add(coursePair);
            }
        }

        if (coursePairList != null) {
            return new Result<List<CoursePair>>(true, coursePairList);
        } else {
            return new Result<List<CoursePair>>(false, Constant.CODE_NO_MORE);
        }
    }

    @RequestMapping(value = "/showcoursechapters")
    public @ResponseBody
    Result<List<Chapter>> showCourseChapters(Integer courseId) {
        List<Chapter> chapterList = chapterService.selectByCourseId(courseId);
        if (chapterList != null && chapterList.size() > 0) {
            return new Result<List<Chapter>>(true, chapterList);
        } else {
            return new Result<List<Chapter>>(false, Constant.CODE_NO_MORE);
        }
    }

    @RequestMapping(value = "/showcoursecomments")
    public @ResponseBody
    Result<List<CommentPair>> showCourseComments(Integer pageNum, Integer courseId) {
        List<Comment> commentList = commentService.selectByPageNumAndCourseId(pageNum, courseId);
        if (commentList != null && commentList.size() > 0) {
            List<CommentPair> commentPairList = new ArrayList<CommentPair>();
            for (Comment comment :
                    commentList) {
                User user = userService.selectByPrimaryKey(comment.getUserId());
                user.setPassword(null);
                CommentPair commentPair = new CommentPair(user, comment);
                commentPairList.add(commentPair);
            }
            return new Result<List<CommentPair>>(true, commentPairList);
        } else {
            return new Result<List<CommentPair>>(false, Constant.CODE_NO_MORE);
        }
    }

    @RequestMapping(value = "/addcomment")
    public @ResponseBody
    Result<CommentPair> addComment(@RequestBody Comment comment, @RequestHeader(value = "token") String token) {
        //评论需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<CommentPair>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        if (comment != null && commentService.addComment(comment) > 0) {
            return new Result<CommentPair>(true, Constant.CODE_ADD_COMMENT_SUCCESS);
        } else {
            return new Result<CommentPair>(false, Constant.CODE_ADD_COMMENT_FAILED);
        }
    }

    @RequestMapping(value = "/deletecomment")
    public @ResponseBody
    Result<CommentPair> deleteComment(Integer commentId, @RequestHeader(value = "token") String token) {
        //评论需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<CommentPair>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        if (commentService.deleteById(commentId) > 0) {
            return new Result<CommentPair>(true, Constant.CODE_DELETE_COMMENT_SUCCESS);
        } else {
            return new Result<CommentPair>(false, Constant.CODE_DELETE_COMMENT_FAILED);
        }
    }

    @RequestMapping(value = "/showchapterresources")
    public @ResponseBody
    Result<List<Resource>> showChapterResources(Integer chapterId, @RequestHeader(value = "token") String token) {
        //访问资源需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<List<Resource>>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        List<Resource> resourceList = resourceService.selectBySelective(new Resource(chapterId, null));
        if (resourceList != null && resourceList.size() > 0) {
            return new Result<List<Resource>>(true, resourceList);
        } else {
            return new Result<List<Resource>>(false, Constant.CODE_NO_MORE);
        }
    }

    @RequestMapping(value = "/showchapterquestions")
    public @ResponseBody
    Result<List<Question>> showChapterQuestions(Integer chapterId, @RequestHeader(value = "token") String token) {
        //访问资源需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (token == null || userAuther == null) {
            return new Result<List<Question>>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        List<Question> questionList = questionService.selectByChapterId(chapterId);
        if (questionList != null && questionList.size() > 0) {
            return new Result<List<Question>>(true, questionList);
        } else {
            return new Result<List<Question>>(false, Constant.CODE_NO_MORE);
        }
    }

    @RequestMapping(value = "/showunreadmessage")
    public @ResponseBody
    Result<List<CommentPair>> showUnReadedMsg(@RequestHeader(value = "token") String token) {
        //访问资源需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<List<CommentPair>>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        List<Comment> commentList = commentService.selectUnReadedByUserId(userAuther.getId());
        List<CommentPair> commentPairList = null;
        if (commentList != null && commentList.size() > 0) {
            commentPairList = new ArrayList<CommentPair>();
            for (Comment comment :
                    commentList) {
                User user = userService.selectByPrimaryKey(comment.getUserId());
                user.setPassword(null);
                commentPairList.add(new CommentPair(user, comment));
                //查询出并设置为已读
                if (!comment.getReaded()) {
                    comment.setReaded(true);
                    commentService.updateByPrimaryKeySelective(comment);
                    comment.setReaded(false);
                }
            }
        }
        if (commentPairList != null && commentPairList.size() > 0) {
            return new Result<List<CommentPair>>(true, commentPairList);
        } else {
            return new Result<List<CommentPair>>(false, Constant.CODE_NO_MORE);
        }
    }

    @RequestMapping(value = "/searchcourses")
    public @ResponseBody
    Result<List<CoursePair>> searchCourses(String query) {
        //start=size(pageNum-1)
        List<CoursePair> coursePairList = null;
        List<Course> courseList = courseService.selectBySelective(new Course(null, null, query.trim()));
        if (courseList != null && courseList.size() > 0) {
            coursePairList = new ArrayList<CoursePair>();
            for (Course course :
                    courseList) {
                User user = userService.selectByPrimaryKey(course.getUserId());
                user.setPassword(null);
                Subject subject = subjectService.selectByPrimaryKey(course.getSubjectId());
                CoursePair coursePair = new CoursePair(subject, course, user);
                coursePairList.add(coursePair);
            }
        }

        if (coursePairList != null) {
            return new Result<List<CoursePair>>(true, coursePairList);
        } else {
            return new Result<List<CoursePair>>(false, Constant.CODE_NO_MORE);
        }
    }

    @RequestMapping(value = "/showallsubjcets")
    public @ResponseBody
    Result<List<Subject>> showAllSubjects() {
        //start=size(pageNum-1)
        List<Subject> subjectList = subjectService.selectAll();
        if (subjectList != null && subjectList.size() > 0) {
            return new Result<List<Subject>>(true, subjectList);
        } else {
            return new Result<List<Subject>>(false, Constant.CODE_NO_MORE);
        }
    }

    @RequestMapping(value = "/mycourses")
    public @ResponseBody
    Result<List<CoursePair>> myCourses(@RequestHeader(value = "token") String token) {
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<List<CoursePair>>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        List<CoursePair> coursePairList = null;
        List<Course> courseList = courseService.selectBySelective(
                new Course(null, userAuther.getId(), null));
        if (courseList != null && courseList.size() > 0) {
            coursePairList = new ArrayList<CoursePair>();
            for (Course course :
                    courseList) {
                User user = userService.selectByPrimaryKey(course.getUserId());
                user.setPassword(null);
                Subject subject = subjectService.selectByPrimaryKey(course.getSubjectId());
                CoursePair coursePair = new CoursePair(subject, course, user);
                coursePairList.add(coursePair);
            }
        }

        if (coursePairList != null) {
            return new Result<List<CoursePair>>(true, coursePairList);
        } else {
            return new Result<List<CoursePair>>(false, Constant.CODE_NO_MORE);
        }
    }

    @RequestMapping(value = "/addcourse")
    public @ResponseBody
    Result<Course> addCourse(@RequestBody Course course, @RequestHeader(value = "token") String token) {
        //评论需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<Course>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        if (course != null && courseService.addCourse(course) > 0) {
            return new Result<Course>(true, Constant.CODE_ADD_SUCCESS);
        } else {
            return new Result<Course>(false, Constant.CODE_ADD_FAILED);
        }
    }

    @RequestMapping(value = "/updatecourse")
    public @ResponseBody
    Result<Course> updateCourse(@RequestHeader(value = "token") String token, @RequestBody Course course) {
        //访问资源需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null || course.getUserId().intValue() != userAuther.getId().intValue()) {
            return new Result<Course>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        } else {
            int count = courseService.updateByPrimaryKeySelective(course);
            if (count > 0) {
                return new Result<Course>(true, course, Constant.CODE_UPDATE_SUCCESS);
            } else {
                return new Result<Course>(false, Constant.CODE_UPDATE_FAILED);
            }
        }
    }

    @RequestMapping(value = "/deletecourse")
    public @ResponseBody
    Result<Course> deleteCourse(@RequestHeader(value = "token") String token, Integer courseId) {
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<Course>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        } else {
            Course course = courseService.selectById(courseId);
            if (course == null || course.getUserId().intValue() != userAuther.getId().intValue()) {
                return new Result<Course>(false, Constant.CODE_USESR_NOT_OAUTHEN);
            }
            if (courseId != null) {
                List<Chapter> chapterList = chapterService.selectByCourseId(courseId);
                for (Chapter chapter :
                        chapterList) {
                    resourceService.deleteByChapterId(chapter.getId());
                    questionService.deleteByChapterId(chapter.getId());
                }
                chapterService.deleteByCourseId(courseId);
                commentService.deleteByCourseId(courseId);
                courseService.deleteCourseById(courseId);
                return new Result<Course>(true, course, Constant.CODE_DELETE_SUCCESS);
            } else {
                return new Result<Course>(false, Constant.CODE_DELETE_FAILED);
            }
        }
    }


    @RequestMapping(value = "/addchapter")
    public @ResponseBody
    Result<Chapter> addChapter(@RequestBody Chapter chapter, @RequestHeader(value = "token") String token) {
        //评论需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<Chapter>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        if (chapter != null && chapterService.addChapter(chapter) > 0) {
            return new Result<Chapter>(true, Constant.CODE_ADD_SUCCESS);
        } else {
            return new Result<Chapter>(false, Constant.CODE_ADD_FAILED);
        }
    }

    @RequestMapping(value = "/updatechapter")
    public @ResponseBody
    Result<Chapter> updateChapter(@RequestHeader(value = "token") String token, @RequestBody Chapter chapter) {
        //访问资源需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        Course course = courseService.selectById(chapter.getCourseId());
        if (userAuther == null || course.getUserId().intValue() != userAuther.getId().intValue()) {
            return new Result<Chapter>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        } else {
            int count = chapterService.updateByPrimaryKeySelective(chapter);
            if (count > 0) {
                return new Result<Chapter>(true, chapter, Constant.CODE_UPDATE_SUCCESS);
            } else {
                return new Result<Chapter>(false, Constant.CODE_UPDATE_FAILED);
            }
        }
    }

    @RequestMapping(value = "/deletechapter")
    public @ResponseBody
    Result<Chapter> deleteChapter(@RequestHeader(value = "token") String token, Integer chapterId) {
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<Chapter>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        } else {
            Chapter chapter = chapterService.selectById(chapterId);
            if (chapter == null) {
                return new Result<Chapter>(false, Constant.CODE_DELETE_FAILED);
            } else {
                Course course = courseService.selectById(chapter.getCourseId());
                if (course == null || course.getUserId().intValue() != userAuther.getId().intValue()) {
                    return new Result<Chapter>(false, Constant.CODE_USESR_NOT_OAUTHEN);
                }
                resourceService.deleteByChapterId(chapter.getId());
                questionService.deleteByChapterId(chapter.getId());
                chapterService.deleteById(chapterId);
                return new Result<Chapter>(true, chapter, Constant.CODE_DELETE_SUCCESS);

            }
        }
    }

    @RequestMapping(value = "/addresource")
    public @ResponseBody
    Result<Resource> addResource(@RequestHeader(value = "token") String token, @RequestParam MultipartFile[] file,
                                 Integer chapterId, String name, HttpServletRequest request) {
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<Resource>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        if (file.length <= 0) {
            return new Result<Resource>(false, Constant.CODE_ADD_FAILED);
        }
        //得到服务器项目发布运行所在地址
        String pathDir = request.getSession().getServletContext().getRealPath("resources");
        File fileDir = new File(pathDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        boolean flag = false;
        for (MultipartFile multipartFile : file) {
            //此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了
            if (multipartFile.isEmpty()) {
                logger.info("文件未上传!");
                return new Result<Resource>(false, Constant.CODE_ADD_FAILED);

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
                        flag = true;
                    } else {
                        flag = false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (flag) {
            return new Result<Resource>(true, Constant.CODE_ADD_SUCCESS);
        } else {
            return new Result<Resource>(false, Constant.CODE_ADD_FAILED);
        }
    }

    @RequestMapping(value = "/deleteresource")
    public @ResponseBody
    Result<Resource> deleteResource(@RequestHeader(value = "token") String token, Integer resourceId) {
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<Resource>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        } else {
            if (resourceService.deleteById(resourceId) > 0) {
                return new Result<Resource>(true, Constant.CODE_DELETE_SUCCESS);
            } else {
                return new Result<Resource>(false, Constant.CODE_DELETE_FAILED);
            }

        }
    }


    @RequestMapping(value = "/addquestion")
    public @ResponseBody
    Result<Question> addQuestion(@RequestBody Question question, @RequestHeader(value = "token") String token) {
        //评论需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<Question>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        if (question != null && questionService.addQuestion(question) > 0) {
            return new Result<Question>(true, Constant.CODE_ADD_SUCCESS);
        } else {
            return new Result<Question>(false, Constant.CODE_ADD_FAILED);
        }
    }

    @RequestMapping(value = "/updatequestion")
    public @ResponseBody
    Result<Question> updateQuestion(@RequestHeader(value = "token") String token, @RequestBody Question question) {
        //访问资源需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<Question>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        } else {
            int count = questionService.updateByPrimaryKeySelective(question);
            if (count > 0) {
                return new Result<Question>(true, question, Constant.CODE_UPDATE_SUCCESS);
            } else {
                return new Result<Question>(false, Constant.CODE_UPDATE_FAILED);
            }
        }
    }

    @RequestMapping(value = "/deletequestion")
    public @ResponseBody
    Result<Question> deleteQuestion(@RequestHeader(value = "token") String token, Integer questionId) {
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<Question>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        } else {
            if (questionService.deleteById(questionId) > 0) {
                return new Result<Question>(true, Constant.CODE_DELETE_SUCCESS);
            } else {
                return new Result<Question>(false, Constant.CODE_DELETE_FAILED);
            }

        }
    }


    @RequestMapping(value = "/uploadheadimg")
    public @ResponseBody
    Result<User> uploadHeadImg(@RequestHeader(value = "token") String token, @RequestParam MultipartFile[] file, HttpServletRequest request) {
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<User>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        if (file.length <= 0) {
            return new Result<User>(false, Constant.CODE_ADD_FAILED);
        }
        //得到服务器项目发布运行所在地址
        String pathDir = request.getSession().getServletContext().getRealPath("headimg");
        File fileDir = new File(pathDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        boolean flag = false;
        for (MultipartFile multipartFile : file) {
            //此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了
            if (multipartFile.isEmpty()) {
                logger.info("文件未上传!");
                return new Result<User>(false, Constant.CODE_ADD_FAILED);

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
                    userAuther.setHeadImg("headimg/" + serverFileName);
                    if (userService.updateByPrimaryKeySelective(userAuther) > 0) {
                        //添加成功
                        flag = true;
                    } else {
                        flag = false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (flag) {
            return new Result<User>(true, userAuther, Constant.CODE_ADD_SUCCESS);
        } else {
            return new Result<User>(false, Constant.CODE_ADD_FAILED);
        }
    }

    @RequestMapping(value = "/starcourse")
    public @ResponseBody
    Result<MyCourse> starCourse(Integer courseId, @RequestHeader(value = "token") String token) {
        //评论需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<MyCourse>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        try {
            if (courseId != null && myCourseService.starCourse(new MyCourse(userAuther.getId(), courseId)) > 0) {
                return new Result<MyCourse>(true, Constant.CODE_ADD_SUCCESS);
            } else {
                return new Result<MyCourse>(false, Constant.CODE_ADD_FAILED);
            }
        } catch (Exception e) {
            return new Result<MyCourse>(false, Constant.CODE_ADD_FAILED);
        }

    }

    @RequestMapping(value = "/unstarcourse")
    public @ResponseBody
    Result<MyCourse> unStarCourse(Integer courseId, @RequestHeader(value = "token") String token) {
        //评论需要授权
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<MyCourse>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        if (courseId != null && myCourseService.unStarCourse(new MyCourse(userAuther.getId(), courseId)) > 0) {
            return new Result<MyCourse>(true, Constant.CODE_DELETE_SUCCESS);
        } else {
            return new Result<MyCourse>(false, Constant.CODE_DELETE_FAILED);
        }
    }

    @RequestMapping(value = "/mystarcourses")
    public @ResponseBody
    Result<List<CoursePair>> myStarCourses(@RequestHeader(value = "token") String token) {
        User userAuther = userService.userOAuthen(new User(null, null, null, token));
        if (userAuther == null) {
            return new Result<List<CoursePair>>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        }
        List<MyCourse> myCourseList = myCourseService.myStarCourses(userAuther.getId());
        if (myCourseList != null) {
            List<CoursePair> coursePairList = new ArrayList<CoursePair>();
            for (MyCourse myCourse :
                    myCourseList) {
                Course course = courseService.selectById(myCourse.getCourseId());
                if (course != null) {
                    User user = userService.selectByPrimaryKey(course.getUserId());
                    Subject subject = subjectService.selectByPrimaryKey(course.getSubjectId());
                    CoursePair coursePair = new CoursePair(subject, course, user);
                    coursePairList.add(coursePair);
                }
            }
            return new Result<List<CoursePair>>(true, coursePairList, Constant.CODE_ADD_SUCCESS);
        } else {
            return new Result<List<CoursePair>>(false, Constant.CODE_NO_MORE);
        }
    }
}