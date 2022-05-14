package sample;

import java.util.Random;
import java.util.Scanner;

public class GameLogic extends Main {
    boolean save2_1;
    boolean save2_2;
    boolean save2_3;
    boolean save3_1;
    boolean enemyHitsTarget;
    boolean playerHitsTarget;
    boolean allyIsSelected;
    boolean playerIsStunned;
    boolean enemyUsedSkill;
    boolean playerUsedSkill;
    boolean playerSkipsTurn;
    boolean enemyIsStunned;
    boolean playerUsesWeapon;
    boolean enemyHitsAlly;
    boolean allyUsesSkill;
    private boolean allyHitsEnemy;
    boolean allyUsesWeapon;
    boolean allySkipsTurn;
    boolean allyIsStunned;
    int enemySelectsSkill;
    int x;
    double d;
    private int defaultDmg;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void levelUp()
    {
        Player.playerLevel++;
        parser.playerGetsSkill();
        levelUpBoost();
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(ANSI_YELLOW + "You have reached level " + Player.playerLevel + "!" + ANSI_RESET);
        Logic.timeDelay();
        Player.experience = 0;
        Player.playerHealth = Player.playerTotalHealth;
        Player.playerMana = Player.playerTotalMana;
    }

    public void openDifficulty()
    {
        int dAdjuster;
        System.out.println(" ");
        System.out.println("What difficulty would you like to set the game to?");
        System.out.println("--------------------------------------------------");
        System.out.println("1) EASY");
        System.out.println("2) NORMAL");
        System.out.println("3) HARD");
        System.out.println("4) EXTREME");
        Scanner input = new Scanner(System.in);
        String difficulty = input.nextLine();
        switch (difficulty)
        {
            case "1" -> {
                Logic.d = 0.5;
                System.out.println("Difficulty has been set to easy.");
            }
            case "2" -> {
                Logic.d = 1;
                System.out.println("Difficulty has been set to normal.");
            }
            case "3" -> {
                Logic.d = 1.2;
                System.out.println("Difficulty has been set to hard.");
            }
            case "4" -> {
                Logic.d = 2;
                System.out.println(ANSI_RED + "You feel like you're gonna have a bad time...");
            }
        }

    }


