package com.weather.redbee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="BOARD_CITY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BOARD_CITY")
public class BoardCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_CITY_ID")
    private Long boardCityId;
    @Column(name = "BOARD_ID")
    private Long boardId;
    @Column(name = "CITY_ID")
    private Long cityId;

}
