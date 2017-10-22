package com.zyq.springtest.bean;

public class Subject {
    private Integer id;

    private String subjectName;

    private String institute;

    public Subject() {
    }

    public Subject(Integer id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }

    public Subject(Integer id, String subjectName, String institute) {
        this.id = id;
        this.subjectName = subjectName;
        this.institute = institute;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute == null ? null : institute.trim();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", institute='" + institute + '\'' +
                '}';
    }
}