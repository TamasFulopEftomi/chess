package com.eftomi.chess.enums;

public enum Player {
    WHITE('x'),
    BLACK('o');

    private char sign;

    Player(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

}
