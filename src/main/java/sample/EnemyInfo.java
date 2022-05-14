package sample;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class EnemyInfo extends Main {
    private String enemySkill1;
    private String enemySkill2;
    private String enemySkill3;
    private String enemySkill4;
    private int enemyMana1;
    private int enemyMana2;
    private int enemyMana3;
    private int enemyMana4;
    private int enemyDamage1;
    private int enemyDamage2;
    private int enemyDamage3;
    private int enemyDamage4;
    private int enemyAccuracy1;
    private int enemyAccuracy2;
    private int enemyAccuracy3;
    private int enemyAccuracy4;
    private int enemyStun1;
    private int enemyStun2;
    private int enemyStun3;
    private int enemyStun4;
    public int enemyHealth;
    public boolean enemyHasSkill;
    public int enemyTotalHealth;
    public int enemyMana;
    public int enemyTotalMana;
    public int enemyLevel;
    public int enemyTotalDamage;
    public String enemyName;
    Map<String, Integer> SkillManaEnemy = new HashMap<>();
    Map<String, Integer> SkillDamageEnemy = new HashMap<>();
    Map<String, Integer> SkillAccuracyEnemy = new HashMap<>();
    Map<String, Integer> SkillStunEnemy = new HashMap<>();
    String enemySkillsJson = "[\"EnemySkills\",{\"Skill\":\"Crossfire\",\"Damage\":24,\"Description\":\"N\\/A\",\"Mana\":4,\"Stat Boost\":0,\"Accuracy\":100,\"Stun Effect\":0},{\"Skill\":\"Sword Piercer\",\"Damage\":27,\"Description\":\"N\\/A\",\"Mana\":6,\"Stat Boost\":0,\"Accuracy\":100,\"Stun Effect\":0},{\"Skill\":\"Wind  Cutter\",\"Damage\":30,\"Description\":\"Has a chance to stun the enemy for one turn upon hit.\",\"Mana\":6,\"Stat Boost\":0,\"Accuracy\":75,\"Stun Effect\":1},{\"Skill\":\"Meditation\",\"Damage\":0,\"Description\":\"Raises attack stat by 3 for one turn.\",\"Mana\":4,\"Stat Boost\":2,\"Accuracy\":0,\"Stun Effect\":0}]";
    JSONArray enemySkillData = new JSONArray(enemySkillsJson);




    public void whatEnemyAmIFacing(String enemyName, int enemyTotalHealth, int enemyHealth, int enemyTotalMana, int enemyMana, int enemyLevel, int enemyTotalDamages, String enemySkill1, int Mana1, int Damage1, int Accuracy1, int Stun1, String enemySkill2, int Mana2, int Damage2, int Accuracy2, int Stun2,  String enemySkill3, int Mana3, int Damage3, int Accuracy3, int Stun3, String enemySkill4, int Mana4, int Damage4, int Accuracy4, int Stun4, boolean hasSkill)
    {
        this.enemyName = enemyName;
        this.enemyLevel = (int) (enemyLevel * Logic.d);
        this.enemyTotalHealth = (int) (enemyTotalHealth * Logic.d);
        this.enemyTotalMana = (int) (enemyTotalMana * Logic.d);
        this.enemyHealth = (int) (enemyHealth * Logic.d);
        this.enemyMana = (int) (enemyMana * Logic.d);
        this.enemyTotalDamage = (int) (enemyTotalDamages * Logic.d);
        this.enemySkill1 = enemySkill1;
        this.enemySkill2 = enemySkill2;
        this.enemySkill3 = enemySkill3;
        this.enemySkill4 = enemySkill4;
        this.enemyMana1 = Mana1;
        this.enemyMana2 = Mana2;
        this.enemyMana3 = Mana3;
        this.enemyMana4 = Mana4;
        this.enemyDamage1 = (int) (Damage1 * Logic.d);
        this.enemyDamage2 = (int) (Damage2 * Logic.d);
        this.enemyDamage3 = (int) (Damage3 * Logic.d);
        this.enemyDamage4 = (int) (Damage4 * Logic.d);
        this.enemyAccuracy1 = Accuracy1;
        this.enemyAccuracy2 = Accuracy2;
        this.enemyAccuracy3 = Accuracy3;
        this.enemyAccuracy4 = Accuracy4;
        this.enemyStun1 = Stun1;
        this.enemyStun2 = Stun2;
        this.enemyStun3 = Stun3;
        this.enemyStun4 = Stun4;
        this.enemyHasSkill = hasSkill;
    }

    public String getEnemySkill1() {
        return enemySkill1;
    }

    public void setEnemySkill1(String enemySkill1) {
        this.enemySkill1 = enemySkill1;
    }

    public String getEnemySkill2() {
        return enemySkill2;
    }

    public void setEnemySkill2(String enemySkill2) {
        this.enemySkill2 = enemySkill2;
    }

    public String getEnemySkill3() {
        return enemySkill3;
    }

    public void setEnemySkill3(String enemySkill3) {
        this.enemySkill3 = enemySkill3;
    }

    public String getEnemySkill4() {
        return enemySkill4;
    }

    public void setEnemySkill4(String enemySkill4) {
        this.enemySkill4 = enemySkill4;
    }

    public int getEnemyMana1() {
        return enemyMana1;
    }

    public void setEnemyMana1(int enemyMana1) {
        this.enemyMana1 = enemyMana1;
    }

    public int getEnemyMana2() {
        return enemyMana2;
    }

    public void setEnemyMana2(int enemyMana2) {
        this.enemyMana2 = enemyMana2;
    }

    public int getEnemyMana3() {
        return enemyMana3;
    }

    public void setEnemyMana3(int enemyMana3) {
        this.enemyMana3 = enemyMana3;
    }

    public int getEnemyMana4() {
        return enemyMana4;
    }

    public void setEnemyMana4(int enemyMana4) {
        this.enemyMana4 = enemyMana4;
    }

    public int getEnemyDamage1() {
        return enemyDamage1;
    }

    public void setEnemyDamage1(int enemyDamage1) {
        this.enemyDamage1 = enemyDamage1;
    }

    public int getEnemyDamage2() {
        return enemyDamage2;
    }

    public void setEnemyDamage2(int enemyDamage2) {
        this.enemyDamage2 = enemyDamage2;
    }

    public int getEnemyDamage3() {
        return enemyDamage3;
    }

    public void setEnemyDamage3(int enemyDamage3) {
        this.enemyDamage3 = enemyDamage3;
    }

    public int getEnemyDamage4() {
        return enemyDamage4;
    }

    public void setEnemyDamage4(int enemyDamage4) {
        this.enemyDamage4 = enemyDamage4;
    }

    public int getEnemyAccuracy1() {
        return enemyAccuracy1;
    }

    public void setEnemyAccuracy1(int enemyAccuracy1) {
        this.enemyAccuracy1 = enemyAccuracy1;
    }

    public int getEnemyAccuracy2() {
        return enemyAccuracy2;
    }

    public void setEnemyAccuracy2(int enemyAccuracy2) {
        this.enemyAccuracy2 = enemyAccuracy2;
    }

    public int getEnemyAccuracy3() {
        return enemyAccuracy3;
    }

    public void setEnemyAccuracy3(int enemyAccuracy3) {
        this.enemyAccuracy3 = enemyAccuracy3;
    }

    public int getEnemyAccuracy4() {
        return enemyAccuracy4;
    }

    public void setEnemyAccuracy4(int enemyAccuracy4) {
        this.enemyAccuracy4 = enemyAccuracy4;
    }

    public int getEnemyStun1() {
        return enemyStun1;
    }

    public void setEnemyStun1(int enemyStun1) {
        this.enemyStun1 = enemyStun1;
    }

    public int getEnemyStun2() {
        return enemyStun2;
    }

    public void setEnemyStun2(int enemyStun2) {
        this.enemyStun2 = enemyStun2;
    }

    public int getEnemyStun3() {
        return enemyStun3;
    }

    public void setEnemyStun3(int enemyStun3) {
        this.enemyStun3 = enemyStun3;
    }

    public int getEnemyStun4() {
        return enemyStun4;
    }

    public void setEnemyStun4(int enemyStun4) {
        this.enemyStun4 = enemyStun4;
    }
}
