package gamePackage;

public class Instruction
{
    public static void startingIntro ()
    {
        System.out.println("\n" + "3 DOORS"  + "\n" +
                "Thank you for choosing my game)))" + "\n" +
                "You are about to entry the game field" + "\n" +
                "Your main goal is to open all doors" + "\n" +
                "Every NPC is responsible for one door" + "\n" +
                "If you die, you will be able to respawn with the same progress" + "\n" +
                "To do this you should buy elixir of rebirth, otherwise the game will be over" + "\n" +
                "So try to collect money, it will be useful:)))" + "\n" +
                "--------------------------------------------------------" + "\n" +
                "Symbols you should know:" + "\n" +
                "@ - your character" + "\n" +
                "numbers(1,2,3...) - coins you could collect" + "\n" +
                "# - rocks, if you touch them, you will loose HP" + "\n"
                );
    }
    public static void fieldCreation(){
        System.out.println("Now you will be asked to create a field" + "\n" +
                "Please, enter the size (height and width)" + "\n");
    }

    public static void beforeStart()
    {
        System.out.println("Now you will appear at the random place of the map" + "\n" +
                "Choose where you want to go (North, South, West, East)" + "\n");
    }

    public static String firstGameInstruction(NPC npc)
    {
        return "Hello, my name is " + npc.getName() +
                " and I am a keeper of the 1st door." + "\n" +
                "I would like to present you the first quest." +
                "\n" + "In this game you should guess the simple riddle." +
                "\n" + "Be attentive and confident in your answer." +
                "\n" + "If you lose you will die";
    }

    public static String secondGameInstruction(NPC npc)
    {
        return "Hello, my name is " + npc.getName() + " and I am a keeper of the 2rd door." + "\n" +
                "I would like to present you the second quest." +
                "\n" + "In this game you should guess the simple math task." +
                "\n" + "Be attentive and confident in your answer." +
                "\n" + "If you lose you will die";
    }

    public static String thirdGameInstruction(NPC npc)
    {
        return "Hello, my name is " + npc.getName() +
                " and I am a keeper of the 3rd door." + "\n" +
                "I would like to present you the third game." +
                "\n" + "In this game you should answer a simple question." +
                "\n" + "Be attentive and confident in your answer." +
                "\n" + "If you lose you will die";
    }
}
