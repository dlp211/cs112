import java.util.NoSuchElementException;

public class LinkedListTest
{
	public static void main(String[] args) {
		LinkedList list = new LinkedList("a");
		list.print();
		try {
			list.delete("b");
		} catch(NoSuchElementException e) {
			System.out.println();
			System.out.println("deleteTest: PASS");
		}
		list.addAfter("c", "a");
		list.addAfter("b", "a");
		try {
			list.addAfter("e", "f");
		} catch(NoSuchElementException e) {
			System.out.println("addAfterTest: PASS");
		}
		list.print();
		System.out.println();
	}
}