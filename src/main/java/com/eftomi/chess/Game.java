package com.eftomi.chess;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new Game().run(scanner);
    }

    private void run(Scanner scanner) {
        ChessBoard chessBoard = new ChessBoard();
        Move move = new Move();
        chessBoard.createBasicLineup();

        boolean end = true;
        boolean correctStep;
        while (end) {
            chessBoard.draw();
            do {
                System.out.print("Give in the coordinate of the piece to be moved: ");
                String fromCoordinateString = scanner.nextLine();
                System.out.print("Give in the goal coordinates of the piece: ");
                String toCoordinateString = scanner.nextLine();
                move.setFromHumanCoordinate(fromCoordinateString);
                move.setToHumanCoordinate(toCoordinateString);
                String playerChessPieceString = chessBoard.getPlayerChessPieceString(move.getFromHumanCoordinate());
                correctStep = chessBoard.checkMove(move, playerChessPieceString);
                if (!correctStep) {
                    System.out.println("\tIncorrect step trial from player [" + playerChessPieceString.charAt(0) + "] with chess piece ["
                            + playerChessPieceString.charAt(1) + "] from coordinate [" + fromCoordinateString + "], please enter new coordinates!");
                }
            } while (!correctStep);
            chessBoard.makeMove(move);
        }
        chessBoard.draw();
        // displayResults();
    }

}
