package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.EditorImgDetail;
import org.springframework.stereotype.Repository;

/**
 * Created by Alan on 2017/12/4.
 */
@Repository
public interface EditorImgDetailMapper {
    int insert(EditorImgDetail detail);

    String selectUuidByUuid(String uuid);

}
