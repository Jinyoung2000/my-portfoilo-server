package com.jinyoung2000.myportfolioserver.service

import com.jinyoung2000.myportfolioserver.entity.Board
import com.jinyoung2000.myportfolioserver.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {
    fun getAllBoards(): List<Board> {
        return boardRepository.findAll()
    }
}