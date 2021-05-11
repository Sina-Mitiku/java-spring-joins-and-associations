package com.launchacademy.launchrpg.seeders;

import com.google.inject.internal.util.Lists;
import com.launchacademy.launchrpg.models.Archetype;
import com.launchacademy.launchrpg.models.PlayerCharacter;
import com.launchacademy.launchrpg.models.School;
import com.launchacademy.launchrpg.models.Spell;
import com.launchacademy.launchrpg.repositories.ArchetypeRepository;
import com.launchacademy.launchrpg.repositories.PlayerCharacterRepository;
import com.launchacademy.launchrpg.repositories.SchoolRepository;
import com.launchacademy.launchrpg.repositories.SpellRepository;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoSeeder implements CommandLineRunner {

  private PlayerCharacterRepository playerCharacterRepository;
  private ArchetypeRepository archetypeRepository;
  private SpellRepository spellRepository;
  private SchoolRepository schoolRepository;

  @Autowired
  public DemoSeeder(PlayerCharacterRepository playerCharacterRepository,

      ArchetypeRepository archetypeRepository,
      SpellRepository spellRepository,
      SchoolRepository schoolRepository) {
    this.playerCharacterRepository = playerCharacterRepository;
    this.archetypeRepository = archetypeRepository;
    this.spellRepository = spellRepository;
    this.schoolRepository = schoolRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Archetype archetype = new Archetype();
    PlayerCharacter playerCharacter = new PlayerCharacter();

    if (Lists.newArrayList(archetypeRepository.findAll()).size() == 0) {
      archetype.setType("Rogue");
      archetype.setHitDice(8);
      archetype.setPrimary_stat("Dex");
      archetypeRepository.save(archetype);
    }

    if (Lists.newArrayList(playerCharacterRepository.findAll()).size() == 0) {
      playerCharacter.setName("Regis");
      playerCharacter.setArchetype(archetype);
      playerCharacter.setRace("Halfling");
      playerCharacter.setBackground("Icewind Dale's Halfling Rogue Extraordinarre");
      playerCharacter.setLevel(1);
      playerCharacterRepository.save(playerCharacter);
    }

    Map<String, String> schoolsMap = new HashMap<String, String>();
    schoolsMap.put("Enchanted_1", "Giving objects special powers, and influencing people");
    schoolsMap.put("Second school", "Helping with spells");

    for (String name : schoolsMap.keySet()) {
      List schools = schoolRepository.findAllByName(name);
      if (schools.size() == 0) {
        School school = new School();
        school.setName(name);
        school.setDescription(schoolsMap.get(name));
        schoolRepository.save(school);
      }

      List<String> spellNameList = Arrays.asList("Charm", "Another Charm", "Lean");
      List<String> spellDescriptionList = Arrays.asList("Good for making Friends", "Good for making study", "Good for fun");
      List<Integer> schoolIdList = Arrays.asList(1,1,2);
      List<Integer> spellLevelList = Arrays.asList(1,2,3);
      List<School> allSchools = Lists.newArrayList(schoolRepository.findAll());
      
        for (int i=0; i < spellNameList.size(); i++) {
          List spellNames = spellRepository.findAllByName(spellNameList.get(i));
          if(spellNames.isEmpty()){
          Spell spell = new Spell();
          spell.setName(spellNameList.get(i));
          spell.setDescription(spellDescriptionList.get(i));
          spell.setLevel(spellLevelList.get(i));
          spell.setSchool(allSchools.get(schoolIdList.get(i)-1));
          spellRepository.save(spell);
        }
      }
    }
  }
}
