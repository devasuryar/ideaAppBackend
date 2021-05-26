package com.devasurya.ideaApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdeaRequest {
    private Long ideaId;
    private String topicName;
    private String ideaName;
    private String description;
}
