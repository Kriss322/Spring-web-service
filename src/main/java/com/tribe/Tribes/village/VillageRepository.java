package com.tribe.Tribes.village;

import com.tribe.Tribes.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
public interface VillageRepository extends JpaRepository<Village, Integer> {

    List<Village> findByName(String name);

    @Query("SELECT v FROM Village v WHERE v.ownerPlayer = :player")
    List<Village> getVillageByPlayerId(@Param("player") Player player);

    @Query("SELECT v FROM Village v WHERE v.ownerPlayer = :player AND v.id = :id")
    Village getOneVillageOfPlayer(@Param("player") Player player, @Param("id") Integer id);
}
