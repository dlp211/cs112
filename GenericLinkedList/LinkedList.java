public class LinkedList<T>
{

    private Node<T> front;
    private Node<T> back;
    private int size;

    private static class Node<T>
    {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public LinkedList()
    {
        front = null;
        back = null;
        size = 0;
    }

    public LinkedList(T data)
    {
        front = new Node<T>(data);
        back = front;
        size = 1;
    }

    public boolean insertFront(T data)
    {
        if (front == null) {
            front = new Node<T>(data);
            back = front;
            ++size;
            return true;
        } else {
            Node<T> temp = new Node<T>(data);
            temp.next = front;
            front = temp;
            ++size;
            return true;
        }
    }

    public boolean insertLast(T data)
    {
        if (back == null) {
            return insertFront(data);
        } else {
            Node<T> temp = new Node<T>(data);
            temp.prev = back;
            back.next = temp;
            back = temp;
            ++size;
            return true;
        }
    }

    public void print()
    {
        for (Node<T> ptr = front; ptr != null; ptr = ptr.next)
            System.out.print(ptr.data + " ");
    }

    public T get(T target)
    {
        if (target == null) {
            return null;
        }
        Node<T> ptr;
        for (ptr = front; ptr != null && !target.equals(ptr.data); ptr = ptr.next) {
            ;
        }
        return ptr.data;
    }

    public boolean has(T target)
    {
        if (target == null) {
            return false;
        }
        for (Node<T> ptr = front; ptr != null; ptr = ptr.next) {
            if (target.equals(ptr.data))
                return true;
        }
        return false;
    }

    public boolean removeFirst(T target)
    {
        if (target == null) {
            return true;
        }
        for (Node<T> ptr = front; ptr != null; ptr = ptr.next) {
            if (target.equals(ptr.data)) {
                removePtr(ptr);
                return true;
            }
        }
        return false;
    }

    public boolean removeLast(T target)
    {
        return true;
    }

    public boolean removeAll(T target)
    {
        if (target == null) {
            return true;
        }
        Node<T> ptr = front;
        while (ptr != null) {
            if (target.equals(ptr.data)) {
                ptr = removePtr(ptr);
            } else {
                ptr = ptr.next;
            }
        }
        return true;
    }

    public void clear()
    {
        size = 0;
        front = back = null;
    }

    public int size()
    {
        return size;
    }

    private Node<T> removePtr(Node<T> ptr)
    {
        --size;
        if (ptr != front && ptr != back) {
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
            Node<T> ret = ptr.next;
            ptr.next = ptr.prev = null;
            return ret;
        } else if(size == 0) {
            clear();
            return null;
        } else if (ptr == front) {
            front.next.prev = null;
            front = front.next;
            return front;
        } else {
            back = back.prev;
            back.next = null;
            return null;
        }

    }
}
