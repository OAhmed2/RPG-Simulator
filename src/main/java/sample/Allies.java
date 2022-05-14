package sample;


import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Allies extends Main{

    String alliesJson = "???";
    public List<Equips> AllyWeapons = new ArrayList<Equips>();
    public List<String> AllySkills = new ArrayList<String>();
    public List<String> AllyTotalSkills = new ArrayList<String>();
    public List<Integer> AllySkillsMp = new ArrayList<Integer>();
    public static Map<String, Allies> PlayerAllyInfo = new HashMap<String, Allies>();
    public static Map<String, Integer> partyMembersHp = new HashMap<>();
    public static Map<String, Integer> partyLevel = new HashMap<>();
    public static Map<String, String> partyClass = new HashMap<>();
    public static Allies Ray = new Allies();
    public static Allies Akane = new Allies();
    public static Allies Jake = new Allies();
    public static Allies Sora = new Allies();
    private String allyName;
    private String allyClass;
    private int allyLevel;
    int allyBp;
    int allyHp;
    int allyTotalHp;
    int allyMp;
    int allyTotalMp;
    int allyDmg;
    int allyExp;

    public void allyReceived(String allyName)
    {
        if (!(Player.PlayerAllies.size() >= 4))
        {
            switch (allyName)
            {
                case "Ray" -> Player.PlayerAllies.add(Ray);
                case "Akane" -> Player.PlayerAllies.add(Akane);
                case "Jake" -> Player.PlayerAllies.add(Jake);
                case "Sora" -> Player.PlayerAllies.add(Sora);
            }
        }
    }

    public void allyInBattle(String allyName, String allyClass, int allyHp, int allyTotalHp, int allyTotalMp, int allyMp, int allyDmg)
    {
        this.allyName = allyName;
        this.allyClass = allyClass;
        this.allyHp = allyHp;
        this.allyTotalHp = allyTotalHp;
        this.allyMp = allyMp;
        this.allyTotalMp = allyTotalMp;
        this.allyDmg = allyDmg;
    }

    public void allyGetsSkill()
    {
        String contents;
        try
        {
            contents = new String((Files.readAllBytes(Paths.get(alliesJson))));
            JSONArray skillData = new JSONArray(contents);
            switch (getAllyName()) {
                case "Ray":
                    if (Ray.allyLevel == skillData.getJSONObject(4).getInt("LevelRequired")) {
                        Ray.AllySkills.add(skillData.getJSONObject(4).getString("Skill"));
                        Ray.AllySkillsMp.add(skillData.getJSONObject(4).getInt("ManaRequired"));
                    } else if (Ray.allyLevel == skillData.getJSONObject(5).getInt("LevelRequired")) {
                        Ray.AllySkills.add(skillData.getJSONObject(5).getString("Skill"));
                        Ray.AllySkillsMp.add(skillData.getJSONObject(5).getInt("ManaRequired"));
                    }
                    break;
                case "Akane":
                    if (Akane.allyLevel == skillData.getJSONObject(6).getInt("LevelRequired")) {
                        Akane.AllySkills.add(skillData.getJSONObject(6).getString("Skill"));
                        Akane.AllySkillsMp.add(skillData.getJSONObject(6).getInt("ManaRequired"));
                    } else if (Akane.allyLevel == skillData.getJSONObject(7).getInt("LevelRequired")) {
                        Akane.AllySkills.add(skillData.getJSONObject(7).getString("Skill"));
                        Akane.AllySkillsMp.add(skillData.getJSONObject(7).getInt("ManaRequired"));
                    }
                    break;
                case "Sora":
                    if (Sora.allyLevel == skillData.getJSONObject(11).getInt("LevelRequired")) {
                        Sora.AllySkills.add(skillData.getJSONObject(11).getString("Skill"));
                        Sora.AllySkillsMp.add(skillData.getJSONObject(11).getInt("ManaRequired"));
                    }
                    break;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void allyMenu()
    {
        while (Enemy.enemyHealth > 0) {
            Logic.allyIsSelected = true;
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("What's my strategy?");
            System.out.println("-------------------" + "  " + "HP: " + allyHp + "/" + allyTotalHp + "  " + "MP: " + allyMp + "/" + allyTotalMp);
            System.out.println("1) FIGHT");
            System.out.println("2) INVENTORY");
            System.out.println("3) LOOK");
            System.out.println("4) DO NOTHING");
            if (Player.PlayerAllies.size() >= 1)
            {
                System.out.println("5) PARTY");
            }
            Scanner mainPlayerMenuSelection = new Scanner(System.in);
            String mainPlayerMenuSelect = mainPlayerMenuSelection.nextLine();
            if (mainPlayerMenuSelect == null) {
                return;
            } else if (mainPlayerMenuSelect.equals("1")) {
                FightSelect();
            } else if (mainPlayerMenuSelect.equals("2")) {
                Player.openInventory();
            } else if (mainPlayerMenuSelect.equals("3")) {
                lookAtEnemy();
            }
              else if (mainPlayerMenuSelect.equals("4")){
                Logic.allySkipsTurn = true;
                switch (Player.allySelect)
                {
                    case "Ray" -> Logic.allyTakesDamage("Ray", Ray.allyHp);
                    case "Akane" -> Logic.allyTakesDamage("Akane", Akane.allyHp);
                    case "Jake" -> Logic.allyTakesDamage("Jake", Jake.allyHp);
                    case "Sora" -> Logic.allyTakesDamage("Sora", Sora.allyHp);
                }
            }
            else if (mainPlayerMenuSelect.equals("5") && Player.PlayerAllies.size() >= 1){
                Logic.allyFaints();
            }
        }
    }

    public void allyManaRecovery()
    {
            if (allyTotalMp >= 5 && allyTotalMp <= 19)
            {
                switch (Player.allySelect)
                {
                    case "Ray" -> Ray.allyMp++;
                    case "Akane" -> Akane.allyMp++;
                    case "Jake" -> Jake.allyMp++;
                    case "Sora" -> Sora.allyMp++;
                }
            }
            else if (allyTotalMp >= 20 && allyTotalMp <= 40)
            {
                switch (Player.allySelect)
                {
                    case "Ray" -> Ray.allyMp += 2;
                    case "Akane" -> Akane.allyMp += 2;
                    case "Jake" -> Jake.allyMp += 2;
                    case "Sora" -> Sora.allyMp += 2;
                }
            }
            else if (allyTotalMp >= 41 && allyTotalMp <= 59)
            {
                switch (Player.allySelect)
                {
                    case "Ray" -> Ray.allyMp += 3;
                    case "Akane" -> Akane.allyMp += 3;
                    case "Jake" -> Jake.allyMp += 3;
                    case "Sora" -> Sora.allyMp += 3;
                }
            }
            else if (allyTotalMp >= 60 && allyTotalMp <= 99)
            {
                switch (Player.allySelect)
                {
                    case "Ray" -> Ray.allyMp += 4;
                    case "Akane" -> Akane.allyMp += 4;
                    case "Jake" -> Jake.allyMp += 4;
                    case "Sora" -> Sora.allyMp+= 4;
                }
            }

            else if (allyTotalMp >= 100)
            {
                switch (Player.allySelect)
                {
                    case "Ray" -> Ray.allyMp += 5;
                    case "Akane" -> Akane.allyMp += 5;
                    case "Jake" -> Jake.allyMp += 5;
                    case "Sora" -> Sora.allyMp += 5;
                }
            }

            if (allyMp >= allyTotalMp)
            {
                switch (Player.allySelect)
                {
                    case "Ray" -> Ray.allyMp = Ray.allyTotalMp;
                    case "Akane" -> Akane.allyMp = Akane.allyTotalMp;
                    case "Jake" -> Jake.allyMp = Jake.allyTotalMp;
                    case "Sora" -> Sora.allyMp = Sora.allyTotalMp;
                }
            }

        if (!Logic.enemyIsStunned)
        {
            if (Enemy.enemyTotalMana >= 5 && Enemy.enemyTotalMana <= 19)
            {
                Enemy.enemyMana++;
            }

            if (Enemy.enemyTotalMana >= 20 && Enemy.enemyTotalMana <= 40)
            {
                Enemy.enemyMana += 2;
            }
            if (Enemy.enemyTotalMana >= 41 && Enemy.enemyTotalMana <= 59)
            {
                Enemy.enemyMana += 3;
            }

            if (Enemy.enemyTotalMana >= 60 && Enemy.enemyTotalMana <= 99)
            {
                Enemy.enemyMana += 4;
            }

            if (Enemy.enemyTotalMana >= 100)
            {
                Enemy.enemyMana += 5;
            }

            if (Enemy.enemyMana >= Enemy.enemyTotalMana)
            {
                Enemy.enemyMana = Enemy.enemyTotalMana;
            }
        }
    }

    public void FightSelect() {
        while (true) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("FIGHT");
            System.out.println("-----");
            System.out.println("1) WEAPONS");
            System.out.println("2) SKILLS");
            System.out.println("3) BACK");
            Scanner mainPlayerFightScanner = new Scanner(System.in);
            String mainPlayerFightSelection = mainPlayerFightScanner.nextLine();
            if (mainPlayerFightSelection == null) {
                return;
            } else if (mainPlayerFightSelection.equals("1")) {
                switch (Player.allySelect)
                {
                    case "Ray" -> Allies.Ray.weaponsMenu();
                    case "Akane" -> Allies.Akane.weaponsMenu();
                    case "Jake" -> Allies.Jake.weaponsMenu();
                    case "Sora" -> Allies.Sora.weaponsMenu();
                }
                break;
            } else if (mainPlayerFightSelection.equals("2")) {
                switch (Player.allySelect)
                {
                    case "Ray" -> Allies.Ray.allySkillMenu();
                    case "Akane" -> Allies.Akane.allySkillMenu();
                    case "Jake" -> Allies.Jake.allySkillMenu();
                    case "Sora" -> Allies.Sora.allySkillMenu();
                }
                break;
            }
            else if (mainPlayerFightSelection.equals("3")) {
                allyMenu();
            }
        }
    }

    public void weaponsMenu()
    {
        boolean weaponFound = false;
        System.out.println(" ");
        System.out.println("WEAPONS");
        System.out.println("-------");
        switch (Player.allySelect)
        {
            case "Ray" -> equips.printMap(Equips.Ray.allyHasEquipment);
            case "Akane" -> equips.printMap(Equips.Akane.allyHasEquipment);
            case "Jake" -> equips.printMap(Equips.Jake.allyHasEquipment);
            case "Sora" -> equips.printMap(Equips.Sora.allyHasEquipment);
        }
        Scanner INPUT = new Scanner(System.in);
        equips.weaponNameInput = INPUT.nextLine();
        switch (Player.allySelect)
        {
            case "Ray" -> {
                if (Equips.Ray.allyHasEquipment.containsKey(equips.weaponNameInput))
                {
                    weaponFound = true;
                }
                else
                    System.out.println("Item not found.");
            }
            case "Akane" -> {
                if (Equips.Akane.allyHasEquipment.containsKey(equips.weaponNameInput))
                {
                    weaponFound = true;
                }
                else
                    System.out.println("Item not found.");
            }
            case "Jake" -> {
                if (Equips.Jake.allyHasEquipment.containsKey(equips.weaponNameInput))
                {
                    weaponFound = true;
                }
                else
                    System.out.println("Item not found.");
            }
        }
        if (weaponFound)
        {
            for (int i = 0; i < equips.WeaponDamageMap.get(equips.weaponNameInput); i++)
            {
                switch (Player.allySelect)
                {
                    case "Ray" -> Ray.allyDmg++;
                    case "Akane" -> Akane.allyDmg++;
                    case "Jake" -> Jake.allyDmg++;
                    case "Sora" -> Sora.allyDmg++;
                }
            }
            Logic.allySkipsTurn = false;
            Logic.allyUsesWeapon = true;
            Logic.enemyTakesDamageByAlly();
        }
    }

    public void retrieveAllyInfo()
    {
        Ray.setAllyName("Ray");
        Ray.setAllyClass("Warrior");
        Akane.setAllyName("Akane");
        Akane.setAllyClass("Mage");
        Jake.setAllyName("Jake");
        Jake.setAllyClass("Archer");
    }

    public void allyGetsExperience(int exp)
    {
        switch (Player.allySelect)
        {
            case "Ray" -> Ray.allyExp += exp;
            case "Akane" -> Akane.allyExp += exp;
            case "Jake" -> Jake.allyExp += exp;
            case "Sora" -> Sora.allyExp += exp;
        }
        if (allyExp >= 100)
        {
            switch (Player.allySelect)
            {
                case "Ray" -> Ray.allyLevelUp();
                case "Akane" -> Akane.allyLevelUp();
                case "Jake" -> Jake.allyLevelUp();
                case "Sora" -> Sora.allyLevelUp();
            }
        }
    }

    public void setAlliesStats() throws IOException {
        String contents;
        {
            try
            {
                contents = new String((Files.readAllBytes(Paths.get(alliesJson))));
                JSONArray o = new JSONArray(contents);
                Ray.setAllyName(o.getJSONObject(1).getString("Ally"));
                Ray.setAllyClass(o.getJSONObject(1).getString("CLASS"));
                Ray.setAllyLevel(o.getJSONObject(1).getInt("LVL"));
                Ray.allyTotalHp = o.getJSONObject(1).getInt("HP");
                Ray.allyTotalMp = o.getJSONObject(1).getInt("MP");
                Ray.allyHp = Ray.allyTotalHp;
                Ray.allyMp = Ray.allyTotalMp;
                Ray.allyDmg = o.getJSONObject(1).getInt("DMG");
                Akane.setAllyName(o.getJSONObject(2).getString("Ally"));
                Akane.setAllyClass(o.getJSONObject(2).getString("CLASS"));
                Akane.setAllyLevel(o.getJSONObject(2).getInt("LVL"));
                Akane.allyTotalHp = (o.getJSONObject(2).getInt("HP"));
                Akane.allyTotalMp = (o.getJSONObject(2).getInt("MP"));
                Akane.allyHp = Akane.allyTotalHp;
                Akane.allyMp = Akane.allyTotalMp;
                Akane.allyDmg = (o.getJSONObject(2).getInt("DMG"));
                Jake.setAllyName(o.getJSONObject(3).getString("Ally"));
                Jake.setAllyClass(o.getJSONObject(3).getString("CLASS"));
                Jake.setAllyLevel(o.getJSONObject(3).getInt("LVL"));
                Jake.allyTotalHp = (o.getJSONObject(3).getInt("HP"));
                Jake.allyTotalMp = (o.getJSONObject(3).getInt("MP"));
                Jake.allyHp = Jake.allyTotalHp;
                Jake.allyMp = Jake.allyTotalMp;
                Jake.allyDmg = (o.getJSONObject(3).getInt("DMG"));
                Sora.setAllyName(o.getJSONObject(4).getString("Ally"));
                Sora.setAllyClass(o.getJSONObject(4).getString("CLASS"));
                Sora.setAllyLevel(o.getJSONObject(4).getInt("LVL"));
                Sora.allyTotalHp = (o.getJSONObject(4).getInt("HP"));
                Sora.allyTotalMp = (o.getJSONObject(4).getInt("MP"));
                Sora.allyHp = Sora.allyTotalHp;
                Sora.allyMp = Sora.allyTotalMp;
                Sora.allyDmg = (o.getJSONObject(4).getInt("DMG"));

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        partyClass.put(Ray.getAllyName(), Ray.getAllyClass());
        partyClass.put(Akane.getAllyName(), Akane.getAllyClass());
        partyClass.put(Jake.getAllyName(), Jake.getAllyClass());
        partyClass.put(Sora.getAllyName(), Sora.getAllyClass());
        partyLevel.putIfAbsent(Ray.getAllyName(), Ray.getAllyLevel());
        partyLevel.putIfAbsent(Akane.getAllyName(), Akane.getAllyLevel());
        partyLevel.putIfAbsent(Jake.getAllyName(), Jake.getAllyLevel());
        partyLevel.putIfAbsent(Sora.getAllyName(), Sora.getAllyLevel());
    }

    public void partyHp()
    {
        partyMembersHp.put("Ray", Ray.allyHp);
        partyMembersHp.put("Akane", Akane.allyHp);
        partyMembersHp.put("Jake", Jake.allyHp);
        partyMembersHp.put(Player.urName, Player.playerHealth);
        partyMembersHp.put("Sora", Sora.allyHp);
    }

    public void lookAtEnemy()
    {
        System.out.println("Where do you want to look?");
        Scanner lookScanner = new Scanner(System.in);
        String look = lookScanner.nextLine();
        if (look.equals(Enemy.enemyName))
        {
            System.out.println("    " + Enemy.enemyName + " Stats");
            System.out.println("--------------------");
            System.out.println("LVL: " + Enemy.enemyLevel);
            System.out.println("HP: " + Enemy.enemyHealth + "/" + Enemy.enemyTotalHealth);
            System.out.println("MP: " + Enemy.enemyMana + "/" + Enemy.enemyTotalMana);
            System.out.println("DMG: " + Enemy.enemyTotalDamage);
        }
        else if (look.equals("self"))
        {
            System.out.println("    " + allyName + " Stats");
            System.out.println("--------------------");
            System.out.println("LVL: " + allyLevel);
            System.out.println("HP: " + allyHp + "/" + allyTotalHp);
            System.out.println("MP: " + allyMp + "/" + allyTotalMp);
            System.out.println("DMG: " + allyDmg);
            System.out.println("EXP: " + allyExp);
            System.out.println("BALANCE: " + "$" + Player.playerCurrency);
        }
        else
            System.out.println("Please enter the name of the person you're looking at.");

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("1) BACK");
        System.out.println("2) LOOK");
        Scanner back = new Scanner(System.in);
        String goBack = back.nextLine();
        if (goBack.equals("1"))
            allyMenu();
        else if (goBack.equals("2"))
            lookAtEnemy();
        else
            allyMenu();
    }

    public void allySkillMenu() {
        JSONArray skillData = new JSONArray();
        skills.skillInsert();
        System.out.println(" ");
        System.out.println("SKILLS");
        System.out.println("------");

        if (AllySkills.size() == 1 && AllySkillsMp.size() == 1)
        {
            System.out.println(AllySkills.get(0) + "  MP: " + AllySkillsMp.get(0));
        }
        else if (AllySkills.size() == 2 && AllySkillsMp.size() == 2)
        {
            System.out.println(AllySkills.get(0) + "  MP: " + AllySkillsMp.get(0));
            System.out.println(AllySkills.get(1) + "  MP: " + AllySkillsMp.get(1));
        }
        else if (AllySkills.size() == 3 && AllySkillsMp.size() == 3)
        {
            System.out.println(AllySkills.get(0) + "  MP: " + AllySkillsMp.get(0));
            System.out.println(AllySkills.get(1) + "  MP: " + AllySkillsMp.get(1));
            System.out.println(AllySkills.get(2) + "  MP: " + AllySkillsMp.get(2));
        }
        else if (AllySkills.size() == 4 && AllySkillsMp.size() == 4)
        {
            System.out.println(AllySkills.get(0) + "  MP: " + AllySkillsMp.get(0));
            System.out.println(AllySkills.get(1) + "  MP: " + AllySkillsMp.get(1));
            System.out.println(AllySkills.get(2) + "  MP: " + AllySkillsMp.get(2));
            System.out.println(AllySkills.get(3) + "  MP: " + AllySkillsMp.get(3));
        }
        else if (AllySkills.size() == 5 && AllySkillsMp.size() == 5)
        {
            System.out.println(AllySkills.get(0) + "  MP: " + AllySkillsMp.get(0));
            System.out.println(AllySkills.get(1) + "  MP: " + AllySkillsMp.get(1));
            System.out.println(AllySkills.get(2) + "  MP: " + AllySkillsMp.get(2));
            System.out.println(AllySkills.get(3) + "  MP: " + AllySkillsMp.get(3));
            System.out.println(AllySkills.get(4) + "  MP: " + AllySkillsMp.get(4));
        }
        else if (AllySkills.size() == 6 && AllySkillsMp.size() == 6)
        {
            System.out.println(AllySkills.get(0) + "  MP: " + AllySkillsMp.get(0));
            System.out.println(AllySkills.get(1) + "  MP: " + AllySkillsMp.get(1));
            System.out.println(AllySkills.get(2) + "  MP: " + AllySkillsMp.get(2));
            System.out.println(AllySkills.get(3) + "  MP: " + AllySkillsMp.get(3));
            System.out.println(AllySkills.get(4) + "  MP: " + AllySkillsMp.get(4));
            System.out.println(AllySkills.get(5) + "  MP: " + AllySkillsMp.get(5));

        }
        Scanner input = new Scanner(System.in);
        String stringInput = input.nextLine();
        skills.stringInput = stringInput;
        if (AllySkills.contains(stringInput) && skills.PlayerSkillsDamageHashMap.containsKey(stringInput) && allyMp >= skills.PlayerSkillsManaHashMap.get(stringInput)) {
            for (int i = 0; i < skills.PlayerSkillsManaHashMap.get(stringInput); i++) {
                allyMp--;
            }
            for (int i = 0; i < skills.PlayerSkillsDamageHashMap.get(stringInput); i++) {
                allyDmg++;
            }
            Logic.allySkipsTurn = false;
            Logic.allyUsesWeapon = false;
            Logic.allyHitsEnemyWithSkill();
        }
        if (AllySkills.contains(stringInput) && skills.PlayerSkillsDamageHashMap.containsKey(stringInput) && Player.playerMana < skills.PlayerSkillsManaHashMap.get(stringInput)) {
            System.out.println("You do not have enough mana to use this skill.");
        }
        else if (!AllySkills.contains(stringInput) || !skills.PlayerSkillsDamageHashMap.containsKey(stringInput))
        {
            System.out.println("Could not find the skill you were looking for.");
        }
    }

    public void allyLevelUp()
    {
        allyLevel++;
        System.out.println(" ");
        System.out.println(allyName + " has reached level " + allyLevel + "!");
        System.out.println(" ");
        switch (Player.allySelect)
        {
            case "Ray" -> Ray.allyStatBoost();
            case "Akane" -> Akane.allyStatBoost();
            case "Jake" -> Jake.allyStatBoost();
            case "Sora" -> Sora.allyStatBoost();
        }
        System.out.println(" ");
        switch (Player.allySelect)
        {
            case "Ray" -> Allies.Ray.allyGetsSkill();
            case "Akane" -> Allies.Akane.allyGetsSkill();
            case "Jake" -> Allies.Jake.allyGetsSkill();
            case "Sora" -> Allies.Sora.allyGetsSkill();
        }
    }

    public void allyStatBoost()
    {
        partyLevel.putIfAbsent(Ray.getAllyName(), Ray.getAllyLevel());
        partyLevel.putIfAbsent(Akane.getAllyName(), Akane.getAllyLevel());
        partyLevel.putIfAbsent(Jake.getAllyName(), Jake.getAllyLevel());
        partyLevel.putIfAbsent(Sora.getAllyName(), Sora.getAllyLevel());
        int allyLvl;
        allyLvl = partyLevel.get(getAllyName());
        int x = 0;
        if (allyLvl <= 10)
        {
            x = 1;
        }
        else if (allyLvl <= 20)
        {
            x = 2;
        }
        else if (allyLvl <= 30)
        {
            x = 3;
        }
        else if (allyLvl <= 40)
        {
            x = 4;
        }
        else if (allyLvl > 41)
        {
            x = 5;
        }
        switch (allyClass)
        {
            case "Warrior" -> {
                allyHp += 8 * x;
                allyMp += 3 * x; //16
                allyDmg += 5 * x;
            }
            case "Mage" -> {
                allyHp += 5 * x;
                allyMp += 7 * x; //16
                allyDmg += 4 * x;
            }
            case "Archer" -> {
                allyHp += 3 * x;
                allyMp += 5 * x; //16
                allyDmg += 8 * x;
            }
        }
    }


    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public String getAllyClass() {
        return allyClass;
    }

    public void setAllyClass(String allyClass) {
        this.allyClass = allyClass;
    }

    public int getAllyLevel() {
        return allyLevel;
    }

    public void setAllyLevel(int allyLevel) {
        this.allyLevel = allyLevel;
    }
}
