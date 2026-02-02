package Graph;
public class GraphList {
    int V;
    int E;
    LinkedList<Integer> adj[];
    GraphList(int V,int E){
        this.V=V;
        this.E=E;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList();
        }
    }    
    
    void addEdge(int v1,int v2,int weight){
        adj[v1].addLast(v2);
    }
    
}
