package Graphic;

import ChessPieces.King;
import GameLogic.ButtonActionListener;
import GameLogic.Game;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


/**
 * Этот класс  инициализирует игровое поле согласно информации о расположении фигур, переданной в него через объект
 * Game. Хранит графическое представление поля при игре за белых и графическое представление поля при игре за черных.
 */
public class ChessDesk {

    /**
     * Хранит графическое представление поля при игре за белых.
     */
    private JPanel deskWhite;

    /**
     * Хранит графическое представление поля при игре за черных.
     */
    private JPanel deskBlack;


    public JPanel getDesk(Color color){
        return color.equals(Color.WHITE)?deskWhite:deskBlack;
    }



    private static class DeskBorderStyle extends JLabel{

        private DeskBorderStyle(String text){
            super(text);
            this.setOpaque(true);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setFont(new Font(null,Font.PLAIN,20));
            this.setBackground(new Color(139,69,19));
            this.setForeground(Color.YELLOW);
        }
    }

    public ChessDesk(Game game){


        deskWhite = new JPanel(new GridLayout(0,10,0,0));
        deskWhite.setBorder(new LineBorder(new Color(218,165,32),10));
        deskWhite.setPreferredSize(new Dimension(800,800));
        deskWhite.setMinimumSize(new Dimension(800,800));
        deskWhite.setMaximumSize(new Dimension(800,800));

        deskBlack = new JPanel(new GridLayout(0,10,0,0));
        deskBlack.setBorder(new LineBorder(new Color(218,165,32),10));
        deskBlack.setPreferredSize(new Dimension(800,800));
        deskBlack.setMinimumSize(new Dimension(800,800));
        deskBlack.setMaximumSize(new Dimension(800,800));


        Color colorOfField = Color.LIGHT_GRAY;


        for (int i=0;i<=9;i++){
            for (char c = '@';c<='I';c++){
                if (i==0 && c=='@' || c=='I'|| i==9){
                    deskWhite.add(new DeskBorderStyle(""));
                    deskBlack.add(new DeskBorderStyle(""));
                    continue;
                }

                if (i==0){
                    deskWhite.add(new DeskBorderStyle(String.valueOf(c)));
                    deskBlack.add(new DeskBorderStyle(String.valueOf(c)));
                    continue;
                }

                if (c=='@'){
                    deskWhite.add(new DeskBorderStyle(String.valueOf(9-i)));
                    deskBlack.add(new DeskBorderStyle(String.valueOf(i)));
                    continue;
                }





                if (game.getChessPiece(c+String.valueOf(9-i)) instanceof King){
                    if (game.getChessPiece(c + String.valueOf(9 - i)).getFigureColor().equals(Color.WHITE)) {
                        game.setKingCoordinate(Color.WHITE,c + String.valueOf(9 - i));
                    } else {
                        game.setKingCoordinate(Color.BLACK,c + String.valueOf(9 - i));
                    }
                }


                JButton button1 = new JButton();
                if (game.getChessPiece(c+String.valueOf(9-i))!=null){
                    button1.setIcon(game.getChessPiece(c+String.valueOf(9-i)).getFigureIcon());
                }
                button1.setBackground(colorOfField);
                button1.addActionListener(new ButtonActionListener());
                button1.setActionCommand(c+String.valueOf(9-i));
                game.setChessFields(c+String.valueOf(9-i),button1,Color.WHITE);
                button1.setFocusPainted(false);
                button1.setBorderPainted(false);
                deskWhite.add(button1);

                JButton button2 = new JButton();
                if (game.getChessPiece(c+String.valueOf(i))!=null){
                    button2.setIcon(game.getChessPiece(c+String.valueOf(i)).getFigureIcon());
                }
                button2.setBackground(colorOfField.equals(Color.DARK_GRAY)?Color.LIGHT_GRAY:Color.DARK_GRAY);
                button2.addActionListener(new ButtonActionListener());
                button2.setActionCommand(c+String.valueOf(i));
                game.setChessFields(c+String.valueOf(i),button2,Color.BLACK);
                button2.setFocusPainted(false);
                button2.setBorderPainted(false);
                deskBlack.add(button2);

                if (c!='H')
                    colorOfField = colorOfField.equals(Color.DARK_GRAY)?Color.LIGHT_GRAY:Color.DARK_GRAY;
            }
        }

    }



}
