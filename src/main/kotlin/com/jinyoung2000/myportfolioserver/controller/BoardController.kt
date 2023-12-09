package com.jinyoung2000.myportfolioserver.controller

import com.jinyoung2000.myportfolioserver.entity.Board
import com.jinyoung2000.myportfolioserver.service.BoardService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/boards")
class BoardController(
    private val boardService: BoardService
) {
    @GetMapping("")
    fun getAllBoards(): List<Board> {
        return boardService.getAllBoards()
    }
}