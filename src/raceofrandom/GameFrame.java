package raceofrandom;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameFrame extends JFrame{
    
    JFrame frame;
    CardLayout card;
    GamePanel gamepanel;
    JPanel ınputpanel;
    
    GameFrame(){
        frame=new JFrame("Race Of Random");
        card=new CardLayout();
        gamepanel=new GamePanel();
        ınputpanel=new JPanel();
        JTextField text=new JTextField(10);
        JButton button=new JButton("submit");
        
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String s=text.getText();
                System.out.println("s");
            }
        });
        ınputpanel.setLayout(new FlowLayout());
        ınputpanel.add(text);
        ınputpanel.add(button);
        frame.add(ınputpanel);
        frame.add(gamepanel);
        
        frame.setLayout(card);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(500,300));
        
        frame.setVisible(true);
        
    }
    
}
