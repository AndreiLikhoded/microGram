package com.example.microGram.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private String commentText;
    private Date dateComment;

    private User user;

    public Comment(String commentText, Date dateComment) {
        this.commentText = commentText;
        this.dateComment = dateComment;
    }
}
