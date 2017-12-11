package com.unimedsci.ydata.jxc.commons.datas;

/**
 * [STRATO MyBatis Generator]
 * Table: popular_science_category
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:04
 */
public class PopularScienceCategory {
    public static enum PopularScienceCategoryStatus{
        ACTIVE,INACTIVE
    }
    /**
     * Column: popular_science_category.popular_science_category_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer popularScienceCategoryId;

    /**
     *   分类名
     * Column: popular_science_category.category_name
    @mbggenerated 2017-11-30 15:36:04
     */
    private String categoryName;

    /**
     *   顺序
     * Column: popular_science_category.order
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer order;

    /**
     *   状态
ACTIVE
INACTIVE
     * Column: popular_science_category.status
    @mbggenerated 2017-11-30 15:36:04
     */
    private PopularScienceCategoryStatus status;

    public Integer getPopularScienceCategoryId() {
        return popularScienceCategoryId;
    }

    public void setPopularScienceCategoryId(Integer popularScienceCategoryId) {
        this.popularScienceCategoryId = popularScienceCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public PopularScienceCategoryStatus getStatus() {
        return status;
    }

    public void setStatus(PopularScienceCategoryStatus status) {
        this.status = status;
    }
}