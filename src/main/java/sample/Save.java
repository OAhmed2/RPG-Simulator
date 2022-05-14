package sample;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Save extends Main {
     static String file_location = "???";
     static Gson gson = new Gson();
     private final double difficulty = Logic.d;
     private final int textSpeed = Logic.x;
    private final boolean chapter2_1 = Logic.save2_1;
    private final boolean chapter2_2 = Logic.save2_2;
    private final boolean chapter2_3 = Logic.save2_3;
    private final boolean chapter3_1 = Logic.save3_1;
    private final String playerName = Player.getUrName();
    private final int playerAge = Player.urAge;
    private final String playerClass = Player.getCl();
    private final int playerLevel = Player.playerLevel;
    private final int playerDamage = Player.playerTotalDamage;
    private final int playerHealth = Player.playerHealth;
    private final int playerTotalHealth = Player.playerTotalHealth;
    private final int playerMana = Player.playerMana;
    private final int playerTotalMana = Player.playerTotalMana;
    private final List<Allies> playerAllies = Player.PlayerAllies;
    private final List<String>playerSkills = skills.PlayerSkills;
    private final List<String>playerTotalSkills = skills.PlayerTotalSkills;
    private final List<Integer>playerSkillsMp = skills.SkillMana;
    private final Map<String, String>playerEquipment = equips.PlayerEquipmentHashMap;
    private final double playerExperience = Player.experience;
    private final int playerCurrency = Player.playerCurrency;
    private final String rayName = Allies.Ray.getAllyName();
    private final String rayClass = Allies.Ray.getAllyClass();
    private final int rayLevel = Allies.Ray.getAllyLevel();
    private final int rayHp = Allies.Ray.allyHp;
    private final int rayTotalHp = Allies.Ray.allyTotalHp;
    private final int rayMp = Allies.Ray.allyMp;
    private final int rayTotalMp = Allies.Ray.allyTotalMp;
    private final int rayDmg = Allies.Ray.allyDmg;
    private final int rayExperience = Allies.Ray.allyExp;
    private final Map<String, String>rayEquipment = Equips.Ray.allyHasEquipment;
    private final List<String>raySkills = Allies.Ray.AllySkills;
    private final List<Integer>raySkillsMp = Allies.Ray.AllySkillsMp;
    private final String akaneName = Allies.Akane.getAllyName();
    private final String akaneClass = Allies.Akane.getAllyClass();
    private final int akaneLevel = Allies.Akane.getAllyLevel();
    private final int akaneHp = Allies.Akane.allyHp;
    private final int akaneTotalHp = Allies.Akane.allyTotalHp;
    private final int akaneMp = Allies.Akane.allyMp;
    private final int akaneTotalMp = Allies.Akane.allyTotalMp;
    private final int akaneDmg = Allies.Akane.allyDmg;
    private final int akaneExperience = Allies.Akane.allyExp;
    private final Map<String, String>akaneEquipment = Equips.Akane.allyHasEquipment;
    private final List<String>akaneSkills = Allies.Akane.AllySkills;
    private final List<Integer>akaneSkillsMp = Allies.Akane.AllySkillsMp;
    private final String jakeName = Allies.Jake.getAllyName();
    private final String jakeClass = Allies.Jake.getAllyClass();
    private final int jakeLevel = Allies.Jake.getAllyLevel();
    private final int jakeHp = Allies.Jake.allyHp;
    private final int jakeTotalHp = Allies.Jake.allyTotalHp;
    private final int jakeMp = Allies.Jake.allyMp;
    private final int jakeTotalMp = Allies.Jake.allyTotalMp;
    private final int jakeDmg = Allies.Jake.allyDmg;
    private final int jakeExperience = Allies.Jake.allyExp;
    private final Map<String, String>jakeEquipment = Equips.Jake.allyHasEquipment;
    private final List<String>jakeSkills = Allies.Jake.AllySkills;
    private final List<Integer>jakeSkillsMp = Allies.Jake.AllySkillsMp;
    private final String soraName = Allies.Sora.getAllyName();
    private final String soraClass = Allies.Sora.getAllyClass();
    private final int soraLevel = Allies.Sora.getAllyLevel();
    private final int soraHp = Allies.Sora.allyHp;
    private final int soraTotalHp = Allies.Sora.allyTotalHp;
    private final int soraMp = Allies.Sora.allyMp;
    private final int soraTotalMp = Allies.Sora.allyTotalMp;
    private final int soraDmg = Allies.Sora.allyDmg;
    private final int soraExperience = Allies.Sora.allyExp;
    private final Map<String, String>soraEquipment = Equips.Sora.allyHasEquipment;
    private final List<String>soraSkills = Allies.Sora.AllySkills;
    private final List<Integer>soraSkillsMp = Allies.Sora.AllySkillsMp;

    public void WriteToFile(String myData) {
        File file = new File(Save.file_location);
        if (!file.exists()) {
            try {
                File directory = new File(file.getParent());
                if (!directory.exists())
                {
                    directory.mkdirs();
                }
                file.createNewFile();
            } catch (IOException e) {
                log("Exception Occurred: " + e);
            }
        }

        try {
            // Convenience class for writing character files
            FileWriter fileWriter;
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);

            // Writes text to a character-output stream
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(myData);
            bufferWriter.close();

            log("Player Data data saved at file location: " + Save.file_location + " Data: " + myData + "\n");
        } catch (IOException e) {
            log("Hmm.. Got an error while saving Player data to file " + e);
        }
    }

    // Read From File Utility
    public void ReadFromFile() {
        File file = new File(Save.file_location);
        if (!file.exists())
            log("File doesn't exist");


        InputStreamReader isReader;
        try {
            isReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);

            JsonReader myReader = new JsonReader(isReader);
            Save save= Save.gson.fromJson(myReader, Save.class);
            Logic.d = save.difficulty;
            Logic.x = save.textSpeed;
            Logic.save2_1 = save.chapter2_1;
            Logic.save2_2 = save.chapter2_2;
            Logic.save2_3 = save.chapter2_3;
            Logic.save3_1 = save.chapter3_1;
            Player.setUrName(save.playerName);
            Player.setCl(save.playerClass);
            Player.setPlayerTotalDamage(save.playerDamage);
            Player.playerTotalHealth = save.playerTotalHealth;
            Player.playerHealth = save.playerHealth;
            Player.playerTotalMana = save.playerTotalMana;
            Player.playerMana = save.playerMana;
            Player.playerLevel = save.playerLevel;
            Player.playerCurrency = save.playerCurrency;
            Player.experience = save.playerExperience;
            equips.PlayerEquipmentHashMap = save.playerEquipment;
            skills.PlayerSkills = save.playerSkills;
            skills.PlayerTotalSkills = save.playerTotalSkills;
            skills.SkillMana = save.playerSkillsMp;
            Allies.Ray.setAllyName(save.rayName);
            Allies.Ray.setAllyClass(save.rayClass);
            Allies.Ray.setAllyLevel(save.rayLevel);
            Allies.Ray.allyDmg = save.rayDmg;
            Allies.Ray.allyTotalHp = save.rayTotalHp;
            Allies.Ray.allyHp = save.rayHp;
            Allies.Ray.allyTotalMp = save.rayTotalMp;
            Allies.Ray.allyMp = save.rayMp;
            Allies.Ray.allyExp = save.rayExperience;
            Equips.Ray.allyHasEquipment = save.rayEquipment;
            Allies.Ray.AllySkills = save.raySkills;
            Allies.Ray.AllySkillsMp = save.raySkillsMp;
            Allies.Akane.setAllyName(save.akaneName);
            Allies.Akane.setAllyClass(save.akaneClass);
            Allies.Akane.setAllyLevel(save.akaneLevel);
            Allies.Akane.allyDmg = save.akaneDmg;
            Allies.Akane.allyTotalHp = save.akaneTotalHp;
            Allies.Akane.allyHp = save.akaneHp;
            Allies.Akane.allyTotalMp = save.akaneTotalMp;
            Allies.Akane.allyMp = save.akaneMp;
            Allies.Akane.allyExp = save.akaneExperience;
            Equips.Akane.allyHasEquipment = save.akaneEquipment;
            Allies.Akane.AllySkills = save.akaneSkills;
            Allies.Akane.AllySkillsMp = save.akaneSkillsMp;
            Allies.Jake.setAllyName(jakeName);
            Allies.Jake.setAllyClass(jakeClass);
            Allies.Jake.setAllyLevel(jakeLevel);
            Allies.Jake.allyDmg = save.jakeDmg;
            Allies.Jake.allyTotalHp = save.jakeTotalHp;
            Allies.Jake.allyHp = save.jakeHp;
            Allies.Jake.allyTotalMp = save.jakeTotalMp;
            Allies.Jake.allyMp = save.jakeMp;
            Allies.Jake.allyExp = save.jakeExperience;
            Equips.Jake.allyHasEquipment = save.jakeEquipment;
            Allies.Jake.AllySkills = save.jakeSkills;
            Allies.Jake.AllySkillsMp = save.jakeSkillsMp;
            Allies.Sora.setAllyName(save.soraName);
            Allies.Sora.setAllyClass(save.soraClass);
            Allies.Sora.setAllyLevel(save.soraLevel);
            Allies.Sora.allyDmg = save.soraDmg;
            Allies.Sora.allyTotalHp = save.soraTotalHp;
            Allies.Sora.allyHp = save.soraHp;
            Allies.Sora.allyTotalMp = save.soraTotalMp;
            Allies.Sora.allyMp = save.soraMp;
            Allies.Sora.allyExp = save.soraExperience;
            Equips.Sora.allyHasEquipment = save.soraEquipment;
            Allies.Sora.AllySkills = save.soraSkills;
            Allies.Sora.AllySkillsMp = save.soraSkillsMp;
            if (!(save.playerName == null))
            {
                Player.theHub();
            }

            log("Player Name: " + save.getPlayerName());
            log("Player Age: " + save.getPlayerAge());
            log("Player Class: " + save.getPlayerClass());

        } catch (Exception e) {
            log("error load cache from file " + e);
        }

        log("\nPlayer Data loaded successfully from file " + Save.file_location);

    }

    void startUpMenu() throws InterruptedException, IOException, ParseException {
        items.weaponDatabase();
        items.armourDatabase();
        items.itemList();
        skills.skillInsert();
        while (true) {
            System.out.println("1) NEW GAME");
            System.out.println("2) LOAD GAME");
            Scanner input = new Scanner(System.in);
            String loadInput = input.nextLine();
            if (loadInput.equals("1")) {
                System.out.println("Are you sure you would like to start a new game?");
                System.out.println("1) YES");
                System.out.println("2) NO");
                Scanner input2 = new Scanner(System.in);
                String sureAboutThis = input2.nextLine();
                if (sureAboutThis.equals("1")) {
                    Save data = new Save();
                    data.delete(Save.file_location, 1, 1);
                    ChapterOne.Ch1.introDialogue();
                    break;
                }
                else if (sureAboutThis.equals("2"))
                {
                    System.out.println(" ");
                }
                else
                {
                    System.out.println(" ");
                }
            }
            else if (loadInput.equals("2"))
            {

                Save data = new Save();
                data.ReadFromFile();
                break;
            }
        }
    }


    void delete(String filename, int startline, int numlines)
    {
        try
        {
            BufferedReader br=new BufferedReader(new FileReader(filename));

            //String buffer to store contents of the file
            StringBuffer sb=new StringBuffer();

            //Keep track of the line number
            int linenumber=1;
            String line;

            while((line=br.readLine())!=null)
            {
                //Store each valid line in the string buffer
                if(linenumber<startline||linenumber>=startline+numlines)
                    sb.append(line+"\n");
                linenumber++;
            }
            if(startline+numlines>linenumber)
                System.out.println("End of file reached.");
            br.close();

            FileWriter fw=new FileWriter(new File(filename));
            //Write entire string buffer into the file
            fw.write(sb.toString());
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println("Something went horribly wrong: "+e.getMessage());
        }
    }

    private static void log(String string) {
        System.out.println(string);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }


    public String getPlayerClass() {
        return playerClass;
    }

}