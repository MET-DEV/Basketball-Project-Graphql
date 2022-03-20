package com.producter.javacasebasketball;

import com.producter.javacasebasketball.models.Player;
import com.producter.javacasebasketball.models.result.PlayerAddResultModel;
import com.producter.javacasebasketball.models.result.PlayerDataResultModel;
import com.producter.javacasebasketball.models.result.PlayerDeleteResultModel;
import com.producter.javacasebasketball.repositories.PlayerRepository;
import com.producter.javacasebasketball.services.implementation.PlayerServiceImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplementTest {
    @InjectMocks
    private PlayerServiceImplement playerServiceImplement;
    @Mock
    private PlayerRepository playerRepository;


    @Test
    public void TestSavePlayer(){
        Player player = new Player();
        player.setFirstName("Test-Name");
        player.setLastName("Test-LastName");
        Player playerMock=Mockito.mock(Player.class);
        Mockito.when(playerMock.getId()).thenReturn(1);
        Mockito.when(playerMock.getFirstName()).thenReturn("Test-Name");
        Mockito.when(playerMock.getLastName()).thenReturn("Test-LastName");
        Mockito.when(playerRepository.save(ArgumentMatchers.any(Player.class))).thenReturn(playerMock);
        PlayerAddResultModel playerData=playerServiceImplement.addPlayer(player);
        Assertions.assertEquals(playerData.getData().getFirstName(),"Test-Name");
        Assertions.assertEquals(playerData.getMessage(),"Added");
        Assertions.assertEquals(playerData.getData().getLastName(),"Test-LastName");
        Assertions.assertEquals(playerData.isStatus(),true);
        Assertions.assertEquals(playerData.getData().getId(),1);

    }
    @Test
    public void TestDeletePlayer(){
        PlayerDeleteResultModel playerData=playerServiceImplement.deletePlayer(1);
        Assertions.assertEquals(playerData.isStatus(),true);
        Assertions.assertEquals(playerData.getMessage(),"Deleted");

    }
    @Test void TestFindPlayers(){
        List<Player> playerMockList = new ArrayList<Player>();
        Player player1=new Player();
        player1.setId(1);
        player1.setFirstName("Test-Name");
        player1.setLastName("Test-LastName");
        Player player2=new Player();
        player1.setId(2);
        player2.setFirstName("Test-Name1");
        player2.setLastName("Test-LastName1");
        playerMockList.add(player1);
        playerMockList.add(player2);
        Mockito.when(playerRepository.findAll()).thenReturn(playerMockList);
        PlayerDataResultModel playerData=playerServiceImplement.findPlayers();
        Assertions.assertEquals(playerData.getData().get(0).getFirstName(),"Test-Name");
        Assertions.assertEquals(playerData.getData().get(1).getFirstName(),"Test-Name1");




    }

}
