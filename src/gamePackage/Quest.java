package gamePackage;

import javax.swing.*;

public class Quest {

    public static void firstGame(NPC npc, Player you){
        JOptionPane.showMessageDialog(null, Instruction.firstGameInstruction(npc));
        String[] answers = {"58678", "45634", "58234", "34276"};
        int ans = JOptionPane.showOptionDialog(null,
                "If 'POST' is 1234, and 'FLIRT' is 56784, what is 'FROST'?" , "1st game",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                answers, answers[0]);
        switch (ans) {
            case 0, 1, 3 -> you.death();
            case 2 -> {
                you.doorsOpenedIncrease(1);
                JOptionPane.showMessageDialog(null,
                        "Congratulations, you have opened this door!");
                you.healthIncrease(50);
            }
        }
    }

    public static void secondGame(NPC npc, Player you){
        JOptionPane.showMessageDialog(null, Instruction.secondGameInstruction(npc));
        String[] answers = {"6", "17", "5", "2"};
        int ans = JOptionPane.showOptionDialog(null,
                "16 - 4 / (1/4) + 2 = ?" , "2nd game",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                answers, answers[0]);
        switch (ans) {
            case 0, 1, 2 -> you.death();
            case 3 -> {
                you.doorsOpenedIncrease(1);
                JOptionPane.showMessageDialog(null,
                        "Congratulations, you have opened this door!");
                you.healthIncrease(50);

            }
        }
    }

    public static void thirdGame(NPC npc, Player you){

        JOptionPane.showMessageDialog(
                null, Instruction.thirdGameInstruction(npc));
        String[] answers = {"Toronto", "Ottawa", "Montreal", "Vancouver"};
        int ans = JOptionPane.showOptionDialog(null,
                "What city is the capital of Canada" , "3rd game",
                JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                answers, answers[0]);
        switch (ans) {
            case 0, 2, 3 -> you.death();
            case 1 -> {
                you.doorsOpenedIncrease(1);
                JOptionPane.showMessageDialog(null,
                        "Congratulations, you have opened this door!");
                you.healthIncrease(50);
            }
        }
    }

    public static boolean additionalGame(Player you, Field map, NPC _1npc, NPC _2npc, NPC _3npc) {
        boolean flag = true;
        map.showField();
        switch (you.getDoorsOpened()) {
            case 0 -> {
                JOptionPane.showMessageDialog(null,
                        "you have met the first npc");
                map.cells[4][4] = ".";
                map.cells[4][1] = "@";
                map.showField();
                Quest.firstGame(_1npc, you);
            }
            case 1 -> {
                JOptionPane.showMessageDialog(null,
                        "you have met the second npc");
                map.cells[4][4] = ".";
                map.cells[1][4] = "@";
                map.showField();
                Quest.secondGame(_2npc, you);
            }
            case 2 -> {
                JOptionPane.showMessageDialog(null,
                        "you have met the third npc");
                map.cells[4][4] = ".";
                map.cells[4][7] = "@";
                map.showField();
                Quest.thirdGame(_3npc, you);
                flag =  false;
            }
        }
        return flag;
    }
}
