package com.weather.redbee.dot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardCityDTO {

    @JsonProperty
    private String boardCityId;
    @JsonProperty
    private String boardId;
    @JsonProperty
    private String cityId;

}
