import java.util.Deque;
import java.util.LinkedList;

public class Dequeue {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

        dq.addLast(10); 
        dq.addLast(20);
        dq.addLast(30);
        dq.addFirst(5); 
        dq.addFirst(1);

        System.out.print("Initial deque: ");
        for (int val : dq) {
            System.out.print(val + " ");
        }
        System.out.println();
        dq.removeFirst(); 
        System.out.print("After pop_front(): ");
        for (int val : dq) {
            System.out.print(val + " ");
        }
        System.out.println();
        dq.removeLast();
        System.out.print("After pop_back(): ");
        for (int val : dq) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
