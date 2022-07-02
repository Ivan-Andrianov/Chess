package Graphic;

import GameLogic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseGameWindow extends JPanel {
    public ChooseGameWindow(){
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        SpringLayout sl = new SpringLayout();
        JPanel main = new JPanel(sl);
        main.setBackground(new Color(139,69,19));
        main.setMaximumSize(new Dimension(800,1080));
        main.setMinimumSize(new Dimension(800,1080));
        main.setPreferredSize(new Dimension(800,1080));

        JTextArea ChooseGameText = new JTextArea("Выберете игру");
        ChooseGameText.setEditable(false);
        ChooseGameText.setOpaque(false);
        ChooseGameText.setForeground(Color.YELLOW);
        ChooseGameText.setFont(new Font("",Font.ITALIC,60));
        main.add(ChooseGameText);

        sl.putConstraint(SpringLayout.NORTH,ChooseGameText,20,SpringLayout.NORTH,main);
        sl.putConstraint(SpringLayout.WEST,ChooseGameText,180,SpringLayout.WEST,main);

        JPanel buttons = new JPanel(new GridLayout(6,1,0,10));
        buttons.setBackground(new Color(139,69,19));
        JButton button1 = new MenuButton("Игра с компьютером",new ImageIcon("src/main/resources/ChooseGameWindowIcons/Computer.png"));
        JButton button2 = new MenuButton("Горячий стул",new ImageIcon("src/main/resources/ChooseGameWindowIcons/HotChair.png"));
        button2.addActionListener(new HotChairButtonListener());
        JButton button3 = new MenuButton("Сетевая игра",new ImageIcon("src/main/resources/ChooseGameWindowIcons/Planet.png"));
        JButton button4 = new MenuButton("Шахматные задачи",new ImageIcon("src/main/resources/ChooseGameWindowIcons/Pawn.png"));
        JButton button5 = new MenuButton("Песочница",new ImageIcon("src/main/resources/ChooseGameWindowIcons/Book.png"));
        JButton button6 = new MenuButton("Назад",new ImageIcon("src/main/resources/ChooseGameWindowIcons/BackIcon.png"));
        button6.addActionListener(new BackButtonListener());
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        main.add(buttons);
        sl.putConstraint(SpringLayout.NORTH,buttons,123,SpringLayout.SOUTH,ChooseGameText);
        sl.putConstraint(SpringLayout.WEST,buttons,225,SpringLayout.WEST,main);

        buttons.setMinimumSize(new Dimension(350,350));
        buttons.setMaximumSize(new Dimension(350,350));
        buttons.setPreferredSize(new Dimension(350,350));


        JLabel logan = new JLabel(new ImageIcon("src/main/resources/goldenFigure.png"));
        main.add(logan);
        sl.putConstraint(SpringLayout.NORTH,logan,300,SpringLayout.NORTH,main);


        this.add(Box.createHorizontalGlue());
        JPanel panel1 = new JPanel();
        panel1.setMinimumSize(new Dimension(7,1080));
        panel1.setMaximumSize(new Dimension(7,1080));
        panel1.setBackground(Color.YELLOW);
        this.add(panel1);
        this.add(main);
        panel1 = new JPanel();
        panel1.setMinimumSize(new Dimension(7,1080));
        panel1.setMaximumSize(new Dimension(7,1080));
        panel1.setBackground(Color.YELLOW);
        this.add(panel1);
        this.add(Box.createHorizontalGlue());

        this.setBackground(new Color(241,205,180));
        System.out.println(ChooseGameText.getSize());
    }

    private class BackButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame.getMainFrame().changeContentPane(new MainMenu());
            MainFrame.getMainFrame().revalidate();
            MainFrame.getMainFrame().repaint();
        }
    }

    private class HotChairButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Game.initGame(Color.WHITE,true);
            GameWindow.initGameWindow(Color.WHITE,Game.getGame());
            MainFrame.getMainFrame().changeContentPane(GameWindow.getGameWindow());
            MainFrame.getMainFrame().pack();
            MainFrame.getMainFrame().revalidate();
            MainFrame.getMainFrame().repaint();
        }
    }

}
