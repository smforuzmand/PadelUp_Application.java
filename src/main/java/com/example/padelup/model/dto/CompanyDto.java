package com.example.padelup.model.dto;

import com.example.padelup.model.entity.Player;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

//@Data

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class CompanyDto {
   @NotBlank(message = "This field is required")
   @Size(min = 3, message = "Need to contain at least 3 letters")
   private String companyName;

   private  double companyScore;

   private List<Player> playerList;
}
