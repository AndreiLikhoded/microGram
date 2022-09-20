package com.example.microGram.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Publication {
    private String image;
    private String description;
    private LocalDateTime dataOfPublication;

    public Publication(String image, String description, LocalDateTime dataOfPublication) {
        this.image = image;
        this.description = description;
        this.dataOfPublication = dataOfPublication;
    }
}
