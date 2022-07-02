package ChessPieces;

import GameLogic.Game;


import javax.swing.*;
import java.awt.*;
import static java.lang.Math.abs;

public class Pawn implements ChessPiece{
    private Color color;
    private ImageIcon icon;
    private boolean firstStep;

    public Pawn(Color color){
        icon = new ImageIcon("src/main/resources/"+(color==Color.WHITE?"White":"Black")+"Pawn"+".png");
        firstStep =false;
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
        if (game.getActiveColor().equals(Color.WHITE) && coordinate1.charAt(1) > coordinate2.charAt(1) || game.getActiveColor().equals(Color.BLACK) && coordinate1.charAt(1) < coordinate2.charAt(1)
                || coordinate1.charAt(1) == coordinate2.charAt(1) || (abs(coordinate1.charAt(1) - coordinate2.charAt(1)) > 2))
            return false;


        int x = game.getActiveColor().equals(Color.WHITE) ? 1 : -1;

        if (coordinate1.charAt(0) == coordinate2.charAt(0)) {
            if (abs(coordinate1.charAt(1) - coordinate2.charAt(1)) == 2 && (coordinate1.charAt(1) == '7' || coordinate1.charAt(1) == '2')){
                for (char c = (char) (coordinate1.charAt(1)+1); c<=coordinate2.charAt(1); c+=x){
                    if (game.getChessPiece(coordinate1.charAt(0)+String.valueOf(c))!=null) return false;
                }
                return true;
            }
            if (abs(coordinate1.charAt(1) - coordinate2.charAt(1)) == 1) {
                if (game.getChessPiece(coordinate2) != null) return false;
                return true;
            }
        } else {
            if (!game.movesIsEmpty() && game.getChessPiece(game.getPreviousMove().get(1)) instanceof Pawn  && abs(game.getPreviousMove().get(0).charAt(1)-game.getPreviousMove().get(1).charAt(1))==2 &&
            coordinate2.charAt(0)==game.getPreviousMove().get(0).charAt(0) && (coordinate2.charAt(1)=='3' || coordinate2.charAt(1)=='6')) {
                game.getChessField(game.getActiveColor().equals(Color.BLACK)?Color.WHITE:Color.BLACK, game.getPreviousMove().get(1)).setIcon(null);
                game.removeChessPiece(game.getPreviousMove().get(1));
                return true;
            }

            if (game.getChessPiece(coordinate2) != null && coordinate1.charAt(1) - coordinate2.charAt(1) == x) return true;
        }
        return false;
    }
}
