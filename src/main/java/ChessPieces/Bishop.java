package ChessPieces;

import GameLogic.Game;


import javax.swing.*;
import java.awt.*;

public class Bishop implements ChessPiece{
    private Color color;
    private ImageIcon icon;


    public Bishop(Color color){
        icon = new ImageIcon("src/main/resources/"+(color==Color.WHITE?"White":"Black")+"Bishop"+".png");
        this.color = color;
    }

    public ImageIcon getFigureIcon(){
        return icon;
    }

    @Override
    public Color getFigureColor() {
        return color;
    }




    @Override
    public boolean enableMakeMoved(String coordinate1, String coordinate2, Game game) {
        if (Math.abs(coordinate1.charAt(0)-coordinate2.charAt(0))!=Math.abs(coordinate1.charAt(1)-coordinate2.charAt(1))) return false;

        int verticalCoordinate = coordinate2.charAt(1)-coordinate1.charAt(1)>0?1:-1;
        int horizontalCoordinate = coordinate2.charAt(0)-coordinate1.charAt(0)>0?1:-1;

        while (true){
            coordinate1 = ((char)(coordinate1.charAt(0)+horizontalCoordinate))+String.valueOf((char)(coordinate1.charAt(1)+verticalCoordinate));
            if (coordinate1.equals(coordinate2)) break;
            if (game.getChessPiece(coordinate1)!=null) return false;
        }
        return true;
    }


}
