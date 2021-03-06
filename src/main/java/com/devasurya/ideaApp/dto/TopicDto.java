package com.devasurya.ideaApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicDto {
    private Long topicId;
    private String topicname;
    private String description;
    private Integer numberOfIdeas;
}
