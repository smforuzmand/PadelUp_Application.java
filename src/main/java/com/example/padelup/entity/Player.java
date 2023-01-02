package com.example.padelup.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Data
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

   @NotBlank(message = "This field is required")
   @Column(name = "first_name")
   private String firstName;

   @NotBlank(message = "This field is required")
   @Column(name = "last_name")
   private String lastName;

   @Column(name = "player_email")
   private String email;

   @NotNull(message = "This field is required")
   @Column(name = "company_id")
   private Integer companyId;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "company_id", insertable = false, updatable = false)
   private Company company;

   @JoinColumn(name = "player_id")
   @EqualsAndHashCode.Exclude
   @ToString.Exclude
   @OneToMany(cascade = ALL)
   @Fetch(FetchMode.JOIN)
   private Set<Round> rounds;

   @PreRemove
   public void dismissCompany() {
      this.company.dismissPlayer(this); //SYNCHRONIZING THE OTHER SIDE OF RELATIONSHIP
      this.company = null;
      this.companyId = null;
   }

   public void dismissRound(final Round round) {
      this.getRounds().remove(round);
   }
}
