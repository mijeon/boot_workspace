package com.edu.boot0307.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.edu.boot0307.domain.Board;
import com.edu.boot0307.exception.BoardException;

@Repository
public class MybatisBoardDAO implements BoardDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(Board board) throws BoardException{
		int result=sqlSessionTemplate.insert("Board.insert", board);
		if(result<1) {
			throw new BoardException("등록 실패");
		}
	}
}
