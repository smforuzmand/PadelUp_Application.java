package com.example.padelup.service;

import com.example.padelup.model.dto.CompanyDto;
import com.example.padelup.model.dto.PlayerDto;
import com.example.padelup.model.entity.Company;
import com.example.padelup.model.entity.Player;
import com.example.padelup.repo.CompanyRepo;
import com.example.padelup.repo.PlayerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{
   private final ModelMapper modelMapper;
   private final PlayerRepo playerRepo;
   @Autowired
   public PlayerServiceImpl(PlayerRepo playerRepo, ModelMapper modelMapper){
      this.modelMapper = modelMapper;
      this.playerRepo = playerRepo;
   }
   @Override
   @Transactional
   public PlayerDto create(PlayerDto playerDto) {
      Player player = modelMapper.map(playerDto,Player.class);
      Player savedPlayer = playerRepo.save(player);
      return modelMapper.map(savedPlayer, PlayerDto.class);
   }

   @Override
   @Transactional
   public boolean delete(Integer id) {
      return false;
   }

   @Override
   @Transactional
   public PlayerDto update(Integer id, PlayerDto playerDto) {
      return null;
   }

   @Override
   @Transactional
   public PlayerDto findById(Integer id) {
      return null;
   }

   @Override
   @Transactional
   public List<PlayerDto> findAll() {
      return null;
   }
}
