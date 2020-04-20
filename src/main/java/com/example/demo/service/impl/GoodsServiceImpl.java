package com.example.demo.service.impl;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Pic;
import com.example.demo.mapper.FocusUserMapper;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.service.FocusUserService;
import com.example.demo.service.GoodsService;
import com.example.demo.util.FileUtil;
import com.example.demo.vo.request.GoodsRequestVO;
import com.example.demo.vo.request.PicRequestVO;
import com.example.demo.vo.response.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-18 22:45
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper mapper;

    @Autowired
    private FocusUserService focusUserService;

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

    @Override
    public Integer saveGoods(Integer userId, String title, String comment) {
        GoodsRequestVO vo = new GoodsRequestVO();
        vo.setUserId(userId);
        vo.setTitle(title);
        vo.setComment(comment);

        mapper.saveGoods(vo);
        return vo.getId();
    }

    @Override
    public List<GoodsVO> getGoodsByLikeTitle(String title) {
        List<Goods> goodsList = mapper.getGoodsByLikeTitle(title);
        List<Integer> userIdsList = goodsList.stream().map(goods -> goods.getUserId()).collect(Collectors.toList());
        List<Pic> pathList = mapper.getPicByIds(userIdsList);

        //list 转为 map 对象
        Map<Integer, List<String>> map = listToMap(pathList);

        List<GoodsVO> goodsVOList = new ArrayList<>(20);
        for (Goods goods : goodsList) {
            GoodsVO vo = new GoodsVO();
            vo.setId(goods.getId());
            vo.setUserId(goods.getUserId());
            vo.setTitle(goods.getTitle());
            vo.setComment(goods.getComment());
            vo.setPathList(map.get(goods.getUserId()));

            goodsVOList.add(vo);
        }
        return goodsVOList;
    }

    @Override
    public List<GoodsVO> getFocusUserGoodsByUserId(Integer userId) {
        List<Integer> focusUserId = focusUserService.getFocueUserIdByUserId(userId);
        List<Goods> goodsList = mapper.getFocusUserGoodsByUserId(focusUserId);
        List<Pic> pathList = mapper.getPicByIds(focusUserId);

        Map<Integer, List<String>> map = listToMap(pathList);

        List<GoodsVO> goodsVOList = new ArrayList<>(20);
        for (Goods goods : goodsList) {
            GoodsVO vo = new GoodsVO();
            vo.setId(goods.getId());
            vo.setUserId(goods.getUserId());
            vo.setTitle(goods.getTitle());
            vo.setComment(goods.getComment());
            vo.setPathList(map.get(goods.getUserId()));

            goodsVOList.add(vo);
        }
        return goodsVOList;
    }

    private Map listToMap(List<Pic> pathList) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < pathList.size(); i++) {
            List<String> stringList = new ArrayList<>();
            Pic pic = pathList.get(i);
            for (int j = i + 1; j < pathList.size(); j++) {
                if (pic.getUserId().equals(pathList.get(j).getUserId())) {
                    stringList.add(pathList.get(j).getPath());
                }
            }
            map.put(pic.getUserId(), stringList);
        }
        return map;
    }
}
