package sample;

public class ChapterThree extends Main {
    static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public void chapterThreeEntry()
    {
        System.out.println(" ");
        System.out.println("CHAPTER 3");
        System.out.println("-------------");
        System.out.println("The Stolen God Arm");
        System.out.println("After leaving Blackwood with Sora, the group heads to sea with no current");
        System.out.println("destination in mind.");
        System.out.println("Andrew: Well, where are we going next?");
        System.out.println(Player.getUrName() + ": I'm not sure. Andrew, you were saying something about");
        System.out.println("a priest earlier in Blackwood. What was that about?");
        System.out.println("Andrew: Oh, right.");
        System.out.println("Andrew: Saint Joseph. He is apart of the Catholic Church, a dangerous individual though.");
        System.out.println(Player.getUrName() + ": Wait, if he's apart of the Church. How can he be bad?");
        System.out.println("Andrew: He disobeyed the church's orders. He has stolen a valuable relic, called the" + ANSI_BLUE + " God Arm." + ANSI_RESET);
        System.out.println(Player.getUrName() + ": God Arm..?");
        System.out.println("Andrew: That's right. It is an extremely valuable weapon, there are only a dozen or so in the world.");
        System.out.println(Player.getUrName() + ": Jesus..");
        System.out.println("Sora: The God Arm.. hmm?");
        System.out.println("Sora: How powerful is he?");
        System.out.println("Andrew: With the God Arm, he is very strong.");
        System.out.println("Sora: Hmm, this could be troublesome then. Even for me.");
        System.out.println("Andrew: That's right prince. This is no ordinary foe we're facing.");
        System.out.println(Player.getUrName() + ": But what does this have to do with you?");
        print("Andrew: What? Don't you understand? He's worth millions!");
        you("Just for some stupid God Arm?");
        print("Andrew: These weapons are valuable, " + Player.getUrName() + " it is no");
        System.out.println("mere stupid weapon.");
        you("Ok, fair enough. But how are we gonna be able to take him down?");
        print("Ray: Can't we gather more allies?");
        you("Where will we get them from?");
        print("Ray: Well, I can't act like I know myself. But I know that there are plenty");
        System.out.println("of mercenaries and bounty hunters available for hire.");
        you("It's unlikely that we'll be able to get somebody that will be up for the task.");
        print("Ray: It doesn't hurt to try, does it?");
        you("I.. I suppose not.");
        print("Sora: I have plenty of gold, folks. So we'll hire the best ones.");
        print("Andrew: It's nice to have you on the team, Prince.");
        print("Sora: Heh.");
        you("Anyways, let's get going. Where is the priest located, Andrew?");
        print("Andrew: In the capital of Adria.");
        you("Alright then, let's begin to set sail for Adria everyone.");
        print("Ray: Roger that.");
        introToAdria();
    }

    public void introToAdria(){
        Logic.save2_3 = false;
        Logic.save3_1 = true;
        Logic.timeDelay();
        print("After a couple of days of sailing on sea, the crew finally arrives to the city of Adria.");
        System.out.println("The landscape seems to be quite beautiful.");
        print("DIALOGUE");
        System.out.println("1) This city is beautiful.");
        System.out.println("2) Are we in the capital?");
        System.out.println("3) This place is uglier than I thought.");
        userInput();
        switch (getInput()){
            default -> {
                System.out.println(" ");
                System.out.println(Player.getUrName() + ": This city is beautiful.");
                print("Sora: Indeed.");
                print("Ray: There's little time for sight-seeing, we need to head to the");
                System.out.println("capital immediately.");
                print("Andrew: I don't think there's a need to rush things so quickly.");
                System.out.println("It is highly unlikely that we will be able to find the priest");
                System.out.println("at a time like this.");
                print("Sora: True. I think it will be more beneficial to us if we gather supplies first.");
                you("I'm inclined to agree with Sora and Andrew, I think this is for the best. A");
                System.out.println("short stop won't hurt anyone.");
                print("Ray: Ok then. But we will need to reunite back here at the dock.");
                you("I'm sure we can all do that. Right guys?");
                print("They all nod their head.");
                you("Great, let's get going then!");
                break;
            }
            case 2 -> {
                System.out.println(" ");
                System.out.println(Player.getUrName() + " are we in the capital?");
                print("Andrew: Not yet, we have only just arrived onto the shore.");
                you("Damn, so we still have quite a bit of distance to go then.");
                print("Andrew: Unfortunately that is the case. However, we can stop to");
                System.out.println("rest for a short period of time.");
                print("Ray: Andrew is right. We should all take a break and gather up supplies before");
                System.out.println("we continue any further.");
                print("Sora: Fine with me.");
                you("Fair enough. Where do we meet up?");
                print("Ray: By the dock, where we are right now.");
                you("Alright then, let's go.");
                break;
            }
            case 3 -> {
                System.out.println(" ");
                System.out.println("This place is uglier than I thought.");
                print("Andrew: Not true. In fact I think it is more beautiful than Blackwood.");
                print("Sora: More beautiful than Blackwood? Haha, of course not! This puny city");
                System.out.println("cannot be compared to the beauty of Blackwood.");
                print("Ray: Alright, calm down everybody. Let's leave our thoughts about");
                System.out.println("Adria to the side for now and get going for supplies.");
                you("Agreed. We're pretty low on stock anyways, I just hope that they");
                you("have good material to make up for it.");
                print("Andrew: Oh they will. Last I checked, Adria has a great weapon industry.");
                you("Good, good. Alright, where do we meet up?");
                print("Ray: We meet at the dock like last time. Take as long as you need to get");
                System.out.println("supplies but be back by tonight.");
                print("Sora: Got it.");
                you("Alright then, let's get going everybody.");
                break;
            }
        }
        Player.theHub();
    }
    public void journeyToCapital(){
        print("After gathering materials and resting, the group reunites at the dock.");
        print("Ray: Looks like everybody is here. Good.");
        print("Sora: So what's our plan?");
        print("Andrew: The plan is to infiltrate the capital and find the priest.");
        you("What is the name of this priest anyway?");
        print("Andrew: His name is Shaxx, and he is not to be messed with.");
        System.out.println("One wrong move and you'll get murdered.");
        print("Sora: I won't be getting murdered.");
        print("Andrew: You seem quite sure of yourself, Sora. Well, just don't blame");
        System.out.println("me when you end up getting butchered.");
        print("Sora: . . .");
        print("Ray: He's right, Sora. Anything can happen, this priest supposedly has");
        System.out.println("a God Arm. We cannot underestimate him no matter what.");
        print("Sora: Right... my bad.");


    }

}
