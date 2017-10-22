package com.zyq.springtest.bean;

public class MyCourse {
    private Integer id;

    private Integer userId;

    private Integer courseId;

    public MyCourse(Integer userId, Integer courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    public MyCourse(Integer userId) {
        this.userId = userId;
    }

    public MyCourse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "MyCourse{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                '}';
    }
}