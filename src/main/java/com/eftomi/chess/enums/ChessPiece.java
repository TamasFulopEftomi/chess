package com.eftomi.chess.enums;

import com.eftomi.chess.Move;

public enum ChessPiece {
    KING('K') {
        @Override
        public boolean regularStep(Move move, char playerSign, char chessPieceSign) {
            boolean regularStep = true;
            if (!(chessPieceSign == getSign())) {
                regularStep = true;
            } else {

            }
            return regularStep;
        }
    },
    QUEEN('V') {
        @Override
        public boolean regularStep(Move move, char playerSign, char chessPieceSign) {
            boolean regularStep = true;
            if (!(chessPieceSign == getSign())) {
                regularStep = true;
            } else {

            }
            return regularStep;
        }
    },
    BISHOP('F') {
        @Override
        public boolean regularStep(Move move, char playerSign, char chessPieceSign) {
            boolean regularStep = true;
            if (!(chessPieceSign == getSign())) {
                regularStep = true;
            } else {

            }
            return regularStep;
        }
    },
    KNIGHT('H') {
        @Override
        public boolean regularStep(Move move, char playerSign, char chessPieceSign) {
            boolean regularStep = true;
            if (!(chessPieceSign == getSign())) {
                regularStep = true;
            } else {

            }
            return regularStep;
        }
    },
    ROOK('B') {
        @Override
        public boolean regularStep(Move move, char playerSign, char chessPieceSign) {
            boolean regularStep = true;
            if (!(chessPieceSign == getSign())) {
                regularStep = true;
            } else {

            }
            return regularStep;
        }
    },
    PAWN('G') {
        @Override
        public boolean regularStep(Move move, char playerSign, char chessPieceSign) {
            boolean sameColumn = move.getFromHumanCoordinate().getColumn() == move.getToHumanCoordinate().getColumn();
            boolean stepFromBlackBaseline = playerSign == Player.BLACK.getSign() && move.getFromHumanCoordinate().getRow() == 2 &&
                    (move.getToHumanCoordinate().getRow() == 3 || move.getToHumanCoordinate().getRow() == 4);
            boolean stepFromWhiteBaseLine = playerSign == Player.WHITE.getSign() && move.getFromHumanCoordinate().getRow() == 7 &&
                    (move.getToHumanCoordinate().getRow() == 6 || move.getToHumanCoordinate().getRow() == 5);
            boolean blackStepAheadFromOtherField = playerSign == Player.BLACK.getSign() && move.getFromHumanCoordinate().getRow() != 2 &&
                    (move.getFromHumanCoordinate().getRow() == move.getToHumanCoordinate().getRow() + 1 ||
                    move.getFromHumanCoordinate().getRow() == move.getToHumanCoordinate().getRow() - 1);
            boolean whiteStepAheadFromOtherField = playerSign == Player.WHITE.getSign() && move.getFromHumanCoordinate().getRow() != 7 &&
                    (move.getFromHumanCoordinate().getRow() == move.getToHumanCoordinate().getRow() + 1 ||
                            move.getFromHumanCoordinate().getRow() == move.getToHumanCoordinate().getRow() - 1);
            boolean regularStep = true;
            if (!(chessPieceSign == getSign())) {
                regularStep = true;
            } else if (sameColumn && (stepFromBlackBaseline || stepFromWhiteBaseLine || whiteStepAheadFromOtherField ||
                    blackStepAheadFromOtherField)) {
                regularStep = true;
            } else {
                regularStep = false;
            }
            return regularStep;
        }
    };

    private char sign;

    ChessPiece(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

    public boolean regularStep(Move move, char playerSign, char chessPieceSign) {
        return true;
    }

}
