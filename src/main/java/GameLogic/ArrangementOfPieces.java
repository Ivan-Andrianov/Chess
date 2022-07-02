package GameLogic;


import ChessPieces.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * ArrangementOfPieces содержит константы, которые хранят в себе информацию о расстановке фигур. Здесь могут быть переменные
 * ,которые хранят расстановку фигур при обычной игре, при тренировочных партиях.
 */
public final class ArrangementOfPieces {


    /**
     * defaultGame содержит координаты расположения фигур в классической игре.
     */
    public final static Map<String, ChessPiece> defaultGame;
    static{
        defaultGame = new HashMap<>();
        defaultGame.putAll(Map.of("A1",new Rook(Color.WHITE),"B1",new Knight(Color.WHITE),"C1",new Bishop(Color.WHITE),"E1",new King(Color.WHITE),"D1",new Queen(Color.WHITE)));
        defaultGame.putAll(Map.of("F1",new Bishop(Color.WHITE),"G1",new Knight(Color.WHITE),"H1",new Rook(Color.WHITE),"A2",new Pawn(Color.WHITE),"B2",new Pawn(Color.WHITE)));
        defaultGame.putAll(Map.of("C2",new Pawn(Color.WHITE),"D2",new Pawn(Color.WHITE),"E2",new Pawn(Color.WHITE),"F2",new Pawn(Color.WHITE),"G2",new Pawn(Color.WHITE)));
        defaultGame.putAll(Map.of("H2",new Pawn(Color.WHITE),"A7",new Pawn(Color.BLACK),"B7",new Pawn(Color.BLACK),"C7",new Pawn(Color.BLACK),"D7",new Pawn(Color.BLACK)));
        defaultGame.putAll(Map.of("E7",new Pawn(Color.BLACK),"F7",new Pawn(Color.BLACK),"G7",new Pawn(Color.BLACK),"H7",new Pawn(Color.BLACK),"H8",new Rook(Color.BLACK)));
        defaultGame.putAll(Map.of("G8",new Knight(Color.BLACK),"F8",new Bishop(Color.BLACK),"E8",new King(Color.BLACK),"D8",new Queen(Color.BLACK),"C8",new Bishop(Color.BLACK)));
        defaultGame.putAll(Map.of("B8",new Knight(Color.BLACK),"A8",new Rook(Color.BLACK)));
    }
}

