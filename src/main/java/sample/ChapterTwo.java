package sample;

import java.util.Scanner;

public class ChapterTwo extends Main {
    int andrewTaunt = 0;
    boolean partyMadAtYou;
    static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void Chap2Intro()
    {
        Logic.save2_1 = true;
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("CHAPTER 2");
        System.out.println("---------");
        System.out.println("Heading to Blackwood");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("After defeating the goblins, you make it back to the");
        System.out.println("village with Andrew and Ray. The three of you are exhausted");
        System.out.println("and out of breath.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Finally, we're out of that mess.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Took a while though, I honestly didn't expect things to become that messy.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": We almost died because of you.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Quit blaming me, alright? You agreed to come along.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Oh, right. My bad.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Hmph.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: Let's all calm down and get along shall we? Let's just be");
        System.out.println("be thankful we made it out alive.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": You've been silent ever since we left. ");
        System.out.println("What's up with you and who are you?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: My name is Andrew. I am a Mage born in Blackwood.");
        Logic.timeDelay();
        System.out.println(" ");
        if (Player.getCl().equals("Mage"))
        {
            System.out.println(Player.getUrName() + ": Ah, so you're a Mage too? I am a mage myself actually.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Andrew: Interesting! I saw your skills in that fight, and I must I am indeed impressed.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": Thanks, I'm flattered. So what brought you here anyway?");
        }
        else
        {
            System.out.println(Player.getUrName() + ": A Mage huh? That's pretty cool.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Andrew: Mhm. And what class might you be?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": I am a " + Player.getCl() + ".");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Andrew: Makes sense, your skills in that fight did resemble that of a " + Player.getCl() + ".");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Mhm. So what brought you here anyway?");
        }
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: I was actually on my way to the great kingdom of Blackwood, however,");
        System.out.println("I managed to bump into you lads along the way.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Fateful coincidence.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: Indeed.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Blackwood you say? Is that not where the Prince Sora resides?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: Yes, although a mere commoner like me cannot wish to meet a man like him.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": I've never heard of this man, who is he?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: What?! You don't know THE Prince Sora himself?!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": I'm not familiar with these names, I apologize.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: He's a renowned Prince known throughout the country for his noble");
        System.out.println("efforts to stop slavery and fight crime, and it is a very beautiful kingdom");
        System.out.println("might I add.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Why don't we go then? Andrew, you said you were on your way there, correct?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: Yes, that's right.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Wait " + Player.getUrName() + ", Blackwood is a very far trip from here. It is no ordinary");
        System.out.println("roadtrip, it will take us quite some time for us to get there.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": That's fine, haven't you ever travelled before?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I'm just saying.. besides I have better things to do. I can't waste my time here.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Like what?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: It's none of your concern.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": That's what I thought. Just stop being a bitch and come.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: . . .");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Fine. I'll do it.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Great, alright then. Let's head out then.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: Wait, this will be quite a big journey. Let's restock on supplies and equipment and then leave.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Fine by me.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Sure. Let's meet at the dock tonight, and have a ship ready by then, Andrew.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: Got it.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("The pack splits up, and you go your separate ways for now.");
        Logic.timeDelay();
        System.out.println(" ");
        Player.theHub();
    }

    public void boatSail()
    {
        System.out.println(" ");
        System.out.println("You arrive at the dock at approximately 10:00PM. Andrew and Ray are making preparations");
        System.out.println("to set sail.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("DIALOGUE");
        System.out.println("--------");
        System.out.println("1) How long have you guys been here?");
        System.out.println("2) Nice ship.");
        System.out.println("3) Let's hurry up.");
        Scanner input = new Scanner(System.in);
        String chat = input.nextLine();
        switch (chat)
        {
            case "1" -> {
                System.out.println(Player.getUrName() + ": How long have you guys been here?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Quite some time. We've been waiting for you.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": Oh. I apologize for the inconvenience, I know arriving late");
                System.out.println("was not appropriate on my part. My bad.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: Apologies are not enough, " + Player.getUrName() + ". We wasted a lot");
                System.out.println("of time waiting for you.");
                Logic.timeDelay();
                System.out.println(" ");
                andrewTaunt++;
                System.out.println(Player.getUrName() + ": Well, we can't make up for lost time now can we? Let's");
                System.out.println("just get going.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: " + Player.pronoun + "'s right. Let's get going.");
                Logic.timeDelay();
                System.out.println(" ");
                onTheOcean();
            }
            case "2" -> {
                System.out.println(Player.getUrName() + ": Nice ship.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: Thanks. It's mine by the way.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("DIALOGUE");
                System.out.println("--------");
                System.out.println("1) Oh. That's pretty cool.");
                System.out.println("2) Cool. Did I ask?");
                System.out.println("3) I missed the part where that's my problem.");
                Scanner line = new Scanner(System.in);
                String provoke = line.nextLine();
                switch (provoke)
                {
                    case "1" -> {
                        andrewTaunt = 0;
                        System.out.println(Player.getUrName() + ": Oh. That's pretty cool.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: Mhm.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: We don't have time for chit chat, let's go.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": Oh right.");
                        onTheOcean();
                        break;
                    }
                    case "2" -> {
                        System.out.println(Player.getUrName() + ": Cool. Did I ask?");
                        andrewTaunt++;
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: . . .");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew ignores you and boards onto the ship quietly.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": Got real quiet all of a sudden. Something wrong?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Enough. Get on the ship, we need to leave immediately.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": Yeah. You're right. Let's get going then.");
                        onTheOcean();
                        break;

                    }
                    case "3" -> {
                        System.out.println(Player.getUrName() + ": I missed the part where that's my problem.");
                        andrewTaunt++;
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: Excuse me?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: You've got some nerve, kid. Speaking to me like that.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": Got a problem with it?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: Mhm. I do actually.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Both of you shut up and get on board! We don't have time to waste!");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("You and Andrew silently walk towards the boat, not saying anything to each other.");
                        onTheOcean();
                    }


                }
            }
            case "3" ->
                    {
                        System.out.println(Player.getUrName() + ": Let's hurry up.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: You? You're the one telling us to hurry up? You're the one whose late.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        andrewTaunt++;
                        System.out.println(Player.getUrName() + ": I know, all the more reason for us to set sail.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: " + Player.getUrName() + "'s right. We need to set sail now. We don't");
                        System.out.println("have time to spare.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: Fine.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("The three of you aboard the ship, although there seems to be slight tension between ");
                        System.out.println(Player.getUrName() + " and Andrew.");
                        onTheOcean();
                    }

        }


    }


    public void onTheOcean()
    {
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("It is a starry night. The waves are quiet.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("DIALOGUE");
        System.out.println("--------");
        System.out.println("1) The stars are beautiful.");
        System.out.println("2) It's pretty dark. I hope we don't get attacked.");
        System.out.println("3) Sleep and skip the boat ride.");
        Scanner input = new Scanner(System.in);
        String actionChosen = input.nextLine();
            switch (actionChosen)
            {
                case "1" ->
                        {
                    System.out.println(Player.getUrName() + ": The stars are beautiful.");
                            Logic.timeDelay();
                            System.out.println(" ");
                    System.out.println("Ray: Yeah, they are.");
                            Logic.timeDelay();
                            System.out.println(" ");
                    System.out.println("Where's Andrew?");

                }
                case "2" ->
                        {
                            System.out.println(Player.getUrName() + ": It's pretty dark. I hope we don't get attacked.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: Doubt it. There aren't any bizarre creatures that can attack us here.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.getUrName() + ": How can you be so sure?");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: I come and sail here every so often, unlike you.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.getUrName() + ": Relax buddy. It's not like I don't have confidence in you.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: . . .");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.getUrName() + ": What?");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println("Ray: Nothing.");
                            Logic.timeDelay();
                            System.out.println(" ");
                            System.out.println(Player.getUrName() + ": Okay then... Where is Andrew?");
                        }
                case "3" ->
                        {
                            welcomeToBlackwood();
                        }
            }
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I don't know. Haven't seen him in a while.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": He might be sleeping. I'll go check up on him.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("You head to the bottom of the ship where the beds are, Andrew seems to be lying down.");
        System.out.println("WHAT DO YOU DO?");
        System.out.println("---------------");
        System.out.println("1) Pour a bucket of water on his face");
        System.out.println("2) Leave him alone. It would be rude to interrupt his nap.");
        Scanner behaviour = new Scanner(System.in);
        String doWhat = behaviour.nextLine();
        switch (doWhat)
        {
            case "1" ->
                    {
                        System.out.println("You grab a small bucket of water from the ocean, heading into the bottom floor silently.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray witnesses " + Player.getUrName() + " grabbing the bucket of water but dismisses it");
                        System.out.println("as you just trying to give him a glass of water.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("You tippy-toe silently, trying not to make any noise until..");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("SPLASH!");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew wakes up from the splash of cold water all over his body...");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: WHAT THE HELL IS WRONG WITH YOU?!");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew immediately grabs your collar, clenching it firmly.");
                        andrewTaunt++;
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": W-Wait! It was a joke. I'm sorry.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: A joke? You got me wet you bastard!");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray barges in abruptly.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: What the hell is happening here?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: This asshole spilled water all over me!");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Explain yourself, " + Player.getUrName() + ".");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Hmm.. what should I do?");
                        System.out.println("-----------------------");
                        System.out.println("1) Apologize");
                        System.out.println("2) Do not apologize");
                        Scanner excuseInput = new Scanner(System.in);
                        String excuse = excuseInput.nextLine();
                        switch (excuse)
                        {
                            case "1" ->
                            {
                                System.out.println(Player.getUrName() + ": I'm genuinely really sorry, Andrew.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Andrew: Sorry is not going to cut it for me, pal.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: Hold on Andrew, just forgive him for now. We'll talk to him later");
                                System.out.println("about this.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Andrew: Hmph.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Andrew immediately leaves, not saying a word back.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: What the hell is wrong with you, " + Player.getUrName() + "?");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println(Player.getUrName() + ": I'm sorry, it was just a prank. Granted, an inappropriate one.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: Just don't do it again.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println(Player.getUrName() + ": Yeah. Understood.");
                                encounterWithSeaMonster();
                            }
                            case "2" ->
                                    {
                                        andrewTaunt++;
                                        System.out.println(Player.getUrName() + ": What's wrong? I was just having a little fun.");
                                        Logic.timeDelay();
                                        System.out.println(" ");
                                        System.out.println("Ray: Are you serious, " + Player.getUrName() + "? This is a pretty ridiculous");
                                        System.out.println("prank if you ask me.");
                                        Logic.timeDelay();
                                        System.out.println(" ");
                                        System.out.println(Player.getUrName() + ": Maybe to you. But not to me.");
                                        Logic.timeDelay();
                                        System.out.println(" ");
                                        System.out.println("Andrew: You're seriously fucked in the head, buddy. I'm not sure if you have some");
                                        System.out.println("grudge against me or something, but you better back it off before I seriously lose it.");
                                        Logic.timeDelay();
                                        System.out.println(" ");
                                        System.out.println(Player.getUrName() + ": . . .");
                                        Logic.timeDelay();
                                        System.out.println(" ");
                                        System.out.println("Andrew leaves in rage, he seems to be very upset.");
                                        Logic.timeDelay();
                                        System.out.println(" ");
                                        System.out.println("Ray: You seriously fucked up, " + Player.getUrName() + ". Good job.");
                                        Logic.timeDelay();
                                        System.out.println(" ");
                                        System.out.println("Ray leaves in disappointment as well...");
                                        Logic.timeDelay();
                                        System.out.println(" ");
                                        partyMadAtYou = true;
                                        System.out.println(ANSI_RED + "YOUR ACTIONS HAVE CONSEQUENCES..." + ANSI_RESET);
                                        encounterWithSeaMonster();
                                    }
                        }
                    }
                    case "2" ->
                            {
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("You decide to leave him alone.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("You climb back up the ladder.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: Well, what's he doing?");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println(Player.getUrName() + ": Taking a nap, it seems.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: Makes sense. He's been up for quite some time getting");
                                System.out.println("the preparations ready and everything. He's really a good guy.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println(Player.getUrName() + ": Yeah. I can definitely tell.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println(Player.getUrName() + ": . . .");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: Is something wrong, " + Player.getUrName() + "?");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println(Player.getUrName() + ": Yeah, well.. I have been meaning to ask you something..");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: What is it?");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println(Player.getUrName() + ": Are you afraid of death?");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: What kind of question is that?");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println(Player.getUrName() + ": I'm just wondering, that's all. You don't have to");
                                System.out.println("answer it if you don't want to.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: To die with regrets, yeah.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println(Player.getUrName() + ": Dying with regrets?");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: I don't want to die without doing something meaningful. I have a big dream");
                                System.out.println("that I would like to accomplish.");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println(Player.getUrName() + ": And what would that be?");
                                Logic.timeDelay();
                                System.out.println(" ");
                                System.out.println("Ray: It's...");
                                encounterWithSeaMonster();
                            }
        }

    }

    public void encounterWithSeaMonster()
    {
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("A large rumbling shakes the ship, everyone onboard can feel the rumbling tilt the ship back and forth.");
        if (!partyMadAtYou)
        {
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": The hell was that?!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: I don't know, but it's definitely from something underwater!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": What, are you serious?!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Does it look like I'm kidding?!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": Tsch! What do we do? Andrew is in the lower bunk.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Shit, shit. Don't go down, it's too risky. We have to take this thing down as soon");
            System.out.println("as possible!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": Are you serious?! Just the two of us?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: We can do it! We'll rush at this thing together!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": Alright, let's go!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + " and Ray rush at the Sea Monster, initiating battle as it surfaces from underneath.");
            Logic.timeDelay();
            System.out.println(" ");
            allies.allyReceived("Ray");
            Equips.Ray.allyHasEquipment.put(Equips.SteelSword.weaponName, Equips.SteelSword.weaponName);
            System.out.println("BATTLE START!");
            Logic.setDefaultDmg(18);
            Enemy.whatEnemyAmIFacing("Sea Monster", 130, 130, 5, 5, 3, 23, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, false);
            Player.playerMenuSelect();
            if (Enemy.enemyHealth <= 0)
            {
                Player.goldGained(300);
                Logic.awardXp();
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("With one final blow, the Sea Monster collapses into the sea.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": We did it!");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Y-yeah.. I'm tired as hell though.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": Me too. We should rest up, we'll be arriving at Blackwood soon.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Agreed. Let's go.");
                welcomeToBlackwood();
            }
        }
        else
        {
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": Huh, what was that?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": You head to the dock of the ship, only to discover that there is something");
            System.out.println("underneath the ship.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": The hell is that..?!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": Ray, Andrew! There's something underneath the ship!");
            System.out.println("Ray and Andrew walk over to you, alarmed.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Yeah, I can feel it too. There's something definitely underneath the ship.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": We need to take it down before it sinks the ship.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Agreed. Let's go-");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Andrew: No Ray, let " + Player.getUrName() + " do it.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("I understand the conflict, but we really cannot afford to let the ship sink.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Andrew: No, no. " + Player.getUrName() + ", you can handle it can't you?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": Of course.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Andrew: See? He can take of it himself.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: . . .");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Fine, go do it " + Player.getUrName());
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": I'm on it.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("You initiate the battle with the Sea Monster!");
            Logic.timeDelay();
            System.out.println(" ");
            Enemy.whatEnemyAmIFacing("Sea Monster", 130, 130, 5, 5, 3, 23, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, false);
            Player.playerMenuSelect();
            if (Enemy.enemyHealth <= 0)
            {
                Player.goldGained(300);
                Logic.awardXp();
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("With one final blow, the Sea Monster collapses into the sea.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + " Holy fuck.. that was exhausting.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Nice work. ");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: Hmph.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + " I'm going to bed. After that fight I feel like I'm about to pass out.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: That's fair. We'll be arriving at Blackwood shortly anyways.");
                welcomeToBlackwood();
            }



        }

    }

    public void welcomeToBlackwood()
    {
        Logic.timeDelay();
        System.out.println(" ");
        Logic.save2_1 = false;
        Logic.save2_2 = true;
        System.out.println("After a long journey on the sea, " + Player.getUrName() + ", Ray, and Andrew arrive");
        System.out.println("at the glorious kingdom of Blackwood.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("DIALOGUE");
        System.out.println("--------");
        System.out.println("1) The scenery is beautiful.");
        System.out.println("2) It's not as good as I thought.");
        System.out.println("3) Why is it so ugly?");
        Scanner input = new Scanner(System.in);
        String comment = input.nextLine();
        switch (comment)
        {
            case "2" -> {
                System.out.println(Player.getUrName() + ": It's not as good as I thought.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: What exactly were you expecting?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": Well, the two of you really exaggerated that this city was gorgeous.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: I don't think we exaggerated at all, but nonetheless, let us depart our separate ways");
                System.out.println("ways for now and meet up later.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: I agree. We're all tuckered out from the trip.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": Fine by me.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("The three of you go your separate ways for now, exploring Blackwood on your own."); }
            case "3" -> {
                System.out.println(Player.getUrName() + ": Why is it so ugly?");
                andrewTaunt++;
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: My God. Just leaves your remarks to yourself, " + Player.getUrName() + ".");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: In all seriousness, " + Player.getUrName() + ". Don't you ever have anything nice to say?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": I think of myself as a fairly nice person.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: Sure you do.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": . . .");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Enough. Let's go rest up for now and meet up later, sound like a plan?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Andrew: Works for me. I'm pretty tired anyways.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": Sure.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Alright, let's all meet up again at 6:00PM.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("The three of you go your separate ways for now, exploring Blackwood on your own."); }
            default ->
                    {
                        System.out.println(Player.getUrName() + ": The scenery is beautiful.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Indeed. It looks even more marvelous than the first time I came here.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Andrew: The trip was pretty exhausting. We should rest up before we explore.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Good idea. Let's all meet up at 6:00PM.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": Sure. Sounds good to me.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("The three of you go your separate ways for now, exploring Blackwood on your own.");
                    }

        }
        Player.theHub();

    }

    public void blackWood()
    {
        System.out.println("After taking a short hiatus, the group reunites right in the center of Blackwood.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Took you guys long enough.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: I'm surprised you arrived here so early. That was unexpected.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": I learned my lesson from last time.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: So Andrew, what was your purpose of coming to Blackwood anyway?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: Well, I was here to collect information on a certain priest.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": A certain priest you say?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: Yes, that's right. But let's not worry about that right now.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: What did you decide to come here for, " + Player.getUrName() + "?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": To meet the prince himself of course!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: What..? I thought you were kidding! " + Player.getUrName() + ", you");
        System.out.println("don't mean to tell me that you actually want to meet him right? What is the");
        System.out.println("purpose of doing such a thing?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Well, Ray made him sound like he is some sort of God.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I did not.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Yes you did.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray sighs, unable to deal with the buffoonery.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Alright fine. Let's go then.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: What?! Ray, don't tell me you actually agree to " + Player.getUrName() + "'s");
        System.out.println("nonsense! You do realize that we are not allowed in the palace right? We're mere commoners!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": It's fine, Andrew. We'll be ok. I'm sure he's a nice guy.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: You don't know what you're getting yourself into.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Like I said, we will be fine.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: Fair enough! Just don't blame me when you get arrested, I will not be the one to");
        System.out.println("bail you idiots out.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": Understood.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Alright, come on " + Player.getUrName() + ". We don't have time.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": On it.");
        meetWithSora();
    }

    public void meetWithSora()
    {
        if (Player.PlayerAllies.size() == 0)
        {
            allies.allyReceived("Ray");
            Equips.Ray.allyHasEquipment.put(Equips.SteelSword.weaponName, Equips.SteelSword.weaponName);
        }
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Upon entry into the palace, Ray and " + Player.getUrName() + " are immediately");
        System.out.println("confronted by the palace guards.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Guard #1: What's your business here?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: We're here to meet Prince Sora.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Guard #1: Sorry, but Prince Sora is not accepting visitors at this time.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.getUrName() + ": We're authorized to come in. The prince has given us permission.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Guard #1: No such message was received from the Prince, please step off the property");
        System.out.println("or you will be arrested.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Let's go, " + Player.getUrName() + ". You heard what the guard said.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("FALL BACK?");
        System.out.println("----------");
        System.out.println("1) YES");
        System.out.println("2) NO");
        Scanner input = new Scanner(System.in);
        String fallBack = input.nextLine();
        switch (fallBack)
        {
            case "1" ->
                    {
                        System.out.println(Player.getUrName() + ": Alright, I apologize for wasting your time.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("You decide to fall back and not confront the guards.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": Now what do we do?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: How about we don't do this at all? Why do you want to meet him so badly anyways?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": I've never met a Prince before, he sounds pretty cool.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Ugh. I don't know then.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Wait..");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": What is it?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: We can try sneaking in.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": Clever. I didn't expect you out of all people to come with such a plan,");
                        System.out.println("since you are so cautious after all.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: If anything, Andrew is the cautious one. I am actually quite cunning for my age.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": Is that so?");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Mhm.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println(Player.getUrName() + ": Well then, let's get this over with and sneak in at night.");
                        Logic.timeDelay();
                        System.out.println(" ");
                        System.out.println("Ray: Sounds like a plan.");
                        sneakIn();
                    }
           case "2" ->
                   {
                       System.out.println(Player.getUrName() + ": We need to get in.");
                       Logic.timeDelay();
                       System.out.println(" ");
                       System.out.println("Ray: " + Player.getUrName() + "!");
                       Logic.timeDelay();
                       System.out.println(" ");
                       System.out.println("Guard #1: You asked for it pal.");
                       Logic.timeDelay();
                       System.out.println(" ");
                       System.out.println("Guard #1: Guards! Attack " + Player.himHer + " immediately!");
                       Logic.timeDelay();
                       System.out.println(" ");
                       System.out.println("Ray: Tsch, looks like I'll have to save your ass.");
                       Logic.timeDelay();
                       System.out.println(" ");
                       if (Player.playerHealth <= 0)
                       {
                           Player.playerHealth = 1;
                       }
                       Logic.setDefaultDmg(24);
                       Enemy.whatEnemyAmIFacing("Blackwood Guards", 100, 100, 5, 5, 4, 24, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, false);
                       Player.playerMenuSelect();
                       if (Enemy.enemyHealth <= 0)
                       {
                           System.out.println(" ");
                           Logic.awardXp();
                           Player.goldGained(200);
                           Logic.timeDelay();
                           System.out.println(" ");
                           System.out.println("You take out the remaining guards as they collapse onto the ground.");
                           Logic.timeDelay();
                           System.out.println(" ");
                           System.out.println("Ray: Let's head in quickly before any guards notice.");
                           Logic.timeDelay();
                           System.out.println(" ");
                           System.out.println(Player.getUrName() + ": Right.");
                           Logic.timeDelay();
                           System.out.println(" ");
                           System.out.println("After climbing a couple hundred steps, you're almost at the last floor of the palace.");
                           System.out.println("There seems to be two staircases, which way do you go?");
                           Logic.timeDelay();
                           System.out.println(" ");
                           System.out.println("WHICH WAY?");
                           System.out.println("1) RIGHT");
                           System.out.println("2) LEFT");
                           Scanner stair = new Scanner(System.in);
                           String stairInput = stair.nextLine();
                           switch (stairInput)
                           {
                               case "1" -> goRight();
                               case "2" -> goLeft();
                           }


                       }

                   }



        }



    }

    public void goRight()
    {
        System.out.println("You decide to climb the right staircase.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("A bunch of guards notice you.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Shit, good job idiot. You went the wrong way!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("The guards rush at you and initiate battle!");
        Logic.timeDelay();
        System.out.println(" ");
        Player.ifPlayerKod();
        Logic.setDefaultDmg(27);
        Enemy.whatEnemyAmIFacing("Blackwood Royal Guards", 100, 100, 5, 5, 5, 27, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0,0, false);
        Player.playerMenuSelect();
        if (Enemy.enemyHealth <= 0)
        {
            Logic.awardXp();
            Player.goldGained(90);
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Wait, " + Player.getUrName() + ". It's not over yet. There are more coming from the left.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.getUrName() + ": Fuck! Are you serious?!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: Of course I am! Look!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("The royal guards rush at you, they just keep coming and coming!");
            Logic.timeDelay();
            System.out.println(" ");
            Player.ifPlayerKod();
            Logic.setDefaultDmg(30);
            Enemy.whatEnemyAmIFacing("Blackwood Royal Guards", 120, 120, 5, 5, 5, 30, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0,0, false);
            Player.playerMenuSelect();
            if (Enemy.enemyHealth <= 0)
            {
                Logic.awardXp();
                Player.goldGained(100);
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("After a long struggle, the guards finally seem to drop down.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": Finally, it's over! If that continued for even a bit longer, we would have been");
                System.out.println("in trouble..");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray seems to be out of breath, slowly nodding his head in agreement.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: I hope you do realize, he will not forgive us for what we've done.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": Well we didn't come this long for nothing. Let's go.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: . . .");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray and " + Player.getUrName() + " arrive to the royal room, sprinting.");
                System.out.println("The prince sits in his throne quietly, with nothing to say.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("He slowly gets off his chair, clapping.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Sora: Bravo. Bravo. Truly bravo, heroes.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": So you're the prince huh, you're more jacked than I thought.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Sora: . . .");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Sora: I think it's only fitting that I give you a nice welcoming for all your efforts, terrorists.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("HE'D FUCKING TAKE HIS SHIRT OFF.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: . . !");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": HOLY SHIT! He's jacked as hell!");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: Wait! We just want to talk, we're not terrorists. The guards weren't letting us in.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Sora: And so that gives you permission to barge in as you please, hmm?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("HE'D FUCKING FLEX");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Ray: It was his idea, not mine..");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": Quit shifting the blame on me, alright?");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("Sora: Don't worry. I'll... give a fitting punishment for the both of you.");
                Logic.timeDelay();
                System.out.println(" ");
                System.out.println("HE'D FUCKING CRACK HIS KNUCKLES AND RUSH");
                Logic.timeDelay();
                System.out.println(" ");
                Player.ifPlayerKod();
                Logic.setDefaultDmg(26);
                Enemy.whatEnemyAmIFacing("Sora", 160, 160, 10, 10, 6, 24, "Mana Slash", 5, 26, 100, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, true);
                Player.playerMenuSelect();
                if (Enemy.enemyHealth <= 0)
                {
                    Logic.awardXp();
                    Player.goldGained(300);
                    soraDefeat();
                }






            }


        }

    }

    public void soraDefeat()
    {
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Argh!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": Finally!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("You and Ray are both completely exhausted and burned out.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Tsch.. you thugs are tough..");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: What is this madness?! What do you want from me?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": Like we said earlier, we're here to talk. We don't");
        System.out.println("want to hurt you.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: You went through all this trouble just to talk to me? You knocked down all my guards!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Do not worry. They're not dead. I actually wanted to meet you as well in secret, to be honest.");
        System.out.println("However, I couldn't have approached without the support of " + Player.urName + ".");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: . . .");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Fine then. What is it?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Let me speak first, I am trying to gather a group. No ordinary group, I need powerful allies to join");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("me for what I'm about to do.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": What are you talking about, Ray? You never told me any of this.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I know. I'm sorry, but here I am telling it now, so listen closely.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I understand you have a kingdom to protect, you have a sister you need to take care of, and you");
        System.out.println("are a very busy man. But I am willing to offer a high amount of gold if you accept.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Very well, speak.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: In recent years, as you may know, your majesty has paired up with Big E to take over the empire");
        System.out.println("nationwide. He's becoming an increasingly bigger threat as the day passes, and there is no stop");
        System.out.println("to his colonising.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: It will not take him very long before Blackwood too perishes under the hands of King William himself.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: If something of such a catastrophe would occur, I am afraid that most of your loved ones and this");
        System.out.println("kingdom would fall under their corrupt hands. I am not sure who he has allied with, but they're certainly very");
        System.out.println("big threats.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: What you say is true of course, but the law cannot permit Sir William to do such a thing. You do realize");
        System.out.println("that the only parts he has colonised are small villages, yes?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I understand your point, Sora. However, this is apart of his plan, of course he's not going to attack");
        System.out.println("now, but trust me when I say I know the nature of that man, and I know what he's plotting.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: You? What would you know about his majesty?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: . . .");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I cannot say what I know, but you have to believe m-");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Enough, I have heard enough horseshit out of your ass.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": Wait, Sora.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Hm..?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": It's true we have no evidence of his majesty plotting such an event, this is the");
        System.out.println("first time that I have heard this as well. But the fact that Ray kept this hidden from me, and went");
        System.out.println("through all of this just to tell this to you convinces me that he is telling the truth.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: . . .");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: So what do you want me to do? I certainly cannot leave this Kingdom and my little sister behind.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: I'm sorry to say, but they will die if we don't take action now. Even though the King is a powerful force");
        System.out.println("we can still stop him while we still can. He does not have many allies.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Many allies..? He is the King! He has every ally you can think of! And besides, what are we");
        System.out.println("supposed to do to stop him?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: That's why we must gather a team. With your influence as a Prince, we can recruit people to join us.");
        System.out.println("But it's only possible with your help. Without you, we cannot do this. Please, I beg of you.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: . . .");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Fine, I will join. But my younger sister Mia will be coming along as well, I have to make sure");
        System.out.println("she is safe. And I cannot leave until I find someone to run the kingdom for me.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: That's fine. Thank you so much.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: You may be dismissed.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(ANSI_BLUE + "Sora has officially joined your party!" + ANSI_RESET);
        Logic.timeDelay();
        System.out.println(" ");
        allies.allyReceived("Sora");
        Player.theHub();


    }

    public void leavingBlackwood()
    {
        Logic.save2_2 = false;
        Logic.save2_3 = true;
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("After two days, Sora announces that he will no longer be ruling the kingdom of Blackwood, and that");
        System.out.println("he will be going on an expedition with his sister, Mia. However, some citizens remain suspicious about");
        System.out.println("what Prince Sora's true intentions for leaving were.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": Looks like we're all here. Me, Ray, Andrew, and Sora.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: It's an honour to meet you, Prince.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: It is nice to meet you");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: I hope you know that the two of them came here because of me.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Oh, interesting.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Andrew: Indeed.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Yeah.. anyways, Sora, you have your own ship right?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Yes.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Ok, can you show us it please?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Yes. Follow me.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("You follow Sora over to the Blackwood dock, he shows off his marvelous first-class ship.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": WHOA! This thing is HUGE!");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Holy shit...");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Heh, ya like it?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Definitely. I'm impressed. How much did it cost?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: A couple million gold.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": Jesus Christ.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Well, it's not that surprising since you are a prince after all.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": True.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: We should prepare to set sail.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Where are we going?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: To recruit more people.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Sora: Sounds like a plan.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Great. Everybody pack up your things and get ready to set sail.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("The group heads on to the big boat, making preparations to find their next");
        System.out.println("ally.");
        // CH 3 METHOD INSERT






    }

    public void sneakIn()
    {
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + " and Ray sneak in carefully, trying not to make any sound to remain inconspicuous.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Is the coast clear?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": I think so..");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("You jump inside the window with no hesitation.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: You idiot. Be more careful when sneaking in.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": My bad. My bad.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Anyways, what do we do from here?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + ": Let's climb the staircase, without getting caught of course.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Sounds like a plan.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println(Player.urName + " and Ray climb the long staircase, it seems like there are only two paths at this point.");
        System.out.println("One staircase that goes right, and one staircase that goes left. Which do you choose?");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("WHICH WAY?");
        System.out.println("1) RIGHT");
        System.out.println("2) LEFT");
        Scanner stair = new Scanner(System.in);
        String stairInput = stair.nextLine();
        switch (stairInput)
        {
            case "1" -> goRight();
            case "2" -> goLeft();
        }


    }

    public void goLeft()
    {
        System.out.println("You decide to go left, it seems like this is the right way. There are few guards nearby.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("Ray: Good, now we just have to be careful and not make any sound. If we do, we're as good as done.");
        Logic.timeDelay();
        System.out.println(" ");
        System.out.println("As soon as Ray says that, a bunch of guards notice you and rush at you!");
        Logic.setDefaultDmg(27);
        Enemy.whatEnemyAmIFacing("Blackwood Royal Guards", 120, 120, 5, 5, 5, 27, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0,0, false);
        Player.playerMenuSelect();
        if (Enemy.enemyHealth <= 0)
        {
            Logic.awardXp();
            Player.goldGained(90);
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: We're lucky we didn't get caught by the other guards. We need to hurry up.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ": Yeah, let's go.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("It doesn't take much longer until you arrive in the throne room, meeting Prince Sora himself.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Sora: Hm?! Who are you?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: We're authorized to come in.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Sora: I don't see your armour on, intruders.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ": Shit.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ": Listen man, we're not here to cause trouble.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Sora: Yeah, yeah.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Sora: I've heard that line a thousand times before.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("HE'D FUCKING RIP HIS SHIRT OFF.");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("HE'D FUCKING FLEX");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println(Player.urName + ": HOLY SHIT!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Ray: I didn't expect him to be this strong, be careful, " + Player.urName + "!");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Sora: Let's have some fun, shall we, Heroes?");
            Logic.timeDelay();
            System.out.println(" ");
            System.out.println("Sora rushes at you with full speed!");
            Logic.timeDelay();
            System.out.println(" ");
            Player.ifPlayerKod();
            Logic.setDefaultDmg(26);
            Enemy.whatEnemyAmIFacing("Sora", 160, 160, 10, 10, 6, 26, "Mana Slash", 5, 26, 100, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, 0, true);
            Player.playerMenuSelect();
            if (Enemy.enemyHealth <= 0)
            {
                Logic.awardXp();
                Player.goldGained(300);
                soraDefeat();
            }


        }

    }



}



