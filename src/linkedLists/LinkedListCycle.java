package linkedLists;

import java.util.List;
import java.util.ListIterator;

/*
    Given a linked list, return a boolean indicating if there is a cycle
    1=> 2 => 3 => 4 => 5 => 11
            <= 7 <= 9 <=8<=6<=
 */
/*
    ALGORITMO TC O(N) SC O(1) only single loop and 2 variables, no external data structureds.
    1. Inicializar 2 pointers, turtle and hare, al inicio de la lista
        hare = head
        turtle = head
    2. Starta a loop that will go on as long as the turtle, the hare and
        the next element after the hare are all valid

        while turtle and hare and hare.next:
   3. In the loop, keep moving the turtle to the next element
   BUT move the hare 2 steps at a time
            hare = hare.next.next
            turtle = turlte.next
   4. Check if hare and turtle are the same, if they are, a cycle exist.
            if(turtle == hare):
                return true
 */
public class LinkedListCycle {
     // Linked list Node
    static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            this.val = x;
            next = null;
        }
    }

    Boolean hasCycle (ListNode head) {
        ListNode  hare = head;
        ListNode  turtle = head;

        while((turtle!=null) && (hare!=null) && hare.next!=null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if(turtle == hare)
                return true;
        }
        return false;
    }



    public static void main(String[] args) {
        LinkedListCycle s = new LinkedListCycle();
        ListNode node_1 = new ListNode(1);
        ListNode node_5 = new ListNode(5);
        ListNode node_11 = new ListNode(11);
        ListNode node_8 = new ListNode(8);
        ListNode node_9 = new ListNode(9);

        node_1.next = node_5;
        node_5.next = node_11;
        node_11.next = node_8;
        node_8.next = node_9;
        //node_9.next = node_5;

        boolean answer = s.hasCycle(node_1);

        System.out.println(Boolean.toString(answer));
    }
}
