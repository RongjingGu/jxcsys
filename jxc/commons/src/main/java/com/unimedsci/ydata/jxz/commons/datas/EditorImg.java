package com.unimedsci.ydata.jxz.commons.datas;

import java.util.Date;
import java.util.List;

/**
 * Created by Alan on 2017/12/4.
 */
public class EditorImg {
    public List<String> getImgUuidList() {
        return imgUuidList;
    }

    public void setImgUuidList(List<String> imgUuidList) {
        this.imgUuidList = imgUuidList;
    }

    public enum RelateType{
        MEETING,
    }

    public Integer getEditorImgId() {
        return editorImgId;
    }

    public void setEditorImgId(Integer editorImgId) {
        this.editorImgId = editorImgId;
    }

    public Integer getRelateId() {
        return relateId;
    }

    public void setRelateId(Integer relateId) {
        this.relateId = relateId;
    }

    public RelateType getRelateType() {
        return relateType;
    }

    public void setRelateType(RelateType relateType) {
        this.relateType = relateType;
    }

    public Date getLastViewTime() {
        return lastViewTime;
    }

    public void setLastViewTime(Date lastViewTime) {
        this.lastViewTime = lastViewTime;
    }

    private Integer editorImgId;
    private Integer relateId;
    private RelateType relateType;
    private Date lastViewTime;
    private List<String> imgUuidList;

}
