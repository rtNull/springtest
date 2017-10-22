package com.zyq.springtest.dto;


import com.zyq.springtest.bean.Comment;
import com.zyq.springtest.bean.User;

/**
 * Created by zhanyq on 2017/4/6.
 */

public class CommentPair {
    private User user;
    private Comment comment;

    public CommentPair() {
    }

    public CommentPair(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentPair{" +
                "user=" + user +
                ", comment=" + comment +
                '}';
    }
}
