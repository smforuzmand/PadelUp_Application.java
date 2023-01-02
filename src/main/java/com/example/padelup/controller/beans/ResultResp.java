package com.example.padelup.controller.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Value;

@Value
public class ResultResp {
    String message;

    @JsonCreator
    public ResultResp(String message) {
        this.message = message;
    }
}
