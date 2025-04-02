package com.notice.notice_board.presentation;

import com.notice.notice_board.application.dto.request.PostRequestDto;
import com.notice.notice_board.application.dto.response.PostUpdateResponseDto;
import com.notice.notice_board.application.service.PostService;
import com.notice.notice_board.domain.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Void> createPost(@RequestBody PostRequestDto requestDto) {
        Long postId = postService.createPost(requestDto);
        URI postLocation = UriComponentsBuilder
                        .fromUriString("/api/v1/posts/{id}")
                        .buildAndExpand(postId)
                        .toUri();
        return ResponseEntity.created(postLocation).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostUpdateResponseDto> modifyPost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        PostUpdateResponseDto responseDto = postService.modifyPost(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPost(id));
    }



}
