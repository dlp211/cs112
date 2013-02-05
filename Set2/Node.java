public class Node
{
	public String data;
	public Node next;
    
    public Node(String data, Node next) {
        this.data = data; this.next = next;
    }

    public static Node deleteAll(Node front, String target) {

    	if(front == null)
    		return front;

    	if(target.equals(front.data))
    		return deleteAll(front.next, target);

    	front.next = deleteAll(front.next, target);

    	return front;
    }

    public static void print(Node ptr) {
    	for(;ptr != null; ptr = ptr.next) {
    		System.out.print(ptr.data + " ");
    	}
    	System.out.println();
    }

    public static void main(String[] args) {
    	Node front = new Node("c", new Node("a", new Node("b", new Node("c", new Node("d", 
    				 new Node("c", new Node("e", new Node("c", null))))))));

    	print(front);

    	front = deleteAll(front, "c");

    	print(front);
    } 
}