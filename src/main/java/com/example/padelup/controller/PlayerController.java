package com.example.padelup.controller;

import com.example.padelup.controller.beans.ResultResp;
import com.example.padelup.entity.Player;
import com.example.padelup.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/player")
public class PlayerController {

   private final PlayerService playerService;
   public PlayerController(PlayerService playerService){
      this.playerService = playerService;
   }

   @PostMapping
   public ResponseEntity<Player> create(@RequestBody final Player Player) {
      return ResponseEntity.status(HttpStatus.CREATED).body(playerService.create(Player));
   }

   @PutMapping(path = "/{id}")
   public ResponseEntity<Player> update(@PathVariable("id") final Integer pId,
                                        @RequestBody final Player Player) {
      return ResponseEntity.status(HttpStatus.CREATED).body(playerService.update(pId, Player));
   }
   @DeleteMapping(path = "/{id}")
   public ResponseEntity<ResultResp> deletePlayer(@PathVariable("id") final Integer pId) {

      playerService.delete(pId);

      final ResultResp result = new ResultResp("Player deleted!");

      return ResponseEntity.ok(result);
   }
   @GetMapping("/{id}")
   public ResponseEntity<Player> findById(@PathVariable("id") final Integer id){
      return ResponseEntity.ok(playerService.findById(id));
   }

   @GetMapping
   public ResponseEntity<List<Player>> findAll(){
      return ResponseEntity.ok(playerService.findAll());
   }

}
