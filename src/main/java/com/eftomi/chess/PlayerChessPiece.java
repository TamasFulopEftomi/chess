package com.eftomi.chess;

import com.eftomi.chess.enums.ChessPiece;
import com.eftomi.chess.enums.Player;

public class PlayerChessPiece {
    private Player player;
    private ChessPiece chessPiece;

    public PlayerChessPiece(Player player, ChessPiece ChessPiece) {
        this.player = player;
        this.chessPiece = ChessPiece;
    }

    public Player getPlayer() {
        return player;
    }

    public ChessPiece getChessPiece() {
        return chessPiece;
    }

}
