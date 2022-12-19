package com.example.padelup.model.dto;

import com.example.padelup.model.entity.Player;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class RoundDto {
   private int roundNr;
   private Date date;
   private int points;
   private Player player;
}
