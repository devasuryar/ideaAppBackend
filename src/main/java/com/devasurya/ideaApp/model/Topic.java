package com.devasurya.ideaApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Topic {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long topicId;

    private String topicname;
    private String description;
    @ManyToOne(fetch = LAZY)
    private User user;


}
