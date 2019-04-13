package com.tribe.Tribes.village;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface VillageRepository extends JpaRepository<Village, Integer> {

    List<Village> findByName(String name);
}
