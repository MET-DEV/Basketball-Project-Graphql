package com.producter.javacasebasketball.models.result;

import lombok.Data;

@Data
public class PlayerDeleteResultModel {
    private String message;
    private boolean status;

    public PlayerDeleteResultModel(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
}
