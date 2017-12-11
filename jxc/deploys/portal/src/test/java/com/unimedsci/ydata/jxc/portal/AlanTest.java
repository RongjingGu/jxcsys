package com.unimedsci.ydata.jxc.portal;

import com.unimedsci.ydata.jxc.commons.dao.EditorImgDetailMapper;
import com.unimedsci.ydata.jxc.commons.dao.EditorImgMapper;
import com.unimedsci.ydata.jxc.commons.datas.EditorImg;
import com.unimedsci.ydata.jxc.commons.datas.EditorImgDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Alan on 2017/12/4.
 */
public class AlanTest  extends BaseUnitTest {
    @Autowired
    EditorImgDetailMapper editorImgDetailMapper;

    @Autowired
    EditorImgMapper editorImgMapper;

    @Test
    public void testEditorImgDetailMapper(){
        EditorImgDetail detail = new EditorImgDetail();
        detail.setEditorImgId(1);
        detail.setImgUuid("wifjweifjweieifhjq");
        editorImgDetailMapper.insert(detail);
    }

    @Test
    public void testEditorImgMapper(){
        EditorImg editorImg = new EditorImg();

        editorImg.setLastViewTime(new Date());
        editorImg.setRelateType(EditorImg.RelateType.MEETING);
        editorImgMapper.insert(editorImg);

        editorImg = editorImgMapper.selectById(1);

        editorImg.setRelateId(2);
        editorImg.setRelateType(EditorImg.RelateType.MEETING);
        editorImg.setLastViewTime(new Date());
        editorImgMapper.update(editorImg);

        EditorImgDetail detail = new EditorImgDetail();
        detail.setEditorImgId(1);
        detail.setImgUuid("wiefjasdlfjiwe");
        editorImgDetailMapper.insert(detail);

        editorImg = editorImgMapper.selectByRelateInfo(1, EditorImg.RelateType.MEETING);

        editorImg = editorImgMapper.selectByRelateInfo(2, EditorImg.RelateType.MEETING);
    }
}
