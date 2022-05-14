package sample;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static PlayerInfo Player = new PlayerInfo();
    static ChapterOne Ch1 = new ChapterOne();
    static Items items = new Items();
    static Equips equips = new Equips();
    static Shop shop = new Shop();
    static GameLogic Logic = new GameLogic();
    static EnemyInfo Enemy = new EnemyInfo();
    static Skills skills = new Skills();
    static JsonParser parser = new JsonParser();
    static Allies allies = new Allies();
    static ChapterTwo Ch2 = new ChapterTwo();
    static Save SaveData = new Save();
    static ChapterThree Ch3 = new ChapterThree();
    private int input;

    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
        SaveData.startUpMenu();
        /*items.weaponDatabase();
        skills.skillInsert();
        Player.setUrName("Ro");
        Player.setCl("Archer");
        Player.setPlayerTotalDamage(10);
        Player.playerTotalHealth = 80;
        Player.playerLevel = 1;
        Player.playerHealth = 80;
        Player.playerTotalMana = 10;
        Player.playerMana = 10;
        parser.playerGetsSkill();
        equips.PlayerEquipmentHashMap.put(Equips.Slingshot.weaponName, Equips.Slingshot.weaponName);
        Logic.setDefaultDmg(15);
        Enemy.whatEnemyAmIFacing("Ray", 80, 80, 5, 5, 1, 15, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, false);

        Player.playerMenuSelect();*/
        //System.out.println("argh");
    }

    public void print(String text){
        System.out.println(" ");
        Logic.timeDelay();
        System.out.println(text);
    }

    public void you(String text){
        System.out.println(" ");
        Logic.timeDelay();
        System.out.println(Player.getUrName() + ": " + text);
    }

    public void userInput(){
        try {
            int input = new Scanner(System.in).nextInt();
            this.setInput(input);
        }
        catch (InputMismatchException e){
            print("Input a number!");
        }
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }
}
