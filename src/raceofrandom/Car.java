package raceofrandom;
import Graph.*;
import java.awt.Rectangle;

public class Car {
    static int ID=0;
    final int velocity=1;
    public Rectangle r;
    int currentV=0;
    int road=0;
    int newRoad=0;
    
    int x;
    int y;
    
    Car(int x, int y,int pLength){
        r=new Rectangle(x,y,pLength,pLength);
        ID++;
    }
    
    public int chooseRandomCheckpoint(GraphList g){
        LinkedList<Edge> adj[]=g.getAdj();
        Node n=adj[currentV].getFirst();
        
        int randomNum=(int)(Math.random()*adj[currentV].getNodeNum()+1);
        for(int i=1;i<randomNum;i++){
            n=n.getNext();
            //System.out.println(n);
        }
        Edge e=(Edge)n.getData();
        currentV=e.getV2();
        return e.getWeigth();
    }
    
    
}
