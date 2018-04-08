package com.weather.redbee.dao;

import com.weather.redbee.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardDao extends CrudRepository<Board, Long> {
}
