package com.entity;

import java.sql.Timestamp;
import java.util.List;

public class CommentInfo {

    private Integer commentId;//评论id
    private Integer uid;//评论者id
    private Integer workId;//评论作品的id
    private Timestamp commentTime;//评论内容
    private String commentDetails;//被评论者id
    private Integer anotherUid;//评论时间

    private WorksInfo worksInfo;
    private User user;
    private User anotherUser;

    public CommentInfo() {
    }

    public CommentInfo(Integer uid, Integer workId, String commentDetails ,Integer anotherUid) {

        this.uid = uid;
        this.workId = workId;
        this.commentDetails = commentDetails;
        this.anotherUid = anotherUid;
    }

    public CommentInfo(Integer commentId, Integer uid, Integer workId, Timestamp commentTime, String commentDetails, Integer anotherUid) {
        this.commentId = commentId;
        this.uid = uid;
        this.workId = workId;
        this.commentTime = commentTime;
        this.commentDetails = commentDetails;
        this.anotherUid=anotherUid;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentDetails() {
        return commentDetails;
    }

    public void setCommentDetails(String commentDetails) {
        this.commentDetails = commentDetails;
    }

    public Integer getAnotherUid() {
        return anotherUid;
    }

    public void setAnotherUid(Integer anotherUid) {
        this.anotherUid = anotherUid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorksInfo getWorksInfo() {
        return worksInfo;
    }

    public void setWorksInfo(WorksInfo worksInfo) {
        this.worksInfo = worksInfo;
    }

    public User getAnotherUser() {
        return anotherUser;
    }

    public void setAnotherUser(User anotherUser) {
        this.anotherUser = anotherUser;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
                "commentId=" + commentId +
                ", uid=" + uid +
                ", workId=" + workId +
                ", commentTime=" + commentTime +
                ", commentDetails='" + commentDetails + '\'' +
                ", anotherUid=" + anotherUid +
                ", worksInfo=" + worksInfo +
                ", user=" + user +
                '}';
    }
}
