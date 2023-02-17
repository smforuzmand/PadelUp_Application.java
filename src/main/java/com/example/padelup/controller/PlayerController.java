package com.example.padelup.controller;

import com.example.padelup.controller.beans.ResultResp;
import com.example.padelup.entity.Player;
import com.example.padelup.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

   private final PlayerService playerService;

   public PlayerController(PlayerService playerService) {
      this.playerService = playerService;
   }

   @PostMapping
   public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
      Player savedPlayer = playerService.create(player);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Player> updatePlayer(@PathVariable("id") int id, @RequestBody Player player) {
      Player updatedPlayer = playerService.update(id, player);
      return ResponseEntity.status(HttpStatus.OK).body(updatedPlayer);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<ResultResp> deletePlayer(@PathVariable("id") int id) {
      playerService.delete(id);
      ResultResp result = new ResultResp("Player deleted!");
      return ResponseEntity.ok(result);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Player> getPlayerById(@PathVariable("id") int id) {
      Player player = playerService.findById(id);
      return ResponseEntity.ok(player);
   }

   @GetMapping
   public ResponseEntity<List<Player>> getAllPlayers() {
      List<Player> players = playerService.findAll();
      return ResponseEntity.ok(players);
   }
}
