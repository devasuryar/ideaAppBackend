package com.devasurya.ideaApp.service;

import com.devasurya.ideaApp.controller.IdeaResponse;
import com.devasurya.ideaApp.dto.IdeaRequest;
import com.devasurya.ideaApp.exception.IdeaNotFoundException;
import com.devasurya.ideaApp.exception.TopicNotFoundException;
import com.devasurya.ideaApp.mapper.IdeaMapper;
import com.devasurya.ideaApp.model.Idea;
import com.devasurya.ideaApp.model.Topic;
import com.devasurya.ideaApp.repository.IdeaRepository;
import com.devasurya.ideaApp.repository.TopicRepository;
import com.devasurya.ideaApp.repository.UserRepository;
import com.programming.techie.springredditclone.dto.PostRequest;
import com.programming.techie.springredditclone.dto.PostResponse;
import com.programming.techie.springredditclone.exceptions.PostNotFoundException;
import com.programming.techie.springredditclone.exceptions.SubredditNotFoundException;
import com.programming.techie.springredditclone.mapper.PostMapper;
import com.programming.techie.springredditclone.model.Post;
import com.programming.techie.springredditclone.model.Subreddit;
import com.programming.techie.springredditclone.model.User;
import com.programming.techie.springredditclone.repository.PostRepository;
import com.programming.techie.springredditclone.repository.SubredditRepository;
import com.programming.techie.springredditclone.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class IdeaService {

    private final IdeaRepository ideaRepository;
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final IdeaMapper ideaMapper;

    public void save(IdeaRequest ideaRequest) {
        Topic topic = topicRepository.findByTopicname(ideaRequest.getTopicName())
                .orElseThrow(() -> new TopicNotFoundException(ideaRequest.getTopicName()));
        ideaRepository.save(ideaMapper.map(ideaRequest, topic, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public IdeaResponse getIdea(Long id) {
        Idea idea = ideaRepository.findById(id)
                .orElseThrow(() -> new IdeaNotFoundException(id.toString()));
        return ideaMapper.mapToDto(idea);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return ideaRepository.findAll()
                .stream()
                .map(ideaMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsBySubreddit(Long subredditId) {
        Subreddit subreddit = topicRepository.findById(subredditId)
                .orElseThrow(() -> new SubredditNotFoundException(subredditId.toString()));
        List<Post> posts = ideaRepository.findAllBySubreddit(subreddit);
        return posts.stream().map(ideaMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return ideaRepository.findByUser(user)
                .stream()
                .map(ideaMapper::mapToDto)
                .collect(toList());
    }
}
