package com.classgen.classgen.service;
import com.classgen.classgen.models.Discussion;
import com.classgen.classgen.models.Message;
import com.classgen.classgen.repositories.DiscussionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    public DiscussionService(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    public Discussion createDiscussion() {
        return discussionRepository.save(new Discussion());
    }

    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    public Discussion getDiscussionById(Long id) {
        return discussionRepository.findById(id).orElseThrow();
    }

    public Discussion addMessageToDiscussion(Long discussionId, Message message) {
        Discussion discussion = getDiscussionById(discussionId);
        message.setDiscussion(discussion);
        discussion.getMessages().add(message);
        return discussionRepository.save(discussion);
    }

}
