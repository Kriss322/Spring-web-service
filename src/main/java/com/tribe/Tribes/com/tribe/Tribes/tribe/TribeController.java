package com.tribe.Tribes.com.tribe.Tribes.tribe;


import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.player.PlayerController;
import com.tribe.Tribes.player.PlayerDTO;
import com.tribe.Tribes.player.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tribes")
public class TribeController {

    private static ModelMapper modelMapper = new ModelMapper();

    private final TribeService tribeService;

    private final PlayerService playerService;

    @Autowired
    public TribeController(TribeService tribeService, PlayerService playerService){
        this.tribeService = tribeService;
        this.playerService = playerService;
    }

    @GetMapping("/{tribeId}")
    @ResponseBody
    public TribeDTO getTribe(@PathVariable Integer tribeId){
        return convertToDto(tribeService.getTribeById(tribeId));
    }

    @GetMapping("/{tribeId}/players")
    @ResponseBody
    public List<PlayerDTO> getPlayersOfTribe(@PathVariable Integer tribeId){
        List<Player> players = tribeService.getPlayersOfTribe(tribeId);

        return players.stream()
                .map(PlayerController::convertToDto)
                .collect(Collectors.toList());
    }


    @GetMapping
    public List<TribeDTO> getAllTribes(){
        List<Tribe> tribes = tribeService.getAllTribes();

        return tribes.stream()
                .map(tribe -> convertToDto(tribe))
                .collect(Collectors.toList());
    }

    @PostMapping
    public TribeDTO newTribe(@RequestBody TribeDTO tribeDto){
        Tribe tribe = convertToEntity(tribeDto);

        Player founderPlayer = playerService.getPlayerById(tribeDto.getMemberPlayerIds().get(0));

        Tribe tribeCreated = tribeService.addNewTribe(tribe);

        tribeService.addPlayerToTribe(tribeCreated.getId(), founderPlayer.getId());

        return convertToDto(tribeCreated);
    }

    public static Tribe convertToEntity(TribeDTO tribeDto){

        Tribe tribe = modelMapper.map(tribeDto, Tribe.class);
        return tribe;
    }

    public static TribeDTO convertToDto(Tribe tribe){
        TribeDTO tribeDTO = modelMapper.map(tribe, TribeDTO.class);


        if(tribe.getMemberPlayers() != null){
            tribeDTO.setMemberPlayerIds(tribe.getMemberPlayers()
                    .stream()
                    .map(Player::getId)
                    .collect(Collectors.toList()));
        }

        if(tribe.getAllyTribes() != null){
            tribeDTO.setAllyTribeIds(tribe.getAllyTribes()
                    .stream()
                    .map(Tribe::getId)
                    .collect(Collectors.toList()));
        }

        if(tribe.getEnemyTribes() != null) {
            tribeDTO.setEnemyTribeIds(tribe.getEnemyTribes()
                    .stream()
                    .map(Tribe::getId)
                    .collect(Collectors.toList()));
        }
        return tribeDTO;
    }
}
