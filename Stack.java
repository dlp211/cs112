import java.util.NoSuchElementException;

class Stacks<T>
{

        private static class Node<T> {
            public T data;
            public Node<T> next;

            public Node(T data, Node<T> next) {
                this.data = data;
                this.next = next;
            }
        }

        private Node<T> stk;

        public Stacks() {
        }

        public void push(T item) {
            stk = new Node<T>(item, stk);
        }

        public T pop() throws NoSuchElementException {
            if (this.isEmpty())
                throw new NoSuchElementException();
            T data = stk.data;
            stk = stk.next;
            return data;
        }

        public boolean isEmpty() {
            return stk == null;
        }

        //this is a test method
        public void print() {
            for(Node<T> ptr = stk; ptr != null; ptr = ptr.next)
                System.out.print(ptr.data + " ");
            System.out.println();
        }


}

public class Stack
{

    public static void main(String[] args)
    {
        Stacks<String> stk = new Stacks<String>();
        stk.push("a");
        stk.push("b");
        stk.push("c");
        stk.push("d");
        stk.push("e");

        System.out.println(size(stk));
        //shows that the stack has not been altered
        stk.print();
    }

    //Runs in O(n) time
    public static <T> int size(Stacks<T> S)
    {
        int count = 0;
        Stacks<T> stk = new Stacks<T>();

        while (true) {
            try {
                stk.push(S.pop());
                ++count;
            } catch (NoSuchElementException e) {
                break;
            }
        }

        while (true) {
            try {
                S.push(stk.pop());
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return count;
    }
}
