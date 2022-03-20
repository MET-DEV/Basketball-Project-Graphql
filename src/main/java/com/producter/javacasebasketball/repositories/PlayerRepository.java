package com.producter.javacasebasketball.repositories;

import com.producter.javacasebasketball.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
