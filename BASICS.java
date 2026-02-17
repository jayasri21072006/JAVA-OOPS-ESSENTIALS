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
