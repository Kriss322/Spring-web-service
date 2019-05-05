package com.tribe.Tribes.com.tribe.Tribes.tribe;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TribeService {

    private final TribeRepository tribeRepository;

    private final PlayerRepository playerRepository;

    @Autowired
    public TribeService(TribeRepository tribeRepository, PlayerRepository playerRepository){
        this.tribeRepository = tribeRepository;
        this.playerRepository = playerRepository;
    }

    public List<Tribe> getAllTribes(){
        return tribeRepository.findAll();
    }

    public Tribe addNewTribe(Tribe tribe){
        return tribeRepository.save(tribe);
    }

    public Tribe getTribeById(Integer id){
        return tribeRepository.getOne(id);
    }

    public Tribe deleteTribe(Integer id){
        Tribe tribeToDelete = tribeRepository.getOne(id);
        tribeRepository.delete(tribeToDelete);
        return  tribeToDelete;
    }

    public Tribe addPlayerToTribe(Integer tribeId, Integer playerId){
        Player player = playerRepository.getOne(playerId);

        Tribe tribe = tribeRepository.getOne(tribeId);

        player.setJoinedTribe(tribe);

        tribe.addPlayer(player);

        tribe.setPoints(tribe.getPoints() + player.getPlayerPoints());
        playerRepository.save(player);
        return tribeRepository.save(tribe);
    }


    public List<Player> getPlayersOfTribe(Integer tribeId) {

        Tribe tribe = tribeRepository.getOne(tribeId);

        return tribe.getMemberPlayers();
    }
}

