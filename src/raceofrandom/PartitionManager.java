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
        this.y=(gp.carNum*2)+1;
        this.x=gp.weightSum;
        partitions=new Partition[x][y];
        this.gp=gp;
        for(int i=0;i<x;i++){
            for(int k=0;k<y;k++){
                partitions[i][k]=new Partition(gp.pLength);
                //System.out.println(partitions[i][k]);
            }
        }
    }
    
    public void draw(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        //int screenPartition=gp.startX/gp.pLength;
        for(int x=0;x<gp.width;x+=gp.pLength){
            for(int y=0;y<gp.height;y+=gp.pLength){
                if(x/gp.pLength%2==0){
                    g2d.setColor(Color.GREEN);
                    g2d.fillRect(x+gp.startX, y, gp.pLength, gp.pLength);
                }
                else{
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(x+gp.startX, y, gp.pLength, gp.pLength);
                }
                
            }
        }
        colorChanger++;
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
}
