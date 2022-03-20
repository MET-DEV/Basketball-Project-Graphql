package com.producter.javacasebasketball.models.result;

import com.producter.javacasebasketball.models.Player;
import lombok.Data;

@Data
public class PlayerAddResultModel{
    private Player data;
    private boolean status;
    private  String message;

    public PlayerAddResultModel(Player data, boolean status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }
}
