public class IntNode {

    public int data;
    public IntNode next;

    public IntNode(int data, IntNode next) {
        this.data = data; this.next = next;
    }

    public String toString() {
        return data + "";
    }


    public static IntNode addBefore(final IntNode front, final int target, final int newItem) {

        IntNode ptr = new IntNode(target, front);

        while (ptr.next != null) {
            if (target == ptr.next.data) {
                IntNode newNode = new IntNode(newItem, ptr.next);
                ptr.next = newNode;
                if (newNode.next == front) {
                    return newNode;
                } else {
                    return front;
                }
            }
            ptr = ptr.next;
        }
        return front;
    }

    public static void deleteEveryOther(final IntNode front) {

        if (front == null || front.next == null)
            return;

        int count = 0;
        IntNode ptr = front;
        IntNode prev = null;

        while (ptr != null) {
            if (count % 2 == 0) {
                prev = ptr;
                ptr = ptr.next;
            } else {
                prev.next = ptr.next;
                ptr = prev.next;
            }
            ++count;
        }
    }

    public static IntNode commonElements(final IntNode frontL1, final IntNode frontL2) {

        IntNode ptr1 = frontL1;
        IntNode ptr2 = frontL2;
        IntNode newList = null;

        while (ptr1 != null && ptr2 != null) {

            if (ptr1.data == ptr2.data) {
                newList = add(newList, ptr1.data);
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            } else if (ptr1.data < ptr2.data) {
                ptr1 = ptr1.next;
            } else {
                ptr2 = ptr2.next;
            }
        }

        return newList;
    }

    public static IntNode add(IntNode front, int data) {

        if (front == null) {
            return new IntNode(data, null);
        } else {
            IntNode ptr;
            for (ptr = front; ptr.next != null; ptr = ptr.next) {
                ;
            }
            ptr.next = new IntNode(data, null);
        }
        return front;
    }


    public void print() {
        for(IntNode ptr = this; ptr != null; ptr = ptr.next)
            System.out.print(ptr + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        IntNode frontL1 = new IntNode(3, new IntNode(9, new IntNode(12, new IntNode(15, new IntNode(21, null)))));
        IntNode frontL2 = new IntNode(2, new IntNode(3, new IntNode(6, new IntNode(12, new IntNode(19, null)))));
        IntNode frontL3 = commonElements(frontL1, frontL2);
        frontL3.print();

        frontL1.print();

        deleteEveryOther(frontL1);
        frontL1.print();

        System.out.println();

        frontL1 = addBefore(frontL1, 3, 1);
        System.out.println();
        frontL1.print();
/*
        deleteEveryOther(front);
        front.print();

        deleteEveryOther(front);
        front.print();

        deleteEveryOther(front);
        front.print();*/

    }


}
