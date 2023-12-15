package com.jinyoung2000.myportfolioserver.dto

import com.jinyoung2000.myportfolioserver.entity.Post

class PostResponse(
    val id: Long, val title: String, val content: String, val createdDate: String
) {
    companion object {
        fun toPostResponse(post: Post): PostResponse {
            with(post) {
                return PostResponse(
                    id, title, content, createdAt.toString()
                )
            }
        }
    }
}
