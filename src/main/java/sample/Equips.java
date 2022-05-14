package sample;

import java.util.*;

public class Equips extends Main {
    public static Equips PEL = new Equips();
    public static Equips Ray = new Equips();
    public static Equips Akane = new Equips();
    public static Equips Jake = new Equips();
    public static Equips Sora = new Equips();

    public static Equips Wand = new Equips();
    public static Equips Dagger = new Equips();
    public static Equips Slingshot = new Equips();
    public static Equips OrdinaryStaff = new Equips();
    public static Equips Spellbook = new Equips();
    public static Equips BrassKnuckles = new Equips();
    public static Equips DoubleFury = new Equips();
    public static Equips Bow = new Equips();
    public static Equips SuperShooter = new Equips();
    public static Equips SteelSword = new Equips();
    public static Equips MossStoneArmour = new Equips();
    public List<Equips> PlayerEquipment = new ArrayList<Equips>();
    Map<String, String> PlayerEquipmentHashMap = new HashMap<String, String>();
    Map<String, String> WeaponNameMap = new HashMap<>();
    Map<String, Integer> WeaponDamageMap = new HashMap<>();
    Map<String, Integer> PriceMap = new HashMap<>();
    Map<String, Integer> LevelMap = new HashMap<>();
    Map<String, String> allyHasEquipment = new HashMap<String, String>();
    public boolean playerIsSelected;
    public boolean allyIsSelected;
    public boolean itemFound;
    public String partyMember;
    public String tradeItem;
    public String weaponName;
    public String weaponDescription;
    public int weaponPrice;
    public int weaponLevel;
    public int weaponDamage;
    public String weaponNameInput;
    public String armourName;
    public int armourDamage;
    public int armourHp;
    public int armourLevel;
    public String armourDescription;
    public int armourMana;
    public int armourBp;
    public int armourPrice;

    public void shareEquipment()
    {
        allies.retrieveAllyInfo();
        System.out.println("Select the first party member you will be transferring equipment from:");
        System.out.println(Player.urName);
        for (Allies party: Player.PlayerAllies)
        {
            System.out.println(party.getAllyName());
        }
        Scanner nextInput = new Scanner(System.in);
        partyMember = nextInput.nextLine();
        if (partyMember.equals(Player.urName))
        {
            playerIsSelected = true;
            allyIsSelected = false;
            tradeItem();
        }
        else
        {
            if (Player.PlayerAllies.size() == 1)
            {
                if (Player.PlayerAllies.get(0).getAllyName().contains(partyMember))
                {
                    goToTradeItem();
                }
            }
            else if (Player.PlayerAllies.size() == 2)
            {
                if (Player.PlayerAllies.get(0).getAllyName().contains(partyMember) || Player.PlayerAllies.get(1).getAllyName().contains(partyMember))
                {
                    goToTradeItem();
                }
            }
            else if (Player.PlayerAllies.size() == 3)
            {
                if (Player.PlayerAllies.get(0).getAllyName().contains(partyMember) || Player.PlayerAllies.get(1).getAllyName().contains(partyMember) || Player.PlayerAllies.get(2).getAllyName().contains(partyMember))
                {
                    goToTradeItem();
                }
            }
            else if (Player.PlayerAllies.size() == 4)
            {
                if (Player.PlayerAllies.get(0).getAllyName().contains(partyMember) || Player.PlayerAllies.get(1).getAllyName().contains(partyMember) || Player.PlayerAllies.get(2).getAllyName().contains(partyMember) || Player.PlayerAllies.get(3).getAllyName().contains(partyMember))
                {
                    goToTradeItem();
                }
            }
            else if (Player.PlayerAllies.size() == 5)
            {
                if (Player.PlayerAllies.get(0).getAllyName().contains(partyMember) || Player.PlayerAllies.get(1).getAllyName().contains(partyMember) || Player.PlayerAllies.get(2).getAllyName().contains(partyMember) || Player.PlayerAllies.get(3).getAllyName().contains(partyMember) || Player.PlayerAllies.get(4).getAllyName().contains(partyMember))
                {
                    goToTradeItem();
                }

            }
        }



     }

     public void goToTradeItem()
     {
         playerIsSelected = false;
         allyIsSelected = true;
         tradeItem();
     }


