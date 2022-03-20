package com.producter.javacasebasketball.api.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.producter.javacasebasketball.models.Player;
import com.producter.javacasebasketball.models.result.PlayerAddResultModel;
import com.producter.javacasebasketball.models.result.PlayerDeleteResultModel;
import com.producter.javacasebasketball.services.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerMutationResolver implements GraphQLMutationResolver {
    private PlayerService playerService;

    @Autowired
    public PlayerMutationResolver(PlayerService playerService) {
        this.playerService = playerService;
    }

    public PlayerAddResultModel savePlayer(Player player){
        return playerService.addPlayer(player);
    }
    public PlayerDeleteResultModel deletePlayer(int id){

        return playerService.deletePlayer(id);
    }
}
