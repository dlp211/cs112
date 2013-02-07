import java.util.NoSuchElementException;

public class Stack<T>
{

    private LinkedList<T> list;

    public Stack()
    {
        list = null;
    }

    public Stack(T item)
    {
        list = new LinkedList<T>(item);
    }

    public boolean isEmpty()
    {
        if (list == null)
            return true;
        return list.isEmpty();
    }

    public T pop() throws NoSuchElementException
    {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        return list.removeFront();
    }

    public boolean push(T item)
    {
        if (list == null) {
            list = new LinkedList<T>(item);
            return true;
        }
        return list.insertFront(item);
    }

    public void clear()
    {
        if (list == null) {
            return;
        }
        list.clear();
    }

    public int size()
    {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T peek() throws NoSuchElementException
    {
        if (list == null) {
            throw new NoSuchElementException();
        }
        T temp = list.removeFront();
        list.insertFront(temp);
        return temp;
    }
}
