package raceofrandom;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameFrame extends JFrame{
    
    CardLayout card;
    GamePanel gamepanel;
    JPanel ınputpanel;
    final int carLimit=15;
    
    GameFrame(){
        card=new CardLayout();
        this.setLayout(card);
        gamepanel=new GamePanel();
        ınputpanel=new JPanel();
        ınputpanel.setPreferredSize(new Dimension(320,60));
        JTextField text=new JTextField(10);
        JButton button=new JButton("submit");
        JLabel label=new JLabel("Please enter how many cars you want in the race (1-"+carLimit+"}:");
        
        
        button.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                String s=text.getText();
                if(stringCheck(s)){
                    card.last(getContentPane());
                    redoFrame();
                }
                else{
                    label.setText("Wrong input, please choose a integer between (1-"+carLimit+"}:");
                    label.setForeground(Color.red);
                    
                }
            }
        });
        ınputpanel.add(label);
        ınputpanel.add(text);
        ınputpanel.add(button);
        this.add(ınputpanel);
        this.add(gamepanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        //this.setPreferredSize(new Dimension(500,500));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
    public boolean stringCheck(String s){
        try{
            int is=Integer.parseInt(s);
            if(0<is&&is<=carLimit){
                return true;
            }
            return false;
        }
        catch(NumberFormatException e){return false;}
    }
    public void redoFrame(){
        gamepanel.setPreferredSize(new Dimension(gamepanel.width,gamepanel.height));
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
}
