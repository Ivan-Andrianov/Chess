package Graphic;

import javax.swing.*;
import java.awt.*;

public class SavedGameWindow extends JPanel {
    public SavedGameWindow(){
        JScrollPane pane = new JScrollPane();
        this.setBackground(new Color(241,205,180));
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        pane.setMaximumSize(new Dimension(800,1080));
        pane.setMinimumSize(new Dimension(800,1080));
        pane.setPreferredSize(new Dimension(800,1080));
        pane.setVerticalScrollBar(new JScrollBar());



        this.add(Box.createHorizontalGlue());
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        panel.setMaximumSize(new Dimension(7,1080));
        this.add(panel);
        this.add(pane);
        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        panel.setMaximumSize(new Dimension(7,1080));
        this.add(panel);
        this.add(Box.createHorizontalGlue());


    }
}
