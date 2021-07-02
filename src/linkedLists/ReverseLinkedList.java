package linkedLists;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode node = null;
        while(head !=null) {
            ListNode next = head.next;
            head.next = node;
            node = head;
            head = next;
        }
        return node;
    }

    public static void main(String[] args) {
        ReverseLinkedList rs = new ReverseLinkedList();
        ListNode node_1 = new ListNode(1,null);
        ListNode node_2 = new ListNode(2,null);
        ListNode node_3 = new ListNode(3,null);
        ListNode node_4 = new ListNode(4,null);
        ListNode node_5 = new ListNode(5,null);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;

        ListNode answer = rs.ReverseList(node_1);

        System.out.println(answer.val);

        while( answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }
}
