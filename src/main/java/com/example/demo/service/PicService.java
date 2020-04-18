package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface PicService {

    String savePic(Integer userId, MultipartFile[] files);
}
