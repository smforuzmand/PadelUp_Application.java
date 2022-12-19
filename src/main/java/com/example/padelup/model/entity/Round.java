package com.example.padelup.model.entity;

import lombok.*;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "round")

public class Round {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "round_id" )
   private int roundId;
   @Column(name = "round_nr")
   private int roundNr;
   @Column(name = "date")
   private Date date;
   @Column(name = "points")
   private int points;

   @ManyToOne( cascade  = {PERSIST, MERGE, DETACH, REFRESH})
   @JoinColumn(name = "player_id")
   private Player player;
}
