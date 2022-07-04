package com.eftomi.chess.coordinate;

public class HumanCoordinate {
    private int row;        // 1-8
    private char column;    // A-H

    public HumanCoordinate(int row, char column) {
        this.row = row;
        this.column = column;
    }

    public HumanCoordinate() {}

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

}
