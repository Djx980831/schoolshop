package com.example.demo.mapper;

import com.example.demo.vo.request.PicRequestVO;
import org.springframework.stereotype.Repository;

@Repository
public interface PicMapper {

    Integer savePic(PicRequestVO vo);
}
