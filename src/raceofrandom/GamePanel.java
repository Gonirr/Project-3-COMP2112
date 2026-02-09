package raceofrandom;
import Graph.GraphList;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    GraphList racetrack;
    
    final private int height;
    final private int width;
    final int Height=800;
    final int Width=1400;
    int scaleh;
    int scalew;
    
    private int carNum;
    Car[] cars;

    GamePanel(int carNum){
        racetrack=read("/racetrack.txt");
        System.out.println(racetrack.toString());
        
        this.carNum=carNum;
        cars=new Car[carNum];
        for(int i=0;i<cars.length;i++){
            cars[i]=new Car();
        }
        int weightSum=racetrack.getWeightSum();
        scaleh=Height/weightSum;
        scalew=Width/weightSum;
        this.height=scaleh*weightSum;
        this.width=scalew*weightSum;
        //System.out.println("w:"+width+" h:"+height+" sum:"+weightSum);
        this.setPreferredSize(new Dimension(width,height));
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
    
    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }
    
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public void paint(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        int partion=height/(carNum+1);
        for(int i=0;i<cars.length;i++){
            int rectLength=scalew*cars[i].chooseRandomCheckpoint(racetrack)*4;
            //System.out.println(rectLength);
            //g2d.drawRect(, , 100, 100);
            g2d.fillRect(100, partion*(i+1), rectLength, 100);
        }
    }
}
