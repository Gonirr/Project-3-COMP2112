package Graph;
public class test {
    public static void main(String[] args) {
        GraphList g=new GraphList(4,4);
        g.addEdge(1, 2, 9);
        g.addEdge(1, 0, 3);
        System.out.println(g.toString());
    }
    
}
