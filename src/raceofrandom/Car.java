package raceofrandom;
import Graph.*;
import java.awt.Rectangle;

public class Car {
    static int ID=0;
    final int velocity=1;
    int currV=0;
    Rectangle r;
    int currentV=0;
    int road=0;
    
    Car(){
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
