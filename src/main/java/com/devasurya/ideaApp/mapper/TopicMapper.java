package com.devasurya.ideaApp.mapper;


import com.devasurya.ideaApp.dto.TopicDto;
import com.devasurya.ideaApp.model.Idea;
import com.devasurya.ideaApp.model.Topic;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TopicMapper {


    @Mapping(target ="numberOfIdeas", expression = "java(mapIdeas(topic.getIdeas()))")
    TopicDto mapTopicToDto(Topic topic);

    default Integer mapIdeas(List<Idea> numberOfIdeas) {
        return numberOfIdeas.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "ideas", ignore = true)
    Topic mapDtoToTopic(TopicDto topicDto);

}
