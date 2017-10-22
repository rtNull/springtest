package com.zyq.springtest.dto;

import com.zyq.springtest.bean.Course;
import com.zyq.springtest.bean.Subject;
import com.zyq.springtest.bean.User;

/**
 * Created by zhanyq on 2017/4/4.
 */

public class CoursePair {

    Subject subject;
    Course course;
    User user;

    public CoursePair() {
    }

    public CoursePair(Subject subject, Course course) {
        this.subject = subject;
        this.course = course;
    }

    public CoursePair(Subject subject, Course course, User user) {
        this.subject = subject;
        this.course = course;
        this.user = user;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CoursePair{" +
                "subject=" + subject +
                ", course=" + course +
                ", user=" + user +
                '}';
    }
}
