package com.devasurya.ideaApp.mapper;


import com.devasurya.ideaApp.dto.TopicDto;
import com.devasurya.ideaApp.model.Topic;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TopicMapper {

    @Mapping(source = "topicId" ,target ="id")
    @Mapping(source = "topicname" ,target ="name")
    TopicDto mapTopicToDto(Topic topic);


    @InheritInverseConfiguration
    Topic mapDtoToTopic(TopicDto topicDto);

}
