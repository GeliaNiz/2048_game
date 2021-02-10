package sample;

import sample.Cell;

import java.util.Random;

public class Field {
    private final int size = 4;
    final private Cell[][] pole = new Cell[size][size];
    final private Random random = new Random();

    public void initialize() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pole[i][j] = new Cell(0);
            }
        }
        double a = Math.random();
        int startX = random.nextInt(size);
        int startY = random.nextInt(size);
        if (a <= 0.8) pole[startX][startY] = new Cell(2);
        else {
            pole[startX][startY] = new Cell(4);
        }
        startX = random.nextInt(size);
        startY = random.nextInt(size);
        while (pole[startX][startY].getValue() != 0) {
            startX = random.nextInt(size);
            startY = random.nextInt(size);
        }
        a = Math.random();
        if (a <= 0.8) pole[startX][startY] = new Cell(2);
        else {
            pole[startX][startY] = new Cell(4);
        }
    }

    public Field() {
        initialize();
    }

    void move(int direction) {
        switch (direction) {
            case 37 -> {
                for (int i = 0; i < size; i++) {
                    changeRow(37, i);
                }
                generateCell();
            }
            case 38 -> {
                for (int i = 0; i < size; i++) {
                    changeColumn(38, i);
                }
                generateCell();
            }
            case 39 -> {
                for (int i = 0; i < size; i++) {
                    changeRow(39, i);
                }
                generateCell();
            }
            case 40 -> {
                for (int i = 0; i < size; i++) {
                    changeColumn(40, i);
                }
                generateCell();
            }
        }
    }

    void changeRow(int direction, int i) {
        if (direction == 37) {
            for (int j = 1; j < size; j++) {
                if (pole[i][j].getValue() != 0) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (pole[i][k].getValue() == 0) {
                            pole[i][k].setValue(pole[i][k + 1].getValue());
                            pole[i][k + 1].setValue(0);
                        }
                    }
                }
            }
            for (int j = 0; j < size - 1; j++) {
                if (pole[i][j].getValue() == pole[i][j + 1].getValue()) {
                    pole[i][j].setValue(pole[i][j].getValue() + pole[i][j + 1].getValue());
                    pole[i][j+1].setValue(0);
                    for (int k = j + 1; k < size - 1; k++) {
                        pole[i][k].setValue(pole[i][k + 1].getValue());
                        pole[i][k+1].setValue(0);
                    }
                }
            }
        } else if (direction == 39) {
            for (int j = size - 1; j >= 0; j--) {
                if (pole[i][j].getValue() != 0) {
                    for (int k = j + 1; k < size; k++) {
                        if (pole[i][k].getValue() == 0) {
                            pole[i][k].setValue(pole[i][k - 1].getValue());
                            pole[i][k - 1].setValue(0);
                        }
                    }
                }
            }
            for (int j = size - 1; j > 0; j--) {
                if (pole[i][j].getValue() == pole[i][j - 1].getValue()) {
                    pole[i][j].setValue(pole[i][j].getValue() + pole[i][j - 1].getValue());
                    pole[i][j-1].setValue(0);
                    for (int k = j - 1; k > 1; k--) {
                        pole[i][k].setValue(pole[i][k - 1].getValue());
                        pole[i][k-1].setValue(0);
                    }
                }
            }
        }
    }
    void changeColumn(int direction, int i){
            if(direction==38) {
                for (int j = 1; j < size; j++) {
                    if (pole[j][i].getValue() != 0) {
                        for (int k = j - 1; k >= 0; k--) {
                            if (pole[k][i].getValue() == 0) {
                                pole[k][i].setValue(pole[k + 1][i].getValue());
                                pole[k + 1][i].setValue(0);
                            }
                        }
                    }
                }
                for (int j = 0; j < size - 1; j++) {
                    if (pole[j][i].getValue() == pole[j + 1][i].getValue()) {
                        pole[j][i].setValue(pole[j][i].getValue() + pole[j + 1][i].getValue());
                        pole[j + 1][i].setValue(0);
                        for (int k = j + 1; k < size - 1; k++) {
                            pole[k][i].setValue(pole[k + 1][i].getValue());
                            pole[k + 1][i].setValue(0);
                        }
                    }
                }
            }
            else if(direction==40){
                for(int j=size-1;j>=0;j--){
                    if(pole[j][i].getValue()!=0){
                        for(int k=j+1;k<size;k++){
                            if(pole[k][i].getValue()==0){
                                pole[k][i].setValue(pole[k-1][i].getValue());
                                pole[k-1][i].setValue(0);
                            }
                        }
                    }
                }
                for (int j = size - 1; j > 0; j--) {
                    if (pole[j][i].getValue() == pole[j-1][i].getValue()) {
                        pole[j][i].setValue(pole[j][i].getValue() + pole[j-1][i].getValue());
                        pole[j-1][i].setValue(0);
                        for (int k = j - 1; k > 1; k--) {
                            pole[k][i].setValue(pole[k-1][i].getValue());
                            pole[k-1][i].setValue(0);
                        }
                    }
                }
            }

            }
    void generateCell() {
        int startX = random.nextInt(size);
        int startY = random.nextInt(size);
        if (pole[startX][startY].getValue() != 0) {
            while (pole[startX][startY].getValue() != 0) {
                startX = random.nextInt(size);
                startY = random.nextInt(size);
            }
        } else {
            double a = Math.random();
            if (a <= 0.8) pole[startX][startY].setValue(2);
            else {
                pole[startX][startY].setValue(4);
            }
        }
    }
    void print(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.printf("%d ",pole[i][j].getValue());

            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public Cell[][] getPole() {
        return pole;
    }
}


