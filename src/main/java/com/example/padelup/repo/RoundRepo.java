package com.example.padelup.repo;

import com.example.padelup.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepo extends JpaRepository<Round, Integer> {

}
