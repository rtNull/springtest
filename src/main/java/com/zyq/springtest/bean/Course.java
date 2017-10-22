package com.zyq.springtest.bean;

public class Course {
    private Integer id;

    private Integer subjectId;

    private Integer userId;

    private String courseName;

    private String introduction;

    public Course() {
    }

    public Course(Integer subjectId, Integer userId, String courseName) {
        this.subjectId = subjectId;
        this.userId = userId;
        this.courseName = courseName;
    }

    public Course(Integer subjectId, Integer userId, String courseName, String introduction) {
        this.subjectId = subjectId;
        this.userId = userId;
        this.courseName = courseName;
        this.introduction = introduction;
    }

    public Course(Integer id, Integer subjectId, Integer userId, String courseName, String introduction) {
        this.id = id;
        this.subjectId = subjectId;
        this.userId = userId;
        this.courseName = courseName;
        this.introduction = introduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", userId=" + userId +
                ", courseName='" + courseName + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}