package com.example.demo.service.impl;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Pic;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.service.CollectionService;
import com.example.demo.service.FocusUserService;
import com.example.demo.service.GoodsService;
import com.example.demo.service.OrderService;
import com.example.demo.util.FileUtil;
import com.example.demo.vo.request.GoodsRequestVO;
import com.example.demo.vo.request.PicRequestVO;
import com.example.demo.vo.response.GoodsVO;
import com.example.demo.vo.response.MainVO;
import com.example.demo.vo.response.OrdersVO;
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

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private OrderService orderService;

    @Override
    public String savePic(Integer goodsId, Integer userId, MultipartFile[] files) {
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
                vo.setGoodsId(goodsId);
                vo.setUserId(userId);
                vo.setPath("http://localhost:8082/" + fileName);
                mapper.savePic(vo);
            }
        }
        return "success";
    }

    @Override
    public Integer saveGoods(Integer userId, String title, String comment, Double money) {
        GoodsRequestVO vo = new GoodsRequestVO();
        vo.setUserId(userId);
        vo.setTitle(title);
        vo.setComment(comment);
        vo.setMoney(money);

        mapper.saveGoods(vo);
        return vo.getId();
    }

    @Override
    public List<GoodsVO> getGoodsByLikeTitle(String title) {
        List<Goods> goodsList = mapper.getGoodsByLikeTitle(title);
        List<Integer> userIds = goodsList.stream().map(goods -> goods.getUserId()).collect(Collectors.toList());
        List<Pic> pathList = mapper.getPicByIds(userIds);

        //list 转为 map 对象
        Map<Integer, List<String>> map = listToMap(pathList);

        List<GoodsVO> goodsVOList = new ArrayList<>(20);
        for (Goods goods : goodsList) {
            GoodsVO vo = new GoodsVO();
            Integer isCollection = mapper.isCollection(goods.getUserId(), goods.getId());
            vo.setIsCollection(isCollection != null ? 1 : 0);
            vo.setId(goods.getId());
            vo.setUserId(goods.getUserId());
            vo.setTitle(goods.getTitle());
            vo.setComment(goods.getComment());
            vo.setPathList(map.get(goods.getId()));
            vo.setMoney(goods.getMoney());

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
            Integer isCollection = mapper.isCollection(goods.getUserId(), goods.getId());
            vo.setIsCollection(isCollection != null ? 1 : 0);
            vo.setId(goods.getId());
            vo.setUserId(goods.getUserId());
            vo.setTitle(goods.getTitle());
            vo.setComment(goods.getComment());
            vo.setMoney(goods.getMoney());
            vo.setPathList(map.get(goods.getId()));

            goodsVOList.add(vo);
        }
        return goodsVOList;
    }

    @Override
    public GoodsVO getGoodsInfoById(Integer id) {
        Goods goods = mapper.getGoodsInfoById(id);
        if (goods == null) {
            return null;
        }
        List<String> picList = mapper.getPicPathByGoodsId(id);
        Integer isCollection = mapper.isCollection(goods.getUserId(), id);
        GoodsVO goodsVO = new GoodsVO();
        goodsVO.setPathList(picList);
        goodsVO.setId(id);
        goodsVO.setComment(goods.getComment());
        goodsVO.setTitle(goods.getTitle());
        goodsVO.setUserId(goods.getUserId());
        goodsVO.setMoney(goods.getMoney());
        if (isCollection != null) {
            goodsVO.setIsCollection(1);
        } else {
            goodsVO.setIsCollection(0);
        }

        return goodsVO;
    }

    @Override
    public MainVO getMainInfoByUserId(Integer userId) {
        MainVO mainVO = new MainVO();

        Integer focue = focusUserService.getFocusUserCountByUserId(userId);
        Integer fenSi = focusUserService.getFensiCountByUserId(userId);
        Integer collection = collectionService.getCollectionCountByUserId(userId);

        //上架商品
        List<GoodsVO> goodsVOList = new ArrayList<>(20);
        List<Goods> goodsList = mapper.getGoodsByUserId(userId);
        if (goodsList.size() != 0) {
            List<Integer> goodsIds = goodsList.stream().map(goods -> goods.getId()).collect(Collectors.toList());
            List<Pic> stringGoodsList = mapper.getPicPathByGoodsIds(goodsIds);
            Map<Integer, List<String>> goodsStringMap = listToMap(stringGoodsList);
            goodsVOList = toGoodsList(goodsList, goodsStringMap);
        }

        //下架商品
        List<GoodsVO> xiaJIaGoodsVOList = new ArrayList<>(20);
        List<Goods> xiaJiaGoodsList = mapper.getXiaJiaGoodsByUserId(userId);
        if (xiaJiaGoodsList.size() != 0) {
            List<Integer> xiaJiaGoodsIds = xiaJiaGoodsList.stream().map(goods -> goods.getId()).collect(Collectors.toList());
            List<Pic> stringXiaJiaGoodsList = mapper.getPicPathByGoodsIds(xiaJiaGoodsIds);
            Map<Integer, List<String>> stringXiaJiaGoodsMap = listToMap(stringXiaJiaGoodsList);
            xiaJIaGoodsVOList = toGoodsList(xiaJiaGoodsList, stringXiaJiaGoodsMap);
        }


        //订单信息
        List<OrdersVO> ordersVOList = new ArrayList<>(20);
        List<Orders> orderList = orderService.getOrderByUserId(userId);
        if (orderList.size() != 0) {
            List<Integer> orderGoodsIds = orderList.stream().map(order -> order.getGoodsId()).collect(Collectors.toList());
            List<Pic> stringOrderGoodsList = mapper.getPicPathByGoodsIds(orderGoodsIds);
            Map<Integer, List<String>> stringOrderGoodsMap = listToMap(stringOrderGoodsList);
            ordersVOList = new ArrayList<>(20);
            for (Orders orders : orderList) {
                OrdersVO vo = new OrdersVO();
                vo.setId(orders.getId());
                vo.setUserId(orders.getUserId());
                vo.setComment(orders.getComment());
                vo.setFlag(orders.getFlag());
                vo.setTitle(orders.getTitle());
                vo.setGoodsId(orders.getGoodsId());
                vo.setMoney(orders.getMoney());
                vo.setPathList(stringOrderGoodsMap.get(orders.getGoodsId()));

                ordersVOList.add(vo);
            }
        }

        mainVO.setFenSi(fenSi);
        mainVO.setFocue(focue);
        mainVO.setCollection(collection);
        mainVO.setGoodsList(goodsVOList);
        mainVO.setXiaJiaGoodsList(xiaJIaGoodsVOList);
        mainVO.setOrderList(ordersVOList);

        return mainVO;
    }

    @Override
    public List<GoodsVO> getXiaJiaGoodsByUserId(Integer userId) {
        List<Goods> xiaJiaGoodsList = mapper.getXiaJiaGoodsByUserId(userId);
        if (xiaJiaGoodsList == null) {
            return null;
        }
        List<Integer> userIds = xiaJiaGoodsList.stream().map(goods -> goods.getUserId()).collect(Collectors.toList());
        List<Pic> pathList = mapper.getPicByIds(userIds);

        //list 转为 map 对象
        Map<Integer, List<String>> map = listToMap(pathList);

        List<GoodsVO> goodsVOList = new ArrayList<>(20);

        for (Goods goods : xiaJiaGoodsList) {
            GoodsVO vo = new GoodsVO();
            Integer isCollection = mapper.isCollection(goods.getUserId(), goods.getId());
            vo.setIsCollection(isCollection != null ? 1 : 0);
            vo.setId(goods.getId());
            vo.setUserId(goods.getUserId());
            vo.setTitle(goods.getTitle());
            vo.setComment(goods.getComment());
            vo.setPathList(map.get(goods.getId()));
            vo.setMoney(goods.getMoney());

            goodsVOList.add(vo);
        }
        return goodsVOList;
    }

    @Override
    public List<GoodsVO> getGoodsByUserId(Integer userId) {
        List<Goods> goodsList = mapper.getGoodsByUserId(userId);
        if (goodsList == null) {
            return null;
        }
        List<Integer> userIds = goodsList.stream().map(goods -> goods.getUserId()).collect(Collectors.toList());
        List<Pic> pathList = mapper.getPicByIds(userIds);

        //list 转为 map 对象
        Map<Integer, List<String>> map = listToMap(pathList);

        List<GoodsVO> goodsVOList = new ArrayList<>(20);

        for (Goods goods : goodsList) {
            GoodsVO vo = new GoodsVO();
            Integer isCollection = mapper.isCollection(goods.getUserId(), goods.getId());
            vo.setIsCollection(isCollection != null ? 1 : 0);
            vo.setId(goods.getId());
            vo.setUserId(goods.getUserId());
            vo.setTitle(goods.getTitle());
            vo.setComment(goods.getComment());
            vo.setPathList(map.get(goods.getId()));
            vo.setMoney(goods.getMoney());

            goodsVOList.add(vo);
        }
        return goodsVOList;
    }

    @Override
    public Integer deleteGoodsById(Integer id) {
        return mapper.deleteGoodsById(id);
    }

    private Map listToMap(List<Pic> pathList) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = pathList.size() - 1; i >= 0; i--) {
            List<String> stringList = new ArrayList<>();
            Pic pic = pathList.get(i);
            stringList.add(pic.getPath());
            for (int j = i - 1; j >= 0; j--) {
                if (pic.getGoodsId().equals(pathList.get(j).getGoodsId())) {
                    stringList.add(pathList.get(j).getPath());
                    pathList.remove(j);
                }
            }
            if (!map.containsKey(pic.getGoodsId())) {
                map.put(pic.getGoodsId(), stringList);
            }
        }
        return map;
    }

    private List<GoodsVO> toGoodsList(List<Goods> goodsList,  Map<Integer, List<String>> goodsStringMap) {
        List<GoodsVO> goodsVOList = new ArrayList<>(20);

        for (Goods goods : goodsList) {
            GoodsVO vo = new GoodsVO();
            Integer isCollection = mapper.isCollection(goods.getUserId(), goods.getId());
            vo.setIsCollection(isCollection != null ? 1 : 0);
            vo.setMoney(goods.getMoney());
            vo.setUserId(goods.getUserId());
            vo.setTitle(goods.getTitle());
            vo.setComment(goods.getComment());
            vo.setId(goods.getId());
            vo.setPathList(goodsStringMap.get(goods.getId()));

            goodsVOList.add(vo);
        }
        return goodsVOList;
    }
}
