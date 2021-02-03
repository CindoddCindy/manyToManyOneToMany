package myrelations.myrelationstessdemo.controller;


import myrelations.myrelationstessdemo.exception.ResourceNotFoundException;
import myrelations.myrelationstessdemo.model.Comment;
import myrelations.myrelationstessdemo.model.Like;
import myrelations.myrelationstessdemo.repository.CommentRepository;
import myrelations.myrelationstessdemo.repository.LikeRepository;
import myrelations.myrelationstessdemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LikeController {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts/{postId}/like")
    public Page<Like> getAllLikesByPostId(@PathVariable (value = "postId") Long postId,
                                             Pageable pageable) {
        return likeRepository.findByPostId(postId, pageable);
    }

    @PostMapping("/posts/{postId}/likes")
    public Like createLike(@PathVariable (value = "postId") Long postId,
                                 @Valid @RequestBody Like like) {
        return postRepository.findById(postId).map(post -> {
            like.setPost(post);
            return likeRepository.save(like);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    @PutMapping("/posts/{postId}/like/{likeId}")
    public Like updateLike(@PathVariable (value = "postId") Long postId,
                                 @PathVariable (value = "likeId") Long likeId,
                                 @Valid @RequestBody Like likeRequest) {
        if(!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("PostId " + postId + " not found");
        }

        return likeRepository.findById(likeId).map(like -> {
            like.setText(likeRequest.getText());
            return likeRepository.save(like);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + likeId + "not found"));
    }

    @DeleteMapping("/posts/{postId}/like/{likeId}")
    public ResponseEntity<?> deleteLike(@PathVariable (value = "postId") Long postId,
                                           @PathVariable (value = "likeId") Long likeId) {
        return likeRepository.findByIdAndPostId(likeId, postId).map(like -> {
            likeRepository.delete(like);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + likeId + " and postId " + postId));
    }
}
