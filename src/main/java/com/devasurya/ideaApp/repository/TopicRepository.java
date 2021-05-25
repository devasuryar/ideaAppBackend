package com.devasurya.ideaApp.repository;


import com.devasurya.ideaApp.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findByTopicname(String topicName);
}
