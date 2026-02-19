CREATION OF LINKED LIST ::



  public class Linkedlist {

    static class Node {
        int data;
        Node next;

        // Constructor for single node
        Node(int data) {
            this.data = data;
            this.next = null;
        }

        // Constructor for node with next reference
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        Node x = new Node(arr[1]);        // Node with value 2
        Node y = new Node(arr[0], x);     // Node with value 1 pointing to x

        System.out.println(y.data);       // 1
        System.out.println(y.next.data);  // 2
    }
}





LINKED LIST DELETION::




  public class Linkedlist {

    static class Node {
        int data;
        Node next;

        // Constructor for single node
        Node(int data) {
            this.data = data;
            this.next = null;
        }

        // Constructor for node with next reference
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // 🔹 Delete at Head
    static Node deleteAtHead(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        return head.next;
    }

    // 🔹 Delete at Tail
    static Node deleteAtTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    // 🔹 Delete by Position (0-based index)
  static Node deleteByPosition(Node head, int position) {

    if (head == null) return null;

    if (position == 0) {
        return head.next;
    }

    Node temp = head;
    Node prev = null;
    int count = 0;

    while (temp != null) {

        if (count == position) {
            prev.next = temp.next;
            break;
        }

        prev = temp;
        temp = temp.next;
        count++;
    }

    return head;
}


    // 🔹 Delete by Value
   static Node deleteByValue(Node head, int val) {

    if (head == null) return null;

    if (head.data== val) {
        return head.next;
    }

    Node temp = head;
    Node prev = null;
    

    while (temp != null) {

        if (temp.data == val) {
            prev.next = temp.next;
            break;
        }

        prev = temp;
        temp = temp.next;
       
    }

    return head;
}

    // 🔹 Print List
    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        // Creating list using your style
        Node x = new Node(arr[1]);
        Node y = new Node(arr[0], x);
        Node z = new Node(arr[2]);
        x.next = z;
        z.next = new Node(arr[3]);

        Node head = y;

        printList(head);

        head = deleteAtHead(head);
        printList(head);

        head = deleteAtTail(head);
        printList(head);

        head = deleteByPosition(head, 0);
        printList(head);

        head = deleteByValue(head, 3);
        printList(head);
    }
}
