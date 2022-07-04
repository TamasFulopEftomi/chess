package com.eftomi.chess;

import com.eftomi.chess.coordinate.HumanCoordinate;
import com.eftomi.chess.coordinate.IndexCoordinate;
import com.eftomi.chess.coordinate.Mapper;
import com.eftomi.chess.enums.ChessPiece;
import com.eftomi.chess.enums.Player;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private Mapper mapper = new Mapper();
    public static final String BLANK = "  ";
    private String[][] table = {
            {BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK},
            {BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK},
    };

    public void draw() {
        System.out.println();
        System.out.println("B: bástya, H: huszár, F: futó, K: király, V: vezér, G: gyalog\n\t\t\to: fekete\t\t\t\tx: fehér");
        System.out.println();
        System.out.println("   A  B  C  D  E  F  G  H");
        System.out.println("  +--+--+--+--+--+--+--+--+");
        System.out.printf("1 |%s|%s|%s|%s|%s|%s|%s|%s| 1%n", table[0][0], table[0][1], table[0][2], table[0][3], table[0][4], table[0][5], table[0][6], table[0][7]);
        System.out.println("  +--+--+--+--+--+--+--+--+");
        System.out.printf("2 |%s|%s|%s|%s|%s|%s|%s|%s| 2%n", table[1][0], table[1][1], table[1][2], table[1][3], table[1][4], table[1][5], table[1][6], table[1][7]);
        System.out.println("  +--+--+--+--+--+--+--+--+");
        System.out.printf("3 |%s|%s|%s|%s|%s|%s|%s|%s| 3%n", table[2][0], table[2][1], table[2][2], table[2][3], table[2][4], table[2][5], table[2][6], table[2][7]);
        System.out.println("  +--+--+--+--+--+--+--+--+");
        System.out.printf("4 |%s|%s|%s|%s|%s|%s|%s|%s| 4%n", table[3][0], table[3][1], table[3][2], table[3][3], table[3][4], table[3][5], table[3][6], table[3][7]);
        System.out.println("  +--+--+--+--+--+--+--+--+");
        System.out.printf("5 |%s|%s|%s|%s|%s|%s|%s|%s| 5%n", table[4][0], table[4][1], table[4][2], table[4][3], table[4][4], table[4][5], table[4][6], table[4][7]);
        System.out.println("  +--+--+--+--+--+--+--+--+");
        System.out.printf("6 |%s|%s|%s|%s|%s|%s|%s|%s| 6%n", table[5][0], table[5][1], table[5][2], table[5][3], table[5][4], table[5][5], table[5][6], table[5][7]);
        System.out.println("  +--+--+--+--+--+--+--+--+");
        System.out.printf("7 |%s|%s|%s|%s|%s|%s|%s|%s| 7%n", table[6][0], table[6][1], table[6][2], table[6][3], table[6][4], table[6][5], table[6][6], table[6][7]);
        System.out.println("  +--+--+--+--+--+--+--+--+");
        System.out.printf("8 |%s|%s|%s|%s|%s|%s|%s|%s| 8%n", table[7][0], table[7][1], table[7][2], table[7][3], table[7][4], table[7][5], table[7][6], table[7][7]);
        System.out.println("  +--+--+--+--+--+--+--+--+");
        System.out.println("   A  B  C  D  E  F  G  H");
    }

    public boolean checkMove(Move move, String playerChessPieceString) {
        String parts[] = playerChessPieceString.split("");
        char playerSign = parts[0].charAt(0);
        char chessPieceSign = parts[1].charAt(0);
        for (ChessPiece chessPiece : ChessPiece.values()) {
            if (!chessPiece.regularStep(move, playerSign, chessPieceSign)) {
                return false;
            }
        }
        return true;
    }

    public void makeMove(Move move) {
        IndexCoordinate fromIndexCoordinate = mapper.createIndexCoordinate(move.getFromHumanCoordinate());
        String actualPlayersChessPiece = table[fromIndexCoordinate.getRow()][fromIndexCoordinate.getColumn()];
        IndexCoordinate toIndexCoordinate = mapper.createIndexCoordinate(move.getToHumanCoordinate());
        table[fromIndexCoordinate.getRow()][fromIndexCoordinate.getColumn()] = BLANK;
        table[toIndexCoordinate.getRow()][toIndexCoordinate.getColumn()] = actualPlayersChessPiece;
    }

    public void createBasicLineup() {
        Map<HumanCoordinate, PlayerChessPiece> basicLineup = new HashMap<>();
        Player blackPlayer = Player.BLACK;
        Player whitePlayer = Player.WHITE;
        ChessPiece kingChessPiece = ChessPiece.KING;
        ChessPiece queenChessPiece = ChessPiece.QUEEN;
        ChessPiece bishopChessPiece = ChessPiece.BISHOP;
        ChessPiece knightChessPiece = ChessPiece.KNIGHT;
        ChessPiece rookChessPiece = ChessPiece.ROOK;
        ChessPiece pawnChessPiece = ChessPiece.PAWN;

        basicLineup.put(new HumanCoordinate(1, 'A'), new PlayerChessPiece(blackPlayer, rookChessPiece));
        basicLineup.put(new HumanCoordinate(1, 'B'), new PlayerChessPiece(blackPlayer, knightChessPiece));
        basicLineup.put(new HumanCoordinate(1, 'C'), new PlayerChessPiece(blackPlayer, bishopChessPiece));
        basicLineup.put(new HumanCoordinate(1, 'D'), new PlayerChessPiece(blackPlayer, kingChessPiece));
        basicLineup.put(new HumanCoordinate(1, 'E'), new PlayerChessPiece(blackPlayer, queenChessPiece));
        basicLineup.put(new HumanCoordinate(1, 'F'), new PlayerChessPiece(blackPlayer, bishopChessPiece));
        basicLineup.put(new HumanCoordinate(1, 'G'), new PlayerChessPiece(blackPlayer, knightChessPiece));
        basicLineup.put(new HumanCoordinate(1, 'H'), new PlayerChessPiece(blackPlayer, rookChessPiece));
        basicLineup.put(new HumanCoordinate(2, 'A'), new PlayerChessPiece(blackPlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(2, 'B'), new PlayerChessPiece(blackPlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(2, 'C'), new PlayerChessPiece(blackPlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(2, 'D'), new PlayerChessPiece(blackPlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(2, 'E'), new PlayerChessPiece(blackPlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(2, 'F'), new PlayerChessPiece(blackPlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(2, 'G'), new PlayerChessPiece(blackPlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(2, 'H'), new PlayerChessPiece(blackPlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(7, 'A'), new PlayerChessPiece(whitePlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(7, 'B'), new PlayerChessPiece(whitePlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(7, 'C'), new PlayerChessPiece(whitePlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(7, 'D'), new PlayerChessPiece(whitePlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(7, 'E'), new PlayerChessPiece(whitePlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(7, 'F'), new PlayerChessPiece(whitePlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(7, 'G'), new PlayerChessPiece(whitePlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(7, 'H'), new PlayerChessPiece(whitePlayer, pawnChessPiece));
        basicLineup.put(new HumanCoordinate(8, 'A'), new PlayerChessPiece(whitePlayer, rookChessPiece));
        basicLineup.put(new HumanCoordinate(8, 'B'), new PlayerChessPiece(whitePlayer, knightChessPiece));
        basicLineup.put(new HumanCoordinate(8, 'C'), new PlayerChessPiece(whitePlayer, bishopChessPiece));
        basicLineup.put(new HumanCoordinate(8, 'D'), new PlayerChessPiece(whitePlayer, kingChessPiece));
        basicLineup.put(new HumanCoordinate(8, 'E'), new PlayerChessPiece(whitePlayer, queenChessPiece));
        basicLineup.put(new HumanCoordinate(8, 'F'), new PlayerChessPiece(whitePlayer, bishopChessPiece));
        basicLineup.put(new HumanCoordinate(8, 'G'), new PlayerChessPiece(whitePlayer, knightChessPiece));
        basicLineup.put(new HumanCoordinate(8, 'H'), new PlayerChessPiece(whitePlayer, rookChessPiece));

        for (Map.Entry<HumanCoordinate, PlayerChessPiece> entry : basicLineup.entrySet()) {
            makeBasicLineup(entry.getKey(), entry.getValue());
        }
    }

    private void makeBasicLineup(HumanCoordinate humanCoordinate, PlayerChessPiece playerChessPiece) {
        IndexCoordinate indexCoordinate = mapper.createIndexCoordinate(humanCoordinate);
        table[indexCoordinate.getRow()][indexCoordinate.getColumn()] =
                String.valueOf(playerChessPiece.getPlayer().getSign()) + String.valueOf(playerChessPiece.getChessPiece().getSign());
    }

    public String getPlayerChessPieceString(HumanCoordinate fromHumanCoordinate) {
        IndexCoordinate indexCoordinate = mapper.createIndexCoordinate(fromHumanCoordinate);
        return table[indexCoordinate.getRow()][indexCoordinate.getColumn()];
    }
}
