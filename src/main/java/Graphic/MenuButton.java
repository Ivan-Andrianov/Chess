package Graphic;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JButton {
    public MenuButton(String text, ImageIcon imageIcon){
        this.setBackground(new Color(250, 215, 162));
        this.setText(text);
        this.setFocusPainted(false);
        this.setBorder(new LineBorder(Color.YELLOW,4));
        this.setForeground(Color.DARK_GRAY);
        this.setFont(new Font("",Font.ITALIC,20));
        this.setIcon(imageIcon);
        this.addMouseListener(new MenuButtonChangeListener());
    }

    private class MenuButtonChangeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setForeground(Color.RED);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBorder(new LineBorder(Color.ORANGE,7));
            button.setFont(new Font("",Font.ITALIC,25));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBorder(new LineBorder(Color.YELLOW,4));
            button.setFont(new Font("",Font.ITALIC,20));
        }
    }
}
