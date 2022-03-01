package com.example.springbootstarted.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
public class Employee {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Date dateOfBirth;
    private String sex;
    private String avatar;
    private String dayIn;
    private String about;
    private String selfIntroduce;
    private Long groupId;
    private Long languageId;
}
