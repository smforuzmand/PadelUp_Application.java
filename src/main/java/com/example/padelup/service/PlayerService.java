package com.example.padelup.service;

import com.example.padelup.model.dto.CompanyDto;
import com.example.padelup.model.dto.PlayerDto;
import com.example.padelup.model.form.CompanyForm;

import java.util.List;

public interface PlayerService {
   PlayerDto create (PlayerDto playerDto);

   boolean delete(Integer id);
   PlayerDto update(Integer id, PlayerDto playerDto);
   PlayerDto findById(Integer id);
   List<PlayerDto> findAll();

}
