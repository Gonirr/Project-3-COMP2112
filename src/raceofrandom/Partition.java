package raceofrandom;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Partition extends JPanel{
    int length;
    
    Partition (int length){
        this.length=length;
        this.setPreferredSize(new Dimension(length,length));
        this.setBackground(Color.GREEN);
    }
}
