package com.classgen.classgen.controller;
import com.classgen.classgen.models.Discussion;
import com.classgen.classgen.models.Message;
import com.classgen.classgen.service.DiscussionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/discussions")
public class DiscussionController {

    private final DiscussionService discussionService;

    public DiscussionController(DiscussionService discussionService) {
        this.discussionService = discussionService;
    }

    @PostMapping
    public Discussion createDiscussion() {
        return discussionService.createDiscussion();
    }

    @GetMapping
    public List<Discussion> getAllDiscussion(){
        return discussionService.getAllDiscussions();
    }

    @GetMapping("/{id}")
    public Discussion getDiscussionById(@PathVariable Long id) {
        return discussionService.getDiscussionById(id);
    }


    @PostMapping("/{id}/message")
    public Discussion addMessageToDiscussion(@PathVariable Long id, @RequestBody Message message) {
        return discussionService.addMessageToDiscussion(id, message);
    }

}
