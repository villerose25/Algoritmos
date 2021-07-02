package linkedLists;

public class RemoveNthNodeFromEndOfList {

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0);
        ans.next = head;

        ListNode first = ans;
        ListNode second = ans;

        for(int i = 1; i <  n +2; i++) {
            first = first.next;
        }

        while(first!=null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return ans.next;
    }

    public static void main(String[] args) {
        // 1-> 3 -> 5 -> 7, n=2
        // 1 -> 3 -> 7
        ListNode node_1 = new ListNode(1);
        ListNode node_3 = new ListNode(3);
        ListNode node_5 = new ListNode(5);
        ListNode node_7 = new ListNode(7);

        node_1.next = node_3;
        node_3.next = node_5;
        node_5.next = node_7;

        ListNode ans = removeNthFromEnd(node_1, 2);

        while(ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
