package com.app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;
@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    private Date dateOfBirth;
    private String sex;
    private String avatar;
    private String dayIn;
    private String about;
    private String selfIntroduce;
    private Set<ProgrammingLanguage> progLanguage;
    private int status;
    private Set<Role> roles ;
    private Set<Team> teams;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.dateOfBirth = user.getDateOfBirth();
        this.sex = user.getSex();
        this.avatar = user.getAvatar();
        this.dayIn = user.getDayIn();
        this.about = user.getAbout();
        this.selfIntroduce = user.getSelfIntroduce();
        this.progLanguage = user.getProgLanguage();
        this.status = user.getStatus();
        this.roles = user.getRoles();
        this.teams = user.getTeams();
    }
}
