package com.example.padelup.controller;

import com.example.padelup.model.dto.CompanyDto;
import com.example.padelup.model.dto.PlayerDto;
import com.example.padelup.model.form.CompanyForm;
import com.example.padelup.service.CompanyService;
import com.example.padelup.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/player")
public class PlayerController {

   private final PlayerService playerService;
   @Autowired
   public PlayerController(PlayerService playerService){
      this.playerService = playerService;
   }

   @PostMapping
   public ResponseEntity<PlayerDto> create(@RequestBody PlayerDto playerDto) {
      return ResponseEntity.status(HttpStatus.CREATED).body(playerService.create(playerDto));
   }
   @DeleteMapping(path = "/{id}")
   public ResponseEntity<String> deletePlayer(@PathVariable("id") Integer pId) {

      boolean delete = playerService.delete(pId);
      return ResponseEntity.ok(delete ? "Olayer with id " + pId + " was deleted" : "Player Not Deleted");
   }
   @GetMapping("/{id}")
   public ResponseEntity<PlayerDto> findById(@PathVariable("id") Integer id){
      return ResponseEntity.ok(playerService.findById(id));
   }

   @GetMapping
   public ResponseEntity<List<PlayerDto>> findAll(){
      return ResponseEntity.ok(playerService.findAll());
   }

}
