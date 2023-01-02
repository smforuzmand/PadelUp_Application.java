package com.example.padelup.controller;

import com.example.padelup.controller.beans.ResultResp;
import com.example.padelup.entity.Round;
import com.example.padelup.service.RoundService;
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
@RequestMapping(path="/api/v1/round")
public class RoundController {
   private final RoundService roundService;

   public RoundController(RoundService roundService){
      this.roundService = roundService;
   }

   @PostMapping
   public ResponseEntity<Round> create(@RequestBody final Round round) {
      return ResponseEntity.status(HttpStatus.CREATED).body(roundService.create(round));
   }

   @PutMapping(path = "/{id}")
   public ResponseEntity<Round> update(@PathVariable("id") final Integer rId,
                                       @RequestBody final Round round) {
      return ResponseEntity.status(HttpStatus.CREATED).body(roundService.update(rId, round));
   }

   @DeleteMapping(path = "/{id}")
   public ResponseEntity<ResultResp> deleteRound(@PathVariable("id") final Integer rId) {

      roundService.delete(rId);
      final ResultResp result = new ResultResp("Round deleted!");
      return ResponseEntity.ok(result);

   }
   @GetMapping("/{id}")
   public ResponseEntity<Round> findById(@PathVariable("id") final Integer id){
      return ResponseEntity.ok(roundService.findById(id));
   }

   @GetMapping
   public ResponseEntity<List<Round>> findAll(){
      return ResponseEntity.ok(roundService.findAll());
   }


}
