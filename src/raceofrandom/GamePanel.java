package raceofrandom;
import Graph.GraphList;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    
    GraphList racetrack;
    
    //for calculating the size of the screen according to given racetrack (graph)
    final public int height;
    final public int width;
    final int weightSum;
    
    //fianlized variables
    final int Height=800;
    final int Width=1400;
    final int FPS=20;
    
    //other
    int carNum;
    int pLength;
    int carPlacement;
    int startX=0;
    
    PartitionManager pm;
    Car[] cars;
    Thread time;
    GameKeyListener kl;
    
    GamePanel(int carNum,GameKeyListener kl){
        //racetrack and initializing varibales
        racetrack=read("/racetrack.txt");
        this.carNum=carNum;
        
        //adjusting screen hiegh
        this.weightSum=racetrack.getWeightSum();
        int scaleh=Height/weightSum;
        this.height=scaleh*weightSum;
        
        //calculating car and raod placement
        pLength=height/(carNum*2+1);
        carPlacement=height/(carNum+1);
        
        //width
        int scalew=Width/pLength;
        this.width=scalew*pLength;
        
        //initializing cars and calculating thier placement on the y-axisis
        cars=new Car[carNum];
        for(int i=0;i<cars.length;i++){
            cars[i]=new Car(0, carPlacement*(i+1)-(pLength/2), pLength);
        }
        
        //final touches
        this.kl=kl;
        pm=new PartitionManager(this);
        this.setPreferredSize(new Dimension(width,height));
        startGame();
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
    
    public void paintComponent(Graphics g){
        
        Graphics2D g2d=(Graphics2D) g;
        update();
        pm.draw(g);
        //g2d.draw(cars[0].r);
        /*
        
        */
    } 
    
    public void startGame(){
        time=new Thread(this);
        time.start();
    }
    
    @Override
    public void run(){
        
        while(time!=null){
            long draw=1000/FPS;
            long nextDraw=System.currentTimeMillis()+draw;
            long remaining=nextDraw-System.currentTimeMillis();
            
            repaint();
            
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void update(){
        if(kl.moving==true&&kl.left==true&&startX>=0){startX+=pLength;}
        if(kl.moving==true&&kl.right==true){startX-=pLength;}
        //System.out.println(startX);
    }
    
    //{Getters and Setters}
    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }
    
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
