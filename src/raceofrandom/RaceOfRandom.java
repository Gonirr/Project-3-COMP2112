package raceofrandom;
import Graph.GraphList;
import java.io.InputStream;
import java.util.Scanner;

public class RaceOfRandom {
    public static void main(String[] args) {
        GraphList racetrack=read("/racetrack.txt");
        System.out.println(racetrack.toString());
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
