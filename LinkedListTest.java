
public class LinkedListTest
{

    public static void main(String[] args)
    {
        LinkedList<Test> list = new LinkedList<Test>();

        System.out.println();

        System.out.println("insertFirst test on null list, followed by insertLast test " +
                           "should print 1....20");
        for(int i = 10; i > 0; --i)
            list.insertFront(new Test(i));
        for(int i = 11; i < 21; ++i)
            list.insertLast(new Test(i));
        list.print();

        System.out.println("\n\nclear test, should print blank line");
        list.clear();
        list.print();
        System.out.println();

        System.out.println("insertLast test on null list, followed by insertFirst test " +
                           "should print 1....20");

        for(int i = 11; i < 21; ++i)
            list.insertLast(new Test(i));
        for(int i = 10; i > 0; --i)
            list.insertFront(new Test(i));
        list.print();

        System.out.println("\n\nhas test, should print true, false");
        System.out.print(list.has(new Test(2)) + ", ");
        System.out.println(list.has(new Test(21)));

        System.out.println("\nsize test, should print 20, 0, 20");
        System.out.print(list.size() + " ");
        list.clear();
        System.out.print(list.size() + " ");
        for (int i = 1; i < 21; ++i) {
            if (i % 2 == 1)
                list.insertLast(new Test(1));
            else
                list.insertLast(new Test(2));
        }
        System.out.println(list.size());

        System.out.println("\nremoveFirst test should print (2 1 ... 1 2) + size test should print 19");
        list.removeFirst(new Test(1));
        list.print(); System.out.print("size: " + list.size());

        System.out.println("\n\nremoveAll test should print (2...2) \"size: 10\"");
        list.insertLast(new Test(3));
        list.removeAll(new Test(3));
        list.removeAll(new Test(1));
        list.print(); System.out.print("size: " + list.size());

        System.out.println();
    }

}
