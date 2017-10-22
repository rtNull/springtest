package com.zyq.springtest.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Chapter {
    public Chapter() {
    }

    public Chapter(Integer id, Integer courseId) {
        this.id = id;
        this.courseId = courseId;
    }

    public Chapter(Integer courseId, String title) {
        this.courseId = courseId;
        this.title = title;
    }

    public Chapter(Integer courseId, String title, Date createDate) {
        this.courseId = courseId;
        this.title = title;
        this.createDate = createDate;
    }

    public Chapter(Integer id, Integer courseId, String title, Date createDate) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.createDate = createDate;
    }

    private Integer id;

    private Integer courseId;

    private String title;

    private Date createDate;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", title='" + title + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}