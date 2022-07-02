package ChessPieces;

import GameLogic.Game;


import javax.swing.*;
import java.awt.*;
import java.util.Map;

public interface ChessPiece {

    ImageIcon getFigureIcon();
    boolean enableMakeMoved(String coordinate1, String coordinate2, Game game);
    Color getFigureColor();

    default boolean checkThreat(String coordinate1, String coordinate2, Game game, Color color){
        boolean result = false;


        ChessPiece figure1 = game.getChessPiece(coordinate1);
        if (figure1 instanceof King) game.setKingCoordinate(color,coordinate2);
        ChessPiece figure2 = game.getChessPiece(coordinate2);

        game.getChessPieces().remove(coordinate1);
        game.getChessPieces().put(coordinate2,figure1);


        for (Map.Entry<String,ChessPiece> piece:game.getChessPieces().entrySet()){
            if (piece.getValue().getFigureColor()!=color && piece.getValue().enableMakeMoved(piece.getKey(),game.getKingCoordinate(color),game)){
                result = true;
                break;
            }
        }

        if (figure1 instanceof King){
            game.setKingCoordinate(color,coordinate1);
        }
        game.getChessPieces().put(coordinate1,figure1);
        if (figure2==null) game.removeChessPiece(coordinate2);
        else game.getChessPieces().put(coordinate2,figure2);

        return result;

    }
}
