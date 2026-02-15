package raceofrandom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Partition extends JPanel{
    int length;
    JLabel label;
    public boolean isRoad;
    Partition (int length){
        this.length=length;
        this.setSize(new Dimension(length,length));
        this.setBackground(Color.red);
    }
}
