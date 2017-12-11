package com.unimedsci.ydata.jxc.commons.datas;

import java.util.Date;

public class CarrouselImg {

    public static enum CarrouselImgstatus {
        ACTIVE, INACTIVE
    }

    private Integer carrouselImgId;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片名
     */
    private String mainImgName;
    private String mainImgUrl;

    /**
     * 顺序
     */
    private Integer item;

    /**
     * 跳转链接
     */
    private String uri;

    /**
     * 状态
     * ACTIVE
     * INACTIVE
     */
    private CarrouselImgstatus status;

    private Date createTime;

    public Integer getCarrouselImgId() {
        return carrouselImgId;
    }

    public void setCarrouselImgId(Integer carrouselImgId) {
        this.carrouselImgId = carrouselImgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMainImgName() {
        return mainImgName;
    }

    public void setMainImgName(String mainImgName) {
        this.mainImgName = mainImgName == null ? null : mainImgName.trim();
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public CarrouselImgstatus getStatus() {
        return status;
    }

    public void setStatus(CarrouselImgstatus status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }
}