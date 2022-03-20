package com.producter.javacasebasketball.services.implementation;

import com.producter.javacasebasketball.models.Player;
import com.producter.javacasebasketball.models.result.PlayerAddResultModel;
import com.producter.javacasebasketball.models.result.PlayerDataResultModel;
import com.producter.javacasebasketball.models.result.PlayerDeleteResultModel;
import com.producter.javacasebasketball.repositories.PlayerRepository;
import com.producter.javacasebasketball.services.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImplement implements PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImplement(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDataResultModel findPlayers() {
        return new PlayerDataResultModel(playerRepository.findAll(),true,"Listed");
    }

    @Override
    public PlayerAddResultModel addPlayer(Player player) {
        int count=playerRepository.findAll().size();
        if (count<5){
            return new PlayerAddResultModel(playerRepository.save(player),true,"Added");
        }
        return new PlayerAddResultModel(null,false,"Team is full");
    }

    @Override
    public PlayerDeleteResultModel deletePlayer(int id) {
        playerRepository.deleteById(id);
        return new  PlayerDeleteResultModel("Deleted",true);
    }
}
