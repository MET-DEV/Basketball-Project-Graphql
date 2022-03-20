package com.producter.javacasebasketball.services.interfaces;

import com.producter.javacasebasketball.models.Player;
import com.producter.javacasebasketball.models.result.PlayerAddResultModel;
import com.producter.javacasebasketball.models.result.PlayerDataResultModel;
import com.producter.javacasebasketball.models.result.PlayerDeleteResultModel;


import java.util.List;

public interface PlayerService {
    PlayerDataResultModel findPlayers();

    PlayerAddResultModel addPlayer(Player player);
    PlayerDeleteResultModel deletePlayer(int id);
}
