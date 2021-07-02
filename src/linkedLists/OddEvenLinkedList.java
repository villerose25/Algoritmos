package linkedLists;

public class OddEvenLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    static ListNode oddEvenList(ListNode head) {
        if(head == null)
            return  head;

        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenList = even;

        while(even!=null && even.next!=null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenList;
        return head;
    }

    public static void main(String[] args) {
        //indexes
        //10->20->30->40->50
        // output
        //10->30->50->20->40
        ListNode node_10 = new ListNode(10);
        ListNode node_20 = new ListNode(20);
        ListNode node_30 = new ListNode(30);
        ListNode node_40 = new ListNode(40);
        ListNode node_50 = new ListNode(50);
        // connection
        node_10.next = node_20;
        node_20.next = node_30;
        node_30.next = node_40;
        node_40.next = node_50;

        oddEvenList(node_10);

        while(node_10!=null) {
            System.out.println(node_10.val);
            node_10 = node_10.next;
        }
    }
}
