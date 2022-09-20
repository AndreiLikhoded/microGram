package com.example.microGram.entity;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Subscriber {
    private int subscriberId;
    private User subscriberTo;
    private LocalDateTime dateSubscribe;


    public Subscriber(int subscriberId, User subscriberTo, LocalDateTime dateSubscribe) {
        this.subscriberId = subscriberId;
        this.subscriberTo = subscriberTo;
        this.dateSubscribe = dateSubscribe;
    }
}
