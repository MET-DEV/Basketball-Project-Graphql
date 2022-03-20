package com.producter.javacasebasketball.models.result;

import com.producter.javacasebasketball.models.Player;
import lombok.Data;

import java.util.List;
@Data
public class PlayerDataResultModel {
    private String message;
    private boolean status;
    private List<Player> data;
    public PlayerDataResultModel(List<Player> data,boolean status,String message){
        this.data=data;
        this.status=status;
        this.message=message;
    }
}
