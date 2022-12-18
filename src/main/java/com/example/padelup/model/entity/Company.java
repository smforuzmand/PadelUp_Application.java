package com.example.padelup.model.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "company")
public class Company {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "company_id")
   private int id;
   @Column(name = "company_name")
   private String companyName;
   @Column(name = "company_score")
   private  double companyScore;
   @Column(name = "company_player")
   @OneToMany(mappedBy = "company", cascade = {MERGE, REFRESH, DETACH}, fetch = LAZY)
   private List<Player> playerList;

   public Company(){
   }
   public Company(int id, String companyName, double companyScore, List<Player> playerList) {
      this.id = id;
      this.companyName = companyName;
      this.companyScore = companyScore;
      this.playerList = playerList;
   }

   public int getId() {
      return id;
   }

   public String getCompanyName() {
      return companyName;
   }

   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }

   public double getCompanyScore() {
      return companyScore;
   }

   public void setCompanyScore(double companyScore) {
      this.companyScore = companyScore;
   }

   public List<Player> getPlayerList() {
      return playerList;
   }

   public void setPlayerList(List<Player> playerList) {
      this.playerList = playerList;
   }
}
