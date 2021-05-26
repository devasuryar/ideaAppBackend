package com.devasurya.ideaApp.mapper;

import com.devasurya.ideaApp.controller.IdeaResponse;
import com.devasurya.ideaApp.dto.IdeaRequest;
import com.devasurya.ideaApp.model.Idea;
import com.devasurya.ideaApp.model.Topic;
import com.devasurya.ideaApp.model.User;
import com.devasurya.ideaApp.service.AuthService;
import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.programming.techie.springredditclone.dto.PostRequest;
import com.programming.techie.springredditclone.dto.PostResponse;
import com.programming.techie.springredditclone.model.*;
import com.programming.techie.springredditclone.repository.CommentRepository;
import com.programming.techie.springredditclone.repository.VoteRepository;
import com.programming.techie.springredditclone.service.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.programming.techie.springredditclone.model.VoteType.DOWNVOTE;
import static com.programming.techie.springredditclone.model.VoteType.UPVOTE;

@Mapper(componentModel = "spring")
public abstract class IdeaMapper {


//    @Autowired
//    private VoteRepository voteRepository;
    @Autowired
    private AuthService authService;


    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "ideaRequest.description")
    @Mapping(target = "topic", source = "topic")
  //  @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "user", source = "user")
    public abstract Idea map(IdeaRequest ideaRequest, Topic topic, User user);


    @Mapping(target = "topicName", source = "topic.name")
    @Mapping(target = "userName", source = "user.username")
  //  @Mapping(target = "upVote", expression = "java(isPostUpVoted(post))")
   // @Mapping(target = "downVote", expression = "java(isPostDownVoted(post))")
    public abstract IdeaResponse mapToDto(Idea idea);


   /* boolean isPostUpVoted(Post post) {
        return checkVoteType(post, UPVOTE);
    }

    boolean isPostDownVoted(Post post) {
        return checkVoteType(post, DOWNVOTE);
    }

    private boolean checkVoteType(Post post, VoteType voteType) {
        if (authService.isLoggedIn()) {
            Optional<Vote> voteForPostByUser =
                    voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post,
                            authService.getCurrentUser());
            return voteForPostByUser.filter(vote -> vote.getVoteType().equals(voteType))
                    .isPresent();
        }
        return false;
    }*/

}