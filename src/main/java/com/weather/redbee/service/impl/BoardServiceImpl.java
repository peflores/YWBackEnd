package com.weather.redbee.service.impl;

import com.weather.redbee.dao.BoardDao;
import com.weather.redbee.dot.BoardDTO;

import com.weather.redbee.entity.Board;
import com.weather.redbee.service.BoardService;
import com.weather.redbee.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao genericDao;

    @Autowired
    private Utilities utilities;

    @Override
    public BoardDTO add(BoardDTO board) {

        Board result =  genericDao.save(utilities.converDOTtoVo(board));
        board.setBoardId(String.valueOf(result.getBoardId()));
        return board;
    }



    @Override
    public List<BoardDTO> findAll() {
        List<BoardDTO> result = new ArrayList<BoardDTO>();
        genericDao.findAll().forEach(
                board -> {
                    result.add(utilities.convertVOtoDTO(board));
                }
        );
        return result;
    }

    @Override
    public BoardDTO update(BoardDTO board) {
        genericDao.save(utilities.converDOTtoVo(board));
        return board;
    }

    @Override
    public void delete(BoardDTO boardDTO) {

    }
}
