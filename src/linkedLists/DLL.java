package linkedLists;
/*A Doubly Linked List (DLL) contains an extra pointer, typically called previous pointer, together with next pointer and data which are there in singly linked list.
    5<- 1 <- 3 <- 7 <-
     >-
 */
public class DLL {
    Node head;
    public static class Node {
        int data;
        Node prev;
        Node next;
        public Node(int d) {
            this.data = d;
        }
    }

    public DLL(){
        this.head = null;
    }

    public Node createList(int[] arr) {
        // initially
        Node start = this.head;
        int n = arr.length;
        Node temp = start; //head at beginning
        int i = 0;

        while(i < n) {
            Node newNode = new Node(arr[i]);

            // 1st check if index is the started index
            if( i == 0) {
                start = newNode; // actual start node
                temp  =start; //start changed, we need to change it
            } else { //this is not the first
                temp.next = newNode;//connect the last node
                newNode.prev = temp;
                temp = temp.next; //always be the last node
            }
            i += 1;
        }

        this.head = start;
        return start;
    }

    Node insertAtLocation(int value,int index) {
        // index begin at 1
        Node temp = this.head;
        int count = this.countList(); //get the number of items in our current list

        // if position where we want to insert a node is not valid.
        if(count + 1 < index)
            return temp;

        Node newNode = new Node(value);

        if(index == 1) {//the head node is the only one with no previous node
            newNode.next = temp;
            temp.prev = newNode;
            this.head = newNode;

            return  this.head;
        }

        // if we haven't returned yet, meaning that the index where we want
        // to have the node at is not the sorted node
        // And if the index that we want to know that is actually the last node,
        // then that's also treated different
        if(index == count+1) {
            while(temp.next !=null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            return this.head;
        }

        // generic case
        int i =1;
        while(i < index - 1) { //until the previous node
            temp = temp.next;
            i-=1;
        }

        //Node at the next position is actually the node at our target index
        // not for long, but currently it's
        Node nodeAtTarget = temp.next;
        newNode.next = nodeAtTarget;
        nodeAtTarget.prev = newNode;

        // change de pointer of the prev node
        temp.next = newNode;
        newNode.prev = temp;

        return this.head;
    }

    int countList() {
        Node temp = this.head;
        int count = 0;

        while (temp != null) {
            // reverse the list
            temp = temp.next;
            count += 1;
        }

        return count;
    }

    /*
        Delete from location
        We will consider that the index begin at 1
     */
    Node deleteAtLocation(int index){
        Node temp = this.head;
        int count = countList();

        if(count < index) //remove at index where there are no values
            return temp;

        // return the head node
        if(index == 1){
            temp = temp.next; //temp is not our head
            this.head = temp;
            return this.head;
        }

        //index is equal to our count, delete our last node
        if(count == index) {
            // means that the next that next is not known, then will be at the node right before the end
            while (temp.next != null && temp.next.next != null) { //stop before the end
                temp = temp.next;
            }
            // 1-2-3-4 temp will be at 3
            temp.next = null;
            return this.head;
        }

        //generic case
        int i = 1;
        while(i < index - 1) {
            temp = temp.next;
            i ++;
        }

        // 1+>2+>3+>4 //we want to delete the 3
        Node prevNode = temp; // temp = 2
        Node nodeAtTarget = temp.next; // nodeAtTarget 3
        Node nextNode = nodeAtTarget.next; // next Nde = 4

        nextNode.prev = prevNode;
        prevNode.next = nextNode;

        return this.head;
    }

    /*
    this method is responsible for printing our lists.
     */
    public void printList() {
        Node temp = this.head;
        String linked_list = "";

        while(temp != null) {
            linked_list += temp.data + " => ";
            temp = temp .next;
        }
        System.out.println(linked_list);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        DLL llist = new DLL();
        llist.createList(arr);
        llist.printList();
        //llist.insertAtLocation(5,6);
        //llist.printList();
        llist.deleteAtLocation(2);
        llist.printList();
    }
}
