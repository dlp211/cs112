class Node
{
    public int val;
    public Node next;

    public Node(int val, Node next) {
        this.val = val; this.next = next;
    }

    public void print() {
        Node ptr;
        for (ptr = this.next; ptr != this; ptr = ptr.next) {
            System.out.print(ptr.val + " ");
        }
        System.out.println(ptr.val);
    }

}

class Suits
{
    public Node clubsRear;
    public Node spadesRear;
    public Node heartsRear;
    public Node diamondsRear;

    public void print() {
        Node ptr;
        for (ptr = clubsRear.next; ptr != clubsRear; ptr = ptr.next) {
            System.out.print(ptr.val + " ");
        }
        System.out.println(ptr.val);
        for (ptr = spadesRear.next; ptr != spadesRear; ptr = ptr.next) {
            System.out.print(ptr.val + " ");
        }
        System.out.println(ptr.val);
        for (ptr = heartsRear.next; ptr != heartsRear; ptr = ptr.next) {
            System.out.print(ptr.val + " ");
        }
        System.out.println(ptr.val);
        for (ptr = diamondsRear.next; ptr != diamondsRear; ptr = ptr.next) {
            System.out.print(ptr.val + " ");
        }
        System.out.println(ptr.val);
    }

}

public class Cards
{

    public static void main(String[] args)
    {

        Node deckRear = null;

        //creates a deck of cards in an array as per the description
        int[] deckFiller = new int[52];
        for (int i = 0; i < deckFiller.length; ++i)
            deckFiller[i] = i + 1;

        //shuffles the deck and puts it into a CLL
        int count = 52;
        while (count > 0) {
            int index = (int) (52 * Math.random());
            if (deckFiller[index] == 0) {
                continue;
            }
            if (deckRear == null) {
                deckRear = new Node(deckFiller[index], null);
                deckRear.next = deckRear;
                --count;
                deckFiller[index] = 0;
                continue;
            }
            Node prev, ptr;
            for(prev = deckRear, ptr = deckRear.next; ptr != deckRear; prev = ptr, ptr = ptr.next) {
                ;
            }

            prev.next = new Node(deckFiller[index], ptr);
            --count;
            deckFiller[index] = 0;
        }

        //prints the deck for function validation
        deckRear.print();
        Suits s = extractSuits(deckRear);
        //prints the suits in order as described for function validation
        s.print();
    }

     // extracts the suits from deck WITHOUT creating any new nodes, i.e. the nodes
     // in each suit are the same as the nodes in the deck
     // the original deck will not exist at the end of the method since the links of
     // the nodes will be changed when grouping according to suits
     public static Suits extractSuits(Node deckRear) {
        Node ptr = deckRear.next;
        Suits suits = new Suits();

        //this is a poor way to run the loop.  It assumes that the deck is 52 cards
        //The 4 switch statements all do the same thing with different variables
        //should be farmed out to a function
        int count = 0;
        while(count != 52)
        {
            switch ((ptr.val - 1)/13) {
                case 0:
                    if (suits.clubsRear == null) {
                        suits.clubsRear = ptr;
                        ptr = ptr.next;
                        suits.clubsRear.next = suits.clubsRear;
                    } else {
                        Node p = suits.clubsRear.next;
                        suits.clubsRear.next = ptr;
                        ptr = ptr.next;
                        suits.clubsRear.next.next = p;
                        suits.clubsRear = suits.clubsRear.next;
                    }
                    break;
                case 1:
                    if (suits.spadesRear == null) {
                        suits.spadesRear = ptr;
                        ptr = ptr.next;
                        suits.spadesRear.next = suits.spadesRear;
                        break;
                    } else {
                        Node p = suits.spadesRear.next;
                        suits.spadesRear.next = ptr;
                        ptr = ptr.next;
                        suits.spadesRear.next.next = p;
                        suits.spadesRear = suits.spadesRear.next;
                    }
                    break;
                case 2:
                    if (suits.heartsRear == null) {
                        suits.heartsRear = ptr;
                        ptr = ptr.next;
                        suits.heartsRear.next = suits.heartsRear;
                        break;
                    } else {
                        Node p = suits.heartsRear.next;
                        suits.heartsRear.next = ptr;
                        ptr = ptr.next;
                        suits.heartsRear.next.next = p;
                        suits.heartsRear = suits.heartsRear.next;
                    }
                    break;
                case 3:
                    if (suits.diamondsRear == null) {
                        suits.diamondsRear = ptr;
                        ptr = ptr.next;
                        suits.diamondsRear.next = suits.diamondsRear;
                        break;
                    } else {
                        Node p = suits.diamondsRear.next;
                        suits.diamondsRear.next = ptr;
                        ptr = ptr.next;
                        suits.diamondsRear.next.next = p;
                        suits.diamondsRear = suits.diamondsRear.next;
                    }
                    break;
                default:
                    System.out.println("You screwed something up");
            }
            ++count;
        }
        return suits;
     }


}
