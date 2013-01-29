public class StringNode
{
    public String data;
    public StringNode next;

    public StringNode(String data, StringNode next)
    {
        this.data = data; this.next = next;
    }

    public String toString()
    {
        return data;
    }

    public static int numberOfOccurrences(StringNode front, String target) {
        int count = 0;
        for (StringNode ptr = front; ptr != null; ptr = ptr.next) {
            if (ptr.data.equals(target)) {
                    ++count;
            }
        }
        return count;
    }

    public void print()
    {
        for(StringNode ptr = this; ptr != null; ptr = ptr.next)
            System.out.print(ptr.data + " ");
        System.out.println();
    }



     public static StringNode deleteAllOccurrences(StringNode front, String target)
     {
         StringNode ptr = new StringNode(target, front);

         while (ptr != null && ptr.next != null) {
             if (ptr.next.data.equals(target)) {
                 if (ptr.next == front) {
                     front = front.next;
                 }
                 ptr.next = ptr.next.next;
             } else {
                 ptr = ptr.next;
             }
         }
         return front;
     }

     public static void main(String[] args)
     {
         StringNode front = new StringNode("a", new StringNode("a", new StringNode("b", new StringNode("a", null))));

         System.out.println(front.numberOfOccurrences(front, "a"));

         front.print();

         front = deleteAllOccurrences(front, "a");
         front.print();
     }
}
