package com.example.padelup.service;

import com.example.padelup.entity.Player;
import com.example.padelup.exception.EntityNotFoundException;
import com.example.padelup.repo.PlayerRepo;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepo playerRepo;

    public PlayerServiceImpl(final PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    @Override
    @Transactional
    public Player create(final Player player) {
        return playerRepo.save(player);
    }

    @Override
    @Transactional
    public void delete(final Integer id) {
        playerRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Player update(final Integer id, final Player player) {
        return playerRepo.findById(id)
                .map(dbPlayer -> {
                    dbPlayer.setFirstName(player.getFirstName());
                    dbPlayer.setLastName(player.getLastName());
                    dbPlayer.setEmail(player.getEmail());
                    return playerRepo.save(dbPlayer);
                })
                .orElseThrow(() -> new EntityNotFoundException(Player.class, "id", String.valueOf(player.getId())));
    }

    @Override
    @Transactional(readOnly = true)
    public Player findById(Integer playerId) {
        return playerRepo.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException(Player.class, "id", playerId.toString()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Player> findAll() {
        return playerRepo.findAll();
    }
}
