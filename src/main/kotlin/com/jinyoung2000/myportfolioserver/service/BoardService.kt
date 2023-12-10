package com.jinyoung2000.myportfolioserver.service

import com.jinyoung2000.myportfolioserver.dto.BoardResponse
import com.jinyoung2000.myportfolioserver.dto.PostBoardRequest
import com.jinyoung2000.myportfolioserver.entity.Board
import com.jinyoung2000.myportfolioserver.repository.BoardRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {
    fun getAllBoards(): List<Board> {
        return boardRepository.findAll()
    }

    fun getBoard(id: Long): BoardResponse {
        return BoardResponse.toBoardResponse(boardRepository.getReferenceById(id))
    }

    @Transactional
    fun postBoard(request: PostBoardRequest): Board {
        with(request) {
            return boardRepository.save(Board(title, content))
        }
    }
}