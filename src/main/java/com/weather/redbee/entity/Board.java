package com.weather.redbee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="BOARD")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BOARD")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long boardId;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "BOARD_NAME")
    private String boardName;
}
