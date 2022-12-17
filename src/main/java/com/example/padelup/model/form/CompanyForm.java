package com.example.padelup.model.form;

import com.example.padelup.model.entity.Player;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CompanyForm {

   @NotBlank(message = "This field is required")
   @Size(min = 3, message = "Need to contain at least 3 letters")
   private String companyName;

   private  double companyScore;

   private List<Player> playerList;


}
