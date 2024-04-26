package com.surfapp.feedback;

import com.surfapp.spot.Spot;
import com.surfapp.spot.SpotRepository;
import com.surfapp.user.User;
import com.surfapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final SpotRepository spotRepository;
    @Autowired
    public CommentController(CommentRepository commentRepository, UserRepository userRepository, SpotRepository spotRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.spotRepository = spotRepository;
    }





    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping(
            path = "api/comment",
            produces = "application/json; charset=utf-8"
    ) public List<CommentDto> getComments(){
        System.out.println("Get Mapping: Comments");
        return this.commentRepository.findAll().stream().map(e -> new CommentDto(e.getText(),e.getUser().getUsername(),e.getSpot().getId(),e.getDate())).toList();
    }

    @PostMapping(
            path = "api/comment",
            consumes = "application/json; charset=utf-8"
    ) public void addComment(@RequestBody CommentDto commentDto){
        System.out.println("Post Mapping: Comments");
        System.out.println("SpotID:" + commentDto.getSpotId());
        System.out.println(commentDto.getUsername());
        User user = this.userRepository.findByUsername(commentDto.getUsername());
        System.out.println(user.toString());
        Spot spot = this.spotRepository.findById(commentDto.getSpotId()).orElseThrow();
        Comment newComment = new Comment(commentDto.getText(),user,spot,commentDto.getDate());
        this.commentRepository.save(newComment);
    }

}
