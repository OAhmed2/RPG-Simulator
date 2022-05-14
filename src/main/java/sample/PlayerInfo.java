package sample;

import org.json.JSONArray;

import java.util.*;

public class PlayerInfo extends Main {
    static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static PlayerInfo Player = new PlayerInfo();
    public List<Allies> PlayerAllies = new ArrayList<Allies>();
    public List<Allies> allPlayerAllies = new ArrayList<>();
    String pronoun;
    String himHer;
    int playerHealth;
    int playerTotalHealth;
    int playerMana;
    int playerTotalMana;
    int playerLevel;
    int playerTotalDamage;
    int playerCurrency;
    int hpRemaining;
    double experience;;
    int urAge;
    int weaponDamage;
    String urName;
    String cl;
    String allySelect;



    public void playerMenuSelect()
    {
        Logic.allyIsSelected = false;
        while (Enemy.enemyHealth > 0) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("What's my strategy?");
            System.out.println("-------------------" + "  " + "HP: " + playerHealth + "/" + playerTotalHealth + "  " + "MP: " + playerMana + "/" + playerTotalMana);
            System.out.println("1) FIGHT");
            System.out.println("2) INVENTORY");
            System.out.println("3) LOOK");
            System.out.println("4) DO NOTHING");
            if (PlayerAllies.size() >= 1)
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
                openInventory();
            } else if (mainPlayerMenuSelect.equals("3")) {
                lookAtEnemy();
            }
            else if (mainPlayerMenuSelect.equals("4")){
                Logic.playerUsedSkill = false;
                Logic.playerUsesWeapon = false;
                Logic.playerSkipsTurn = true;
                Logic.playerTakesDamage();
            }
              else if (mainPlayerMenuSelect.equals("5") && PlayerAllies.size() >= 1){
                  Logic.allyFaints();
            }
        }
    }

    public void openInventory() {
        if (items.PlayerInventory.size() >= 10)
        {
            items.PlayerInventory.remove(10);
        }
        else
            System.out.println(" ");
        System.out.println("INVENTORY");
        System.out.println("---------");
        System.out.println(items.PlayerInventory);
        System.out.println(" ");
        System.out.println("1) USE");
        System.out.println("2) THROW AWAY");
        System.out.println("3) BACK");
        Scanner inventoryInput = new Scanner(System.in);
        String input = inventoryInput.nextLine();
        switch (input) {
            case "1" -> {

                System.out.println(items.PlayerInventory);
                System.out.println("What would you like to use?");
                Scanner useInput = new Scanner(System.in);
                String uInput = useInput.nextLine();
                if (uInput.equals("Potion") && items.PlayerInventory.contains(Items.Potion.itemName))
                {
                    items.PlayerInventory.remove(Items.Potion.itemName);
                    items.healHP(30);
                    Logic.whoTakesDamage();
                }
                else if (uInput.equals("Elixir") && items.PlayerInventory.contains(Items.Elixir.itemName)) {
                    items.PlayerInventory.remove(Items.Elixir.itemName);
                    items.manaHeal(5);
                    Logic.whoTakesDamage();
                }
                else
                    System.out.println("No item has been found with that name.");

            }
            case "2" -> {
                for (String inventory : items.PlayerInventory) {
                    System.out.println(inventory);
                }
                System.out.println("What would you like to throw out?");
                Scanner useInput = new Scanner(System.in);
                String uInput = useInput.nextLine();
                if (uInput.equals("Potion") && items.PlayerInventory.contains(Items.Potion.itemName))
                {
                    items.PlayerInventory.remove(Items.Potion.itemName);
                    System.out.println("Removed Potion.");
                }
                else if (uInput.equals("Elixir") && items.PlayerInventory.contains(Items.Elixir.itemName))
                {
                    items.PlayerInventory.remove(Items.Elixir.itemName);
                    System.out.println("Removed Elixir.");
                }
                else
                    System.out.println("No item has been found with that name.");
            }
            case "3" ->
                    playerMenuSelect();
        }
    }

    public void FightSelect()
    {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("FIGHT");
        System.out.println("-----");
        System.out.println("1) WEAPONS");
        System.out.println("2) SKILLS");
        System.out.println("3) BACK");
        Scanner mainPlayerFightScanner = new Scanner(System.in);
        String mainPlayerFightSelection = mainPlayerFightScanner.nextLine();
        switch (mainPlayerFightSelection)
        {
            case "1" -> weaponsMenu();
            case "2" -> playerSkillMenu();
            case "3" -> playerMenuSelect();
        }
    }

    public void goldGained(int totalGoldDrop)
    {
        int x = 100;
        Random goldEarned = new Random();
        int gold = goldEarned.nextInt(totalGoldDrop + x);
        if (Enemy.enemyLevel <= 8){
            playerCurrency += gold;
        }
        else if (Enemy.enemyLevel <= 15){
            gold *= 2;
            playerCurrency += gold;
        }
        else if (Enemy.enemyLevel <= 24){
            gold *= 4;
            playerCurrency += gold;
        }
        else if (Enemy.enemyLevel <= 35){
            gold *= 5;
            playerCurrency += gold;
        }
        else if (Enemy.enemyLevel <= 46){
            gold *= 6;
            playerCurrency += gold;
        }
        else if (Enemy.enemyLevel >= 50){
            gold *= 10;
            playerCurrency += gold;
        }
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(ANSI_YELLOW + "You got " + gold + " gold!" + ANSI_RESET);
    }


    public void openWallet()
    {
        System.out.println(" ");
        System.out.println("WALLET");
        System.out.println("------");
        System.out.println(ANSI_YELLOW + "$" + playerCurrency + ANSI_RESET);
    }



    public void lookAtEnemy()
    {
        System.out.println("Where do you want to look?");
        Scanner lookScanner = new Scanner(System.in);
        String look = lookScanner.nextLine();
        if (look.equals("enemy"))
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
            System.out.println("    " + urName + " Stats");
            System.out.println("--------------------");
            System.out.println("LVL: " + playerLevel);
            System.out.println("HP: " + playerHealth + "/" + playerTotalHealth);
            System.out.println("MP: " + playerMana + "/" + playerTotalMana);
            System.out.println("DMG: " + playerTotalDamage);
            System.out.println("EXP: " + experience);
            System.out.println("BALANCE: " + "$" + playerCurrency);
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
                playerMenuSelect();
            else if (goBack.equals("2"))
                lookAtEnemy();
            else
                playerMenuSelect();
        }

    public void weaponsMenu()
    {
        items.weaponDatabase();
        System.out.println(" ");
        System.out.println("WEAPONS");
        System.out.println("-------");
        equips.printMap(equips.PlayerEquipmentHashMap);
        Scanner INPUT = new Scanner(System.in);
        equips.weaponNameInput = INPUT.nextLine();
        if (equips.PlayerEquipmentHashMap.containsKey(equips.weaponNameInput))
        {
            Logic.playerUsedSkill = false;
            Logic.playerSkipsTurn = false;
            Logic.playerUsesWeapon = true;
            for (int i = 0; i < equips.WeaponDamageMap.get(equips.weaponNameInput); i++)
            {
                playerTotalDamage++;
            }
            Logic.enemyTakesDamage();
        }
        else
            System.out.println("Item not found.");
    }

    public void playerSkillMenu()
    {
        JSONArray skillData = new JSONArray();
        skills.skillInsert();
        System.out.println(" ");
        System.out.println("SKILLS");
        System.out.println("------");

        if (skills.PlayerSkills.size() == 1 && skills.SkillMana.size() == 1)
        {
            System.out.println(skills.PlayerSkills.get(0) + "  MP: " + skills.SkillMana.get(0));
        }
        else if (skills.PlayerSkills.size() == 2 && skills.SkillMana.size() == 2)
        {
            System.out.println(skills.PlayerSkills.get(1) + "  MP: " + skills.SkillMana.get(1));
        }
        else if (skills.PlayerSkills.size() == 3 && skills.SkillMana.size() == 3)
        {
            System.out.println(skills.PlayerSkills.get(1) + "  MP: " + skills.SkillMana.get(1));
            System.out.println(skills.PlayerSkills.get(2) + "  MP: " + skills.SkillMana.get(2));
        }
        else if (skills.PlayerSkills.size() == 4 && skills.SkillMana.size() == 4)
        {
            System.out.println(skills.PlayerSkills.get(1) + "  MP: " + skills.SkillMana.get(1));
            System.out.println(skills.PlayerSkills.get(2) + "  MP: " + skills.SkillMana.get(2));
            System.out.println(skills.PlayerSkills.get(3) + "  MP: " + skills.SkillMana.get(3));
        }
        else if (skills.PlayerSkills.size() == 5 && skills.SkillMana.size() == 5)
        {
            System.out.println(skills.PlayerSkills.get(1) + "  MP: " + skills.SkillMana.get(1));
            System.out.println(skills.PlayerSkills.get(2) + "  MP: " + skills.SkillMana.get(2));
            System.out.println(skills.PlayerSkills.get(3) + "  MP: " + skills.SkillMana.get(3));
            System.out.println(skills.PlayerSkills.get(4) + "  MP: " + skills.SkillMana.get(4));
        }
        else if (skills.PlayerSkills.size() == 6 && skills.SkillMana.size() == 6)
        {
            System.out.println(skills.PlayerSkills.get(1) + "  MP: " + skills.SkillMana.get(1));
            System.out.println(skills.PlayerSkills.get(2) + "  MP: " + skills.SkillMana.get(2));
            System.out.println(skills.PlayerSkills.get(3) + "  MP: " + skills.SkillMana.get(3));
            System.out.println(skills.PlayerSkills.get(4) + "  MP: " + skills.SkillMana.get(4));
            System.out.println(skills.PlayerSkills.get(5) + "  MP: " + skills.SkillMana.get(5));
        }
        Scanner input = new Scanner(System.in);
        String stringInput = input.nextLine();
         if (skills.PlayerSkillsDamageHashMap.containsKey(stringInput) && skills.PlayerSkillsManaHashMap.containsKey(stringInput))
         {
             skills.stringInput = stringInput;
             if (skills.PlayerSkills.contains(stringInput) && skills.PlayerSkillsDamageHashMap.containsKey(stringInput) && playerMana >= skills.PlayerSkillsManaHashMap.get(stringInput))
             {
                 for (int i = 0; i < skills.PlayerSkillsManaHashMap.get(stringInput); i++)
                 {
                     playerMana--;
                 }
                 for (int i = 0; i < skills.PlayerSkillsDamageHashMap.get(stringInput); i++)
                 {
                     playerTotalDamage++;
                 }
                 Logic.playerUsedSkill = true;
                 Logic.playerSkipsTurn = false;
                 Logic.playerUsesWeapon = false;
                 Logic.allyIsSelected = false;
                 Logic.enemyTakesDamageUsingSkill();
             }
             else if (skills.PlayerSkills.contains(stringInput) && skills.PlayerSkillsDamageHashMap.containsKey(stringInput) && playerMana < skills.PlayerSkillsManaHashMap.get(stringInput)) {
                 System.out.println("You do not have enough mana to use this skill.");
             }
             else if (!skills.PlayerSkills.contains(stringInput) || !skills.PlayerSkillsDamageHashMap.containsKey(stringInput) || stringInput == null) {
                 System.out.println("No skill with that name can be found.");
             }
         }
         else
         {
             System.out.println("No skill with that name can be found.");
         }
    }

    public void ifPlayerKod()
    {
        if (Player.playerHealth <= 0)
        {
            Player.playerHealth = 1;
        }
    }

    public void theHub()
    {
        boolean playerOnMenu = true;
        while (playerOnMenu)
        {

            System.out.println(" ");
            System.out.println("What do you want to do?");
            System.out.println("-----------------------");
            System.out.println("1) CHECK");
            System.out.println("2) HEAD TO SHOP");
            System.out.println("3) HEAD TO BLACKSMITH");
            System.out.println("4) SAVE");
            System.out.println("5) SETTINGS");
            System.out.println("6) CONTINUE STORY");
            Scanner input = new Scanner(System.in);
            String hubInput = input.nextLine();
            switch (hubInput)
            {
                case "1" ->
                        {
                            System.out.println(" ");
                            System.out.println("CHECK WHAT?");
                            System.out.println("-----------");
                            System.out.println("1) Equipment");
                            System.out.println("2) Player Balance");
                            System.out.println("3) Party Experience)");
                            System.out.println("4) Skills");
                            System.out.println("5) Party Members");
                            Scanner check = new Scanner(System.in);
                            String checkWhat = check.nextLine();
                            switch (checkWhat)
                            {
                                case "1" -> {
                                    System.out.println(" ");
                                    System.out.println("Remove Equipment");
                                    System.out.println("Trade Equipment");
                                }
                                case "2" -> Player.openWallet();
                                case "3" -> Player.partyExperience();
                                case "5" -> Player.partyMembers();


                            }
                        }
                case "2" -> shop.openShopMenu();
                case "3" -> shop.openBlackSmith();
                case "4" ->
                {
                    Save data = new Save();
                    // Save data to file
                    data.delete(Save.file_location, 1, 1);
                    data.WriteToFile(Save.gson.toJson(data));
                }
                case "5" ->
                {
                    System.out.println(" ");
                    System.out.println("SETTINGS");
                    System.out.println("--------");
                    System.out.println("1) ADJUST TEXT SPEED");
                    System.out.println("2) ADJUST DIFFICULTY");
                    Scanner settings = new Scanner(System.in);
                    String settingsInput = settings.nextLine();
                    if (settingsInput.equals("1")) {
                                    System.out.println(" ");
                                    System.out.println("Select the time interval between messages:");
                                    System.out.println("1) Very Slow");
                                    System.out.println("2) Slow");
                                    System.out.println("3) Normal");
                                    System.out.println("4) Fast");
                                    System.out.println("5) Very Fast");
                                    Scanner ti = new Scanner(System.in);
                                    String tiInput = ti.nextLine();
                                    switch (tiInput)
                                    {
                                        case "1" -> Logic.x = 5000;
                                        case "2" -> Logic.x = 4000;
                                        case "3" -> Logic.x = 3000;
                                        case "4" -> Logic.x = 2000;
                                        case "5" -> Logic.x = 1000;
                                        default -> System.out.println("Please type in a number and try again.");
                                    }
                    }
                    else if (settingsInput.equals("2")){
                        Logic.openDifficulty();
                    }
                }

                case "6" ->
                {
                    if (Logic.save2_1)
                    {
                        playerOnMenu = false;
                        Ch2.boatSail();
                    }
                    else if (Logic.save2_2)
                    {
                        playerOnMenu = false;
                        Ch2.blackWood();
                    }
                    else if (Logic.save3_1)
                    {
                        playerOnMenu = false;
                        Ch3.journeyToCapital();
                    }
                }

            }
        }
    }

    public void partyMembers() {
        for (Allies party : Player.allPlayerAllies)
        {
            System.out.println(party.getAllyName());
        }
        System.out.println(" ");
        System.out.println("Would you like to add or remove an ally?");
        System.out.println("----------------------------------------");
        System.out.println("1) ADD");
        System.out.println("2) REMOVE");
        Scanner input = new Scanner(System.in);
        String partyInput = input.nextLine();
        switch (partyInput)
        {
            case "1" ->
                    {
                        System.out.println(" ");
                        System.out.println("What party member would you like to add?");
                        Scanner add = new Scanner(System.in);
                        String addMember = add.nextLine();
                        if (!(Player.PlayerAllies.size() >= 4))
                        {
                            switch (addMember)
                            {
                                case "Ray" -> {
                                   if (Player.allPlayerAllies.contains(Allies.Ray))
                                   {
                                       Player.PlayerAllies.add(Allies.Ray);
                                       System.out.println("Successfully added Ray into your party.");
                                   }
                                }
                                case "Akane" -> {
                                    if (Player.allPlayerAllies.contains(Allies.Akane))
                                    {
                                        Player.PlayerAllies.add(Allies.Akane);
                                        System.out.println("Successfully added Akane into your party.");

                                    }
                                }
                                case "Jake" -> {
                                    if (Player.allPlayerAllies.contains(Allies.Jake))
                                    {
                                        Player.PlayerAllies.add(Allies.Jake);
                                        System.out.println("Successfully added Jake into your party.");
                                    }
                                }
                                case "Sora" -> {
                                    if (Player.allPlayerAllies.contains(Allies.Sora))
                                    {
                                        Player.PlayerAllies.add(Allies.Sora);
                                        System.out.println("Successfully added Sora into your party.");
                                    }
                                }
                            }
                        }
                    }
                    case "2" ->
                            {
                                System.out.println(" ");
                                System.out.println("Which party member would you like to remove?");
                                for (Allies party : Player.PlayerAllies)
                                {
                                    System.out.println(party.getAllyName());
                                }
                                Scanner remove = new Scanner(System.in);
                                String removeMember = remove.nextLine();
                                switch (removeMember)
                                {
                                    case "Ray" -> Player.PlayerAllies.remove(Allies.Ray);
                                    case "Akane" -> Player.PlayerAllies.remove(Allies.Akane);
                                    case "Jake" -> Player.PlayerAllies.remove(Allies.Jake);
                                    case "Sora" -> Player.PlayerAllies.remove(Allies.Sora);

                                }
                            }
        }
    }


    public void partyExperience() {
        allies.partyHp();
        System.out.println(" ");
        System.out.println("PARTY EXPERIENCE");
        System.out.println("----------------");
        System.out.println(urName);
        if (PlayerAllies.size() == 1)
        {
            System.out.println(PlayerAllies.get(0).getAllyName() + ANSI_CYAN + " (Level) " + PlayerAllies.get(0).getAllyLevel() + "): "+ ANSI_RESET + ANSI_YELLOW + PlayerAllies.get(0).allyExp + ANSI_RESET);
        }
        else if (PlayerAllies.size() == 2)
        {
            System.out.println(PlayerAllies.get(0).getAllyName() + ANSI_CYAN + " (Level) " + PlayerAllies.get(0).getAllyLevel() + "): "+ ANSI_RESET + ANSI_YELLOW + PlayerAllies.get(0).allyExp + ANSI_RESET);
            System.out.println(PlayerAllies.get(1).getAllyName() + ANSI_CYAN + " (Level) " + PlayerAllies.get(1).getAllyLevel() + "): "+ ANSI_RESET + ANSI_YELLOW + PlayerAllies.get(1).allyExp + ANSI_RESET);
        }
        else if (PlayerAllies.size() == 3)
        {
            System.out.println(PlayerAllies.get(0).getAllyName() + ANSI_CYAN + " (Level) " + PlayerAllies.get(0).getAllyLevel() + "): "+ ANSI_RESET + ANSI_YELLOW + PlayerAllies.get(0).allyExp + ANSI_RESET);
            System.out.println(PlayerAllies.get(1).getAllyName() + ANSI_CYAN + " (Level) " + PlayerAllies.get(1).getAllyLevel() + "): "+ ANSI_RESET + ANSI_YELLOW + PlayerAllies.get(1).allyExp + ANSI_RESET);
            System.out.println(PlayerAllies.get(2).getAllyName() + ANSI_CYAN + " (Level) " + PlayerAllies.get(2).getAllyLevel() + "): "+ ANSI_RESET + ANSI_YELLOW + PlayerAllies.get(2).allyExp + ANSI_RESET);
        }
        else if (PlayerAllies.size() == 4)
        {
            System.out.println(PlayerAllies.get(0).getAllyName() + ANSI_CYAN + " (Level) " + PlayerAllies.get(0).getAllyLevel() + "): "+ ANSI_RESET + ANSI_YELLOW + PlayerAllies.get(0).allyExp + ANSI_RESET);
            System.out.println(PlayerAllies.get(1).getAllyName() + ANSI_CYAN + " (Level) " + PlayerAllies.get(1).getAllyLevel() + "): "+ ANSI_RESET + ANSI_YELLOW + PlayerAllies.get(1).allyExp + ANSI_RESET);
            System.out.println(PlayerAllies.get(2).getAllyName() + ANSI_CYAN + " (Level) " + PlayerAllies.get(2).getAllyLevel() + "): "+ ANSI_RESET + ANSI_YELLOW + PlayerAllies.get(2).allyExp + ANSI_RESET);
            System.out.println(PlayerAllies.get(3).getAllyName() + ANSI_CYAN + " (Level) " + PlayerAllies.get(3).getAllyLevel() + "): "+ ANSI_RESET + ANSI_YELLOW + PlayerAllies.get(3).allyExp + ANSI_RESET);
        }
    }


    public String getUrName() {
        return urName;
    }

    public void setUrName(String urName) {
        this.urName = urName;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public int getPlayerTotalDamage(){
        return playerTotalDamage;
    }

    public void setPlayerTotalDamage(int playerTotalDamage) {
        this.playerTotalDamage = playerTotalDamage;
    }


}
