package com.jinyoung2000.myportfolioserver.controller

import com.jinyoung2000.myportfolioserver.dto.PostResponse
import com.jinyoung2000.myportfolioserver.dto.PostPostRequest
import com.jinyoung2000.myportfolioserver.dto.UpdatePostRequest
import com.jinyoung2000.myportfolioserver.entity.Post
import com.jinyoung2000.myportfolioserver.service.PostService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts")
class PostController(
    private val postService: PostService
) {
    @GetMapping("")
    fun getAllPosts(): List<Post> {
        return postService.getAllPosts()
    }

    @PostMapping("")
    fun savePost(@RequestBody body: PostPostRequest): Post {
        return postService.savePost(body)
    }

    @GetMapping("{postId}")
    fun getPost(@PathVariable postId: Long): PostResponse {
        return postService.getPost(postId)
    }

    @PatchMapping("{postId}")
    fun updatePost(@PathVariable postId: Long, @RequestBody body: UpdatePostRequest): Post {
        return postService.updatePost(postId, body)
    }
}
