import java.util.Deque;
import java.util.LinkedList;

public class DequeInsertion {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

        dq.addLast(10);  
        dq.addLast(20);
        dq.addLast(30);
        dq.addFirst(5); 
        dq.addFirst(1);
        System.out.print("Deque elements: ");
        for (int num : dq) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
