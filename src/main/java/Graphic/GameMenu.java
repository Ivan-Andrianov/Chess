package Graphic;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;


/**
 * Класс создающий объект игрового меню, реализуя паттерн singleton. Объект menu должен быть один на всю игру. В конце партии
 * объект очищается.
 */
public class GameMenu extends JPanel{


    /**
     * Хранит ссылку на объект окна для вывода ходов.
     */
    private static JTextArea outputOfMoves;

    public GameMenu(){

        this.setBackground(new Color(139,69,19));
        this.setMinimumSize(new Dimension(400,800));
        this.setPreferredSize(new Dimension(400,800));
        this.setMaximumSize(new Dimension(400,800));
        SpringLayout sl = new SpringLayout();
        this.setLayout(sl);


        outputOfMoves = new JTextArea();
        outputOfMoves.setEditable(false);
        outputOfMoves.setBackground(new Color(240,180,140));
        outputOfMoves.setFont(new Font(null,Font.PLAIN,20));

        JScrollPane pane = new JScrollPane(outputOfMoves,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setBorder(new LineBorder(new Color(218,165,32),4));
        pane.setPreferredSize(new Dimension(300,400));
        pane.setMinimumSize(new Dimension(300,400));
        pane.setMaximumSize(new Dimension(300,400));

        this.add(pane);
        sl.putConstraint(SpringLayout.WEST,pane,40, SpringLayout.WEST, this);
        sl.putConstraint(SpringLayout.NORTH,pane,40, SpringLayout.NORTH, this);

        JButton button1 = new MenuButton("Главное меню",new ImageIcon(""));
        JButton button2 = new MenuButton("Сдаться",new ImageIcon(""));
        JButton button3 = new MenuButton("Предложить ничью",new ImageIcon(""));

        JPanel buttons = new JPanel(new GridLayout(3,1,0,10));
        buttons.setPreferredSize(new Dimension(300,150));
        buttons.setMinimumSize(new Dimension(300,150));
        buttons.setMaximumSize(new Dimension(300,150));
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.setOpaque(false);
        this.add(buttons);
        sl.putConstraint(SpringLayout.NORTH,buttons,80,SpringLayout.SOUTH,pane);
        sl.putConstraint(SpringLayout.WEST,buttons,40,SpringLayout.WEST,this);

        this.setBorder(new LineBorder(new Color(218,165,32),10));
    }


    /**
     * Функция геттер outputOfMoves. Позволяет получить объект окна для вывода ходов из внешнего кода.
     */
    public static JTextArea getOutputOfMoves(){
        return outputOfMoves;
    }
}
