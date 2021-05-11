package com.launchacademy.launchrpg.repositories;

import com.launchacademy.launchrpg.models.Archetype;
import com.launchacademy.launchrpg.models.Spell;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SpellRepository extends CrudRepository<Spell, Integer> {
  public List<Spell> findAllByName(String name);

  public List<Spell> findAllById(String name);

  List<Spell> findAll();

}
