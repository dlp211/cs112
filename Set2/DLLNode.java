public class DLLNode {
         
      public String data;
      public DLLNode prev, next;
      
      public DLLNode(String data, DLLNode next) {
          this.data = data; this.next = next;
      }

      public static void moveToFront(DLLNode front, DLLNode target) {
            if (front == null || target == null) {
               return;
            }

            //if item is the end of the list
            if (target.next == null) {
               target.prev.next = null;
               target.next = front;
               front.prev = target;
               target.prev = null;
               return;
            }
            //link up the surrounding nodes
            target.prev.next = target.next;
            target.next.prev = target.prev;
            target.next = front;
            front.prev = target;
            target.prev = null;
      }

      public static void main(String[] args) {
         DLLNode front = new DLLNode("a", null);
         front.next = new DLLNode("b", null);
         front.next.prev = front;
         front.next.next = new DLLNode("c", null);
         front.next.next.prev = front.next;

         DLLNode ptr = front;
         while(ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
         }
         DLLNode newFront = front.next;
         moveToFront(front, newFront);

         ptr = newFront;
         while(ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
         }

      }
}