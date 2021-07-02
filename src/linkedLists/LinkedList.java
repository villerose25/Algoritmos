package linkedLists;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            // next pointer initially will be none
            // which means that the pointer is none initially
            this.next = null;
        }

    }

    public void insertNode(int val, int pos) {
        /* 1&2: allocate the Node & Put in the data*/
        Node target = new Node(val);

        // 3. Make next of new Node as head
        if(pos == 0) {
            target.next = this.head;
            // Move the head to point to new Node
            this.head = target;
            return;
        }

        Node prev = getPrev(pos);
        Node nextNode = prev.next;
        prev.next = target;
        target.next = nextNode;
    }

    private Node getPrev(int pos) {
        // make a pointer to our head
        Node temp = this.head;
        int count =1;

        // move the pointer no next position
        while(count < pos) {
            temp = temp.next;
            // on each node we visit, we increase the counter
            count += 1;
        }
        return temp;
    }

    public void deleteNode(int key) {
        // Store head node
        Node  temp = this.head;

        if(temp == null)
            return;
        // If head node itself holds the key to be deleted
        if(temp.data == key){
            this.head = temp.next;
            temp = null;
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp.next.data != key) {
            temp = temp.next;
        }

        Node target_node = temp.next;
        // remove the connection between temp
        temp.next = target_node.next;
        target_node.next = null;

    }
    public void printList() {
        Node temp = this.head;
        String linked_list = "";
        while(temp != null) {
            linked_list += temp.data + " => ";
            temp = temp.next;
        }

        System.out.println(linked_list);
    }

    public static void main(String[] args) {
        LinkedList linked_list = new LinkedList();

        // Node structure: 5=> 1 => 3 => 7
        linked_list.head = new Node(5);
        Node second_node = new Node(1);
        Node third_node = new Node(3);
        Node fourth_node = new Node(7);

        // but they are not connected
        linked_list.head.next = second_node;
        second_node.next = third_node;
        third_node.next = fourth_node;
        linked_list.printList();
        linked_list.insertNode(2,2);
        linked_list.printList();
        linked_list.deleteNode(3);
        linked_list.printList();
    }
}
