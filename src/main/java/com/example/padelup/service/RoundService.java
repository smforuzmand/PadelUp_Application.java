package com.example.padelup.service;

import com.example.padelup.entity.Round;

import java.util.List;

public interface RoundService {
   Round create (final Round Round);

   void delete(final Integer id);
   Round update(final Integer id, final Round Round);
   Round findById(final Integer id);
   List<Round> findAll();

}
