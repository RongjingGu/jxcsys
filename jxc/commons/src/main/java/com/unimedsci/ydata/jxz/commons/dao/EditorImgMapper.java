package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.EditorImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Alan on 2017/12/4.
 */
@Repository
public interface EditorImgMapper {
    int insert(EditorImg editorImg);

    int update(EditorImg editorImg);

    EditorImg selectById(Integer editorImgId);

    EditorImg selectByRelateInfo(
            @Param("relateId") Integer relateId,
            @Param("relateType") EditorImg.RelateType relateType );

}
