package com.example.microGram.entity;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Like {
    private User likeHolder;
    private Subscriber subLikeHolder;
    private User likeAim;
    private LocalDateTime dateOfLike;

    public Like(User likeHolder, User likeAim, LocalDateTime dateOfLike, Subscriber subLikeHolder) {
        this.likeHolder = likeHolder;
        this.likeAim = likeAim;
        this.dateOfLike = dateOfLike;
        this.subLikeHolder = subLikeHolder;
    }
}


