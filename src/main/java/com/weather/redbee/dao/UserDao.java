package com.weather.redbee.dao;

import com.weather.redbee.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
}
