package com.tribe.Tribes.player;

import java.util.List;
import java.util.stream.Collectors;

import com.tribe.Tribes.village.Village;
import com.tribe.Tribes.village.VillageController;
import com.tribe.Tribes.village.VillageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;


@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/players")
public class PlayerController {

    private ModelMapper modelMapper = new ModelMapper();

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public PlayerDTO getPlayer(@PathVariable("id") Integer id){
        //shame
        List<Player> player = playerService.getAllPlayers();
        return player.stream()
                .filter(player1 -> player1.getId() == id)
                .map(player1 -> convertToDto(player1))
                .collect(Collectors.toList()).get(0);
    }

    @GetMapping("/{id}/villages")
    @ResponseBody
    public List<VillageDTO> getVillagesOfPlayer(@PathVariable("id") Integer id){
        List<Village> villages = playerService.getVillagesOfPlayer(id);
        return villages.stream()
                .map(village -> VillageController.convertToDto(village))
                .collect(Collectors.toList());
    }

    @GetMapping("/{playerId}/villages/{villageId}")
    @ResponseBody
    public VillageDTO getOneVillageOfPlayer(@PathVariable Integer playerId, @PathVariable Integer villageId){
        Village villageEntity = playerService.getOneVillageOfPlayer(playerId, villageId);
        return VillageController.convertToDto(villageEntity);
    }

    @GetMapping
    public List<PlayerDTO> getAllPlayers(){
        List<Player> players = playerService.getAllPlayers();
        return players.stream()
                .map(player -> convertToDto(player))
                .collect(Collectors.toList());
    }

    @PostMapping
    public PlayerDTO newPlayer(@RequestBody PlayerDTO playerDto){
        Player playerEntity = convertToEntity(playerDto);
        Player playerCreated = playerService.addNewPlayer(playerEntity);
        return convertToDto(playerCreated);
    }

    @DeleteMapping("/{playerId}")
    public PlayerDTO deletePlayer(@PathVariable Integer playerId){

        Player playerEntity = playerService.deletePlayer(playerId);
        return convertToDto(playerEntity);
    }

    private Player convertToEntity(PlayerDTO playerDto) {
       Player player = modelMapper.map(playerDto, Player.class);
       return player;
    }

    private PlayerDTO convertToDto(Player player) {
        PlayerDTO playerDto = modelMapper.map(player, PlayerDTO.class);

        playerDto.setVillageIds(player.getVillages()
                .stream()
                .map(Village::getId)
                .collect(Collectors.toList()));

        return playerDto;
    }
    
}
