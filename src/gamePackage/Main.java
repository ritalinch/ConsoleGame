package gamePackage;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		Instruction.startingIntro();
		Instruction.fieldCreation();
		Field Game = new Field(15,25);//by default
		Player you = new Player();

		try {
			you = new Player(JOptionPane.showInputDialog(null, "Enter the name of you character"));
		} catch (IllegalArgumentException e) {
			System.err.println("\n" +
					"Please, follow the instructions to  complete the game successfully");
		}

		Field additionalQuest = new Field (5, 9);
		additionalQuest.addQuestFill();

		Instruction.beforeStart();

		NPC firstNPC = new NPC("Zem");
		NPC secondNPC = new NPC("Mia");
		NPC thirdNPC = new NPC("Negos");

		Game.fill();
		you.initPlacing(Game);
		Game.showField();

		do {
			try {
				you.step(Game);
			} catch (IllegalStateException ex){
				System.err.print("Program was cancelled");
				System.exit(1);
			}
			Game.showField();
			System.out.println("to start additional quest collect 10 points");
			you.showInfo();
			if (you.getPoints() >= 10) {
				you.pointsIncrease(-10);
				Quest.additionalGame(you, additionalQuest, firstNPC, secondNPC, thirdNPC);
				if(you.getDoorsOpened() != 3){
					Game.fill();
					you.initPlacing(Game);
					Game.showField();
				}
			}
		} while(you.getDoorsOpened() != 3);

		System.out.println("CONGRATULATIONS!!! YOU WON)");
	}
}