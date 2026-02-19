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




1 -> 2 -> 3 -> 4 -> null
2 -> 3 -> 4 -> null
2 -> 3 -> null
3 -> null
null




  public class Linkedlist {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // 1️⃣ Insert at Head
    static Node insertAtHead(Node head, int val) {
        return new Node(val, head);
    }

    // 2️⃣ Insert at Tail
    static Node insertAtTail(Node head, int val) {

        Node newnode = new Node(val);

        if (head == null) {
            return newnode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newnode;

        return head;
    }

    // 3️⃣ Insert at Position (0-based index)
    static Node insertAtPosition(Node head, int position, int val) {

        Node newnode = new Node(val);

        if (position == 0) {
            newnode.next = head;
            return newnode;
        }

        Node temp = head;
        int count = 0;

        while (temp != null)  {
            
            count++;
            if(count==position-1){
                temp.next=new Node(val,temp.next);
                break;
                
            }
            temp=temp.next;
        }

        

       

        return head;
    }

    // 4️⃣ Insert After a Given Value
    static Node insertAfterValue(Node head, int target, int val) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == target) {

                Node newnode = new Node(val);
                newnode.next = temp.next;
                temp.next = newnode;

                break;
            }

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

        Node head = null;

        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        printList(head);

        head = insertAtTail(head, 4);
        printList(head);

        head = insertAtPosition(head, 2, 99);
        printList(head);

        head = insertAfterValue(head, 3, 77);
        printList(head);
    }
}



1 -> 2 -> 3 -> null
1 -> 2 -> 3 -> 4 -> null
1 -> 2 -> 99 -> 3 -> 4 -> null
1 -> 2 -> 99 -> 3 -> 77 -> 4 -> null
