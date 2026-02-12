package raceofrandom;
import Graph.GraphList;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    GraphList racetrack;
    
    final private int height;
    final private int width;
    final int Height=800;
    final int Width=1400;
    int scaleh;
    int scalew;
    int weightSum;
    final int FPS=60;
    
    private int carNum;
    Car[] cars;
    Thread time;
    int colorChanger=0;
    
    GamePanel(int carNum){
        racetrack=read("/racetrack.txt");
        this.carNum=carNum;
        cars=new Car[carNum];
        for(int i=0;i<cars.length;i++){
            cars[i]=new Car();
        }
        this.weightSum=racetrack.getWeightSum();
        scaleh=Height/weightSum;
        scalew=Width/weightSum;
        this.height=scaleh*weightSum;
        this.width=scalew*weightSum;
        this.setPreferredSize(new Dimension(width,height));
        startGame();
        //System.out.println("w:"+width+" h:"+height+" sum:"+weightSum);
        //System.out.println("scalew:"+scalew);
        //System.out.println(racetrack.toString());
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
        int carPlacement=height/(carNum+1);
        int partition=height/(carNum*2+1);
        for(int i=0;i<cars.length;i++){
            int newRoad=scalew*cars[i].chooseRandomCheckpoint(racetrack);
            cars[i].road+=newRoad;
            if(colorChanger%2==0){
              g2d.setPaint(Color.DARK_GRAY);
              g2d.fillRect(cars[i].road-newRoad, carPlacement*(i+1)-(partition/2), cars[i].road, partition);
            }
            else{
                g2d.setPaint(Color.GRAY);
                g2d.fillRect(cars[i].road-newRoad, carPlacement*(i+1)-(partition/2), cars[i].road, partition);
            }
            
            g2d.setPaint(Color.RED);
            g2d.setStroke(new BasicStroke(5));
            //g2d.drawLine(cars[i].road, carPlacement*(i+1)-(partition/2), cars[i].road, carPlacement*(i+1)-(partition/2));
            g2d.drawString(cars[i].currentV+"", cars[i].road, carPlacement*(i+1)-(partition/2)-1);
            
        }
        colorChanger++;
        /*
        for(int i=0;i<scalew;i++){
            g2d.drawLine(weightSum*i, 0, weightSum*i, height);
        }
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
}
