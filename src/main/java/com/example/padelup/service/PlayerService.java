package com.example.padelup.service;

import com.example.padelup.entity.Player;

import java.util.List;

public interface PlayerService {
   Player create (final Player player);

   void delete(final Integer id);
   Player update(final Integer id, final Player Player);
   Player findById(final Integer id);
   List<Player> findAll();

}
