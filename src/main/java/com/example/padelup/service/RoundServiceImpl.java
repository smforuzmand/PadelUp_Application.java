package com.example.padelup.service;

import com.example.padelup.model.dto.PlayerDto;
import com.example.padelup.model.dto.RoundDto;
import com.example.padelup.model.entity.Player;
import com.example.padelup.model.entity.Round;
import com.example.padelup.repo.PlayerRepo;
import com.example.padelup.repo.RoundRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoundServiceImpl implements  RoundService{
   private final ModelMapper modelMapper;
   private final RoundRepo roundRepo;

   @Autowired
   public RoundServiceImpl(RoundRepo roundRepo, ModelMapper modelMapper){
      this.modelMapper = modelMapper;
      this.roundRepo = roundRepo;
   }
   @Override
   @Transactional
   public RoundDto create(RoundDto roundDto) {
      Round round = modelMapper.map(roundDto,Round.class);
      Round savedRound = roundRepo.save(round);
      return modelMapper.map(savedRound, RoundDto.class);
   }

   @Override
   @Transactional
   public boolean delete(Integer id) {
      return false;
   }

   @Override
   @Transactional
   public RoundDto update(Integer id, RoundDto roundDto) {
      return null;
   }

   @Override
   @Transactional(readOnly = true)
   public RoundDto findById(Integer roundId) {
      Optional<Round> foundRound = roundRepo.findById(roundId);
      Round round = foundRound.orElseThrow(()
              -> new IllegalArgumentException ("Could not find Round by Id " + roundId));
      return modelMapper.map(round, RoundDto.class);
   }

   @Override
   @Transactional(readOnly = true)
   public List<RoundDto> findAll() {
      return null;
   }
}
