package com.example.padelup.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
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

   @Range(min= 1, max= 5)
   @Column(name = "number")
   private int roundNr;

   @Column(name = "date")
   private LocalDate date;

   @Positive
   @Column(name = "points")
   private int points;

   @NotNull(message = "This field is required")
   @Column(name = "player_id")
   private Integer playerId;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "player_id", insertable = false, updatable = false)
   private Player player;

   @PreRemove
   public void dismissPlayer(){
      this.player.dismissRound(this);
      this.player = null;
      this.playerId = null;
   }
}
