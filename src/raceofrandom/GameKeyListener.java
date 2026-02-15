package raceofrandom;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

    public boolean moving;
    public boolean left;
    public boolean right;
    boolean Continue;
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_ENTER){Continue=true;}
        if(code==KeyEvent.VK_A){left=true;moving=true;}
        if(code==KeyEvent.VK_D){right=true;moving=true;}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_ENTER){Continue=false;}
        if(code==KeyEvent.VK_A){left=false;moving=false;}
        if(code==KeyEvent.VK_D){left=false;moving=false;}
    }
    
}
