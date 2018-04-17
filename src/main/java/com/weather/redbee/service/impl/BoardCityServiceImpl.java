package com.weather.redbee.service.impl;


import com.weather.redbee.dao.BoardCityDao;
import com.weather.redbee.dot.BoardCityDTO;
import com.weather.redbee.entity.BoardCity;
import com.weather.redbee.service.BoardCityService;
import com.weather.redbee.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BoardCityServiceImpl implements BoardCityService {

    @Autowired
    private BoardCityDao boardCityDao;
    @Autowired
    private Utilities utilities;

    @Override
    public BoardCityDTO add(BoardCityDTO boardCity) {
        BoardCity boardVO = utilities.convertDTOtoVO(boardCity);
        BoardCity boardCityVO = boardCityDao.save(boardVO);
        boardCity.setBoardCityId(String.valueOf(boardCityVO.getBoardCityId()));
        return boardCity;
    }


    @Override
    public List<BoardCityDTO> findAll() {
        List<BoardCityDTO> result = new ArrayList<>();
        boardCityDao.findAll().forEach(
                boardCity -> {
                    BoardCityDTO boardCityDTO = utilities.convertVOtoDTO(boardCity);
                    result.add(boardCityDTO);
                });
        return result;
    }

    @Override
    public BoardCityDTO update(BoardCityDTO boardCity) {

        return utilities.convertVOtoDTO(
                boardCityDao.save(utilities.convertDTOtoVO(boardCity)));
    }

    @Override
    public void delete(BoardCityDTO boardCityDTO) {
        boardCityDao.findByBoardIdAndCityId(Long.valueOf(boardCityDTO.getBoardId()),
                Long.valueOf(boardCityDTO.getCityId())).ifPresent(
                boardCity -> {
                    boardCityDao.delete(boardCity);
                }
        );
    }
}
