package com.unimedsci.ydata.jxz.commons.datas;

/**
 * [STRATO MyBatis Generator]
 * Table: conversation_question_store
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class ConversationQuestionStore {
    /**
     * Column: conversation_question_store.conversation_question_store_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Long conversationQuestionStoreId;

    /**
     * Column: conversation_question_store.conversation_detail_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Long conversationDetailId;

    /**
     * Column: conversation_question_store.question_store_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer questionStoreId;

    public Long getConversationQuestionStoreId() {
        return conversationQuestionStoreId;
    }

    public void setConversationQuestionStoreId(Long conversationQuestionStoreId) {
        this.conversationQuestionStoreId = conversationQuestionStoreId;
    }

    public Long getConversationDetailId() {
        return conversationDetailId;
    }

    public void setConversationDetailId(Long conversationDetailId) {
        this.conversationDetailId = conversationDetailId;
    }

    public Integer getQuestionStoreId() {
        return questionStoreId;
    }

    public void setQuestionStoreId(Integer questionStoreId) {
        this.questionStoreId = questionStoreId;
    }
}