package com.tribe.Tribes.village;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VillageRepository extends JpaRepository<Village, Integer> {
}
