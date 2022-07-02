package Graphic;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionConfirmation extends JDialog {
    public ActionConfirmation(Frame frame){
        super(frame,true);
        this.setSize(400,150);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(139,69,19));
        this.getContentPane().setLayout(new FlowLayout());
        this.setLocation((int) frame.getSize().getWidth()/2-200,465);


        JTextArea text = new JTextArea("Вы действительно хотите выйти?");
        text.setEditable(false);
        text.setFont(new Font("",Font.ITALIC,20));
        text.setOpaque(false);
        text.setForeground(Color.YELLOW);
        this.add(text);



        JButton yes = new MenuButton("    Да    ",null);
        yes.addActionListener(new YesButtonListener());
        JButton no = new MenuButton("   Нет   ",null);
        no.addActionListener(new NoButtonListener(this));


        this.add(yes);
        this.add(no);



        this.setVisible(true);


    }
    private class YesButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class NoButtonListener implements ActionListener{
        JDialog dialog;
        public NoButtonListener(JDialog dialog){
            this.dialog = dialog;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            dialog.setVisible(false);
        }
    }
}
