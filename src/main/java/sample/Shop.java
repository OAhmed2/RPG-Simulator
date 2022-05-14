package sample;

import java.util.Scanner;


public class Shop extends Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    String buyWithThisPerson;
    boolean buyingForPlayer;
    boolean buyingForAlly;
    boolean allyFound;
    static Shop shop = new Shop();
    public int x = 1;

    public void openShopMenu() {
        items.itemList();
        while (true) {
            System.out.println(" ");
            System.out.println("SHOP");
            System.out.println("----");
            System.out.println("What would you like to purchase?");
            System.out.println(" ");
            if (Player.playerLevel <= 5) {
                System.out.println("Potion");
                System.out.println("Elixir");
                Scanner inputPurchase = new Scanner(System.in);
                String stringPurchase = inputPurchase.nextLine();
                switch (stringPurchase) {
                    case "Potion" -> {
                        if (Player.playerCurrency >= 100) {
                            for (int i = 0; i < 100; i++) {
                                Player.playerCurrency--;
                            }
                            System.out.println("You have purchased a potion.");
                            items.PlayerInventory.add(Items.Potion.itemName);
                        } else {
                            System.out.println("Sorry, you cannot purchase this.");
                            continue;
                        }
                    }
                    case "Elixir" -> {
                        if (Player.playerCurrency >= 100) {
                            for (int i = 0; i < 100; i++) {
                                Player.playerCurrency--;
                            }
                            System.out.println("You have purchased an Elixir.");
                            items.PlayerInventory.add(Items.Elixir.itemName);
                        } else
                            System.out.println("Sorry, you cannot purchase this.");
                        continue;
                    }

                }
            }
            System.out.println("Your balance is now: " + "$" + Player.playerCurrency);
            break;
        }
    }

    public void openBlackSmith() {
        Allies.partyClass.putIfAbsent(Allies.Ray.getAllyName(), Allies.Ray.getAllyClass());
        Allies.partyClass.putIfAbsent(Allies.Akane.getAllyName(), Allies.Akane.getAllyClass());
        Allies.partyClass.putIfAbsent(Allies.Jake.getAllyName(), Allies.Jake.getAllyClass());
        Allies.partyClass.putIfAbsent(Allies.Sora.getAllyName(), Allies.Sora.getAllyClass());
        
        Allies.partyLevel.putIfAbsent(Allies.Ray.getAllyName(), Allies.Ray.getAllyLevel());
        Allies.partyLevel.putIfAbsent(Allies.Akane.getAllyName(), Allies.Akane.getAllyLevel());
        Allies.partyLevel.putIfAbsent(Allies.Jake.getAllyName(), Allies.Jake.getAllyLevel());
        Allies.partyLevel.putIfAbsent(Allies.Sora.getAllyName(), Allies.Sora.getAllyLevel());
        items.armourDatabase();
        items.weaponDatabase();
        if (Player.PlayerAllies.size() < 1)
        {
            buyingForPlayer = true;
        }
        else
        {
            System.out.println("Select a party member you would like to purchase an item with:");
            System.out.println(Player.urName);
            for (Allies party : Player.PlayerAllies)
            {
                System.out.println(party.getAllyName());
            }
            Scanner input = new Scanner(System.in);
            buyWithThisPerson = input.nextLine();
            goToShop();
        }
        System.out.println(" ");
        System.out.println("BLACKSMITH");
        System.out.println("----------");
        System.out.println("Select a weapon/armor piece you would like to purchase:");
        System.out.println(" ");
        if (buyingForPlayer) {
            if (Player.playerLevel <= 5) {
                switch (Player.getCl()) {
                    case "Mage" -> {
                        System.out.println(Equips.OrdinaryStaff.weaponName + " (" + Equips.OrdinaryStaff.weaponDamage + "): " + Equips.OrdinaryStaff.weaponDescription + " -" + ANSI_YELLOW + Equips.OrdinaryStaff.weaponPrice + " GOLD" + ANSI_RESET);
                        System.out.println(Equips.Spellbook.weaponName + " (" + Equips.Spellbook.weaponDamage + "): " + Equips.Spellbook.weaponDescription + " -" + ANSI_YELLOW + Equips.Spellbook.weaponPrice + " GOLD" + ANSI_RESET);
                    }
                    case "Warrior" -> {
                        System.out.println(Equips.BrassKnuckles.weaponName + " (" + Equips.BrassKnuckles.weaponDamage + "): " + Equips.BrassKnuckles.weaponDescription + " -" + ANSI_YELLOW + Equips.BrassKnuckles.weaponPrice + " GOLD" + ANSI_RESET);
                        System.out.println(Equips.DoubleFury.weaponName + " (" + Equips.DoubleFury.weaponDamage + "): " + Equips.DoubleFury.weaponDescription + " -" + ANSI_YELLOW + Equips.DoubleFury.weaponPrice + " GOLD" + ANSI_RESET);
                    }
                    case "Archer" -> {
                        System.out.println(Equips.Bow.weaponName + " (" + Equips.Bow.weaponDamage + "): " + Equips.Bow.weaponDescription + " -" + ANSI_YELLOW + Equips.Bow.weaponPrice + " GOLD" + ANSI_RESET);
                        System.out.println(Equips.SuperShooter.weaponName + " (" + Equips.SuperShooter.weaponDamage + "): " + Equips.SuperShooter.weaponDescription + " -" + ANSI_YELLOW + Equips.SuperShooter.weaponPrice + " GOLD" + ANSI_RESET);
                    }
                }
                System.out.println(Equips.MossStoneArmour.armourName + " (" + Equips.MossStoneArmour.armourDamage + "): " + Equips.MossStoneArmour.armourDescription + " -" + ANSI_YELLOW + Equips.MossStoneArmour.armourPrice + " GOLD" + ANSI_RESET);
            }
            Scanner input = new Scanner(System.in);
            String purchase = input.nextLine();
            if (equips.PriceMap.containsKey(purchase)) {
                if (Player.playerCurrency >= equips.PriceMap.get(purchase) && Player.playerLevel >= equips.LevelMap.get(purchase)) {
                    if (equips.PlayerEquipmentHashMap.size() <= 10)
                    {
                        equips.PlayerEquipmentHashMap.putIfAbsent(purchase, purchase);
                        System.out.println(purchase + " has been successfully purchased!");
                    }
                    else
                    {
                        System.out.println(Player.getUrName() + "'s inventory is full.");
                    }
                } else if (Player.playerCurrency < equips.PriceMap.get(purchase)) {
                    System.out.println("You don't have enough gold to afford " + purchase + ".");
                } else if (Player.playerLevel < equips.LevelMap.get(purchase)) {
                    System.out.println("Your current level is " + Player.playerLevel + "." + " You need to be level " + equips.LevelMap.get(purchase) + " in order to purchase this item.");
                } else if (Player.playerCurrency < equips.PriceMap.get(purchase) && Player.playerLevel < equips.LevelMap.get(purchase)) {
                    System.out.println("git gud");
                }
            } else
                System.out.println("Item not found. Please try again,");

        }
            if (allyFound) {
                if (Allies.partyLevel.get(buyWithThisPerson) <= 5) {
                    switch (Allies.partyClass.get(buyWithThisPerson)) {
                        case "Mage" -> {
                            System.out.println(Equips.OrdinaryStaff.weaponName + " (" + Equips.OrdinaryStaff.weaponDamage + "): " + Equips.OrdinaryStaff.weaponDescription + " -" + ANSI_YELLOW + Equips.OrdinaryStaff.weaponPrice + " GOLD" + ANSI_RESET);
                            System.out.println(Equips.Spellbook.weaponName + " (" + Equips.Spellbook.weaponDamage + "): " + Equips.Spellbook.weaponDescription + " -" + ANSI_YELLOW + Equips.Spellbook.weaponPrice + " GOLD" + ANSI_RESET);
                        }
                        case "Warrior" -> {
                            System.out.println(Equips.BrassKnuckles.weaponName + " (" + Equips.BrassKnuckles.weaponDamage + "): " + Equips.BrassKnuckles.weaponDescription + " -" + ANSI_YELLOW + Equips.BrassKnuckles.weaponPrice + " GOLD" + ANSI_RESET);
                            System.out.println(Equips.DoubleFury.weaponName + " (" + Equips.DoubleFury.weaponDamage + "): " + Equips.DoubleFury.weaponDescription + " -" + ANSI_YELLOW + Equips.DoubleFury.weaponPrice + " GOLD" + ANSI_RESET);
                        }
                        case "Archer" -> {
                            System.out.println(Equips.Bow.weaponName + " (" + Equips.Bow.weaponDamage + "): " + Equips.Bow.weaponDescription + " -" + ANSI_YELLOW + Equips.Bow.weaponPrice + " GOLD" + ANSI_RESET);
                            System.out.println(Equips.SuperShooter.weaponName + " (" + Equips.SuperShooter.weaponDamage + "): " + Equips.SuperShooter.weaponDescription + " -" + ANSI_YELLOW + Equips.SuperShooter.weaponPrice + " GOLD" + ANSI_RESET);
                        }
                    }
                    System.out.println(Equips.MossStoneArmour.armourName + " (" + Equips.MossStoneArmour.armourDamage + "): " + Equips.MossStoneArmour.armourDescription + " -" + ANSI_YELLOW + Equips.MossStoneArmour.armourPrice + " GOLD" + ANSI_RESET);
                }
                Scanner input = new Scanner(System.in);
                String purchaseWithAlly = input.nextLine();
                if (equips.PriceMap.containsKey(purchaseWithAlly)) {
                    if (Player.playerCurrency >= equips.PriceMap.get(purchaseWithAlly) && Allies.partyLevel.get(buyWithThisPerson) >= equips.LevelMap.get(purchaseWithAlly)) {
                        switch (buyWithThisPerson) {
                            case "Ray" -> {
                                if (Equips.Ray.allyHasEquipment.size() <= 10) {
                                    Equips.Ray.allyHasEquipment.putIfAbsent(purchaseWithAlly, purchaseWithAlly);
                                    System.out.println(purchaseWithAlly + " has been successfully purchased and has been added into " + Allies.Ray.getAllyName() + "'s inventory.");

                                } else {
                                    System.out.println("Ray's inventory is full.");
                                }
                            }
                            case "Akane" -> {
                                if (Equips.Akane.allyHasEquipment.size() <= 10) {
                                    Equips.Akane.allyHasEquipment.putIfAbsent(purchaseWithAlly, purchaseWithAlly);
                                    System.out.println(purchaseWithAlly + " has been successfully purchased and has been added into " + Allies.Akane.getAllyName() + "'s inventory.");

                                } else {
                                    System.out.println("Akane's inventory is full.");
                                }
                            }
                            case "Jake" -> {
                                if (Equips.Jake.allyHasEquipment.size() <= 10) {
                                    Equips.Jake.allyHasEquipment.putIfAbsent(purchaseWithAlly, purchaseWithAlly);
                                    System.out.println(purchaseWithAlly + " has been successfully purchased and has been added into " + Allies.Jake.getAllyName() + "'s inventory.");
                                } else {
                                    System.out.println("Jake's inventory is full.");
                                }
                            }
                            case "Sora" -> {
                                if (Equips.Sora.allyHasEquipment.size() <= 10) {
                                    Equips.Ray.allyHasEquipment.putIfAbsent(purchaseWithAlly, purchaseWithAlly);
                                    System.out.println(purchaseWithAlly + " has been successfully purchased and has been added into " + Allies.Ray.getAllyName() + "'s inventory.");

                                } else {
                                    System.out.println("Ray's inventory is full.");
                                }
                            }
                        }
                    } else if (Player.playerCurrency < equips.PriceMap.get(purchaseWithAlly)) {
                        System.out.println("You don't have enough gold to afford " + purchaseWithAlly + ".");
                    } else if (Allies.partyLevel.get(buyWithThisPerson) < equips.LevelMap.get(purchaseWithAlly)) {
                        System.out.println(buyWithThisPerson + "'s current level is " + Allies.partyLevel.get(buyWithThisPerson) + ". You need to be level " + equips.LevelMap.get(purchaseWithAlly) + " in order to purchase this.");
                    }
                }
                else
                {
                    System.out.println("Item not found. Please try again.");
                }
            }
        }


    public void goToShop() {
        if (buyWithThisPerson.equals(Player.urName))
        {
            buyingForPlayer = true;
            buyingForAlly = false;
        }
        else {
            if (Player.PlayerAllies.size() == 1)
            {
                if (buyWithThisPerson.equals(Player.PlayerAllies.get(0).getAllyName()))
                {
                    buyingForAlly = true;
                    allyFound = true;
                }
            }
            if (Player.PlayerAllies.size() == 2) {
                if (buyWithThisPerson.equals(Player.PlayerAllies.get(0).getAllyName()) || buyWithThisPerson.equals(Player.PlayerAllies.get(1).getAllyName())) {
                    buyingForAlly = true;
                    allyFound = true;
                }
            } else if (Player.PlayerAllies.size() == 3) {
                if (buyWithThisPerson.equals(Player.PlayerAllies.get(0).getAllyName()) || buyWithThisPerson.equals(Player.PlayerAllies.get(1).getAllyName()) || buyWithThisPerson.equals(Player.PlayerAllies.get(2).getAllyName())) {
                    buyingForAlly = true;
                    allyFound = true;
                }
            } else if (Player.PlayerAllies.size() == 4) {
                if (buyWithThisPerson.equals(Player.PlayerAllies.get(0).getAllyName()) || buyWithThisPerson.equals(Player.PlayerAllies.get(1).getAllyName()) || buyWithThisPerson.equals(Player.PlayerAllies.get(2).getAllyName()) || buyWithThisPerson.equals(Player.PlayerAllies.get(3).getAllyName())) {
                    buyingForAlly = true;
                    allyFound = true;
                }
            } else if (Player.PlayerAllies.size() == 5) {
                if (buyWithThisPerson.equals(Player.PlayerAllies.get(0).getAllyName()) || buyWithThisPerson.equals(Player.PlayerAllies.get(1).getAllyName()) || buyWithThisPerson.equals(Player.PlayerAllies.get(2).getAllyName()) || buyWithThisPerson.equals(Player.PlayerAllies.get(3).getAllyName()) || buyWithThisPerson.equals(Player.PlayerAllies.get(4).getAllyName())) {
                    buyingForAlly = true;
                    allyFound = true;
                }

            }
        }
    }
}
