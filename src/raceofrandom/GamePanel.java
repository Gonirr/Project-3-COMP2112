package raceofrandom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    int height=750;
    int width=1400;
    
    GamePanel(){
        this.setPreferredSize(new Dimension(width,height));
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        //g2d.drawLine(0, 0, width, height);
    }
    
}
