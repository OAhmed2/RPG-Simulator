package sample;

import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Skills extends Main {
    public List<String> PlayerSkills = new ArrayList<String>();
    public List <String> PlayerTotalSkills = new ArrayList<String>();
    public List <Integer> SkillMana = new ArrayList<Integer>();
    Map<String, Integer> PlayerSkillsDamageHashMap = new HashMap<String, Integer>();
    Map<String, Integer> PlayerSkillsManaHashMap = new HashMap<>();
    Map<String, Integer> PlayerSkillsAccuracyHashMap = new HashMap<>();
    Map<String, Integer> PlayerSkillsStunHashMap = new HashMap<>();
    public String stringInput;

    public void skillInsert()
    {
        String filepath = "???";
        String contents;
        try
        {
            contents = new String(Files.readAllBytes(Paths.get(filepath)));
            JSONArray skillData = new JSONArray(contents);
            PlayerSkillsDamageHashMap.put("Fireball", skillData.getJSONObject(1).getInt("Damage"));
            PlayerSkillsManaHashMap.put("Fireball", skillData.getJSONObject(1).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("Fireball", skillData.getJSONObject(1).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("Fireball", skillData.getJSONObject(1).getInt("Stun"));

            PlayerSkillsDamageHashMap.put("Super Slash", skillData.getJSONObject(2).getInt("Damage"));
            PlayerSkillsManaHashMap.put("Super Slash", skillData.getJSONObject(2).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("Super Slash", skillData.getJSONObject(2).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("Super Slash", skillData.getJSONObject(2).getInt("Stun"));

            PlayerSkillsDamageHashMap.put("Flaming Arrow", skillData.getJSONObject(3).getInt("Damage"));
            PlayerSkillsManaHashMap.put("Flaming Arrow", skillData.getJSONObject(3).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("Flaming Arrow", skillData.getJSONObject(3).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("Flaming Arrow", skillData.getJSONObject(3).getInt("Stun"));

            PlayerSkillsDamageHashMap.put("Blade Piercer", skillData.getJSONObject(4).getInt("Damage"));
            PlayerSkillsManaHashMap.put("Blade Piercer", skillData.getJSONObject(4).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("Blade Piercer", skillData.getJSONObject(4).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("Blade Piercer", skillData.getJSONObject(4).getInt("Stun"));

            PlayerSkillsDamageHashMap.put("Dual-Wielding Buster", skillData.getJSONObject(5).getInt("Damage"));
            PlayerSkillsManaHashMap.put("Dual-Wielding Buster", skillData.getJSONObject(5).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("Dual-Wielding Buster", skillData.getJSONObject(5).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("Dual-Wielding Buster", skillData.getJSONObject(5).getInt("Stun"));

            PlayerSkillsDamageHashMap.put("100,000 Volts", skillData.getJSONObject(6).getInt("Damage"));
            PlayerSkillsManaHashMap.put("100,000 Volts", skillData.getJSONObject(6).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("100,000 Volts", skillData.getJSONObject(6).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("100,000 Volts", skillData.getJSONObject(6).getInt("Stun"));

            PlayerSkillsDamageHashMap.put("Magic Spell", skillData.getJSONObject(7).getInt("Damage"));
            PlayerSkillsManaHashMap.put("Magic Spell", skillData.getJSONObject(7).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("Magic Spell", skillData.getJSONObject(7).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("Magic Spell", skillData.getJSONObject(7).getInt("Stun"));

            PlayerSkillsDamageHashMap.put("Thunder Shock", skillData.getJSONObject(8).getInt("Damage"));
            PlayerSkillsManaHashMap.put("Thunder Shock", skillData.getJSONObject(8).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("Thunder Shock", skillData.getJSONObject(8).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("Thunder Shock", skillData.getJSONObject(8).getInt("Stun"));

            PlayerSkillsDamageHashMap.put("Blade Buster", skillData.getJSONObject(9).getInt("Damage"));
            PlayerSkillsManaHashMap.put("Blade Buster", skillData.getJSONObject(9).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("Blade Buster", skillData.getJSONObject(9).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("Blade Buster", skillData.getJSONObject(9).getInt("Stun"));

            PlayerSkillsDamageHashMap.put("Bullseye", skillData.getJSONObject(10).getInt("Damage"));
            PlayerSkillsManaHashMap.put("Bullseye", skillData.getJSONObject(10).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("Bullseye", skillData.getJSONObject(10).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("Bullseye", skillData.getJSONObject(10).getInt("Stun"));

            PlayerSkillsDamageHashMap.put("Mana Stab", skillData.getJSONObject(11).getInt("Damage"));
            PlayerSkillsManaHashMap.put("Mana Stab", skillData.getJSONObject(11).getInt("ManaRequired"));
            PlayerSkillsAccuracyHashMap.put("Mana Stab", skillData.getJSONObject(11).getInt("Accuracy"));
            PlayerSkillsStunHashMap.put("Mana Stab", skillData.getJSONObject(11).getInt("Stun"));





        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}