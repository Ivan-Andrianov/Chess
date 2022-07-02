package Graphic;

import javax.swing.*;

public class MainFrame extends JFrame{
    private static MainFrame mainFrame;
    private MainFrame(){
        super("Шахматы");
        this.setContentPane(new MainMenu());
        this.setSize(850,1080);
        this.setVisible(true);
    }
    public static MainFrame getMainFrame(){
        return mainFrame;
    }

    public void changeContentPane(JPanel panel){
        this.setContentPane(panel);
    }

    public static void main(String[] args) {
        mainFrame = new MainFrame();
    }


}
