package gamePackage;

public class Field {

    int x;
    int y;
    String[][] cells;

    public Field (int x, int y){
        this.x = x;
        this.y = y;
        this.cells = new String[x][y];
    }

    public void fill(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cells[i][j] = cellFilling();
            }
        }
    }

    public static String cellFilling(){
        if(Math.random()<0.1)
            return "" + (int)(Math.random()*9 + 1);
        else if (Math.random() >= 0.1 && Math.random() <= 0.2)
            return "#";
        else
            return ".";
    }

    public void showField(){
        for (int i = 0; i < x; i++) {
            if(i%2 == 0) System.out.print (" ");
            for (int j = 0; j < y; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addQuestFill(){
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 9; j++){
                this.cells[i][j] = " ";
            }
        }

        this.cells[4][0] = "NPC1";
        this.cells[0][4] = "NPC2";
        this.cells[4][8] = "NPC3";
        this.cells[4][4] = "@";
    }
}