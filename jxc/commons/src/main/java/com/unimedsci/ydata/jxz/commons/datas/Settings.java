package com.unimedsci.ydata.jxz.commons.datas;

/**
 * [STRATO MyBatis Generator]
 * Table: settings
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:04
 */
public class Settings {
    /**
     * Column: settings.key
    @mbggenerated 2017-11-30 15:36:04
     */
    private String key;

    /**
     * Column: settings.value
    @mbggenerated 2017-11-30 15:36:04
     */
    private String value;

    /**
     * Column: settings.comment
    @mbggenerated 2017-11-30 15:36:04
     */
    private String comment;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}