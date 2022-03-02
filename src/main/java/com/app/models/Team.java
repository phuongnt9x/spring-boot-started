package com.app.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;
    private String about;

    public Team(String name, String image, String about) {
        this.name = name;
        this.image = image;
        this.about = about;
    }

    public Team() {
    }

}
