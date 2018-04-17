package com.weather.redbee.dao;

import com.weather.redbee.entity.BoardCity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardCityDao extends CrudRepository<BoardCity, Long> {

    @Query("SELECT new com.weather.redbee.entity.BoardCity(boardCityId, boardId, cityId) FROM BOARD_CITY WHERE boardId =:boardId AND cityId = :cityId")
    Optional<BoardCity> findByBoardIdAndCityId(@Param("boardId") Long boardId,
                                              @Param("cityId") Long cityId);

}
