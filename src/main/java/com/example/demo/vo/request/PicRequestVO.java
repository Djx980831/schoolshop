package com.example.demo.vo.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-18 22:37
 */
@Data
public class PicRequestVO {
    Integer id;
    Integer userId;
    String path;
}
