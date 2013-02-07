import java.util.NoSuchElementException;

public class LinkedList 
{
    private static class Node {
        public String data;
        public Node next;
         
        public Node(String data, Node next) {
          this.data = data; this.next = next;
        }
    }
    
    private Node rear;  // pointer to last node of CLL

    public LinkedList() {}

    public LinkedList(String s) {
        rear = new Node(s, null);
        rear.next = rear;
    }

    public void print() {

        if (rear == null)
          System.out.println("List is empty");
        Node ptr = rear;
        do {
          ptr = ptr.next;
          System.out.print(ptr.data + " ");
        } while (ptr != rear);
    }

    public void addAfter(String newItem, String afterItem) throws NoSuchElementException {
          //handle empty list
          if (rear == null) {
              throw new NoSuchElementException(afterItem);
          }

          Node ptr = rear;

          do {
              if (afterItem.equals(ptr.data)) {
                  //handle insertion after rear
                  if(ptr == rear) {
                      Node newNode = new Node(newItem, rear.next);
                      rear.next = newNode;
                      rear = newNode;
                      return;
                  } else { //handle all other insertions
                      Node newNode = new Node(newItem, ptr.next);
                      ptr.next = newNode;
                      return;
                  }
              }
              ptr = ptr.next;
          } while (ptr != rear);

          throw new NoSuchElementException(afterItem);
     }

    public void delete(String target) throws NoSuchElementException {

        //handle empty list
        if (rear == null) {
            throw new NoSuchElementException(target);
        }

        Node ptr = rear.next;
        Node prev = rear;

        do {

          if (target.equals(ptr.data)) {
              //handle single item in list that matches
              if (prev == ptr) {
                  rear = null;
                  return;
              } else if(ptr == rear) {
                  prev.next = ptr.next;
                  rear = prev;
                  return;
              } else {
                  prev.next = ptr.next;
                  return;
              }


          }
          prev = ptr;
          ptr = ptr.next;
        } while (prev != rear);

        throw new NoSuchElementException(target);

     }
}
