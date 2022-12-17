package com.example.padelup.model.entity;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "player_id" )
   private int id;
   @Column(name = "first_name")
   private String playerFirstName;
   @Column(name = "last_name")
   private String playerLastName;
   @Column(name = "player_email")
   private String playerEnail;
   @Column(name = "rounds")
   private int rounds;
   @Column(name = "player_average")
   private double playerAverage;

   @ManyToOne( cascade  = {PERSIST, MERGE, DETACH, REFRESH})
   @JoinColumn(name = "company_id")
   private Company company;

}
