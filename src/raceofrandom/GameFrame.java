package raceofrandom;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GameFrame extends JFrame implements Runnable{
    
    
    private JTextField ınputField;
    private JButton button;
    Thread ınputThread;
    boolean ınputTaken=false;
    
    GameFrame(){
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        ınputThread=new Thread();
        run();
    }

    void takeInput(){
        ınputField=new JTextField(5);
        button=new JButton("submit");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button){
                    String carNumS=ınputField.getText();
                    ınputTaken=true;
                }
            }
        }
        );
        this.add(ınputField);
        this.add(button);
        this.pack();
        this.setVisible(true);
    }
    
    void gameScreen(){
        ınputThread=null;
        GamePanel gamepanel=new GamePanel();
        this.remove(ınputField);
        this.remove(button);
        this.add(gamepanel);
        this.pack();
        this.setVisible(true);
        
    }

    @Override
    public void run() {
        ınputThread.start();
        takeInput();
        while(ınputTaken==false){
            try {
                ınputThread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        gameScreen();
    }
    
}
