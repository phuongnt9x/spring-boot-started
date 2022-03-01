package com.example.springbootstarted.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Group {
    private Long id;
    private String name;
    private String image;
    private String about;

    public Group(String name, String image, String about) {
        this.name = name;
        this.image = image;
        this.about = about;
    }
}
