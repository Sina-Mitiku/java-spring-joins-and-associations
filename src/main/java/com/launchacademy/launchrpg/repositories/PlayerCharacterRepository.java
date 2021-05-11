package com.launchacademy.launchrpg.repositories;

import com.launchacademy.launchrpg.models.PlayerCharacter;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PlayerCharacterRepository extends CrudRepository<PlayerCharacter, Integer> {
  List<PlayerCharacter> findAll();
}
