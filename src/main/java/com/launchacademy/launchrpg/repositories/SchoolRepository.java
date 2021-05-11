package com.launchacademy.launchrpg.repositories;

import com.launchacademy.launchrpg.models.PlayerCharacter;
import com.launchacademy.launchrpg.models.School;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Integer> {
  public List<School> findAllByName(String name);

  List<School> findAll();

}
