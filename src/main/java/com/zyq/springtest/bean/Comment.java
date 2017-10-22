package com.zyq.springtest.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer courseId;

    private Integer userId;

    private Integer toUserId;

    private Date commentTime;

    private Boolean readed;

    private String content;

    public Comment() {
    }

    public Comment(Integer courseId, Integer userId, Date commentTime, String content) {
        this.courseId = courseId;
        this.userId = userId;
        this.commentTime = commentTime;
        this.content = content;
    }

    public Comment(Integer courseId, Integer userId, Integer toUserId, Date commentTime, Boolean readed, String content) {
        this.courseId = courseId;
        this.userId = userId;
        this.toUserId = toUserId;
        this.commentTime = commentTime;
        this.readed = readed;
        this.content = content;
    }

    public Comment(Integer id, Integer courseId, Integer userId, Integer toUserId, Date commentTime, Boolean readed, String content) {
        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
        this.toUserId = toUserId;
        this.commentTime = commentTime;
        this.readed = readed;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Boolean getReaded() {
        return readed;
    }

    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", userId=" + userId +
                ", toUserId=" + toUserId +
                ", commentTime=" + commentTime +
                ", readed=" + readed +
                ", content='" + content + '\'' +
                '}';
    }
}