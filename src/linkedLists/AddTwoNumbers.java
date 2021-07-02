package linkedLists;

public class AddTwoNumbers {

    public static class ListNode {
        Integer val;
        ListNode next;
        ListNode(Integer x) {
            this.val = x;
            this.next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(null);
        ListNode pointer= ans;
        Integer carry = 0;
        Integer sum = 0;

        while(l1!=null || l2 != null) {
            sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum/10; //will return a valid integer
            pointer.next = new ListNode(sum%10); // resultante
            pointer = pointer.next; //move the pointer to the pointer that next we just move it one step for the pointer
        }

        if(carry > 0)
            pointer.next = new ListNode(carry);

        return ans.next; // the actual answer begins after that
    }

    public static  void main(String[] args) {
        AddTwoNumbers s = new AddTwoNumbers();
        // first list implementation
        // creation
        ListNode l1_node_2 = new ListNode(2);
        ListNode l1_node_4 = new ListNode(4);
        ListNode l1_node_3 = new ListNode(3);
        //connection
        l1_node_2.next = l1_node_4;
        l1_node_4.next = l1_node_3;

        // second list implementation
        //creation
        ListNode l2_node_5 = new ListNode(5);
        ListNode l2_node_6 = new ListNode(6);
        ListNode l2_node_4 = new ListNode(4);
        //connection
        l2_node_5.next = l2_node_6;
        l2_node_6.next = l2_node_4;

        ListNode ans = s.addTwoNumbers(l1_node_2,l2_node_5);

        while(ans != null ){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
