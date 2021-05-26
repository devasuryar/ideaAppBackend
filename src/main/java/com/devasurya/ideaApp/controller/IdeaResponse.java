package com.devasurya.ideaApp.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdeaResponse {
    private Long ideaId;
    private String ideaName;
    private String description;
    private String userName;
    private String topicName;
   // private Integer voteCount;
    private String createdDate;
   // private boolean upVote;
    //private boolean downVote;
}
