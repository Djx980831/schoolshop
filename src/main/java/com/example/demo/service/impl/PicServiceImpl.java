package com.example.demo.service.impl;

import com.example.demo.mapper.PicMapper;
import com.example.demo.service.PicService;
import com.example.demo.util.FileUtil;
import com.example.demo.vo.request.PicRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-18 22:45
 */
@Service
public class PicServiceImpl implements PicService {

    @Autowired
    private PicMapper mapper;

    @Override
    public String savePic(Integer userId, MultipartFile[] files) {
        if (files.length != 0) {
            for (MultipartFile multipartFile : files) {
                String fileName = multipartFile.getOriginalFilename();

                // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
                // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
                String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";

                try {
                    // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
                    FileUtil.fileupload(multipartFile.getBytes(), path, fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
                PicRequestVO vo = new PicRequestVO();
                vo.setUserId(userId);
                vo.setPath("http://localhost:8080/" + fileName);
                mapper.savePic(vo);
            }
        }
        return "success";
    }
}
