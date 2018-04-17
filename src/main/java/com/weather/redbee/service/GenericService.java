package com.weather.redbee.service;


import java.util.List;

public interface GenericService<T> {

    T add(T t);

    List<T> findAll();

    T update(T t);

    void delete(T t);

}
