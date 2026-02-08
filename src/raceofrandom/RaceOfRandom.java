package raceofrandom;
import Graph.GraphList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class RaceOfRandom {
    public static void main(String[] args) {
        GraphList racetrack=read("/racetrack.txt");
        //System.out.println(racetrack.toString());
        GameFrame gameframe=new GameFrame();
        //gameframe.setVisible(true);
        
        
    }
    
    public static GraphList read(String resource){
        InputStream IS=RaceOfRandom.class.getResourceAsStream(resource);
        Scanner scn=new Scanner(IS);
        int V=scn.nextInt();
        int E=scn.nextInt();
        GraphList rt=new GraphList(V,E);
        while(scn.hasNext()!=false){
            rt.addEdge(scn.nextInt(), scn.nextInt(), scn.nextInt());
        }
        return rt;
    }
    
    
}
