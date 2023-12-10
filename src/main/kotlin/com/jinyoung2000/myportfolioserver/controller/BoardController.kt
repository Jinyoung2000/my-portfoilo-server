package com.jinyoung2000.myportfolioserver.controller

import com.jinyoung2000.myportfolioserver.dto.BoardResponse
import com.jinyoung2000.myportfolioserver.dto.PostBoardRequest
import com.jinyoung2000.myportfolioserver.entity.Board
import com.jinyoung2000.myportfolioserver.service.BoardService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/boards")
class BoardController(
    private val boardService: BoardService
) {
    @GetMapping("")
    fun getAllBoards(): List<Board> {
        return boardService.getAllBoards()
    }

    @PostMapping("")
    fun postBoard(@RequestBody body: PostBoardRequest): Board {
        return boardService.postBoard(body)
    }

    @GetMapping("{boardId}")
    fun getBoard(@PathVariable boardId: Long): BoardResponse {
        return boardService.getBoard(boardId)
    }
}