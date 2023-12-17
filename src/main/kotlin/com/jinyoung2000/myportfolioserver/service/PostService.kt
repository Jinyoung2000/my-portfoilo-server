package com.jinyoung2000.myportfolioserver.service

import com.jinyoung2000.myportfolioserver.dto.PostPostRequest
import com.jinyoung2000.myportfolioserver.dto.PostResponse
import com.jinyoung2000.myportfolioserver.dto.UpdatePostRequest
import com.jinyoung2000.myportfolioserver.entity.Post
import com.jinyoung2000.myportfolioserver.repository.PostRepository
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.lang.Exception

@Service
class PostService(
    private val postRepository: PostRepository
) {
    fun getAllPosts(): List<Post> {
        return postRepository.findAll()
    }

    fun getPost(id: Long): PostResponse {
        return PostResponse.toPostResponse(postRepository.getReferenceById(id))
    }

    @Transactional
    fun savePost(request: PostPostRequest): Post {
        with(request) {
            return postRepository.save(Post(title, content))
        }
    }

    @Transactional
    fun updatePost(id: Long, request: UpdatePostRequest): Post {
        // TODO: Exception Handler
        val post = postRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "POST를 찾을 수 없습니다.")
        }

        post.title = request.title
        post.content = request.content


        return postRepository.save(post)
    }
}
