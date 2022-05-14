package sample;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class ChapterOne extends Main {
    static ChapterOne Ch1 = new ChapterOne();

    public void introDialogue() throws InterruptedException, IOException, ParseException {
        Logic.d = 1;
        items.weaponDatabase();
        items.armourDatabase();
        allies.setAlliesStats();
        skills.skillInsert();
        System.out.println("Please enter your desired text speed.");
        System.out.println("-------------------------------------");
        System.out.println("1) Very Slow");
        System.out.println("2) Slow");
        System.out.println("3) Normal");
        System.out.println("4) Fast");
        System.out.println("5) Very Fast");
        System.out.println(" ");
        Scanner textSpeedScanner = new Scanner(System.in);
        String textSpeed = textSpeedScanner.nextLine();
        switch (textSpeed)
        {
            case "1" -> Logic.x = 5000;
            case "2" -> Logic.x = 4000;
            case "3" -> Logic.x = 3000;
            case "4" -> Logic.x = 2000;
            case "5" -> Logic.x = 1000;
        }
        System.out.println(" ");
        System.out.println("Hello, welcome to the world of RPG.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Are you a male or female?");
        System.out.println("Male");
        System.out.println("Female");
        System.out.println("Other");
        Scanner genderInput = new Scanner(System.in);
        Player.pronoun = genderInput.nextLine();
        switch (Player.pronoun)
        {
            case "Male" -> Player.pronoun = "he";
            case "Female" -> Player.pronoun = "she";
            case "Other" ->{
                System.out.println(" ");
                System.out.println("What is your pronoun? (E.g. He/Her)");
                Scanner otherInput = new Scanner(System.in);
                Player.pronoun = otherInput.nextLine();
            }
        }
        switch (Player.pronoun)
        {
            case "Male" -> Player.himHer = "him";
            case "Female" -> Player.himHer = "her";
            case "Other" -> Player.himHer = Player.pronoun;
        }
        System.out.println(" ");
        System.out.println("May I ask you what your name is?");
        Scanner name = new Scanner(System.in);
        String urName = name.nextLine();
        Player.setUrName(urName);
        System.out.println(" ");
        System.out.println("Ok, what is your age?");
        Scanner age = new Scanner(System.in);
        Player.urAge = age.nextInt();
        System.out.println(" ");
        System.out.println("Please select one of the following classes below:");
        System.out.println("Mage");
        System.out.println("Warrior");
        System.out.println("Archer");
        Logic.timeDelay();
        System.out.println("This is caps-sensitive, so please choose one of the above carefully. Otherwise the program will not continue to run.");
        Scanner classInput = new Scanner(System.in);
        String playerClass = classInput.nextLine();
        Player.setCl(playerClass);
        switch (Player.getCl())
        {
            case "Mage" -> {
                System.out.println("So you've chosen Mage as your class.");
                Player.playerTotalHealth = 90;
                Player.playerHealth = Player.playerTotalHealth;
                Player.playerLevel = 1;
                Player.playerTotalDamage = 14;
                Player.playerTotalMana = 15;
                Player.playerMana = Player.playerTotalMana;
                Player.experience = 0;
                equips.PlayerEquipmentHashMap.put(Equips.Wand.weaponName, Equips.Wand.weaponName);
            }
            case "Warrior" -> {
                System.out.println("So you've chosen Warrior as your class.");
                Player.playerTotalHealth = 100;
                Player.playerHealth = Player.playerTotalHealth;
                Player.playerLevel = 1;
                Player.playerTotalDamage = 17;
                Player.playerTotalMana = 5;
                Player.playerMana = Player.playerTotalMana;
                Player.experience = 0;
                equips.PlayerEquipmentHashMap.put(Equips.Dagger.weaponName, Equips.Dagger.weaponName);

            }
            case "Archer" -> {
                System.out.println("So you've chosen Archer as your class.");
                Player.playerTotalHealth = 80;
                Player.playerHealth = Player.playerTotalHealth;
                Player.playerLevel = 1;
                Player.playerTotalDamage = 20;
                Player.playerTotalMana = 10;
                Player.playerMana = Player.playerTotalMana;
                Player.experience = 0;
                equips.PlayerEquipmentHashMap.put(Equips.Slingshot.weaponName, Equips.Slingshot.weaponName);
            }
            default -> System.exit(0);
        }
        parser.playerGetsSkill();
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("In this world you will encounter many ferocious enemies, varying from humans to monsters.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("But as in any other RPG, you will be able to defeat them and level up.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("You will be able to find new weapons, skills, and dangerous enemies that will approach you.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Will you be able to survive?");
        Logic.timeDelay();
        chapterOneIntro();
    }

    public void chatWithRay1() throws InterruptedException {
        System.out.println(Player.urName + ":" + " " + "Hey there.");
        Logic.timeDelay();

        System.out.println(" ");
        System.out.println("? ? ?:" + " " + "Hm?");
        Logic.timeDelay();

        System.out.println(" ");
        System.out.println(Player.urName + ":" + " My name is" + " " + Player.urName + ", yours?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("? ? ?: " + " Why does it matter to you?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " No harm in making a friend, right?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I suppose not. My name is Ray.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Nice to meet you, Ray. What are you doing here?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Well, I was just on my way to kill some goblins, you wanna come?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Sure, I used to be a mercenary, so I know how to fight.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: All the more better, follow me.");
        chapterOneGoblins();
    }

    public void chatWithRay2() throws InterruptedException {
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " What's your name?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("He turns his head towards you.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("? ? ?: A curious guy, aren't you?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " I'm just trying to make conversation.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: It's Ray. Yours?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " " + Player.urName + ".");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Nice to meet you," + " " + Player.urName + ".");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " So what are you doing here?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I'm here to take down some goblins.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Sounds fun. Can I come?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Haha, this is the first time I've seen somebody");
        System.out.println("enthusiastic about killing goblins.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Well, I do have experience with this sort of stuff.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Very well then, follow me.");
        chapterOneGoblins();
    }

    public void chatWithRay3() throws InterruptedException {
        System.out.println(" ");
        System.out.println("You feel too hesitant to start a discussion.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("The atmosphere is tense, the bar drops in silence.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("? ? ?: Was there something you needed?");
        System.out.println("   DIALOGUE");
        System.out.println("---------------");
        System.out.println("1) Yes");
        System.out.println("2) No");
        Scanner yon = new Scanner(System.in);
        String yesOrNo = yon.nextLine();
        if (yesOrNo.equals("1")) {
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Yes.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: What is it?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " I've never seen you around here.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: I don't come here very often. I am just here to");
            System.out.println("kill some time.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " What do you normally do then?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: I'm a bounty hunter, but I am hunting goblins");
            System.out.println("at the moment.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Mind if I come along?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: You won't get a reward, and I'm not responsible");
            System.out.println("for your death.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " No worries, fine by me.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: Fair enough, follow me.");
            chapterOneGoblins();

        }
        else if (yesOrNo.equals("2")) {
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " No.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: Oh, alright then.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("He gets off the stool and walks towards the exit.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Hey, wait!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: What now?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Where are you going?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: To hunt some goblins, why?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " May I come along?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: Sorry, it's too dangerous.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " No worries, I can take care of myself.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: Alright, but if you die, it's not on me. Got it?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Yeah, yeah. I know.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("? ? ?: Good. Follow me.");
            chapterOneGoblins();
            }
        }

    public void fightWithRay() throws InterruptedException {
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Hey you.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("You approach him menacingly.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("? ? ?: Hm?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Let's fight. If I win, I get your money.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("? ? ?: Who do you think you are?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " " + " Come on, don't be a coward.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("? ? ?: Alright, fine. But don't whine when I take everything");
        System.out.println("out of your pocket.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("BATTLE START");
        Logic.setDefaultDmg(13);
        Enemy.whatEnemyAmIFacing("Ray", 100, 100, 5, 5, 1, 13, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, false);
        Player.playerMenuSelect();
        if (Enemy.enemyHealth <= 0)
        {
            Player.goldGained(450);
            Logic.timeDelay();
            Logic.awardFixedXp(100);
            Logic.timeDelay();
            System.out.println("Ray: Argh!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " You're not as strong as I thought.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: I admit, you're pretty strong.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Thanks, you're not so bad yourself.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: So is there any particular reason you chose to fight with me?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Well, you seemed pretty looted.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Makes sense... Alright then, it was nice talking to you but I gotta go.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Where? If you don't mind me asking.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: To hunt some goblins. Wanna come? You seem like a pretty capable fighter.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Sure, let's go.");
            chapterOneGoblins();
        }
    }

    public void chapterOneGoblins()
    {
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("You go to the field of Goblins with Ray, however no goblins appear in sight.");
        System.out.println(" ");
        System.out.println("DIALOGUE");
        System.out.println("--------");
        System.out.println("1) Are we there yet?");
        System.out.println("2) Why aren't there any goblins?");
        System.out.println("3) Nice weather we're having.");
        Scanner input = new Scanner(System.in);
        String sinput = input.nextLine();
        if (sinput.equals("1"))
        {
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Are we there yet?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: We're here, although something is off. There are no goblins here.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " What do you mean?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Typically there are horde of Goblins here, but");
            System.out.println("there are none in sight, strange.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " You sure you didn't come to the wrong place by accident?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: No, I'm positive that this is the right place.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("YOU HEAR SOMETHING COMING WITHIN THE CAVERNS..");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("WHAT DO YOU DO..?");
            System.out.println("-----------------");
            System.out.println("1) Warn Ray about the sound");
            System.out.println("2) Ignore it");
            System.out.println("3) Head straight towards the cavern");
            Scanner ninput = new Scanner(System.in);
            String warning = ninput.nextLine();
            switch (warning) {
                case "1" -> {
                    System.out.println(" ");
                    System.out.println(Player.urName + ":" + " Hold on, I hear something coming from the caverns.");
                    Logic.timeDelay();
                    System.out.println("Ray: What did you hear?");
                    Logic.timeDelay();
                    System.out.println("TELL RAY WHAT..?");
                    System.out.println("----------------");
                    System.out.println("1) NOOOOOOOOOOOOOOOOOOO!");
                    System.out.println("2) Something about this roleplay never ending..");
                    System.out.println("3) It sounded like goblins.");
                    Scanner tellRayInput = new Scanner(System.in);
                    String tellRay = tellRayInput.nextLine();
                    switch (tellRay) {
                        case "1" -> {
                            System.out.println(" ");
                            System.out.println(Player.urName + ":" + " NOOOOOOOOOOOOOOOOOOOO!");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: What..?");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.urName + ":" + " Not kidding, that's what I heard.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: Quit screwing around!");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.urName + ":" + " Fine, fine. It sounded like goblins.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: Perfect, let's go kill these fuckers and get outta here.");
                            chapterOneCaverns();
                        }
                        case "2" -> {
                            System.out.println(" ");
                            System.out.println(Player.urName + ":" + " Something about this roleplay never ending..");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: Ok..?");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: Seriously though, what did you hear?");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.urName + ":" + " I'm serious, that's what I heard.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: Jesus, you're unreliable. I'm going to go find out myself then.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.urName + ":" + " Wait, isn't it dangerous?");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: I can take care of myself.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.urName + ":" + " No way in hell am I letting you go alone.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: Fine, hurry up and come then.");
                            chapterOneCaverns();
                        }
                        case "3" -> {
                            System.out.println(" ");
                            System.out.println(Player.urName + ":" + "It sounded like goblins.");
                            System.out.println("I think it came from the caverns.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: Perfect, let's go then.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.urName + ":" + "Are you sure this is a good idea?");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: Trust me, we'll be ok.");
                            chapterOneCaverns();
                        }
                    }
                }
                case "2" -> {
                    System.out.println(" ");
                    System.out.println("You hear a disturbing sound, but dismiss it as nothing.");
                    Logic.timeDelay();
                    System.out.println("Ray: Something wrong, " + Player.urName + "?");
                    Logic.timeDelay();
                    System.out.println(Player.urName + ":" + "What? No.");
                    Logic.timeDelay();
                    System.out.println("Ray looks at you suspiciously.");
                    Logic.timeDelay();
                    System.out.println(Player.urName + ":" + " Well, I did hear something over there, but I'm sure it was nothing.");
                    Logic.timeDelay();
                    System.out.println("Ray: Over there? Inside the caverns?");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("DIALOGUE");
                    System.out.println("--------");
                    System.out.println("1) Yes");
                    System.out.println("2) No");
                    Scanner warning2Input = new Scanner(System.in);
                    String warning2 = warning2Input.nextLine();
                    if (warning2.equals("1")) {
                        System.out.println(" ");
                        Logic.timeDelay();
                        System.out.println(Player.urName + ":" + " Yes.");
                        Logic.timeDelay();
                        System.out.println("Ray: Looks like we've found our prey, let's get going then.");
                        Logic.timeDelay();
                        System.out.println("You run towards the caverns with Ray.");
                        chapterOneCaverns();
                    } else if (warning2.equals("2")) {
                        System.out.println(" ");
                        Logic.timeDelay();
                        System.out.println(Player.urName + ":" + " No.");
                        Logic.timeDelay();
                        System.out.println("Ray: Where then?");
                        Logic.timeDelay();
                        System.out.println(Player.urName + ":" + " I don't know. I just heard it somewhere.");
                        Logic.timeDelay();
                        System.out.println("GROANS CAN BE HEARD FROM THE CAVERNS....");
                        Logic.timeDelay();
                        System.out.println("Ray: Well, that proves it. There are definitely goblins in there, let's go.");
                        Logic.timeDelay();
                        System.out.println(Player.urName + ":" + " Right.");
                        chapterOneCaverns();
                    }
                }
                case "3" -> {
                    System.out.println(" ");
                    System.out.println("You run towards the caverns.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("Ray: Hey wait! Where are you going?!");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println(Player.urName + ":" + " The goblins, they're in the caverns!");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("Ray: Wait! Slow down and wait for me!");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("You accidentally slip into the caverns and fall head first.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("Blood gushes out of your head as your corpse is fed to the goblins..");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("Upon witnessing the horrific sight, Ray ran away in panic.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("GAME OVER");
                    Logic.timeDelay();
                    System.exit(0);
                }
            }
        }
        else if (sinput.equals("2"))
        {
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Why aren't there any goblins?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: I don't know. Typically, there are a lot.");
            System.out.println("We should try to split up and find them.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " Are you sure that's safe?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Relax. The goblins aren't that powerful.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ":" + " I'll take your word for it.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Which way do you wanna go?");
            System.out.println(" ");
            System.out.println("WHICH WAY?");
            System.out.println("----------");
            System.out.println("1) CAVERNS");
            System.out.println("2) HILLSIDE");
            Scanner directionInput = new Scanner(System.in);
            String direction = directionInput.nextLine();
            if (direction.equals("1"))
            {
                System.out.println(" ");
                System.out.println(Player.urName + ": I'll go to the caverns.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Alright, don't die on me.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ":" + " I won't. I promise.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("You split up with Ray, sprinting towards the caverns.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("You carefully navigate your way through the caverns, hearing groans coming from deep within.");
                Logic.timeDelay();
                System.out.println("WHAT DO YOU DO?");
                System.out.println("---------------");
                System.out.println("1) GO FORWARD");
                System.out.println("2) TURN BACK");
                Scanner cavernInput = new Scanner(System.in);
                String cavernDialogue = cavernInput.nextLine();
                if (cavernDialogue.equals("1"))
                {
                    System.out.println(" ");
                    System.out.println("You decide to go forward, the sounds of groans become louder.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("A horde of goblins suddenly attack you!");
                    Logic.timeDelay();
                    System.out.println(" ");
                    Logic.setDefaultDmg(8);
                    Enemy.whatEnemyAmIFacing("Goblin Horde", 60, 60, 1, 1, 1, 8, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, false);
                    Player.playerMenuSelect();
                    if (Enemy.enemyHealth <= 0)
                    {
                        Player.goldGained(100);
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("You walk past the pile of corpses, stumbling upon the leader of the goblins himself.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("GOBLIN GIANT: GROAAGHHHHH!");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.urName + ": What the hell?!");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("A giant swarm of goblins surround you, it seems there is no escape.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.urName + ": Shit, is this really the end for me..?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.urName + ": I'm sorry I let you down, Ray.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("YOU HEAR A FAMILIAR VOICE ECHOING FROM BEHIND.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Oi " + Player.urName + " ,you're lucky we found you!");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.urName + ": What?! We..?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: That's right, I met a new friend.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: Let's save the introductions for later, shall we?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Right, " + Player.urName + " you focus on taking down the Goblin Giant, we'll take care of this horde!");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.urName + ": Awesome! Will do.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("You rush towards the Goblin Giant initiating battle!");
                        Logic.timeDelay();
                        System.out.println(" ");
                        Logic.setDefaultDmg(15);
                        Enemy.whatEnemyAmIFacing("Goblin Giant", 75, 75, 5, 5, 3, 15, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, false);
                        Player.playerMenuSelect();
                        if (Enemy.enemyHealth <= 0)
                        {
                            Logic.timeDelay();
                            Logic.awardFixedXp(100);
                            Logic.timeDelay();
                            Player.goldGained(500);
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.urName + ": Take this asshole!");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("You kill the Goblin Giant with one final attack.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray and Andrew look exhausted, but relieved to see that the battle is over.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Andrew: That took longer than I thought it would, jesus.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.urName + ": Can we talk somewhere else? I know I don't you, but");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("I would like to get to know you better while we're heading back.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Andrew: That's fine with me, let's go then.");
                            Ch2.Chap2Intro();
                        }
                    }
                }
                else if (cavernDialogue.equals("2"))
                {
                    System.out.println(" ");
                    System.out.println("You turn around and run in panic.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("The groans get louder, it seems like somebody is following you.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("You realize that climbing out of the caverns would not be an optimal solution");
                    System.out.println("at this point.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("You see silhouettes of goblins running towards you.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("You try and climb out, but it's too late. The goblins have already");
                    System.out.println("caught up with you.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("You try to fend them off, but it's futile. They rip apart your flesh");
                    System.out.println("and bones, eating them bit by bit.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("GAME OVER");
                    Logic.timeDelay();
                    System.exit(0);
                }

            }
            else if (direction.equals("2"))
            {
                System.out.println(" ");
                System.out.println(Player.urName + ": I'll go to the hillside.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Fair enough, I'll go to the caverns then.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("You venture alone to the hillside, although it seems like nothing is here.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("? ? ?: Hey you.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": ?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("? ? ?: What are you doing here?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": I'm hunting goblins. What are you doing here?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("? ? ?: The same as you, what's your name?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": " + Player.urName + ".");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: Nice name, mine is Andrew.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": Nice to meet you, Andrew. So have you had any luck");
                System.out.println("finding the goblins?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: Nope. Although, I am fairly sure that they're in the caverns.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": Is that so? A companion of mine went down there alone.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: Let's hope he isn't dead then.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": I'm sure he will be fine.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: Either way, we should head down there to see what's going on.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": Agreed. Let's go.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("You follow Andrew and head towards the caverns, carefully navigating your way through.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": Seems pretty empty to me, are you sure we're in the right place?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: Yes, I think so. I definitely heard something down here.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("YOU HEAR LOUD GROANS AND SCREAMS COMING FROM DEEP WITHIN THE CAVERNS..");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": Shit. I'm pretty sure that's Ray.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: That doesn't sound good, let's go, hurry!");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": Right!");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("You follow Andrew and find the large horde of goblins, you see Ray attempting");
                System.out.println("to defend himself from the horde.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("GOBLIN GIANT: GRAGAGAGAHHA!");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Finally you come, hurry and help me out!");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: I'll take down the horde. You should try to save Ray");
                System.out.println("from the giant there!");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": On it!");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("You rush towards the Goblin Giant initiating battle!");
                Logic.timeDelay();
                System.out.println(" ");
                Logic.setDefaultDmg(15);
                Enemy.whatEnemyAmIFacing("Goblin Giant", 75, 75, 5, 5, 3, 15, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, false);
                Player.playerMenuSelect();
                if (Enemy.enemyHealth <= 0)
                {
                    Logic.timeDelay();
                    Logic.awardFixedXp(100);
                    Logic.timeDelay();
                    Player.goldGained(500);
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("You finish off the Goblin Giant, as its remains scatter all over the floor.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println(Player.urName + ": It's.. finally dead.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("Ray: Good grief. Finally.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("Andrew and Ray quickly finish off the last of the goblins.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("Andrew: Let's get out of here first before we talk, this place smells like shit.");
                    Logic.timeDelay();
                    System.out.println(" ");
                    System.out.println("Ray: Good idea.");
                    Logic.timeDelay();
                    Ch2.Chap2Intro();
                }
            }

        }
        else if (sinput.equals("3"))
        {
            System.out.println(" ");
            System.out.println(Player.urName + ": Nice weather we're having.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Mhm.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ": So what are we doing here anyways?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Hunting goblins. Don't you remember?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ": Oh, right. But where are they?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: I don't know. They should be close by.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ": Are you sure this is the right place?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: I'm positive.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ": I'll take your word for it then.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("You hear a sound coming from the caverns..");
            System.out.println("DIALOGUE");
            System.out.println("--------");
            System.out.println("1) Did you hear that?");
            System.out.println("2) Say nothing");
            Scanner dialogueinput = new Scanner(System.in);
            String dialogue = dialogueinput.nextLine();
            if (dialogue.equals("1"))
            {
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": Did you hear that?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: No?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": It sounded like goblins. It came from the caverns, I think.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Well, that does make sense. Considering that they aren't here.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": Should we go and investigate?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Definitely.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": Alright, follow my lead.");
                chapterOneCaverns();
            }
            else if (dialogue.equals("2"))
            {
                System.out.println(" ");
                System.out.println("Ray: What was that noise?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": You heard it as well?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Obviously, what was it though?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": It sounded like groans. I think we should try to investigate,");
                System.out.println("it might be the goblins.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Maybe. Just be careful.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.urName + ": Don't worry about me. I'll be fine.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Alright, you lead the way then.");
                chapterOneCaverns();
            }
        }
    }

    public void chapterOneCaverns()
    {
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + " and Ray sprint towards the caverns, carefully navigating");
        System.out.println("their way through, making sure not to slip.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Finally, we're down this pit. Are you sure you heard something here?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Yup. I'm positive.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Strange, I don't see or hear anything.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("YOU HEAR A FAINT GROAN COMING FROM BEHIND YOU..");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Wait! I just heard something..");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Me too, those fuckers are close by. Keep your guard up.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("THE GROANING GETS LOUDER, AS YOU NOTICE DARK SILHOUETTES OF GOBLINS APPROACHING..");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Shit! We're being ambushed!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Fuck, FUCK! What do we do?!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " I thought you could take them on!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Not these many! What the hell are we supposed to do?!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " I have an idea. I'll get horde's leader, you hold them off.");
        System.out.println(" ");
        Logic.timeDelay();
        System.out.println("Ray: Are you insane?! You can't expect me to hold all these goblins off!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Well someone has to do it, otherwise their leader will");
        System.out.println("will confront us while we're holding them off. We can't take them on all at once.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Tsch, you're insane. But I guess we have no other options. Go then!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Don't die on me, Ray.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I can't guarantee anything " + Player.urName + ", but I'll try.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("You split up with Ray to try and find the horde's leader, and with");
        System.out.println("an unwelcoming surprise, you encounter him.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("GOBLIN GIANT: GROAGHHH....");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Jesus, you're uglier than I thought.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("The Goblin Giant is infuriated at your remark, rushing at you with great speed.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ":" + " Alright fatass, bring it!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("BATTLE START!");
        Logic.setDefaultDmg(15);
        Enemy.whatEnemyAmIFacing("Goblin Giant", 75, 75, 5, 5, 3, 15, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, false);
        Player.playerMenuSelect();
        if (Enemy.enemyHealth <= 0)
        {
            Logic.timeDelay();
            Logic.awardFixedXp(100);
            Logic.timeDelay();
            Player.goldGained(500);
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("You finish off the Goblin Giant with one final blow as blood gushes out of its stomach.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("GOBLIN GIANT: GRHAHAHAHSGAYDGYGYAD! *dies*");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("You pant heavily out of exhuastion.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Is that thing finally fucking dead?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ": Yeah, I think so.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Good. Let's get the hell out of here.");
            Logic.timeDelay();
            System.out.println(" ");
            Ch2.Chap2Intro();
        }

    }




    public void chapterOneIntro() throws InterruptedException
    {
        System.out.println("     CHAPTER 1");
        System.out.println("---------------------");
        System.out.println("   A Goblin Horde");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("You walk into the bar, spotting a young man with long hair drinking alone by himself.");
        Logic.timeDelay();
        System.out.println("  ");
        System.out.println("What do you do?");
        System.out.println("---------------");
        System.out.println("1) Approach and talk");
        System.out.println("2) Sit somewhere else");
        System.out.println("3) Fight him");
        Scanner dialogue1 = new Scanner(System.in);
        String optionSelect = dialogue1.nextLine();
        switch (optionSelect) {
            case "1" -> {
                System.out.println(" ");
                System.out.println("You approach him carefully, sitting next to him.");
                System.out.println("   DIALOGUE");
                System.out.println("---------------");
                System.out.println("1) Hey there.");
                System.out.println("2) What's your name?");
                System.out.println("3) Do nothing");
                Scanner o1 = new Scanner(System.in);
                String heyThere = o1.nextLine();
                switch (heyThere) {
                    case "1" -> chatWithRay1();
                    case "2" -> chatWithRay2();
                    case "3" -> chatWithRay3();
                }
            }
            case "2" -> {
                System.out.println(" ");
                System.out.println("You sit down at a different table, staring at him continuously.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("He makes eye contact with you.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("The atmosphere becomes tense.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("You think that it would be better to approach him instead, what do you say?");
                System.out.println("   DIALOGUE");
                System.out.println("---------------");
                System.out.println("1) Hey there.");
                System.out.println("2) What's your name?");
                System.out.println("3) Do nothing");
                Scanner o1 = new Scanner(System.in);
                String heyThere = o1.nextLine();
                switch (heyThere) {
                    case "1" -> chatWithRay1();
                    case "2" -> chatWithRay2();
                    case "3" -> chatWithRay3();
                }

            }
            case "3" -> {
                System.out.println(" ");
                fightWithRay();
            }
        }
    }

}

