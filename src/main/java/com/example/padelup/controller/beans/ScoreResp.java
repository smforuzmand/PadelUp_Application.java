package com.example.padelup.controller.beans;

import com.example.padelup.entity.Company;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Value;

@Value
public class ScoreResp {
    String companyName;
    Double score;

    @JsonCreator
    public ScoreResp(final String companyName,
                     final Double score) {
        this.companyName = companyName;
        this.score = score;
    }
}
