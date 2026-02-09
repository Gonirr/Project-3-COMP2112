package raceofrandom;
import Graph.GraphList;
import java.awt.Dimension;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    GraphList racetrack;
    int height;
    int width;
    final int scaleh=4;
    final int scalew=7;
    GamePanel(){
        racetrack=read("/racetrack.txt");
        this.height=scaleh*racetrack.getWeightSum();
        this.width=scalew*racetrack.getWeightSum();
        //this.setPreferredSize(new Dimension(width,height));
    }
    
    public GraphList read(String resource){
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
