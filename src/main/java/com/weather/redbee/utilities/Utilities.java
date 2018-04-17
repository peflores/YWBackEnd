package com.weather.redbee.utilities;

import com.weather.redbee.dot.BoardCityDTO;
import com.weather.redbee.dot.BoardDTO;
import com.weather.redbee.dot.CityDTO;
import com.weather.redbee.entity.Board;
import com.weather.redbee.entity.BoardCity;
import com.weather.redbee.entity.City;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;

@Component
public class Utilities {

    public Timestamp getCurrentDateTime() {
        Calendar toDay = Calendar.getInstance();
        toDay.clear(Calendar.MILLISECOND);
        toDay.clear(Calendar.SECOND);
        return new Timestamp(toDay.getTimeInMillis());
    }

    public Timestamp getBeforesHourDateTime() {
        Calendar toDay = Calendar.getInstance();
        toDay.clear(Calendar.MILLISECOND);
        toDay.clear(Calendar.SECOND);
        toDay.add(Calendar.HOUR_OF_DAY, -1);

        return new Timestamp(toDay.getTimeInMillis());
    }

    public BoardDTO convertVOtoDTO(Board board) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardId(String.valueOf(board.getBoardId()));
        boardDTO.setUserId(String.valueOf(board.getBoardId()));
        boardDTO.setBoardName(board.getBoardName());
        return boardDTO;
    }

    public BoardCity convertDTOtoVO(BoardCityDTO boardCity) {
        BoardCity boardVO = new BoardCity();
        boardVO.setBoardCityId(StringUtils.trimToNull(boardCity.getBoardCityId()) != null ?
                Long.valueOf(StringUtils.trimToNull(boardCity.getBoardCityId())) : null );
        boardVO.setBoardId(StringUtils.trimToNull(boardCity.getBoardId()) != null ?
                Long.valueOf(boardCity.getBoardId()) : null );
        boardVO.setCityId(StringUtils.trimToNull(boardCity.getCityId()) != null ?
                Long.valueOf(boardCity.getCityId()) : null );
        return boardVO;
    }

    public Board converDOTtoVo(BoardDTO board) {
        Board boardVO = new Board();
        boardVO.setBoardId(StringUtils.trimToNull(board.getBoardId()) != null ? Long.valueOf(board.getBoardId()) : null );
        boardVO.setUserId(StringUtils.trimToNull(board.getUserId()) != null ?  Long.valueOf(board.getUserId()) : null);
        boardVO.setBoardName(StringUtils.trimToNull(board.getBoardName()));
        return boardVO;
    }

    public CityDTO convertVOtoDTO(City city) {
        CityDTO cityDTO =  new CityDTO();
        cityDTO.setCityId(String.valueOf(city.getCityId()));
        cityDTO.setDate(city.getDate());
        cityDTO.setDescription(city.getDescription());
        cityDTO.setLat(city.getLat());
        cityDTO.setLon(city.getLon());
        cityDTO.setTemp(city.getTemp());
        cityDTO.setText(city.getText());
        cityDTO.setTitle(city.getTitle());
        cityDTO.setUnit(city.getUnit());
        return cityDTO;
    }

    public BoardCityDTO convertVOtoDTO(BoardCity boardCity) {
        BoardCityDTO boardCityDTO = new BoardCityDTO();
        boardCityDTO.setBoardCityId(String.valueOf(boardCity.getBoardCityId()));
        boardCityDTO.setBoardId(String.valueOf(boardCity.getBoardId()));
        boardCityDTO.setCityId(String.valueOf(boardCity.getCityId()));
        return boardCityDTO;
    }

    public City converDTOtoVO(CityDTO city) {
        City cityVO = new City();
        cityVO.setCityId(StringUtils.trimToNull(city.getCityId()) != null ? Long.valueOf(city.getCityId()) : null);
        cityVO.setDate(city.getDate());
        cityVO.setDescription(city.getDescription());
        cityVO.setLat(city.getLat());
        cityVO.setLon(city.getLon());
        cityVO.setTemp(city.getTemp());
        cityVO.setText(city.getText());
        cityVO.setTitle(city.getTitle());
        cityVO.setUnit(city.getUnit());
        return cityVO;
    }

    public String getImgUrl(String description) {
        return StringUtils.substringBefore(
                StringUtils.substringAfter(
                        description,"=\""), "\"/>");
    }
}
