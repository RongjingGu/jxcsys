package com.unimedsci.ydata.jxc.commons.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.unimedsci.ydata.jxc.commons.datas.CarrouselImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrouselImgMapper {
    int deleteByPrimaryKey(Integer carrouselImgId);

    int insert(CarrouselImg record);

    int insertSelective(CarrouselImg record);

    CarrouselImg selectByPrimaryKey(Integer carrouselImgId);

    int updateByPrimaryKeySelective(CarrouselImg record);

    int updateByPrimaryKey(CarrouselImg record);

    CarrouselImg queryCarrouseImgByOrderId(@Param(value = "orderId") Integer orderId);

    List<CarrouselImg> queryCarrouselImgsList(PageBounds pageBounds,
                                              @Param(value = "carrouselImgId") Integer carrouselImgId);

}