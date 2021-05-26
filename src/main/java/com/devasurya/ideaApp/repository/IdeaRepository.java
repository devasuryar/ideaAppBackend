package com.devasurya.ideaApp.repository;

import com.devasurya.ideaApp.model.Idea;
import com.devasurya.ideaApp.model.Topic;
import com.devasurya.ideaApp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {

    List<Idea> findAllByTopic(Topic topic);

    List<Idea> findByUser(User user);
}
