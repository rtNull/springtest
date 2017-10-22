package com.zyq.springtest.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Resource {

    private Integer id;

    private Integer chapterId;

    private String name;

    private String type;

    private Date date;

    private String url;

    public Resource() {
    }

    public Resource(Integer chapterId, String name) {
        this.chapterId = chapterId;
        this.name = name;
    }

    public Resource(Integer chapterId, String name, String url) {
        this.chapterId = chapterId;
        this.name = name;
        this.url = url;
    }

    public Resource(Integer id, Integer chapterId, String name, String url) {
        this.id = id;
        this.chapterId = chapterId;
        this.name = name;
        this.url = url;
    }

    public Resource(Integer chapterId, String name, String type, Date date, String url) {
        this.chapterId = chapterId;
        this.name = name;
        this.type = type;
        this.date = date;
        this.url = url;
    }

    public Resource(Integer id, Integer chapterId, String name, String type, Date date, String url) {
        this.id = id;
        this.chapterId = chapterId;
        this.name = name;
        this.type = type;
        this.date = date;
        this.url = url;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }


    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", chapterId=" + chapterId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", url='" + url + '\'' +
                '}';
    }
}