    public void manaRecovery()
    {

            if (Player.playerTotalMana >= 5 && Player.playerTotalMana <= 19)
            {
                Player.playerMana++;
            }

            else if (Player.playerTotalMana >= 20 && Player.playerTotalMana <= 40)
            {
                Player.playerMana += 2;

            }
            else if (Player.playerTotalMana >= 41 && Player.playerTotalMana <= 59)
            {
                Player.playerMana += 3;
            }

            else if (Player.playerTotalMana >= 60 && Player.playerTotalMana <= 99)
            {
                Player.playerMana += 4;
            }

            if (Player.playerTotalMana >= 100)
            {
                Player.playerMana += 6;
            }

            if (Player.playerMana >= Player.playerTotalMana)
            {
                Player.playerMana = Player.playerTotalMana;
            }

        if (!enemyIsStunned)
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

    public void enemyTakesDamage() {
        manaRecovery();
        Random damageRandomizer = new Random();
        int playerDmg = damageRandomizer.nextInt(Player.getPlayerTotalDamage() + 1);
        if (Logic.playerUsesWeapon)
        {
            if (!(equips.weaponNameInput == null))
            {
                for (int i = 0; i < equips.WeaponDamageMap.get(equips.weaponNameInput); i++)
                {
                    Player.playerTotalDamage--;
                }
            }
        }
        if (playerDmg >= 1) {
            System.out.println(ANSI_GREEN + "You did " + playerDmg + " damage." + ANSI_RESET);
            for (int i = 0; i < playerDmg; i++) {
                Enemy.enemyHealth--;
            }
            timeDelay();
            if (Enemy.enemyHealth > 1)
            {
                System.out.println(Enemy.enemyName + " has " + Enemy.enemyHealth + " HP remaining.");
                Logic.playerTakesDamage();
            }
            else if (Enemy.enemyHealth <= 0)
            {
                System.out.println("YOU WIN.");
            }

        }
        else
        {
            System.out.println("You missed your attack!");
            playerTakesDamage();
        }
    }

    public void playerTakesDamage() {
        enemyHitsTarget = true;
        if (Logic.playerSkipsTurn)
        {
            manaRecovery();
        }
        if (Enemy.enemyHasSkill)
        {
            Random enemyUsesWhatSkill = new Random();
            enemySelectsSkill = enemyUsesWhatSkill.nextInt(4 + 1);
            if (enemySelectsSkill == 1)
            {
                if (Enemy.getEnemySkill1() == null)
                {
                    playerHitsTarget = true;
                }
                else
                    if (Enemy.enemyMana >= Enemy.getEnemyMana1())
                    {
                        enemyUsedSkill = true;
                        for (int i = 0; i < Enemy.getEnemyDamage1(); i++)
                        {
                            Enemy.enemyTotalDamage++;
                        }
                        for (int i = 0; i < Enemy.getEnemyMana1(); i++)
                        {
                            Enemy.enemyMana--;
                        }
                        enemyUsesSkill1();
                    }
            }
            else if (enemySelectsSkill == 2)
            {
                if (Enemy.getEnemySkill2() == null)
                {
                    enemyHitsTarget = true;
                }
                else
                    if (Enemy.enemyMana >= Enemy.getEnemyMana2())
                    {
                        enemyUsedSkill = true;
                        for (int i = 0; i < Enemy.getEnemyDamage2(); i++)
                        {
                            Enemy.enemyTotalDamage++;
                        }
                        for (int i = 0; i < Enemy.getEnemyMana2(); i++)
                        {
                            Enemy.enemyMana--;
                        }
                        enemyUsesSkill2();
                    }
            }
            else if (enemySelectsSkill == 3)
            {
                if (Enemy.getEnemySkill3() == null)
                {
                    enemyHitsTarget = true;
                }
                else
                    if (Enemy.enemyMana >= Enemy.getEnemyMana3())
                    {
                        enemyUsedSkill = true;
                        for (int i = 0; i < Enemy.getEnemyDamage3(); i++)
                        {
                            Enemy.enemyTotalDamage++;
                        }
                        for (int i = 0; i < Enemy.getEnemyMana3(); i++)
                        {
                            Enemy.enemyMana--;
                        }
                        enemyUsesSkill3();
                    }
            }
            else if (enemySelectsSkill == 4)
            {
                if (Enemy.getEnemySkill4() == null)
                {
                    enemyHitsTarget = true;
                }
                else
                if (Enemy.enemyMana >= Enemy.getEnemyMana4())
                {
                    enemyUsedSkill = true;
                    for (int i = 0; i < Enemy.getEnemyDamage4(); i++)
                    {
                        Enemy.enemyTotalDamage++;
                    }
                    for (int i = 0; i < Enemy.getEnemyMana4(); i++)
                    {
                        Enemy.enemyMana--;
                    }
                    enemyUsesSkill4();
                }
            }
        }
        if (enemyHitsTarget)
        {
            Random damageRandomizer = new Random();
            int enemyDmg = damageRandomizer.nextInt(Enemy.enemyTotalDamage + 1);
            if (Enemy.enemyTotalDamage > Logic.getDefaultDmg())
            {
                Enemy.enemyTotalDamage = Logic.getDefaultDmg();
            }
            timeDelay();
            if (enemyDmg >= 1)
            {
                System.out.println(ANSI_RED + Enemy.enemyName + " has dealt " + enemyDmg + " damage." + ANSI_RESET);
                for (int i = 0; i < enemyDmg; i++)
                {
                    Player.playerHealth--;
                }
                timeDelay();
                if (Player.playerHealth <= 0)
                {
                    if (!(Player.PlayerAllies.size() >= 1))
                    {
                        System.out.println("GAME OVER.");
                        System.exit(1);
                    }
                    else
                        System.out.println(Player.urName + " has passed out!");
                        Logic.timeDelay();
                        allyFaints();
                }
                else if (Player.playerHealth > 1)
                {
                    System.out.println(Player.getUrName() + " has " + Player.playerHealth + " HP remaining.");
                    timeDelay();
                    Player.playerMenuSelect();
                }
            }
        }
        else
        {
            System.out.println("not workin");
        }
    }


    public void enemyHitsPlayerUsingSkill()
    {
        if (enemyHitsTarget = true)
        {
            Random damageRandomizer = new Random();
            int enemyDmg = damageRandomizer.nextInt(Enemy.enemyTotalDamage + 1);
            if (Enemy.enemyTotalDamage > Logic.getDefaultDmg())
            {
                Enemy.enemyTotalDamage = Logic.getDefaultDmg();
            }
            if (enemyDmg >= 1)
            {
                System.out.println(ANSI_RED + Enemy.enemyName + " has dealt " + enemyDmg + " damage." + ANSI_RESET);
                for (int i = 0; i < enemyDmg; i++)
                {
                    Player.playerHealth--;
                }
                timeDelay();
                if (Player.playerHealth <= 0)
                {
                    if (!(Player.PlayerAllies.size() >= 1))
                    {
                        System.out.println("GAME OVER.");
                        System.exit(1);
                    }
                    else
                        System.out.println(Player.urName + " has passed out!");
                        Logic.timeDelay();
                        allyFaints();
                }
                else
                    System.out.println(Player.getUrName() + " has " + Player.playerHealth + " HP remaining.");
                    timeDelay();
                    if (!enemyUsedSkill && !playerIsStunned)
                    {
                        Player.playerMenuSelect();
                    }
                    else if (enemyUsedSkill && !playerIsStunned)
                    {
                        Player.playerMenuSelect();
                    }
                }
                else
                    System.out.println(Enemy.enemyName + " misses!");
        }
    }







    public void enemyTakesDamageUsingSkill()
    {
        manaRecovery();
        playerHitsTarget = true;
        int playerAccuracy = skills.PlayerSkillsAccuracyHashMap.get(skills.stringInput);
        int playerStun = skills.PlayerSkillsStunHashMap.get(skills.stringInput);
        Random accuracyRandomizer = new Random();
        int accuracy = accuracyRandomizer.nextInt(playerAccuracy + 70);
        if (playerAccuracy >= 100)
        {
            playerHitsTarget = true;
        }
        else if (accuracy >= 70 && accuracy <= 98)
        {
            playerHitsTarget = true;
        }
        else if (accuracy >= 50 && accuracy <= 69)
        {
            playerHitsTarget = true;
        }
        else if (accuracy <= 49)
        {
            playerHitsTarget = false;
            System.out.println("You used " + skills.stringInput + " but missed your attack!");
            playerTakesDamage();
        }
        if (playerHitsTarget)
        {
            if (playerStun >= 1)
            {
                enemyIsStunned = true;
                System.out.println(ANSI_CYAN + "You used " + skills.stringInput + " and stunned " + Enemy.enemyName + " for " + playerStun + " turns!" + ANSI_RESET);
                for (int i = 1; i <= playerStun; i++)
                {
                    enemyTakesDamage();
                    if (i == playerStun)
                    {
                        enemyIsStunned = false;
                        playerTakesDamage();
                        break;
                    }
                }
            }
            Random damageRandomizer = new Random();
            int playerDmg = damageRandomizer.nextInt(Player.getPlayerTotalDamage() + 1);
            if (playerUsedSkill = true)
            {
                for (int i = 0; i < skills.PlayerSkillsDamageHashMap.get(skills.stringInput); i++)
                {
                    Player.playerTotalDamage--;
                }
            }
            if (playerDmg >= 1)
            {
                System.out.println(ANSI_CYAN + "You used " + skills.stringInput + " and did " + playerDmg + " damage!" + ANSI_RESET);
                Logic.timeDelay();
                for (int i = 0; i < playerDmg; i++)
                {
                    Enemy.enemyHealth--;
                }
                if (Enemy.enemyHealth > 1)
                {
                    System.out.println(Enemy.enemyName + " has " + Enemy.enemyHealth + " HP remaining.");
                    Logic.playerTakesDamage();
                }
                else if (Enemy.enemyHealth <= 0)
                {
                    System.out.println("YOU WIN.");
                }
            }
        }
    }

    public void enemyTakesDamageByAlly() {
        //Enemy.whatEnemyAmIFacing(Enemy.enemyName, Enemy.enemyTotalHealth, Enemy.enemyHealth, Enemy.enemyTotalMana, Enemy.enemyMana, Enemy.enemylevel, Enemy.enemyTotalDamage);
        if (!allyUsesSkill)
        {
            switch (Player.allySelect)
            {
                case "Ray" -> Allies.Ray.allyManaRecovery();
                case "Akane" -> Allies.Akane.allyManaRecovery();
                case "Jake" -> Allies.Jake.allyManaRecovery();
                case "Sora" -> Allies.Sora.allyManaRecovery();
            }
        }
        int allyDamage = 1;
        switch (Player.allySelect)
        {
            case "Ray" -> allyDamage = Allies.Ray.allyDmg;
            case "Akane" -> allyDamage = Allies.Akane.allyDmg;
            case "Jake" -> allyDamage = Allies.Jake.allyDmg;
            case "Sora" -> allyDamage = Allies.Sora.allyDmg;
        }
        Random damageRandomizer = new Random();
        int allyDmg = damageRandomizer.nextInt(allyDamage + 1);
        if (Logic.allyUsesWeapon)
        {
            for (int i = 0; i < equips.WeaponDamageMap.get(equips.weaponNameInput); i++)
            {
                allyDamage--;
            }
        }
        switch (Player.allySelect)
        {
            case "Ray" -> Allies.Ray.allyDmg = allyDamage;
            case "Akane" -> Allies.Akane.allyDmg = allyDamage;
            case "Jake" -> Allies.Jake.allyDmg = allyDamage;
            case "Sora" -> Allies.Sora.allyDmg = allyDamage;
        }
        if (allyDmg >= 1)
        {
            System.out.println(ANSI_GREEN + Player.allySelect + " did " + allyDmg + " damage." + ANSI_RESET);
            for (int i = 0; i < allyDmg; i++)
            {
                Enemy.enemyHealth--;
            }
            timeDelay();
            if (Enemy.enemyHealth >= 1)
            {
                System.out.println(Enemy.enemyName + " has " + Enemy.enemyHealth + " HP remaining.");
                if (!enemyIsStunned)
                {
                    switch (Player.allySelect)
                    {
                        case "Ray" -> allyTakesDamage("Ray", Allies.Ray.allyHp);
                        case "Akane" -> allyTakesDamage("Akane", Allies.Akane.allyHp);
                        case "Jake" -> allyTakesDamage("Jake", Allies.Jake.allyHp);
                        case "Sora" -> allyTakesDamage("Sora", Allies.Sora.allyHp);
                    }
                }
            }
            if (Enemy.enemyHealth <= 0)
            {
                System.out.println("YOU WIN.");
            }
        }
        else
        {
            switch (Player.allySelect)
            {
                case "Ray" -> System.out.println(Allies.Ray.getAllyName() + " has missed their attack!");
                case "Akane" -> System.out.println(Allies.Akane.getAllyName() + " has missed their attack!");
                case "Jake" -> System.out.println(Allies.Jake.getAllyName() + " has missed their attack!");
                case "Sora" -> System.out.println(Allies.Sora.getAllyName() + " has missed their attack!");
            }
            timeDelay();
            switch (Player.allySelect)
            {
                case "Ray" -> allyTakesDamage("Ray", Allies.Ray.allyHp);
                case "Akane" -> allyTakesDamage("Akane", Allies.Akane.allyHp);
                case "Jake" -> allyTakesDamage("Jake", Allies.Jake.allyHp);
                case "Sora" -> allyTakesDamage("Sora", Allies.Sora.allyHp);
            }
        }
    }

    public void allyHitsEnemyWithSkill()
    {
        allies.allyManaRecovery();
        int playerAccuracy = skills.PlayerSkillsAccuracyHashMap.get(skills.stringInput);
        int playerStun = skills.PlayerSkillsStunHashMap.get(skills.stringInput);
        Random accuracyRandomizer = new Random();
        int accuracy = accuracyRandomizer.nextInt(playerAccuracy + 70);
        if (playerAccuracy >= 100)
        {
            setAllyHitsEnemy(true);
        }
        else if (accuracy >= 70 && accuracy <= 98)
        {
            setAllyHitsEnemy(true);
        }
        else if (accuracy >= 50 && accuracy <= 69)
        {
            setAllyHitsEnemy(true);
        }
        else if (accuracy <= 49)
        {
            setAllyHitsEnemy(false);
            System.out.println(isAllyHitsEnemy());
            System.out.println("You used " + skills.stringInput + " but missed your attack!");
            for (int i = 0; i < skills.PlayerSkillsDamageHashMap.get(skills.stringInput); i++)
            {
                switch (Player.allySelect)
                {
                    case "Ray" -> Allies.Ray.allyDmg--;
                    case "Akane" -> Allies.Akane.allyDmg--;
                    case "Jake" -> Allies.Jake.allyDmg--;
                    case "Sora" -> Allies.Sora.allyDmg--;
                }
            }
            switch (Player.allySelect)
            {
                case "Ray" -> allyTakesDamage("Ray", Allies.Ray.allyHp);
                case "Akane" -> allyTakesDamage("Akane", Allies.Akane.allyHp);
                case "Jake" -> allyTakesDamage("Jake", Allies.Jake.allyHp);
                case "Sora" -> allyTakesDamage("Sora", Allies.Sora.allyHp);
            }

        }
        if (isAllyHitsEnemy())
        {
            if (playerStun >= 1)
            {
                enemyIsStunned = true;
                System.out.println(ANSI_CYAN + Player.allySelect + " used " + skills.stringInput + " and stunned " + Enemy.enemyName + " for " + playerStun + " turns!" + ANSI_RESET);
                for (int i = 1; i <= playerStun; i++)
                {
                    if (i == playerStun)
                    {
                        enemyIsStunned = false;
                        break;
                    }
                }
            }
            Random damageRandomizer = new Random();
            int playerDmg = damageRandomizer.nextInt(Player.getPlayerTotalDamage() + 1);
            if (allyUsesSkill = true)
            {
                for (int i = 0; i < skills.PlayerSkillsDamageHashMap.get(skills.stringInput); i++)
                {
                    switch (Player.allySelect)
                    {
                        case "Ray" -> Allies.Ray.allyDmg--;
                        case "Akane" -> Allies.Akane.allyDmg--;
                        case "Jake" -> Allies.Jake.allyDmg--;
                        case "Sora" -> Allies.Sora.allyDmg--;
                    }
                }
            }
            if (playerDmg >= 1)
            {
                System.out.println(ANSI_CYAN + Player.allySelect + " used " + skills.stringInput + " and did " + playerDmg + " damage!" + ANSI_RESET);
                for (int i = 0; i < playerDmg; i++)
                {
                    Enemy.enemyHealth--;
                }
                timeDelay();
                if (Enemy.enemyHealth >= 0)
                {
                    System.out.println(Enemy.enemyName + " has " + Enemy.enemyHealth + " HP remaining.");
                    if (!enemyIsStunned)
                    {
                        switch (Player.allySelect)
                        {
                            case "Ray" -> allyTakesDamage("Ray", Allies.Ray.allyHp);
                            case "Akane" -> allyTakesDamage("Akane", Allies.Akane.allyHp);
                            case "Jake" -> allyTakesDamage("Jake", Allies.Jake.allyHp);
                            case "Sora" -> allyTakesDamage("Sora", Allies.Sora.allyHp);
                        }
                    }
                    if (enemyIsStunned)
                    {
                        enemyTakesDamageByAlly();
                    }
                }
                if (Enemy.enemyHealth <= 0)
                {
                    System.out.println("YOU WIN.");
                }
            }
            else
            {
                System.out.println(Player.allySelect + " missed their attack!");
                switch (Player.allySelect)
                {
                    case "Ray" -> allyTakesDamage("Ray", Allies.Ray.allyHp);
                    case "Akane" -> allyTakesDamage("Akane", Allies.Akane.allyHp);
                    case "Jake" -> allyTakesDamage("Jake", Allies.Jake.allyHp);
                    case "Sora" -> allyTakesDamage("Sora", Allies.Sora.allyHp);
                }
            }
        }
        else
            goToAllyMenu();
    }


    public void allyTakesDamage(String allyName, int allyHp) {
        allyIsSelected = true;
        if (allySkipsTurn = true)
        {
            switch (Player.allySelect)
            {
                case "Ray" -> Allies.Ray.allyManaRecovery();
                case "Akane" -> Allies.Akane.allyManaRecovery();
                case "Jake" -> Allies.Jake.allyManaRecovery();
                case "Sora" -> Allies.Sora.allyManaRecovery();
            }
        }
        enemyHitsAlly = true;
        if (Enemy.enemyHasSkill)
        {
            Random enemyUsesWhatSkill = new Random();
            enemySelectsSkill = enemyUsesWhatSkill.nextInt(4 + 1);
            if (enemySelectsSkill == 1)
            {
                if (Enemy.getEnemySkill1() == null)
                {
                    enemyHitsAlly = true;
                }
                else
                if (Enemy.enemyMana >= Enemy.getEnemyMana1())
                {
                    enemyUsedSkill = true;
                    for (int i = 0; i < Enemy.getEnemyDamage1(); i++)
                    {
                        Enemy.enemyTotalDamage++;
                    }
                    for (int i = 0; i < Enemy.getEnemyMana1(); i++)
                    {
                        Enemy.enemyMana--;
                    }
                    enemyUsesSkill1();
                }
                else
                    playerHitsTarget = true;
            }
            else if (enemySelectsSkill == 2)
            {
                if (Enemy.getEnemySkill2() == null)
                {
                    enemyHitsAlly = true;
                }
                else
                if (Enemy.enemyMana >= Enemy.getEnemyMana2())
                {
                    enemyUsedSkill = true;
                    for (int i = 0; i < Enemy.getEnemyDamage2(); i++)
                    {
                        Enemy.enemyTotalDamage++;
                    }
                    for (int i = 0; i < Enemy.getEnemyMana2(); i++)
                    {
                        Enemy.enemyMana--;
                    }
                    enemyUsesSkill2();
                }
            }
            else if (enemySelectsSkill == 3)
            {
                if (Enemy.getEnemySkill3() == null)
                {
                    enemyHitsAlly = true;
                }
                else
                if (Enemy.enemyMana >= Enemy.getEnemyMana3())
                {
                    enemyUsedSkill = true;
                    for (int i = 0; i < Enemy.getEnemyDamage3(); i++)
                    {
                        Enemy.enemyTotalDamage++;
                    }
                    for (int i = 0; i < Enemy.getEnemyMana3(); i++)
                    {
                        Enemy.enemyMana--;
                    }
                    enemyUsesSkill3();
                }
            }
            else if (enemySelectsSkill == 4)
            {
                if (Enemy.getEnemySkill4() == null)
                {
                    enemyHitsAlly = true;
                }
                else
                if (Enemy.enemyMana >= Enemy.getEnemyMana4())
                {
                    enemyUsedSkill = true;
                    for (int i = 0; i < Enemy.getEnemyDamage4(); i++)
                    {
                        Enemy.enemyTotalDamage++;
                    }
                    for (int i = 0; i < Enemy.getEnemyMana4(); i++)
                    {
                        Enemy.enemyMana--;
                    }
                    enemyUsesSkill4();
                }
            }
        }
            switch (Player.allySelect)
            {
                case "Ray" -> allyHp = Allies.Ray.allyHp;
                case "Akane" -> allyHp = Allies.Akane.allyHp;
                case "Jake" -> allyHp = Allies.Jake.allyHp;
                case "Sora" -> allyHp = Allies.Sora.allyHp;
            }
            switch (Player.allySelect)
            {
                case "Ray" -> allyName = Allies.Ray.getAllyName();
                case "Akane" -> allyName = Allies.Akane.getAllyName();
                case "Jake" -> allyName = Allies.Jake.getAllyName();
                case "Sora" -> allyName = Allies.Sora.getAllyName();
            }
            int enemyTotalDmg = Enemy.enemyTotalDamage;
            Random damageRandomizer = new Random();
            int enemyDmg = damageRandomizer.nextInt(enemyTotalDmg + 1);
            Logic.timeDelay();
            if (enemyDmg >= 1)
            {
                System.out.println(ANSI_RED + Enemy.enemyName + " has dealt " + enemyDmg + " damage." + ANSI_RESET);
                for (int i = 0; i < enemyDmg; i++)
                {
                    allyHp--;
                }
                switch (Player.allySelect)
                {
                    case "Ray" ->  Allies.Ray.allyHp = allyHp;
                    case "Akane" -> Allies.Akane.allyHp = allyHp;
                    case "Jake" -> Allies.Jake.allyHp = allyHp;
                    case "Sora" -> Allies.Sora.allyHp = allyHp;
                }
                Logic.timeDelay();
                if (allyHp <= 0)
                {
                    System.out.println(allyName + " has passed out!");
                    Logic.timeDelay();
                    allyFaints();
                }
                else
                    System.out.println(allyName + " has " + allyHp + " HP remaining.");
                    timeDelay();
                    if (!allyIsStunned)
                    {
                        goToAllyMenu();
                    }

            }
            if (enemyDmg <= 0)
            {
                System.out.println(Enemy.enemyName + " misses!");
                if (!allyIsStunned)
                {
                    goToAllyMenu();
                }
            }

        }

    public void allyTakesDamageUsingSkill(String allyName, int allyHp)
    {
        switch (Player.allySelect)
        {
            case "Ray" -> allyName = Allies.Ray.getAllyName();
            case "Akane" -> allyName = Allies.Akane.getAllyName();
            case "Jake" -> allyName = Allies.Jake.getAllyName();
            case "Sora" -> allyName = Allies.Sora.getAllyName();
        }
        int enemyTotalDmg = Enemy.enemyTotalDamage;
        Random damageRandomizer = new Random();
        int enemyDmg = damageRandomizer.nextInt(enemyTotalDmg + 1);
        Enemy.enemyTotalDamage = Logic.getDefaultDmg();
        //timeDelay(2000);
        if (enemyDmg >= 1)
        {
            System.out.println(ANSI_RED + Enemy.enemyName + " has dealt " + enemyDmg + " damage." + ANSI_RESET);
            for (int i = 0; i < enemyDmg; i++)
            {
                allyHp--;
            }
            switch (Player.allySelect)
            {
                case "Ray" ->  Allies.Ray.allyHp = allyHp;
                case "Akane" -> Allies.Akane.allyHp = allyHp;
                case "Jake" -> Allies.Jake.allyHp = allyHp;
                case "Sora" -> Allies.Sora.allyHp = allyHp;
            }
            //Logic.timeDelay(3000);
            if (allyHp <= 0)
            {
                System.out.println(allyName + " has passed out!");
                Logic.timeDelay();
                allyFaints();
            }
            else
                System.out.println(allyName + " has " + allyHp + " HP remaining.");
                timeDelay();
                if (!allyIsStunned)
                {
                    goToAllyMenu();
                }

            }
        if (enemyDmg <= 0)
        {
            System.out.println(Enemy.enemyName + " misses!");
            if (!allyIsStunned)
            {
                goToAllyMenu();
            }
        }

    }

    public void goToAllyMenu()
    {
        switch (Player.allySelect)
        {
            case "Ray" -> Allies.Ray.allyMenu();
            case "Akane" -> Allies.Akane.allyMenu();
            case "Jake" -> Allies.Jake.allyMenu();
            case "Sora" -> Allies.Sora.allyMenu();
        }
    }

    public void allyFaints() {
        allies.partyHp();
        int allyHp = 0;
        if (Player.allySelect == null) {
            Player.allySelect = Player.PlayerAllies.get(0).getAllyName();
        }
        switch (Player.allySelect) {
            case "Ray" -> allyHp = Allies.Ray.allyHp;
            case "Akane" -> allyHp = Allies.Akane.allyHp;
            case "Jake" -> allyHp = Allies.Jake.allyHp;
            case "Sora" -> allyHp = Allies.Sora.allyHp;
        }

        for (int i = 0; i < Player.PlayerAllies.toArray().length; i++)
        {
            if (Player.PlayerAllies.size() == 1)
            {
                if (Player.PlayerAllies.get(0).allyHp <= 0 && Player.playerHealth <= 0)
                {
                    System.out.println("GAME OVER.");
                    System.exit(1);
                }
            }
            else if (Player.PlayerAllies.size() == 2)
            {
                if (Player.PlayerAllies.get(0).allyHp <= 0 && Player.PlayerAllies.get(1).allyHp <= 0 && Player.playerHealth <= 0)
                {
                    System.out.println("GAME OVER.");
                    System.exit(1);
                }
            }
            else if (Player.PlayerAllies.size() == 3)
            {
                if (Player.PlayerAllies.get(0).allyHp <= 0 && Player.PlayerAllies.get(1).allyHp <= 0 && Player.PlayerAllies.get(2).allyHp <= 0 && Player.playerHealth <= 0)
                {
                    System.out.println("GAME OVER.");
                    System.exit(1);
                }
            }
            else if (Player.PlayerAllies.size() == 4)
            {
                if (Player.PlayerAllies.get(0).allyHp <= 0 && Player.PlayerAllies.get(1).allyHp <= 0 && Player.PlayerAllies.get(2).allyHp <= 0 && Player.PlayerAllies.get(3).allyHp <= 0 && Player.playerHealth <= 0)
                {
                    System.out.println("GAME OVER.");
                    System.exit(1);
                }
            }
            while (true) {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("PARTY");
                System.out.println("-----");
                System.out.println(Player.urName);
                if (Player.PlayerAllies.size() == 1)
                {
                    System.out.println(Player.PlayerAllies.get(0).getAllyName());
                }
                else if (Player.PlayerAllies.size() == 2)
                {
                    System.out.println(Player.PlayerAllies.get(0).getAllyName());
                    System.out.println(Player.PlayerAllies.get(1).getAllyName());
                }
                else if (Player.PlayerAllies.size() == 3)
                {
                    System.out.println(Player.PlayerAllies.get(0).getAllyName());
                    System.out.println(Player.PlayerAllies.get(1).getAllyName());
                    System.out.println(Player.PlayerAllies.get(2).getAllyName());
                }
                else if (Player.PlayerAllies.size() == 4)
                {
                    System.out.println(Player.PlayerAllies.get(0).getAllyName());
                    System.out.println(Player.PlayerAllies.get(1).getAllyName());
                    System.out.println(Player.PlayerAllies.get(2).getAllyName());
                    System.out.println(Player.PlayerAllies.get(3).getAllyName());
                }
                Scanner input = new Scanner(System.in);
                Player.allySelect = input.nextLine();
                if (Player.PlayerAllies.size() == 1)
                {
                    if (Player.PlayerAllies.get(0).getAllyName().equals(Player.allySelect) || Player.allySelect.equals(Player.urName))
                    {
                        nextAllySelection();
                        break;
                    }
                    else
                        System.out.println("Could not find the character you were looking for, please try again.");

                }
                else if (Player.PlayerAllies.size() == 2)
                {
                    if (Player.PlayerAllies.get(0).getAllyName().equals(Player.allySelect) || Player.PlayerAllies.get(1).getAllyName().equals(Player.allySelect) || Player.allySelect.equals(Player.urName))
                    {
                        nextAllySelection();
                        break;
                    }
                    else
                        System.out.println("Could not find the character you were looking for, please try again.");
                }
                else if (Player.PlayerAllies.size() == 3)
                {
                    if (Player.PlayerAllies.get(0).getAllyName().equals(Player.allySelect) || Player.PlayerAllies.get(1).getAllyName().equals(Player.allySelect) || Player.PlayerAllies.get(2).getAllyName().equals(Player.allySelect) || Player.allySelect.equals(Player.urName))
                    {
                        nextAllySelection();
                        break;
                    }
                    else
                        System.out.println("Could not find the character you were looking for, please try again.");
                }
                else if (Player.PlayerAllies.size() == 4)
                {
                    if (Player.PlayerAllies.get(0).getAllyName().equals(Player.allySelect) || Player.PlayerAllies.get(1).getAllyName().equals(Player.allySelect) || Player.PlayerAllies.get(2).getAllyName().equals(Player.allySelect) || Player.PlayerAllies.get(3).getAllyName().equals(Player.allySelect) || Player.allySelect.equals(Player.urName))
                    {
                        nextAllySelection();
                        break;
                    }
                    else
                        System.out.println("Could not find the character you were looking for, please try again.");
                }
            }
        }
    }

    public void nextAllySelection() {

                if (Allies.partyMembersHp.get(Player.allySelect) <= 0)
                {
                    System.out.println(Player.allySelect + " is currently down, please select another ally.");
                    allyFaints();
                }
                else if (Player.allySelect.equals(Player.getUrName()) && Player.playerHealth <= 0)
                {
                    System.out.println(Player.getUrName() + " is currently down, please select another ally.");
                    allyFaints();
                }
                else if (Player.allySelect.equals(Player.getUrName()) && Player.playerHealth >= 1)
                {
                    Player.playerMenuSelect();
                }
                else
                    allyIsSelected = true;
                    switch (Player.allySelect)
                    {
                        case "Ray" -> Allies.Ray.allyMenu();
                        case "Akane" -> Allies.Akane.allyMenu();
                        case "Jake" -> Allies.Jake.allyMenu();
                        case "Sora" -> Allies.Sora.allyMenu();
                    }
    }





    public void levelUpBoost()
    {
        int m = 0;

        if (Player.playerLevel <= 10)
        {
            m = 1;
        }
        else if (Player.playerLevel <= 20)
        {
            m = 2;
        }
        else if (Player.playerLevel <= 30)
        {
            m = 3;
        }
        else if (Player.playerLevel <= 40)
        {
            m = 4;
        }
        else if (Player.playerLevel > 41)
        {
            m = 5;
        }
        switch (Player.cl)
        {
            case "Mage" -> {
                Player.playerTotalHealth += 5 * m;
                Player.playerTotalMana += 7 * m; // TOTAL 16
                Player.playerTotalDamage += 4 * m;
                System.out.println(ANSI_BLUE + "STATS");
                System.out.println("-----");
                System.out.println("LVL: " + Player.playerLevel);
                System.out.println("HP:" + " " + Player.playerTotalHealth);
                System.out.println("MP:" + " " + Player.playerTotalMana);
                System.out.println("DMG:" + " " + Player.playerTotalMana + ANSI_RESET);
            }
            case "Warrior" -> {
                Player.playerTotalHealth += 8 * m;
                Player.playerTotalMana += 3 * m; // TOTAL 16
                Player.playerTotalDamage += 5 * m;
                System.out.println(ANSI_BLUE + "STATS:");
                System.out.println("-----");
                System.out.println("LVL: " + Player.playerLevel);
                System.out.println("HP:" + " " + Player.playerTotalHealth);
                System.out.println("MP:" + " " + Player.playerTotalMana);
                System.out.println("DMG:" + " " + Player.playerTotalMana + ANSI_RESET);
            }
            case "Archer" -> {
                Player.playerTotalHealth += 2 * m;
                Player.playerTotalMana += 5 * m; // TOTAL 16
                Player.playerTotalDamage += 9 * m;
                System.out.println(ANSI_BLUE + "STATS");
                System.out.println("-----");
                System.out.println("LVL: " + Player.playerLevel);
                System.out.println("HP:" + " " + Player.playerTotalHealth);
                System.out.println("MP:" + " " + Player.playerTotalMana);
                System.out.println("DMG:" + " " + Player.playerTotalMana + ANSI_RESET);
            }
        }
    }

    public void enemyUsesSkill1()
    {
        if (Enemy.getEnemyAccuracy1() <= 99)
        {

            Random willThisHit = new Random();
            int enemyAccuracy = willThisHit.nextInt(Enemy.getEnemyAccuracy1() + 70);
            if (enemyAccuracy >= 85)
            {
                enemyUsedSkill = true;
                timeDelay();
                System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill1() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun1() >= 1)
                {
                    for (int i = 1; i < Enemy.getEnemyStun1(); i++)
                    {
                        if (!allyIsSelected)
                        {
                            enemyHitsTarget = true;
                            playerIsStunned = true;
                            enemyHitsPlayerUsingSkill();
                            playerIsStunned = i != Enemy.getEnemyStun1();
                        }
                        if (allyIsSelected)
                        {
                            allyIsStunned = true;
                            allyTakesDamage();
                            if (i == Enemy.getEnemyStun1())
                            {
                                allyIsStunned = false;
                                allyTakesDamage();
                                break;
                            }
                        }
                    }
                }
                else
                    enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy >= 60)
            {
                Random aSecondTry = new Random();
                int enemyAccuracy2 = aSecondTry.nextInt(7 + 1);
                if (enemyAccuracy2 < 3)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill1() + " but missed!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                    timeDelay();
                    System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill1() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun1() >= 1)
                    {
                        System.out.println("You've been stunned for " +  Enemy.getEnemyStun1()  + " turns!");
                        for (int i = 1; i < Enemy.getEnemyStun1(); i++)
                        {
                            if (!allyIsSelected)
                            {
                                enemyHitsTarget = true;
                                playerIsStunned = true;
                                enemyHitsPlayerUsingSkill();
                                playerIsStunned = i != Enemy.getEnemyStun1();
                            }
                            if (allyIsSelected)
                            {
                                allyIsStunned = true;
                                allyTakesDamage();
                                if (i == Enemy.getEnemyStun1())
                                {
                                    allyIsStunned = false;
                                    allyTakesDamage();
                                    break;
                                }
                            }
                        }
                    }
                else
                    enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy >= 50)
            {
                Random aSecondTry = new Random();
                int enemyLowAccuracy = aSecondTry.nextInt(5 + 1);
                if (enemyLowAccuracy < 3)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill1() + " but missed!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                    timeDelay();
                System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill1() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun1() >= 1)
                    {
                        System.out.println("You've been stunned for " +  Enemy.getEnemyStun1()  + " turns!");
                        for (int i = 1; i < Enemy.getEnemyStun1(); i++)
                        {
                            if (!allyIsSelected)
                            {
                                enemyHitsTarget = true;
                                playerIsStunned = true;
                                enemyHitsPlayerUsingSkill();
                                playerIsStunned = i != Enemy.getEnemyStun1();
                            }
                            if (allyIsSelected)
                            {
                                allyIsStunned = true;
                                allyTakesDamage();
                                if (i == Enemy.getEnemyStun1() + 1)
                                    {
                                        allyIsStunned = false;
                                        allyTakesDamage();
                                        break;
                                    }
                            }
                        }
                    }
                    else
                        enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy < 49)
            {
                Random aSecondTry = new Random();
                int enemyVeryLowAccuracy = aSecondTry.nextInt(10 + 1);
                if (enemyVeryLowAccuracy <= 8)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill1() + " but missed by a long shot!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                {
                    enemyHitsTarget = true;
                    timeDelay();
                    System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill1() + "!" + ANSI_RESET);
                    if (Enemy.getEnemyStun1() >= 1)
                    {
                        System.out.println("You've been stunned for " + Enemy.getEnemyStun1() + " turns!");
                        for (int i = 1; i < Enemy.getEnemyStun1(); i++)
                        {
                            if (!allyIsSelected)
                            {
                                playerIsStunned = true;
                                enemyHitsPlayerUsingSkill();
                                playerIsStunned = i != Enemy.getEnemyStun1();
                            }
                            if (allyIsSelected)
                            {
                                allyIsStunned = true;
                                allyTakesDamage();
                                if (i == Enemy.getEnemyStun1() + 1)
                                {
                                    allyIsStunned = false;
                                    allyTakesDamage();
                                    break;
                                }
                            }
                        }
                    }
                    else
                        enemyHitsPlayerUsingSkill();
                }
            }
        }
        else
        {
            enemyUsedSkill = true;
            enemyHitsTarget = true;
            timeDelay();
            System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill1() + "!" + ANSI_RESET);
            if (Enemy.getEnemyStun1() >= 1)
            {
                System.out.println("You've been stunned for " + Enemy.getEnemyStun1() + " turns!");
                for (int i = 1; i < Enemy.getEnemyStun1(); i++)
                {
                    if (!allyIsSelected)
                    {
                        playerIsStunned = true;
                        enemyHitsPlayerUsingSkill();
                        playerIsStunned = i != Enemy.getEnemyStun1();
                    }
                    if (allyIsSelected)
                    {
                        allyIsStunned = true;
                        allyTakesDamage();
                        allyIsStunned = i != Enemy.getEnemyStun1();
                    }
                }
            }
            else if (Enemy.getEnemyStun1() <= 0)
            {
                enemyHitsPlayerUsingSkill();
            }
        }
    }

    public void enemyUsesSkill2()
    {
        if (Enemy.getEnemyAccuracy2() <= 99)
        {

            Random willThisHit = new Random();
            int enemyAccuracy = willThisHit.nextInt(Enemy.getEnemyAccuracy2() + 70);
            if (enemyAccuracy >= 85)
            {
                enemyHitsTarget = true;
                enemyUsedSkill = true;
                timeDelay();
                System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill2() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun2() >= 1)
                {
                    System.out.println("You've been stunned for " +  Enemy.getEnemyStun2()  + " turns!");
                    for (int i = 1; i < Enemy.getEnemyStun2(); i++)
                    {
                        if (!allyIsSelected)
                        {
                            playerIsStunned = true;
                            enemyHitsPlayerUsingSkill();
                            playerIsStunned = i != Enemy.getEnemyStun2();
                        }
                        if (allyIsSelected)
                        {
                            allyIsStunned = true;
                            allyTakesDamage();
                            if (i == Enemy.getEnemyStun2())
                            {
                                allyIsStunned = false;
                                allyTakesDamage();
                                break;
                            }
                        }
                    }
                }
                else
                    enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy >= 60)
            {
                Random aSecondTry = new Random();
                int enemyAccuracy2 = aSecondTry.nextInt(7 + 1);
                if (enemyAccuracy2 < 3)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill2() + " but missed!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                    enemyHitsTarget = true;
                timeDelay();
                System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill2() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun2() >= 1)
                {
                    System.out.println("You've been stunned for " +  Enemy.getEnemyStun2()  + " turns!");
                    for (int i = 1; i < Enemy.getEnemyStun2(); i++)
                    {
                        if (!allyIsSelected)
                        {
                            playerIsStunned = true;
                            enemyHitsPlayerUsingSkill();
                            playerIsStunned = i != Enemy.getEnemyStun2();
                        }
                        if (allyIsSelected)
                        {
                            allyIsStunned = true;
                            allyTakesDamage();
                            if (i == Enemy.getEnemyStun2())
                            {
                                allyIsStunned = false;
                                allyTakesDamage();
                                break;
                            }
                        }
                    }
                }
                else
                    enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy >= 50)
            {
                Random aSecondTry = new Random();
                int enemyLowAccuracy = aSecondTry.nextInt(5 + 1);
                if (enemyLowAccuracy < 3)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill2() + " but missed!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                    enemyHitsTarget = true;
                    timeDelay();
                    System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill2() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun2() >= 1)
                    {
                        System.out.println("You've been stunned for " +  Enemy.getEnemyStun2()  + " turns!");
                        for (int i = 1; i < Enemy.getEnemyStun2(); i++)
                        {
                            if (!allyIsSelected)
                            {
                                playerIsStunned = true;
                                enemyHitsPlayerUsingSkill();
                                playerIsStunned = i != Enemy.getEnemyStun2();
                            }
                            if (allyIsSelected)
                            {
                                allyIsStunned = true;
                                allyTakesDamage();
                                if (i == Enemy.getEnemyStun1())
                                {
                                    allyIsStunned = false;
                                    allyTakesDamage();
                                    break;
                                }
                            }
                        }
                    }
                    else
                        enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy < 49)
            {
                Random aSecondTry = new Random();
                int enemyVeryLowAccuracy = aSecondTry.nextInt(10 + 1);
                if (enemyVeryLowAccuracy <= 8)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill2() + " but missed by a long shot!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                {
                    enemyHitsTarget = true;
                    timeDelay();
                    System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill2() + "!" + ANSI_RESET);
                    if (Enemy.getEnemyStun2() >= 1)
                    {
                        System.out.println("You've been stunned for " + Enemy.getEnemyStun2() + " turns!");
                        for (int i = 1; i < Enemy.getEnemyStun2(); i++)
                        {
                            if (!allyIsSelected)
                            {
                                playerIsStunned = true;
                                enemyHitsPlayerUsingSkill();
                                playerIsStunned = i != Enemy.getEnemyStun2();
                            }
                            if (allyIsSelected)
                            {
                                allyIsStunned = true;
                                allyTakesDamage();
                                if (i == Enemy.getEnemyStun1())
                                {
                                    allyIsStunned = false;
                                    allyTakesDamage();
                                    break;
                                }
                            }
                        }
                    }
                    else
                        enemyHitsPlayerUsingSkill();
                }
            }
        }
        else
        {
            enemyUsedSkill = true;
            enemyHitsTarget = true;
            timeDelay();
            System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill2() + "!" + ANSI_RESET);
            if (Enemy.getEnemyStun2() >= 1)
            {
                System.out.println("You've been stunned for " + Enemy.getEnemyStun2() + " turns!");
                for (int i = 1; i < Enemy.getEnemyStun2(); i++)
                {
                    if (!allyIsSelected)
                    {
                        playerIsStunned = true;
                        enemyHitsPlayerUsingSkill();
                        playerIsStunned = i != Enemy.getEnemyStun2();
                    }
                    if (allyIsSelected)
                    {
                        allyIsStunned = true;
                        allyTakesDamage();
                        if (i == Enemy.getEnemyStun2())
                            {
                                allyIsStunned = false;
                                allyTakesDamage();
                                break;
                            }
                    }
                }
            }
            else if (Enemy.getEnemyStun2() <= 0)
            {
                enemyHitsPlayerUsingSkill();
            }
        }
    }

    public void enemyUsesSkill3()
    {
        if (Enemy.getEnemyAccuracy3() <= 99)
        {

            Random willThisHit = new Random();
            int enemyAccuracy = willThisHit.nextInt(Enemy.getEnemyAccuracy3() + 70);
            if (enemyAccuracy >= 85)
            {
                enemyHitsTarget = true;
                enemyUsedSkill = true;
                timeDelay();
                System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill3() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun3() >= 1)
                {
                    System.out.println("You've been stunned for " +  Enemy.getEnemyStun3()  + " turns!");
                    for (int i = 1; i < Enemy.getEnemyStun3(); i++)
                    {
                        if (!allyIsSelected)
                        {
                            playerIsStunned = true;
                            enemyHitsPlayerUsingSkill();
                            playerIsStunned = i != Enemy.getEnemyStun3();
                        }
                        if (allyIsSelected)
                        {
                            allyIsStunned = true;
                            allyTakesDamage();
                            if (i == Enemy.getEnemyStun3())
                            {
                                allyIsStunned = false;
                                allyTakesDamage();
                                break;
                            }
                        }
                    }
                }
                else
                    enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy >= 60)
            {
                Random aSecondTry = new Random();
                int enemyAccuracy2 = aSecondTry.nextInt(7 + 1);
                if (enemyAccuracy2 < 3)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill3() + " but missed!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                    enemyHitsTarget = true;
                timeDelay();
                System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill3() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun3() >= 1)
                {
                    System.out.println("You've been stunned for " +  Enemy.getEnemyStun3()  + " turns!");
                    for (int i = 1; i < Enemy.getEnemyStun3(); i++)
                    {
                        if (!allyIsSelected)
                        {
                            playerIsStunned = true;
                            enemyHitsPlayerUsingSkill();
                            playerIsStunned = i != Enemy.getEnemyStun3();
                        }
                        if (allyIsSelected)
                        {
                            allyIsStunned = true;
                            allyTakesDamage();
                            if (i == Enemy.getEnemyStun3())
                            {
                                allyIsStunned = false;
                                allyTakesDamage();
                                break;
                            }
                        }
                    }
                }
                else
                    enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy >= 50)
            {
                Random aSecondTry = new Random();
                int enemyLowAccuracy = aSecondTry.nextInt(5 + 1);
                if (enemyLowAccuracy < 3)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill3() + " but missed!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                    enemyHitsTarget = true;
                timeDelay();
                System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill3() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun3() >= 1)
                {
                    System.out.println("You've been stunned for " +  Enemy.getEnemyStun3()  + " turns!");
                    for (int i = 1; i < Enemy.getEnemyStun3(); i++)
                    {
                        if (!allyIsSelected)
                        {
                            playerIsStunned = true;
                            enemyHitsPlayerUsingSkill();
                            playerIsStunned = i != Enemy.getEnemyStun3();
                        }
                        if (allyIsSelected)
                        {
                            allyIsStunned = true;
                            allyTakesDamage();
                            if (i == Enemy.getEnemyStun3())
                            {
                                allyIsStunned = false;
                                allyTakesDamage();
                                break;
                            }
                        }
                    }
                }
                else
                    enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy < 49)
            {
                Random aSecondTry = new Random();
                int enemyVeryLowAccuracy = aSecondTry.nextInt(10 + 1);
                if (enemyVeryLowAccuracy <= 8)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill3() + " but missed by a long shot!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                {
                    enemyHitsTarget = true;
                    timeDelay();
                    System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill3() + "!" + ANSI_RESET);
                    if (Enemy.getEnemyStun3() >= 1)
                    {
                        System.out.println("You've been stunned for " + Enemy.getEnemyStun3() + " turns!");
                        for (int i = 1; i < Enemy.getEnemyStun3(); i++)
                        {
                            if (!allyIsSelected)
                            {
                                playerIsStunned = true;
                                enemyHitsPlayerUsingSkill();
                                playerIsStunned = i != Enemy.getEnemyStun3();
                            }
                            if (allyIsSelected)
                            {
                                allyIsStunned = true;
                                allyTakesDamage();
                                if (i == Enemy.getEnemyStun3())
                                {
                                    allyIsStunned = false;
                                    allyTakesDamage();
                                    break;
                                }
                            }
                        }
                    }
                    else
                        enemyHitsPlayerUsingSkill();
                }
            }
        }
        else
        {
            enemyUsedSkill = true;
            enemyHitsTarget = true;
            timeDelay();
            System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill3() + "!" + ANSI_RESET);
            if (Enemy.getEnemyStun3() >= 1)
            {
                System.out.println("You've been stunned for " + Enemy.getEnemyStun3() + " turns!");
                for (int i = 1; i < Enemy.getEnemyStun3(); i++)
                {
                    if (!allyIsSelected)
                    {
                        playerIsStunned = true;
                        enemyHitsPlayerUsingSkill();
                        playerIsStunned = i != Enemy.getEnemyStun3();
                    }
                    if (allyIsSelected)
                    {
                        if (i < Enemy.getEnemyStun3())
                        {
                            allyIsStunned = true;
                            allyTakesDamage();
                        }
                    }
                        if (i == Enemy.getEnemyStun3())
                        {
                            allyIsStunned = false;
                            allyTakesDamage();
                            break;
                        }
                    }
                }
            }
                if (Enemy.getEnemyStun3() <= 0)
                {
                    enemyHitsPlayerUsingSkill();
                }
    }


    public void enemyUsesSkill4()
    {
        if (Enemy.getEnemyAccuracy4() <= 99)
        {

            Random willThisHit = new Random();
            int enemyAccuracy = willThisHit.nextInt(Enemy.getEnemyAccuracy4() + 70);
            if (enemyAccuracy >= 85)
            {
                enemyHitsTarget = true;
                enemyUsedSkill = true;
                timeDelay();
                System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill4() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun4() >= 1)
                {
                    System.out.println("You've been stunned for " +  Enemy.getEnemyStun4()  + " turns!");
                    for (int i = 1; i < Enemy.getEnemyStun4(); i++)
                    {
                        if (!allyIsSelected)
                        {
                            playerIsStunned = true;
                            enemyHitsPlayerUsingSkill();
                            playerIsStunned = i != Enemy.getEnemyStun4();
                        }
                        if (allyIsSelected)
                        {
                            allyIsStunned = true;
                            allyTakesDamage();
                            if (i == Enemy.getEnemyStun4())
                            {
                                allyIsStunned = false;
                                allyTakesDamage();
                                break;
                            }
                        }
                    }
                }
                else
                    enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy >= 60)
            {
                Random aSecondTry = new Random();
                int enemyAccuracy2 = aSecondTry.nextInt(7 + 1);
                if (enemyAccuracy2 < 3)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill4() + " but missed!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                    enemyHitsTarget = true;
                timeDelay();
                System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill4() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun4() >= 1)
                {
                    System.out.println("You've been stunned for " +  Enemy.getEnemyStun4()  + " turns!");
                    for (int i = 1; i == Enemy.getEnemyStun4(); i++)
                    {
                        if (!allyIsSelected)
                        {
                            playerIsStunned = true;
                            enemyHitsPlayerUsingSkill();
                            playerIsStunned = i != Enemy.getEnemyStun4();
                        }
                        if (allyIsSelected)
                        {
                            allyIsStunned = true;
                            allyTakesDamage();
                            if (i == Enemy.getEnemyStun4())
                            {
                                allyIsStunned = false;
                                allyTakesDamage();
                                break;
                            }
                        }
                    }
                }
                else
                    enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy >= 50)
            {
                Random aSecondTry = new Random();
                int enemyLowAccuracy = aSecondTry.nextInt(5 + 1);
                if (enemyLowAccuracy < 3)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill4() + " but missed!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                    enemyHitsTarget = true;
                timeDelay();
                System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill4() + "!" + ANSI_RESET);
                if (Enemy.getEnemyStun4() >= 1)
                {
                    System.out.println("You've been stunned for " +  Enemy.getEnemyStun4()  + " turns!");
                    for (int i = 1; i < Enemy.getEnemyStun4(); i++)
                    {
                        if (!allyIsSelected)
                        {
                            playerIsStunned = true;
                            enemyHitsPlayerUsingSkill();
                            playerIsStunned = i != Enemy.getEnemyStun4();
                        }
                        if (allyIsSelected)
                        {
                            allyIsStunned = true;
                            allyTakesDamage();
                            if (i == Enemy.getEnemyStun4())
                            {
                                allyIsStunned = false;
                                allyTakesDamage();
                                break;
                            }
                        }
                    }
                }
                else
                    enemyHitsPlayerUsingSkill();
            }
            else if (enemyAccuracy < 49)
            {
                Random aSecondTry = new Random();
                int enemyVeryLowAccuracy = aSecondTry.nextInt(10 + 1);
                if (enemyVeryLowAccuracy <= 8)
                {
                    enemyHitsTarget = false;
                    Logic.timeDelay();
                    System.out.println(Enemy.enemyName + " used " + Enemy.getEnemySkill4() + " but missed by a long shot!");
                    Logic.timeDelay();
                    Player.playerMenuSelect();
                }
                else
                {
                    enemyHitsTarget = true;
                    timeDelay();
                    System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill4() + "!" + ANSI_RESET);
                    if (Enemy.getEnemyStun4() >= 1)
                    {
                        System.out.println("You've been stunned for " + Enemy.getEnemyStun4() + " turns!");
                        for (int i = 1; i < Enemy.getEnemyStun4(); i++)
                        {
                            if (!allyIsSelected)
                            {
                                playerIsStunned = true;
                                enemyHitsPlayerUsingSkill();
                                playerIsStunned = i != Enemy.getEnemyStun4();
                            }
                            if (allyIsSelected)
                            {
                                allyIsStunned = true;
                                    switch (Player.allySelect)
                                    {
                                        case "Ray" -> Logic.allyTakesDamageUsingSkill("Ray", Allies.Ray.allyHp);
                                        case "Akane" -> Logic.allyTakesDamageUsingSkill("Akane", Allies.Akane.allyHp);
                                        case "Jake" -> Logic.allyTakesDamageUsingSkill("Jake", Allies.Jake.allyHp);
                                        case "Sora" -> Logic.allyTakesDamageUsingSkill("Sora", Allies.Sora.allyHp);
                                    }
                                if (i == Enemy.getEnemyStun4())
                                {
                                    allyIsStunned = false;
                                    goToAllyMenu();
                                    break;
                                }
                            }
                        }
                    }
                    else
                        enemyHitsPlayerUsingSkill();
                }
            }
        }
        else
        {
            enemyUsedSkill = true;
            enemyHitsTarget = true;
            timeDelay();
            System.out.println(ANSI_RED + Enemy.enemyName + " used " + Enemy.getEnemySkill4() + "!" + ANSI_RESET);
            if (Enemy.getEnemyStun4() >= 1)
            {
                System.out.println("You've been stunned for " + Enemy.getEnemyStun4() + " turns!");
                for (int i = 1; i < Enemy.getEnemyStun4(); i++)
                {
                    if (!allyIsSelected)
                    {
                        playerIsStunned = true;
                        enemyHitsPlayerUsingSkill();
                        playerIsStunned = i != Enemy.getEnemyStun4();
                    }
                    if (allyIsSelected)
                    {
                        allyIsStunned = true;
                            switch (Player.allySelect)
                            {
                                case "Ray" -> Logic.allyTakesDamageUsingSkill("Ray", Allies.Ray.allyHp);
                                case "Akane" -> Logic.allyTakesDamageUsingSkill("Akane", Allies.Akane.allyHp);
                                case "Jake" -> Logic.allyTakesDamageUsingSkill("Jake", Allies.Jake.allyHp);
                                case "Sora" -> Logic.allyTakesDamageUsingSkill("Sora", Allies.Sora.allyHp);
                            }
                        if (i == Enemy.getEnemyStun4())
                        {
                            allyIsStunned = false;
                            switch (Player.allySelect)
                            {
                                case "Ray" -> Allies.Ray.allyMenu();
                                case "Akane" -> Allies.Akane.allyMenu();
                                case "Jake" -> Allies.Jake.allyMenu();
                                case "Sora" -> Allies.Sora.allyMenu();
                            }
                            break;
                        }
                    }


                }
            }
            else if (Enemy.getEnemyStun4() <= 0)
            {
                enemyHitsPlayerUsingSkill();
            }
        }
    }



    public void awardFixedXp(int xpEarned)
    {
        if (!allyIsSelected)
        {
            System.out.println(" ");
            System.out.println(ANSI_GREEN + "You gained " + xpEarned + " XP!" + ANSI_RESET);
            System.out.println(" ");
            Player.experience += xpEarned;
            if (Player.experience >= 100)
            {
                levelUp();
            }
        }
        else
        {
            int allyExp = 0;
            switch (Player.allySelect)
            {
                case "Ray" -> allyExp = Allies.Ray.allyExp;
                case "Akane" -> allyExp = Allies.Akane.allyExp;
                case "Jake" -> allyExp = Allies.Jake.allyExp;
                case "Sora" -> allyExp = Allies.Sora.allyExp;
            }
            allyExp += xpEarned;
            switch (Player.allySelect)
            {
                case "Ray" -> Allies.Ray.allyExp = allyExp;
                case "Akane" -> Allies.Akane.allyExp = allyExp;
                case "Jake" -> Allies.Jake.allyExp = allyExp;
                case "Sora" -> Allies.Sora.allyExp = allyExp;
            }
            System.out.println(" ");
            System.out.println(ANSI_GREEN + Player.allySelect + " gained " + xpEarned + " XP!" + ANSI_RESET);
            System.out.println(" ");
            if (allyExp >= 100)
            {
                allies.allyLevelUp();
            }

        }
        Logic.timeDelay();
    }

    public  void awardXp()
    {
        Random xpPlayerGains = new Random();
        int xpGained = xpPlayerGains.nextInt(100 + 1);
        if (!allyIsSelected)
        {
            Player.experience += xpGained;
            System.out.println(" ");
            System.out.println("You gained " + xpGained + " XP.");
            System.out.println(" ");
            if (Player.experience >= 100)
            {
                levelUp();
            }
        }
        else
        {
            int allyExp = 0;
            switch (Player.allySelect)
            {
                case "Ray" -> allyExp = Allies.Ray.allyExp;
                case "Akane" -> allyExp = Allies.Akane.allyExp;
                case "Jake" -> allyExp = Allies.Jake.allyExp;
                case "Sora" -> allyExp = Allies.Sora.allyExp;
            }
            allyExp += xpGained;
            switch (Player.allySelect)
            {
                case "Ray" -> Allies.Ray.allyExp = allyExp;
                case "Akane" -> Allies.Akane.allyExp = allyExp;
                case "Jake" -> Allies.Jake.allyExp = allyExp;
                case "Sora" -> Allies.Sora.allyExp = allyExp;
            }
            System.out.println(" ");
            System.out.println(Player.allySelect + " gained " + xpGained + " XP!");
            System.out.println(" ");
            if (allyExp >= 100)
            {
                allies.allyLevelUp();
            }

        }
        Logic.timeDelay();

    }

    public void whoTakesDamage()
    {
        if (!Logic.allyIsSelected)
        {
            Logic.playerTakesDamage();
        }
        else
        {
            Logic.allyTakesDamage();
        }
    }

    public void timeDelay()
    {
        long t = this.x;
        try
        {
            Thread.sleep(t);
        }
        catch (InterruptedException e)
        {

        }
    }

    public void allyTakesDamage()
    {
        switch (Player.allySelect)
        {
            case "Ray" -> Logic.allyTakesDamageUsingSkill("Ray", Allies.Ray.allyHp);
            case "Akane" -> Logic.allyTakesDamageUsingSkill("Akane", Allies.Akane.allyHp);
            case "Jake" -> Logic.allyTakesDamageUsingSkill("Jake", Allies.Jake.allyHp);
            case "Sora" -> Logic.allyTakesDamageUsingSkill("Sora", Allies.Sora.allyHp);
        }
    }


    public boolean isAllyHitsEnemy() {
        return allyHitsEnemy;
    }

    public void setAllyHitsEnemy(boolean allyHitsEnemy) {
        this.allyHitsEnemy = allyHitsEnemy;
    }

    public int getDefaultDmg() {
        return defaultDmg;
    }

    public void setDefaultDmg(int defaultDmg) {
        this.defaultDmg = (int) (defaultDmg * Logic.d);
    }
}
