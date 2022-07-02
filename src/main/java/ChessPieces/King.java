package ChessPieces;

import GameLogic.Game;


import javax.swing.*;
import java.awt.*;

import static java.lang.Math.abs;

public class King implements ChessPiece{
    private Color color;
    private ImageIcon icon;
    private boolean firstMove;
    private boolean check;
    private boolean mat;
    private boolean pat;



    public King(Color color){
        icon = new ImageIcon("src/main/resources/"+(color==Color.WHITE?"White":"Black")+"King"+".png");
        this.color = color;
        this.firstMove = false;
        this.mat = false;
    }


    @Override
    public ImageIcon getFigureIcon() {
        return icon;
    }

    public boolean isCheck(){return check;}

    @Override
    public boolean enableMakeMoved(String coordinate1, String coordinate2, Game game) {
        if (abs(coordinate1.charAt(0)-coordinate2.charAt(0))<=1 && abs(coordinate1.charAt(1)-coordinate2.charAt(1))<=1){
            this.firstMove = true;
            return true;
        }

        if (abs(coordinate1.charAt(0)-coordinate2.charAt(0))==2 && coordinate1.charAt(1)==coordinate2.charAt(1) && this.firstMove!=true){
            if (coordinate2.equals("C1") && (game.getChessPiece("A1") instanceof Rook) && (((Rook) game.getChessPiece("A1")).getFirstStep())==false){
                for (char c = 'C';c<='D';c++){
                    if (game.getChessPiece(c+"1")!=null) return false;
                    if (this.checkThreat(coordinate1,c+String.valueOf(1),game, game.getActiveColor())) return false;
                }
                this.firstMove = true;
                game.makeMove("A1","D1");
                return true;
            }
            if (coordinate2.equals("G1")  && (game.getChessPiece("H1") instanceof Rook) && (((Rook) game.getChessPiece("A1")).getFirstStep())==false){
                for (char c = 'F';c<='G';c++){
                    if (game.getChessPiece(c+"1")!=null) return false;
                    if (this.checkThreat(coordinate1,c+String.valueOf(1),game, game.getActiveColor())) return false;
                }
                this.firstMove = true;
                game.makeMove("H1","F1");
                return true;
            }
            if (coordinate2.equals("C8") && game.getChessPiece("C8")==null && game.getChessPiece("B8")==null && game.getChessPiece("D8")==null && (game.getChessPiece("A8") instanceof Rook) && (((Rook) game.getChessPiece("A8")).getFirstStep())==false){
                for (char c = 'C';c<='D';c++){
                    if (game.getChessPiece(c+"8")!=null) return false;
                    if (this.checkThreat(coordinate1,c+String.valueOf(8),game, game.getActiveColor())) return false;
                }
                this.firstMove = true;
                game.makeMove("A8","D8");
                return true;
            }
            if (coordinate2.equals("G8") && game.getChessPiece("G8")==null && game.getChessPiece("F8")==null && (game.getChessPiece("H8") instanceof Rook) && (((Rook) game.getChessPiece("H8")).getFirstStep())==false){
                for (char c = 'F';c<='G';c++){
                    if (game.getChessPiece(c+"8")!=null) return false;
                    if (this.checkThreat(coordinate1,c+String.valueOf(8),game, game.getActiveColor())) return false;
                }
                this.firstMove = true;
                game.makeMove("H8","F8");
                return true;
            }
        }
        return false;
    }

    @Override
    public Color getFigureColor() {
        return color;
    }

    public boolean isMat() {
        return mat;
    }

    public void setMat() {
        this.mat = true;
    }

    public boolean isPat() {
        return pat;
    }

    public void setPat() {
        this.pat = true;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
