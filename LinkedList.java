public class LinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void deleteNode() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;  
        size--;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void getSize() {
        System.out.println("Size of the list: " + size);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.display();  
        list.getSize();  

        list.deleteNode();  
        list.display();     
        list.getSize();     
    }
}
