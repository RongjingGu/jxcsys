package com.unimedsci.ydata.jxc.commons.datas;

/**
 * [STRATO MyBatis Generator]
 * Table: question_store_keyword
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:04
 */
public class QuestionStoreKeyword {
    /**
     * Column: question_store_keyword.question_store_keyword_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer questionStoreKeywordId;

    /**
     * Column: question_store_keyword.question_store_id
    @mbggenerated 2017-11-30 15:36:04
     */
    private Integer questionStoreId;

    /**
     * Column: question_store_keyword.keyword
    @mbggenerated 2017-11-30 15:36:04
     */
    private String keyword;

    public Integer getQuestionStoreKeywordId() {
        return questionStoreKeywordId;
    }

    public void setQuestionStoreKeywordId(Integer questionStoreKeywordId) {
        this.questionStoreKeywordId = questionStoreKeywordId;
    }

    public Integer getQuestionStoreId() {
        return questionStoreId;
    }

    public void setQuestionStoreId(Integer questionStoreId) {
        this.questionStoreId = questionStoreId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
}