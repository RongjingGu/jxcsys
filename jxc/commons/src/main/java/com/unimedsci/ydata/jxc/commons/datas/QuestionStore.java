package com.unimedsci.ydata.jxc.commons.datas;

import java.util.Date;

public class QuestionStore {

    public static enum QuestionStoreStatus{
       ACTIVE,INACTIVE
    }

    private Integer questionStoreId;
    private String question;
    private String answer;

    /**
     *   访问量
     */
    private Integer visitCount;

    private Date createTime;
    private QuestionStoreStatus status;

    public Integer getQuestionStoreId() {
        return questionStoreId;
    }

    public void setQuestionStoreId(Integer questionStoreId) {
        this.questionStoreId = questionStoreId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public QuestionStoreStatus getStatus() {
        return status;
    }

    public void setStatus(QuestionStoreStatus status) {
        this.status = status;
    }
}