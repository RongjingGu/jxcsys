package com.unimedsci.ydata.jxz.commons.datas;

/**
 * [STRATO MyBatis Generator]
 * Table: conversation_read_record
@mbggenerated do_not_delete_during_merge 2017-11-30 15:36:03
 */
public class ConversationReadRecordKey {
    /**
     * Column: conversation_read_record.question_read_record_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer questionReadRecordId;

    /**
     * Column: conversation_read_record.conversation_id
    @mbggenerated 2017-11-30 15:36:03
     */
    private Integer conversationId;

    public Integer getQuestionReadRecordId() {
        return questionReadRecordId;
    }

    public void setQuestionReadRecordId(Integer questionReadRecordId) {
        this.questionReadRecordId = questionReadRecordId;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }
}