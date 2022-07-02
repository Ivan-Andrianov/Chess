package GameLogic;

import ChessPieces.King;
import Graphic.GameMenu;
import Graphic.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Класс слушателя, связанного с полями шахматной доски.
 */
public class ButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        Game game = Game.getGame();
        if (((King)game.getChessPiece(game.getKingCoordinate(game.getActiveColor()))).isMat() || ((King)game.getChessPiece(game.getKingCoordinate(game.getActiveColor()))).isPat()) return;
        Move move = Move.getMoveObject();



        JButton[] arrayOfChooseButton = move.getArrayOfChooseButton();
        if (arrayOfChooseButton[0]==null && (game.getChessPiece(button.getActionCommand())==null || game.getChessPiece(button.getActionCommand()).getFigureColor()!=game.getActiveColor())) return;
        if (arrayOfChooseButton[0]!=null && game.getChessPiece(button.getActionCommand())!=null && game.getChessPiece(arrayOfChooseButton[0].getActionCommand()).getFigureColor().equals(game.getChessPiece(button.getActionCommand()).getFigureColor())){
            move.clean();
            return;
        }
        if (arrayOfChooseButton[0]!=null && game.getChessPiece(button.getActionCommand())!=null && game.getChessPiece(arrayOfChooseButton[0].getActionCommand()).getFigureColor().equals(game.getChessPiece(button.getActionCommand()).getFigureColor())){
            move.clean();
        }

        move.addButton(button);

        if (move.isFilled()){

            String x = arrayOfChooseButton[0].getActionCommand();
            String y = arrayOfChooseButton[1].getActionCommand();


            if (game.getChessPiece(x).checkThreat(x,y,game, game.getActiveColor())){
                move.clean();
                return;
            }


            if (game.getChessPiece(x).enableMakeMoved(x, y,game)){
                if (game.getActiveColor().equals(Color.WHITE)) game.increaseMoveCounter();

                if (game.getChessPiece(x).checkThreat(x,y,game,game.getNoActiveColor())){
                    ((King)game.getChessPiece(game.getKingCoordinate(game.getNoActiveColor()))).setCheck(true);
                }

                game.makeMove(x,y);
                game.changeActiveColor();




                if (game.isMustBeReversed()){
                    GameWindow.getGameWindow().reverse();
                }

                JTextArea output = GameMenu.getOutputOfMoves();
                String text = "";
                if (((King) game.getChessPiece(game.getKingCoordinate(game.getActiveColor()))).isCheck()) text = "Шах";
                if (((King) game.getChessPiece(game.getKingCoordinate(game.getActiveColor()))).isPat()) text = "Пат";
                if (((King) game.getChessPiece(game.getKingCoordinate(game.getActiveColor()))).isMat()) text = "Мат";
                output.append((game.getNoActiveColor().equals(Color.WHITE)?game.getMoveCounter()+".Белые - ":"  Черные - ")+x+":"+y+" "+text+" \n"+(game.getNoActiveColor().equals(Color.BLACK)?"\n":""));


                move.clean();

            }else{
                move.clean();
                return;
            }

        }



    }
}
