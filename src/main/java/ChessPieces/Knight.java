package ChessPieces;

import GameLogic.Game;


import javax.swing.*;
import java.awt.*;

import static java.lang.Math.abs;


public class Knight implements ChessPiece{
    private Color color;
    private ImageIcon icon;


    public Knight(Color color){
        icon = new ImageIcon("src/main/resources/"+(color==Color.WHITE?"White":"Black")+"Knight"+".png");
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
        if (abs(coordinate1.charAt(0)-coordinate2.charAt(0))==2 && abs(Integer.valueOf(coordinate1.charAt(1))-Integer.valueOf(coordinate2.charAt(1)))==1 ||
                abs(coordinate1.charAt(0)-coordinate2.charAt(0))==1 && abs(Integer.valueOf(coordinate1.charAt(1))-Integer.valueOf(coordinate2.charAt(1)))==2) return true;
        return false;
    }


}
