package com.example.padelup.model.dto;

import com.example.padelup.model.entity.Company;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class PlayerDto {
   private String playerFirstName;
   private String playerLastName;
   private String playerEmail;
   private int rounds;
   private double playerAverage;
   private Company company;
}
