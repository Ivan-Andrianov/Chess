package Graphic;

import ChessPieces.*;
import GameLogic.Game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;


/**
 * Класс графического представления окна.
 */
public class GameWindow extends JPanel {

    private JPanel main;

    private JPanel deskContainer;


    /**
     * desk хранит объект доски, выводимый в игровом окне.
     */
    private ChessDesk desk;


    /**
     * menu хранит объект меню, выводимый в игровом окне.
     */
    private JPanel menu;


    /**
     * deskLayout хранит представление доски.
     */
    private JPanel deskLayout;

    private GameWindow(Game game, Color color){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(new Color(241,205,180));

        main = new JPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.X_AXIS));
        desk = new ChessDesk(game);
        deskLayout = color.equals(Color.WHITE)?desk.getDesk(Color.WHITE):desk.getDesk(Color.BLACK);

        menu = new GameMenu();
        deskContainer = new JPanel();
        deskContainer.setBackground(new Color(241,205,180));
        deskContainer.setMaximumSize(new Dimension(800,800));


        deskContainer.add(deskLayout);
        main.add(Box.createHorizontalGlue());
        main.add(menu);
        main.add(Box.createHorizontalStrut(100));
        main.add(deskContainer);
        main.add(Box.createHorizontalGlue());
        main.setOpaque(false);
        main.setMaximumSize(new Dimension(2000,800));



        this.add(Box.createVerticalGlue());
        this.add(main);
        this.add(Box.createVerticalGlue());


    }

    static GameWindow window;

    public static void initGameWindow(Color color,Game game){
        if (window==null) window = new GameWindow(game, color);

    }
    public static GameWindow getGameWindow(){
        if (window==null) return null;
        return window;
    }

    public static void deleteGameWindow(){
        window=null;
    }

    /**
     * Задает графическое представление доски.
     */
    public void reverse() {
        deskContainer.remove(deskLayout);
        deskLayout = desk.getDesk(Game.getGame().getActiveColor());
        deskLayout.revalidate();
        deskContainer.add(deskLayout);
        deskContainer.repaint();
    }
}
