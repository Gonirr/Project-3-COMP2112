package Graph;
public class LinkedList<T> {
    private Node first;
    private Node last;
    
    LinkedList(){
        first=null;
        last=null;
    }
    
    public void addLast(T data){
        Node n=new Node(data);
        if(last==null){
            first=n;
            last=n;
        }
        else{
            last.next=n;
            last=last.next;
        }
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }
    
    public void printList(){
        Node n=first;
        while(n!=null){
            System.out.print(n.data+"->");
            n=n.next;
        }
        System.out.println("null");
    }
}
