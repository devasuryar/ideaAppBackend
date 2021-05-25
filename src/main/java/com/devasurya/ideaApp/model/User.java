package com.devasurya.ideaApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long userId;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String type;
    private Instant created;

}
