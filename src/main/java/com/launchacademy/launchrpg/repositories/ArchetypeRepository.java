package com.launchacademy.launchrpg.repositories;

import com.launchacademy.launchrpg.models.Archetype;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ArchetypeRepository extends CrudRepository<Archetype, Integer> {
  List<Archetype> findAll();
}
