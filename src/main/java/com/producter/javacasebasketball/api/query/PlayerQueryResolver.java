package com.producter.javacasebasketball.api.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.producter.javacasebasketball.models.Player;
import com.producter.javacasebasketball.models.result.PlayerDataResultModel;
import com.producter.javacasebasketball.services.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PlayerQueryResolver implements GraphQLQueryResolver {
    private final PlayerService playerService;
    @Autowired
    public PlayerQueryResolver(PlayerService playerService) {
        this.playerService = playerService;
    }
    public PlayerDataResultModel getPlayers(){
        return  playerService.findPlayers();
    }
}
