package com.app.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String language;
}
