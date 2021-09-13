package gamePackage;

import javax.swing.*;

public class Player extends Person {
    private int health = 100;
    private int money = 0;
    private int points = 0;
    int currentX;
    int currentY;
    private int doorsOpened = 0;
    int oneMove = 1;

    public Player(String name) {
        super(name);
    }

    public Player() {
        super();
    }

    public int getDoorsOpened() {
        return this.doorsOpened;
    }

    public void doorsOpenedIncrease(int points) {
        this.doorsOpened += points;
    }

    public int getPoints() {
        return this.points;
    }

    public void initPlacing(Field f) {
        int x, y;
        do {
            x = (int) (Math.random() * f.x);
            y = (int) (Math.random() * f.y);
        } while (!f.cells[x][y].equals("."));
        this.currentX = x;
        this.currentY = y;
        f.cells[x][y] = "@";
    }

    public void showInfo() {
        System.out.println(this.getName() + "," +
                "\n" + "Your hp: " + this.health +
                "\n" + "Your money: " + this.money +
                "\n" + "Your points: " + this.points +
                "\n" + "Doors opened: " + this.doorsOpened);
    }

    public void healthDecrease(int points) {
        if (this.health - points <= 0) {
            this.death();
        } else {
            this.health -= points;
        }
    }

    public void healthIncrease(int points) {
        this.health += points;
    }

    public void pointsIncrease(int points) {
        this.points += points;
    }

    public void moneyIncrease(int points) {
        this.money += points;
    }

    public void death() {
        String[] answers = {"respawn for 30 coins", "Game over"};
        int ans = JOptionPane.showOptionDialog(null,
                "You have been died", "Death",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                answers, answers[1]);
        if (ans == 1) System.exit(1);
        else {
            if (this.money > 29) {
                this.money -= 30;
                this.health += 50;
                this.showInfo();
            } else {
                JOptionPane.showMessageDialog(null, "no enough money. Your game is over");
                System.exit(1);
            }
        }
    }

    public void step(Field f) {
        this.healthDecrease(3);
        int newX = 0;
        int newY = 0;
        int step;
        boolean mayGo;
        String[] directions = {"N-E", "S-E", "W", "E", "N-W", "S-W"};
        do {
            step = JOptionPane.showOptionDialog(null,
                    "Choose direction:" + "\n" +
                            "N-E -> NORTH-EAST" + "\n" +
                            "S-E -> SOUTH-EAST" + "\n" +
                            "W -> WEST" + "\n" +
                            "E -> EAST" + "\n" +
                            "N-W -> NORTH-WEST" + "\n" +
                            "S-W -> SOUTH-WEST" + "\n", "Next step",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    directions, directions[0]);
            mayGo = this.checkAbilityToGo(step, f);
        } while (!mayGo);
        switch (step) {
            case 0 -> {
                newY = this.currentY;
                if(this.currentX%2 == 0) newY+=oneMove;
                newX = this.currentX - oneMove;
            }
            case 1 -> {
                newY = this.currentY;
                if(this.currentX%2 == 0) newY+=oneMove;
                newX = this.currentX + oneMove;
            }
            case 2 -> {
                newY = this.currentY - oneMove;
                newX = this.currentX;
            }
            case 3 -> {
                newY = this.currentY + oneMove;
                newX = this.currentX;
            }
            case 4 -> {
                newY = this.currentY - oneMove;
                if(this.currentX%2 == 0) newY+=oneMove;
                newX = this.currentX - oneMove;
            }
            case 5 -> {
                newY = this.currentY - oneMove;
                if(this.currentX%2 == 0) newY+=oneMove;
                newX = this.currentX + oneMove;
            }
        }
        this.cellsRenewal(f, newX, newY);
    }


    public void cellsRenewal(Field f, int newX, int newY){
        f.cells[this.currentX][this.currentY] = ".";
        this.currentX = newX;
        this.currentY = newY;

        if (f.cells[this.currentX][this.currentY].equals("#"))
            this.healthDecrease(10);
        else if (!f.cells[this.currentX][this.currentY].equals(".")) {
            this.moneyIncrease(Integer.parseInt(f.cells[this.currentX][this.currentY]));
            this.pointsIncrease(1);
        }

        f.cells[this.currentX][this.currentY] = "@";
    }


    public boolean checkAbilityToGo(int step, Field f){
        boolean mayGo = true;
        switch (step) {
            case 0:
                if (this.currentX == 0) {
                    mayGo = false;
                    System.out.print("Choose another direction" + "\n");
                }
                break;

            case 1:
                if (this.currentX == f.x - oneMove) {
                    mayGo = false;
                    System.out.print("Choose another direction" + "\n");
                }
                break;
            case 2:
                if (this.currentY == 0) {
                    mayGo = false;
                    System.out.print("Choose another direction" + "\n");
                }
                break;
            case 3:
                if (this.currentY == f.y - oneMove) {
                    mayGo = false;
                    System.out.print("Choose another direction" + "\n");
                }
                break;
            case 4:
                if ((this.currentX == 0)||(this.currentY == 0)) {
                    mayGo = false;
                    System.out.print("Choose another direction" + "\n");
                }
                break;
            case 5:
                if ((this.currentX == f.x - oneMove)||(this.currentY == 0)) {
                    mayGo = false;
                    System.out.print("Choose another direction" + "\n");
                }
                break;
            default:
                throw new IllegalStateException("program cancelled");
        }
        return mayGo;
    }

}