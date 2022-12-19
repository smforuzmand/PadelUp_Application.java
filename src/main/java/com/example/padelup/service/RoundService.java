package com.example.padelup.service;

import com.example.padelup.model.dto.RoundDto;

import java.util.List;

public interface RoundService {
   RoundDto create (RoundDto roundDto);

   boolean delete(Integer id);
   RoundDto update(Integer id, RoundDto roundDto);
   RoundDto findById(Integer id);
   List<RoundDto> findAll();

}
