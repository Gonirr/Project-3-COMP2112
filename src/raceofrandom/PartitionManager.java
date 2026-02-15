package raceofrandom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PartitionManager {
    
    Partition partitions[][];
    int x;
    int y;
    GamePanel gp;
    int colorChanger=0;
    
    PartitionManager(GamePanel gp){
        this.y=gp.carNum;
        this.x=gp.weightSum;
        partitions=new Partition[x][y];
        this.gp=gp;
        for(int i=0;i<x;i++){
            for(int k=0;k<y;k++){
                partitions[i][k]=new Partition(gp.pLength);
            }
        }
    }
    
    public void drawBackground (Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        for(int i=0;i<gp.cars.length;i++){
            if(gp.kl.Continue==true){
                int newRoad=gp.pLength*gp.cars[i].chooseRandomCheckpoint(gp.racetrack);
                gp.cars[i].road+=newRoad;
            }
            
            for(int x=0;x<gp.cars[i].road;x+=gp.pLength){
                if(gp.cars[i].road>x+gp.pLength){
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(gp.startX+x, gp.carPlacement*(i+1)-(gp.pLength/2), gp.pLength, gp.pLength);
                }
                else{
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.fillRect(gp.startX+x, gp.carPlacement*(i+1)-(gp.pLength/2), gp.pLength, gp.pLength);
                }
                System.out.println("x:"+(x+gp.pLength)+" r:"+gp.cars[i].road);
            }
            //g2d.setColor(Color.red);
            //g2d.drawString(""+gp.cars[i].currentV, gp.cars[i].road, gp.carPlacement*(i+1)-(gp.pLength/2));
        }
        
        /*
        if(x/gp.pLength%2==0){
            g2d.setColor(Color.GREEN);
            g2d.fillRect(x+gp.startX, y, gp.pLength, gp.pLength);
        }
        else{
            g2d.setColor(Color.BLACK);
            g2d.fillRect(x+gp.startX, y, gp.pLength, gp.pLength);
        }
        */
        
        /*
        for(int i=0;i<cars.length;i++){
            int newRoad=partition*cars[i].chooseRandomCheckpoint(racetrack);
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
        */
    }
    
    public void markRoad(){
        for(int i=0;i<gp.cars.length;i++){
            int newRoad=gp.cars[i].chooseRandomCheckpoint(gp.racetrack);
            int startPoint=gp.cars[i].road;
            for(int k=0;k<newRoad;k++){
                partitions[startPoint+k][1+i*2].isRoad=true;
            }
            gp.cars[i].road+=newRoad;
        }
    }
    
}
