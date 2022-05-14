package sample;


import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser extends Main {
    static JsonParser parser = new JsonParser();
    String json = "[\"Skills\",{\"Skill\":\"Fireball\",\"ID\":1,\"Stun\":0,\"Accuracy\":90,\"Damage\":10,\"Description\":\"Casts a fireball onto the enemy.\",\"LevelRequired\":1,\"ManaRequired\":3,\"Character\":\"Player\",\"Class\":\"Mage\"},{\"Skill\":\"Super Slash\",\"ID\":2,\"Stun\":0,\"Accuracy\":100,\"Damage\":17,\"Description\":\"Charges a super slash and hits the enemy.\",\"LevelRequired\":1,\"ManaRequired\":5,\"Character\":\"Player\",\"Class\":\"Warrior\"},{\"Skill\":\"Flaming Arrow\",\"ID\":3,\"Stun\":0,\"Accuracy\":100,\"Damage\":14,\"Description\":\"Shoots a flaming arrow at the enemy.\",\"LevelRequired\":1,\"ManaRequired\":4,\"Character\":\"Player\",\"Class\":\"Archer\"},{\"Skill\":\"Blade Piercer\",\"ID\":4,\"Stun\":0,\"Accuracy\":100,\"Damage\":29,\"Description\":\"Pierces the enemy with a mana-engulfed sword.\",\"LevelRequired\":5,\"ManaRequired\":6,\"Character\":\"Ray\",\"Class\":\"Warrior\"},{\"Skill\":\"Dual-Wielding Buster\",\"ID\":5,\"Stun\":0,\"Accuracy\":95,\"Damage\":40,\"Description\":\"Dual-wield two mana-engulfed swords at the same time.\",\"LevelRequired\":10,\"ManaRequired\":6,\"Character\":\"Ray\",\"Class\":\"Warrior\"},{\"Skill\":\"100,000 Volts\",\"ID\":6,\"Stun\":1,\"Accuracy\":80,\"Damage\":29,\"Description\":\"Shocks the enemy with a bolt of thunder.\",\"LevelRequired\":5,\"ManaRequired\":5,\"Character\":\"Akane\",\"Class\":\"Mage\"},{\"Skill\":\"Magic Spell\",\"ID\":7,\"Stun\":0,\"Accuracy\":100,\"Damage\":38,\"Description\":\"Casts a magic spell onto the enemy.\",\"LevelRequired\":10,\"ManaRequired\":6,\"Character\":\"Akane\",\"Class\":\"Mage\"}]";
    public void test()
    {
        JSONArray b = new JSONArray(json);
        skills.PlayerSkills.add(String.valueOf(b.getJSONObject(1).getInt("LevelRequired")));
        skills.PlayerSkills.add(String.valueOf(b.getJSONObject(1).getInt("ManaRequired")));
        skills.PlayerSkills.add(String.valueOf(b.getJSONObject(1).getInt("Damage")));
        System.out.println(skills.PlayerSkills.toString());
    }

    public void playerGetsSkill()
    {
        String filepath = "???";
        try {

            String contents = new String(Files.readAllBytes(Paths.get(filepath)));
            JSONArray skillData = new JSONArray(contents);
            int[] levelNeeded = {1, 5, 10, 15};
            if (Player.playerLevel ==  levelNeeded[0] || Player.playerLevel == levelNeeded[1] || Player.playerLevel == levelNeeded[2] || Player.playerLevel == levelNeeded[3])
            {

                if (Player.playerLevel == skillData.getJSONObject(1).getInt("LevelRequired") && Player.getCl().equals("Mage")) {
                    skills.PlayerSkills.add((skillData.getJSONObject(1).getString("Skill")));
                    skills.PlayerTotalSkills.add((skillData.getJSONObject(1).getString("Skill")));
                    skills.SkillMana.add(skillData.getJSONObject(1).getInt("ManaRequired"));
                }
                else if (Player.playerLevel == skillData.getJSONObject(2).getInt("LevelRequired") && Player.getCl().equals("Warrior")) {
                    skills.PlayerSkills.add((skillData.getJSONObject(2).getString("Skill")));
                    skills.PlayerTotalSkills.add((skillData.getJSONObject(2).getString("Skill")));
                    skills.SkillMana.add(skillData.getJSONObject(2).getInt("ManaRequired"));
                }
                else if (Player.playerLevel == skillData.getJSONObject(3).getInt("LevelRequired") && Player.getCl().equals("Archer")) {
                    skills.PlayerSkills.add((skillData.getJSONObject(3).getString("Skill")));
                    skills.PlayerTotalSkills.add((skillData.getJSONObject(3).getString("Skill")));
                    skills.SkillMana.add(skillData.getJSONObject(3).getInt("ManaRequired"));
                }
                else if (Player.playerLevel == skillData.getJSONObject(8).getInt("LevelRequired") && Player.getCl().equals("Mage")) {
                    skills.PlayerSkills.add((skillData.getJSONObject(8).getString("Skill")));
                    skills.PlayerTotalSkills.add((skillData.getJSONObject(8).getString("Skill")));
                    skills.SkillMana.add(skillData.getJSONObject(8).getInt("ManaRequired"));
                }
                else if (Player.playerLevel == skillData.getJSONObject(9).getInt("LevelRequired") && Player.getCl().equals("Warrior")) {
                    skills.PlayerSkills.add((skillData.getJSONObject(9).getString("Skill")));
                    skills.PlayerTotalSkills.add((skillData.getJSONObject(9).getString("Skill")));
                    skills.SkillMana.add(skillData.getJSONObject(9).getInt("ManaRequired"));
                }
                else if (Player.playerLevel == skillData.getJSONObject(10).getInt("LevelRequired") && Player.getCl().equals("Archer")) {
                    skills.PlayerSkills.add((skillData.getJSONObject(10).getString("Skill")));
                    skills.PlayerTotalSkills.add((skillData.getJSONObject(10).getString("Skill")));
                    skills.SkillMana.add(skillData.getJSONObject(10).getInt("ManaRequired"));
                }

        }

            } catch (IOException e) {
            e.printStackTrace();
        }

        if (skills.PlayerSkills.size() >= 7 && skills.SkillMana.size() >= 7)
        {
            int ind = skills.SkillMana.size() - 1;
            int index = skills.PlayerSkills.size() - 1;
            skills.SkillMana.remove(ind);
            skills.PlayerSkills.remove(index);
            System.out.println("Your skill slots are full.");
            System.out.println(skills.PlayerTotalSkills.toString());
        }
    }

}


