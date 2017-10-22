package com.zyq.springtest.web;

import com.zyq.springtest.bean.User;
import com.zyq.springtest.dto.Result;
import com.zyq.springtest.service.UserService;
import com.zyq.springtest.util.Constant;
import com.zyq.springtest.util.FileUtil;
import com.zyq.springtest.util.IPTimeStamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhanyq on 2017/3/30.
 */
@Controller
@RequestMapping("/resources")
public class ResourcesController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 上传教学材料
     *
     * @return
     */
    @RequestMapping(value = "/upload")
    public @ResponseBody
    Result<List<String>>
    upload(@RequestParam MultipartFile[] file, HttpServletRequest request) throws IOException {
        List<String> urlList = new ArrayList<String>();
        try {
            for (MultipartFile multipartFile : file) {
                //此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了
                if (multipartFile.isEmpty()) {
                    System.out.println("文件未上传!");
                } else {
                    //得到上传的文件名
                    String fileName = multipartFile.getOriginalFilename();
                    //得到服务器项目发布运行所在地址
                    String pathDir = request.getSession().getServletContext().getRealPath("resources");
                    File fileDir = new File(pathDir);
                    if (!fileDir.exists()) {
                        fileDir.mkdir();
                    }
                    //  此处未使用UUID来生成唯一标识,用日期做为标识
                    String path = pathDir + File.separator
                            + new IPTimeStamp().getIPTimeRand()
                            + "." + FileUtil.getExtensionName(fileName);
                    //查看文件上传路径,方便查找
                    System.out.println(path);
                    //把文件上传至path的路径
                    File localFile = new File(path);
                    multipartFile.transferTo(localFile);
                    urlList.add(path);
                }
            }
            return new Result<List<String>>(true, urlList);
        } catch (Exception e) {
            return new Result<List<String>>(false, Constant.CODE_UPLOAD_FAILED);
        }


    }


//    @RequestMapping(value = "/download/{resourceUrl}")
//    public @ResponseBody
//    Result<User> login(@RequestBody User user) {
//        logger.info("user{}", user);
//        user = userService.login(user);
//        if (user != null) {
//            return new Result<User>(true, user, "登录成功");
//        } else {
//            return new Result<User>(false, "登录失败");
//        }
//    }


    @RequestMapping(value = "/download")
    public String showUpload() {
        return "hello";
    }


}