    public void tradeItem()
    {
        equips.PlayerEquipmentHashMap.put("Sam", "Sam");
        boolean charFound = false;
        boolean successfulTrade = false;
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Trade with whom?");
        System.out.println(Player.urName);
        for (Allies party : Player.PlayerAllies)
        {
            System.out.println(party.getAllyName());
        }
        Scanner input = new Scanner(System.in);
        String tradeWith = input.nextLine();
        for (Allies party : Player.PlayerAllies)
        {
            if (party.getAllyName().contains(tradeWith))
            {
                charFound = true;
                break;
            }
        }
        if (tradeWith.equals(Player.urName))
        {
            charFound = true;
        }

        if (charFound)
        {
            System.out.println(" ");
            System.out.println("Select a piece of equipment you would like to transfer:");

                if (equips.PlayerEquipmentHashMap.size() <= 10 && playerIsSelected)
                {
                    successfulTrade = true;
                    printMap(equips.PlayerEquipmentHashMap);
                }
                else if (equips.PlayerEquipmentHashMap.size() > 10)
                {
                    System.out.println(Player.urName + "'s inventory is full, remove an item so you can transfer equipment.");
                }
                if (allyIsSelected = true)
                {
                    switch (partyMember)
                    {
                        case "Sora":
                            if (Sora.allyHasEquipment.size() <= 10)
                            {
                                successfulTrade = true;
                                printMap(Sora.allyHasEquipment);
                            }
                            else
                                System.out.println(Allies.Sora.getAllyName() + "'s inventory is full, remove an item so you can transfer equipment.");
                        case "Ray":
                            if (Ray.allyHasEquipment.size() <= 10)
                            {
                                successfulTrade = true;
                                printMap(Ray.allyHasEquipment);
                            }
                            else
                                System.out.println(Allies.Ray.getAllyName() + "'s inventory is full, remove an item so you can transfer equipment.");
                        case "Akane":
                            if (Akane.allyHasEquipment.size() <= 10)
                            {
                                successfulTrade = true;
                                printMap(Akane.allyHasEquipment);
                            }
                            else
                                System.out.println(Allies.Akane.getAllyName() + "'s inventory is full, remove an item so you can transfer equipment.");
                        case "Jake":
                            if (Jake.allyHasEquipment.size() <= 10)
                            {
                                successfulTrade = true;
                                printMap(Jake.allyHasEquipment);
                            }
                            else
                                System.out.println(Allies.Jake.getAllyName() + "'s inventory is full, remove an item so you can transfer equipment.");
                    }
                }
            Scanner tradeInput = new Scanner(System.in);
            String trade = tradeInput.nextLine();
            if (successfulTrade)
            {
                if (playerIsSelected && equips.PlayerEquipmentHashMap.containsKey(trade))
                {
                    equips.PlayerEquipmentHashMap.remove(trade);
                    itemFound = true;
                }
                if (allyIsSelected = true)
                {

                    switch (partyMember)
                    {
                        case "Ray" -> {
                            if (Ray.allyHasEquipment.containsKey(trade))
                            {
                                itemFound = true;
                            }
                        }

                        case "Akane" -> {
                            if (Akane.allyHasEquipment.containsKey(trade))
                            {
                                itemFound = true;
                            }
                        }

                        case "Jake" -> {
                            if (Jake.allyHasEquipment.containsKey(trade))
                            {
                                itemFound = true;
                            }
                        }

                        case "Sora" -> {
                            if (Sora.allyHasEquipment.containsKey(trade))
                            {
                                itemFound = true;
                            }
                        }
                    }

                    if (itemFound = true)
                    {

                        switch (partyMember)
                        {
                            case "Ray" -> Ray.allyHasEquipment.remove(trade);
                            case "Akane" -> Akane.allyHasEquipment.remove(trade);
                            case "Jake" -> Jake.allyHasEquipment.remove(trade);
                            case "Sora" -> Sora.allyHasEquipment.remove(trade);
                        }
                        switch (tradeWith)
                        {
                            case "Sora":
                                if (Sora.allyHasEquipment.size() <= 10)
                                {
                                    Sora.allyHasEquipment.putIfAbsent(trade, trade);
                                }
                            case "Ray":
                                if (Ray.allyHasEquipment.size() <= 10)
                                {
                                    Ray.allyHasEquipment.putIfAbsent(trade, trade);
                                }
                            case "Akane":
                                if (Akane.allyHasEquipment.size() <= 10)
                                {
                                    Akane.allyHasEquipment.putIfAbsent(trade, trade);
                                }
                            case "Jake":
                                if (Jake.allyHasEquipment.size() <= 10)
                                {
                                    Jake.allyHasEquipment.putIfAbsent(trade, trade);
                                }
                        }

                        if (tradeWith.equals(Player.getUrName()) && equips.PlayerEquipmentHashMap.size() <= 10)
                        {
                            equips.PlayerEquipmentHashMap.putIfAbsent(trade, trade);
                        }
                    }
                }
            }
            else
            {
                System.out.println(partyMember + "'s inventory is full, please remove an item and try again.");
            }
        }
    }

    public void printMap(Map mp)
    {
        Iterator it  = mp.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey());
        }
    }



}