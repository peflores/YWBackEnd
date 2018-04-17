package com.weather.redbee.dot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO implements Serializable {

    @JsonProperty
    private String boardId;
    @JsonProperty
    @NonNull
    private String userId;
    @JsonProperty
    @NonNull
    private String boardName;
}
