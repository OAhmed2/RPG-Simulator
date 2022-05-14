package sample;

import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Items extends Main {
    static Items items = new Items();
    public static Items Potion = new Items();
    public static Items Elixir = new Items();
    public List<Items> ItemDatabase = new ArrayList<Items>();
    public List<String> PlayerInventory = new ArrayList<>();
    public String itemName;



    public void healHP(int potionRecovery)
    {
        if (!Logic.allyIsSelected)
        {
            for (int i = 0; i < potionRecovery; i++)
            {
                Player.playerHealth++;
            }
            if (Player.playerHealth >= Player.playerTotalHealth)
            {
                Player.playerHealth = Player.playerTotalHealth;
            }
        }
        if (Logic.allyIsSelected)
        {
            for (int i = 0; i < potionRecovery; i++)
            {
                switch (Player.allySelect)
                {
                    case "Ray" -> Allies.Ray.allyHp++;
                    case "Akane" -> Allies.Akane.allyHp++;
                    case "Jake" -> Allies.Jake.allyHp++;
                }
            }
        }
    }

    public void manaHeal(int elixirRecovery)
    {
        if (!Logic.allyIsSelected)
        {
            for (int i = 0; i < elixirRecovery; i++)
            {
                Player.playerMana++;
                if (Player.playerMana >= Player.playerTotalMana)
                {
                    Player.playerMana = Player.playerTotalMana;
                    break;
                }
            }
        }
        if (Logic.allyIsSelected)
        {
            for (int i = 0; i < elixirRecovery; i++)
            {
                switch (Player.allySelect)
                {
                    case "Ray" -> Allies.Ray.allyMp++;
                    case "Akane" -> Allies.Akane.allyMp++;
                    case "Jake" -> Allies.Jake.allyMp++;
                }
            }
        }
    }

    public void itemList()
    {
        ItemDatabase.add(Potion);
        ItemDatabase.add(Elixir);
        Potion.itemName = "Potion";
        Elixir.itemName = "Elixir";
    }

    public void weaponDatabase()
    {
        String filepath = "???";
        try
        {
            String contents = new String(Files.readAllBytes(Paths.get(filepath)));
            JSONArray weaponData = new JSONArray(contents);
            Equips.Wand.weaponName = weaponData.getJSONObject(1).getString("Weapon Name");
            Equips.Wand.weaponDamage = weaponData.getJSONObject(1).getInt("DMG");
            equips.WeaponNameMap.put(Equips.Wand.weaponName, Equips.Wand.weaponName);
            equips.WeaponDamageMap.put(Equips.Wand.weaponName, Equips.Wand.weaponDamage);

            Equips.Dagger.weaponName = weaponData.getJSONObject(2).getString("Weapon Name");
            Equips.Dagger.weaponDamage = weaponData.getJSONObject(2).getInt("DMG");
            equips.WeaponNameMap.put(Equips.Dagger.weaponName, Equips.Dagger.weaponName);
            equips.WeaponDamageMap.put(Equips.Dagger.weaponName, Equips.Dagger.weaponDamage);

            Equips.Slingshot.weaponName = weaponData.getJSONObject(3).getString("Weapon Name");
            Equips.Slingshot.weaponDamage = weaponData.getJSONObject(3).getInt("DMG");
            equips.WeaponNameMap.put(Equips.Slingshot.weaponName, Equips.Slingshot.weaponName);
            equips.WeaponDamageMap.put(Equips.Slingshot.weaponName, Equips.Slingshot.weaponDamage);

            Equips.OrdinaryStaff.weaponName = weaponData.getJSONObject(4).getString("Weapon Name");
            Equips.OrdinaryStaff.weaponLevel = weaponData.getJSONObject(4).getInt("Level");
            Equips.OrdinaryStaff.weaponPrice = weaponData.getJSONObject(4).getInt("Price");
            Equips.OrdinaryStaff.weaponDamage = weaponData.getJSONObject(4).getInt("DMG");
            Equips.OrdinaryStaff.weaponDescription = weaponData.getJSONObject(4).getString("Description");
            equips.WeaponNameMap.put(Equips.OrdinaryStaff.weaponName, Equips.OrdinaryStaff.weaponName);
            equips.WeaponDamageMap.put(Equips.OrdinaryStaff.weaponName, Equips.OrdinaryStaff.weaponDamage);
            equips.PriceMap.put(Equips.OrdinaryStaff.weaponName, Equips.OrdinaryStaff.weaponPrice);
            equips.LevelMap.put(Equips.OrdinaryStaff.weaponName, Equips.OrdinaryStaff.weaponLevel);

            Equips.Spellbook.weaponName = weaponData.getJSONObject(5).getString("Weapon Name");
            Equips.Spellbook.weaponLevel = weaponData.getJSONObject(5).getInt("Level");
            Equips.Spellbook.weaponPrice = weaponData.getJSONObject(5).getInt("Price");
            Equips.Spellbook.weaponDamage = weaponData.getJSONObject(5).getInt("DMG");
            Equips.Spellbook.weaponDescription = weaponData.getJSONObject(5).getString("Description");
            equips.WeaponNameMap.put(Equips.Spellbook.weaponName, Equips.Spellbook.weaponName);
            equips.WeaponDamageMap.put(Equips.Spellbook.weaponName, Equips.Spellbook.weaponDamage);
            equips.PriceMap.put(Equips.Spellbook.weaponName, Equips.Spellbook.weaponPrice);
            equips.LevelMap.put(Equips.Spellbook.weaponName, Equips.Spellbook.weaponLevel);

            Equips.BrassKnuckles.weaponName = weaponData.getJSONObject(6).getString("Weapon Name");
            Equips.BrassKnuckles.weaponLevel = weaponData.getJSONObject(6).getInt("Level");
            Equips.BrassKnuckles.weaponPrice = weaponData.getJSONObject(6).getInt("Price");
            Equips.BrassKnuckles.weaponDamage = weaponData.getJSONObject(6).getInt("DMG");
            Equips.BrassKnuckles.weaponDescription = weaponData.getJSONObject(6).getString("Description");
            equips.WeaponNameMap.put(Equips.BrassKnuckles.weaponName, Equips.BrassKnuckles.weaponName);
            equips.WeaponDamageMap.put(Equips.BrassKnuckles.weaponName, Equips.BrassKnuckles.weaponDamage);
            equips.PriceMap.put(Equips.BrassKnuckles.weaponName, Equips.BrassKnuckles.weaponPrice);
            equips.LevelMap.put(Equips.BrassKnuckles.weaponName, Equips.BrassKnuckles.weaponLevel);

            Equips.DoubleFury.weaponName = weaponData.getJSONObject(7).getString("Weapon Name");
            Equips.DoubleFury.weaponLevel = weaponData.getJSONObject(7).getInt("Level");
            Equips.DoubleFury.weaponPrice = weaponData.getJSONObject(7).getInt("Price");
            Equips.DoubleFury.weaponDamage = weaponData.getJSONObject(7).getInt("DMG");
            Equips.DoubleFury.weaponDescription = weaponData.getJSONObject(7).getString("Description");
            equips.WeaponNameMap.put(Equips.DoubleFury.weaponName, Equips.DoubleFury.weaponName);
            equips.WeaponDamageMap.put(Equips.DoubleFury.weaponName, Equips.Dagger.weaponDamage);
            equips.PriceMap.put(Equips.DoubleFury.weaponName, Equips.DoubleFury.weaponPrice);
            equips.LevelMap.put(Equips.DoubleFury.weaponName, Equips.DoubleFury.weaponLevel);

            Equips.Bow.weaponName = weaponData.getJSONObject(8).getString("Weapon Name");
            Equips.Bow.weaponLevel = weaponData.getJSONObject(8).getInt("Level");
            Equips.Bow.weaponPrice = weaponData.getJSONObject(8).getInt("Price");
            Equips.Bow.weaponDamage = weaponData.getJSONObject(8).getInt("DMG");
            Equips.Bow.weaponDescription = weaponData.getJSONObject(8).getString("Description");
            equips.WeaponNameMap.put(Equips.Bow.weaponName, Equips.Bow.weaponName);
            equips.WeaponDamageMap.put(Equips.Bow.weaponName, Equips.Bow.weaponDamage);
            equips.PriceMap.put(Equips.Bow.weaponName, Equips.Bow.weaponPrice);
            equips.LevelMap.put(Equips.Bow.weaponName, Equips.Bow.weaponLevel);

            Equips.SuperShooter.weaponName = weaponData.getJSONObject(9).getString("Weapon Name");
            Equips.SuperShooter.weaponLevel = weaponData.getJSONObject(9).getInt("Level");
            Equips.SuperShooter.weaponPrice = weaponData.getJSONObject(9).getInt("Price");
            Equips.SuperShooter.weaponDamage = weaponData.getJSONObject(9).getInt("DMG");
            Equips.SuperShooter.weaponDescription = weaponData.getJSONObject(9).getString("Description");
            equips.WeaponNameMap.put(Equips.SuperShooter.weaponName, Equips.SuperShooter.weaponName);
            equips.WeaponDamageMap.put(Equips.SuperShooter.weaponName, Equips.SuperShooter.weaponDamage);
            equips.PriceMap.put(Equips.SuperShooter.weaponName, Equips.SuperShooter.weaponPrice);
            equips.LevelMap.put(Equips.SuperShooter.weaponName, Equips.SuperShooter.weaponLevel);

            Equips.SteelSword.weaponName = weaponData.getJSONObject(10).getString("Weapon Name");
            Equips.SteelSword.weaponLevel = weaponData.getJSONObject(10).getInt("Level");
            Equips.SteelSword.weaponPrice = weaponData.getJSONObject(10).getInt("Price");
            Equips.SteelSword.weaponDamage = weaponData.getJSONObject(10).getInt("DMG");
            Equips.SteelSword.weaponDescription = weaponData.getJSONObject(10).getString("Description");
            equips.WeaponNameMap.put(Equips.SteelSword.weaponName, Equips.SteelSword.weaponName);
            equips.WeaponDamageMap.put(Equips.SteelSword.weaponName, Equips.SteelSword.weaponDamage);
            equips.PriceMap.put(Equips.SteelSword.weaponName, Equips.SteelSword.weaponPrice);
            equips.LevelMap.put(Equips.SuperShooter.weaponName, Equips.SuperShooter.weaponLevel);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public void armourDatabase()
    {
        String filepath = "???";
        try
        {
            String contents = new String(Files.readAllBytes(Paths.get(filepath)));
            JSONArray armourData = new JSONArray(contents);
            Equips.MossStoneArmour.armourName = armourData.getJSONObject(1).getString("Armour Name");
            Equips.MossStoneArmour.armourHp = armourData.getJSONObject(1).getInt("HP");
            Equips.MossStoneArmour.armourMana = armourData.getJSONObject(1).getInt("MP");
            Equips.MossStoneArmour.armourDamage = armourData.getJSONObject(1).getInt("Damage");
            Equips.MossStoneArmour.armourDescription = armourData.getJSONObject(1).getString("Description");
            Equips.MossStoneArmour.armourLevel = armourData.getJSONObject(1).getInt("Level");
            Equips.MossStoneArmour.armourPrice = armourData.getJSONObject(1).getInt("Price");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        equips.PriceMap.put(Equips.MossStoneArmour.armourName, Equips.MossStoneArmour.weaponPrice);
        equips.LevelMap.put(Equips.MossStoneArmour.armourName, Equips.MossStoneArmour.armourLevel);
    }




}


