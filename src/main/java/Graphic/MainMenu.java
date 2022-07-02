package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    public MainMenu(){

        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        SpringLayout sl = new SpringLayout();
        JPanel main = new JPanel(sl);

        main.setBackground(new Color(139,69,19));
        main.setMaximumSize(new Dimension(800,1080));
        main.setMinimumSize(new Dimension(800,1080));
        main.setPreferredSize(new Dimension(800,1080));




        JLabel chess = new JLabel("Шахматы");
        chess.setForeground(Color.YELLOW);
        chess.setFont(new Font("chessTitle",Font.ITALIC,60));
        main.add(chess);
        sl.putConstraint(SpringLayout.WEST,chess,257,SpringLayout.WEST,main);
        sl.putConstraint(SpringLayout.NORTH,chess,20,SpringLayout.NORTH,main);


        JPanel buttons = new JPanel(new GridLayout(6,1,0,10));
        buttons.setBackground(new Color(139,69,19));


        JButton button1 = new MenuButton("Новая игра",new ImageIcon("src/main/resources/newGame.png"));
        button1.addActionListener(new NewGameListener());
        JButton button2 = new MenuButton("Сохраненная игра", new ImageIcon("src/main/resources/save.png"));
        button2.addActionListener(new SavedGameListener());
        JButton button3 = new MenuButton("Настройки языка", new ImageIcon("src/main/resources/Planet.png"));
        button3.setIconTextGap(13);

        JButton button4 = new MenuButton("Рейтинг игроков", new ImageIcon("src/main/resources/Rate.png"));
        button4.setIconTextGap(10);

        JButton button5 = new MenuButton("Об авторе", new ImageIcon("src/main/resources/Author.png"));
        JButton button6 = new MenuButton("Выход", new ImageIcon("src/main/resources/Exit.png"));
        button6.addActionListener(new ExitButtonListener());

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        main.add(buttons);
        sl.putConstraint(SpringLayout.SOUTH,buttons,550,SpringLayout.NORTH,chess);
        sl.putConstraint(SpringLayout.WEST,buttons,225,SpringLayout.WEST,main);
        buttons.setMinimumSize(new Dimension(350,350));
        buttons.setMaximumSize(new Dimension(350,350));
        buttons.setPreferredSize(new Dimension(350,350));




        JLabel logan = new JLabel(new ImageIcon("src/main/resources/goldenFigure.png"));
        main.add(logan);
        sl.putConstraint(SpringLayout.NORTH,logan,300,SpringLayout.NORTH,main);





        this.setBackground(new Color(241,205,180));
        this.add(Box.createHorizontalGlue());

        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        panel.setMaximumSize(new Dimension(7,1080));
        this.add(panel);

        this.add(main);

        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        panel.setMaximumSize(new Dimension(7,1080));
        this.add(panel);

        Component component2 = Box.createHorizontalStrut(7);

        this.add(Box.createHorizontalGlue());
        this.setVisible(true);

    }

    private class ExitButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            new ActionConfirmation(MainFrame.getMainFrame());
        }
    }

    private class NewGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame.getMainFrame().changeContentPane(new ChooseGameWindow());
            MainFrame.getMainFrame().revalidate();
            MainFrame.getMainFrame().repaint();
        }
    }
    private class SavedGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame.getMainFrame().changeContentPane(new SavedGameWindow());
            MainFrame.getMainFrame().revalidate();
            MainFrame.getMainFrame().repaint();
        }
    }
}
