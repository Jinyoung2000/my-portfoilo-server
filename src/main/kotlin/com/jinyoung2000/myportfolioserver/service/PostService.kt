package com.jinyoung2000.myportfolioserver.service

import com.jinyoung2000.myportfolioserver.dto.PostResponse
import com.jinyoung2000.myportfolioserver.dto.PostPostRequest
import com.jinyoung2000.myportfolioserver.entity.Post
import com.jinyoung2000.myportfolioserver.repository.PostRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {
    fun getAllBoards(): List<Post> {
        return postRepository.findAll()
    }

    fun getBoard(id: Long): PostResponse {
        return PostResponse.toPostResponse(postRepository.getReferenceById(id))
    }

    @Transactional
    fun postBoard(request: PostPostRequest): Post {
        with(request) {
            return postRepository.save(Post(title, content))
        }
    }
}
