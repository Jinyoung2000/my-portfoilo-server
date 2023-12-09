package com.jinyoung2000.myportfolioserver.repository

import com.jinyoung2000.myportfolioserver.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : JpaRepository<Board, Long> {

}