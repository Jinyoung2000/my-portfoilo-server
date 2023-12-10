package com.jinyoung2000.myportfolioserver.dto

import com.jinyoung2000.myportfolioserver.entity.Board
import org.springframework.data.annotation.CreatedDate
import java.time.format.DateTimeFormatter

class BoardResponse(
    val id: Long, val title: String, val content: String, val createdDate: String
) {
    companion object {
        fun toBoardResponse(board: Board): BoardResponse {
            with(board) {
                return BoardResponse(
                    id, title, content, createdAt.toString()
                )
            }
        }
    }
}