package com.notice.notice_board.presentation;

import com.notice.notice_board.application.dto.request.PostRequestDto;
import com.notice.notice_board.application.dto.response.PostResponseDto;
import com.notice.notice_board.application.dto.response.PostUpdateResponseDto;
import com.notice.notice_board.application.service.PostService;
import com.notice.notice_board.domain.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;
import org.springframework.data.web.PagedResourcesAssembler;
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
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long id,
                                                         @RequestParam(required = false, defaultValue = "0") int page,
                                                         @RequestParam(required = false, defaultValue = "10") int size) {
        size = pageSizeCheck(size);
        return ResponseEntity.ok(postService.getPost(id, page, size));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    private int pageSizeCheck(int size) {
        if(size != 10 && size != 30 && size != 50){
            return size = 10;
        }
        return size;
    }



}
