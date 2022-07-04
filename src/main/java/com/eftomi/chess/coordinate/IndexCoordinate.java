package com.eftomi.chess.coordinate;

public class IndexCoordinate {
    private int row;        // 0-7
    private int column;     // 0-7

    public IndexCoordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public IndexCoordinate() {}

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}
