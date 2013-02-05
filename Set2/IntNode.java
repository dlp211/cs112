public class IntNode
{
	public int data;
	public IntNode next;

	public IntNode(int data, IntNode next) {
		this.data = data;
		this.next = next;
	}

	public static IntNode merge(IntNode front1, IntNode front2) {

		if(front1 == null)
			return front2;
		if(front2 == null)
			return front1;

		if(front1.data == front2.data) {
			front1.next = merge(front1.next, front2.next);
			return front1;
		} else if(front1.data < front2.data) {
			front1.next = merge(front1.next, front2);
			return front1;
		} else {
			front2.next = merge(front1, front2.next);
			return front2;
		}
	}

	public static void main(String[] args) {

		IntNode front1 = new IntNode(3, new IntNode(9, new IntNode(12, new IntNode(15, null))));
		IntNode front2 = new IntNode(2, new IntNode(3, new IntNode(6, new IntNode(12, null))));

		IntNode front3 = merge(front1, front2);

		for(IntNode ptr = front3; ptr != null; ptr = ptr.next)
			System.out.print(ptr.data + " ");
		System.out.println();
	}
}