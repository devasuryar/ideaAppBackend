package com.devasurya.ideaApp.service;

import com.devasurya.ideaApp.dto.TopicDto;
import com.devasurya.ideaApp.exception.TopicNotFoundException;
import com.devasurya.ideaApp.mapper.TopicMapper;
import com.devasurya.ideaApp.model.Topic;
import com.devasurya.ideaApp.repository.TopicRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class TopicService {
    private final TopicRepository topicRepository;
    private final AuthService authService;
    private final TopicMapper topicMapper;

    @Transactional(readOnly = true)
    public List<TopicDto> getAll() {
        return topicRepository.findAll()
                .stream()
                .map(topicMapper::mapTopicToDto)
                .collect(toList());
    }

    @Transactional
    public TopicDto save(TopicDto topicDto) {
        Topic topic = topicRepository.save(topicMapper.mapDtoToTopic(topicDto));
        topicDto.setTopicId(topic.getTopicId());
        return topicDto;
    }

    @Transactional(readOnly = true)
    public TopicDto getTopic(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("Subreddit not found with id -" + id));
        return topicMapper.mapTopicToDto(topic);
    }

//    private TopicDto mapToDto(Topic topic) {
//        return TopicDto.builder().name(topic.getTopicname())
//                .id(topic.getTopicId())
//                .build();
//    }
//
//    private Topic mapToTopic(TopicDto topicDto) {
//        return Topic.builder().topicname(topicDto.getName())
//                .description(topicDto.getDescription())
//                .user(authService.getCurrentUser()).build();
//    }
}
