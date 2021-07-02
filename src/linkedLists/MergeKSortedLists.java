package linkedLists;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    static public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size() == 0)
            return  null;

       int i=0;
       int last= lists.size()-1;
       int j = last;

       while(last!=0) {
           i = 0;
           j = last; //reset j

           //merge 2 lists
           while (j > i) {
               lists.set(i, mergeTwoLists(lists.get(i), lists.get(j)));
               i++;
               j--;
               last = j;
           }
       }

       return lists.get(0);
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode cur = new ListNode(0);
        ListNode ans = cur;

        while(l1!=null && l2!=null) {
            if(l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next; //some point it wont be valid
        }

        // as long l1 is valid
        while(l1!=null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }

        while(l2!=null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }

        return ans.next;
    }

    public static void main(String[] args) {
        //indexes
        //10->20->30->40->50
        // output
        //10->30->50->20->40
        ListNode l1_node_1 = new ListNode(1);
        ListNode l1_node_2 = new ListNode(2);
        ListNode l1_node_4 = new ListNode(4);

        l1_node_1.next = l1_node_2;
        l1_node_2.next = l1_node_4;

        ListNode l2_node_2 = new ListNode(1);
        ListNode l2_node_3 = new ListNode(3);
        ListNode l2_node_4 = new ListNode(4);
        // connection

        l2_node_2.next = l2_node_3;
        l2_node_3.next = l2_node_4;

        List<ListNode> lists = new ArrayList<ListNode>();
        lists.add(l1_node_1);
        lists.add(l2_node_2);
        ListNode ans = mergeKLists(lists);

        while(ans!=null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
