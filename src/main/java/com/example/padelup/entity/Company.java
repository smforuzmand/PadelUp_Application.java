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
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "company_id")
   private int id;

   @NotBlank(message = "This field is required")
   @Size(min = 3, message = "Need to contain at least 3 letters")
   @Column(name = "company_name")
   private String companyName;

   @JoinColumn(name = "company_id")
   @EqualsAndHashCode.Exclude
   @ToString.Exclude
   @OneToMany(cascade = ALL)
   @Fetch(FetchMode.JOIN)
   private Set<Player> playerList;

   public void dismissPlayer(final Player player) {
      this.getPlayerList().remove(player);
   }

}
