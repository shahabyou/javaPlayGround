package main.java.coding.ds;

public class MyLinkedList {

        public static void main(String[] args) {

//                MyLinkedList myLinkedList = new MyLinkedList();
//                myLinkedList.print("initializing phase");
//                myLinkedList.addAtHead(1);
//                myLinkedList.print("added 1 to head");
//                myLinkedList.addAtTail(3);
//                myLinkedList.print("added 3 to tail");
//                myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//                myLinkedList.print("add 2 at index 1");
//                System.out.println("Get index 1" + myLinkedList.get(1));              // return 2
//                myLinkedList.deleteAtIndex(0);    // now the linked list is 1->3
//                myLinkedList.print("delete index 0");
//                System.out.println( "Get" + myLinkedList.get(1));              // return 3

                MyLinkedList myLinkedList = new MyLinkedList();
                myLinkedList.print("initializing phase");
                myLinkedList.addAtIndex(0, 10);    // linked list becomes 1->2->3
                myLinkedList.print("add 2 at index 1");
                myLinkedList.addAtIndex(0, 20);    // linked list becomes 1->2->3
                myLinkedList.print("add 2 at index 1");
                myLinkedList.addAtIndex(1, 30);    // linked list becomes 1->2->3
                myLinkedList.print("add 2 at index 1");
                System.out.println( "Get" + myLinkedList.get(0));              // return 3

        }

         class SinglyListNode{
            public int val;
            public SinglyListNode next;
            public SinglyListNode(int val){
                this.val = val;

            }
        }

        SinglyListNode head;
        /** Initialize your data structure here. */
        public MyLinkedList() {
                head = null;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
                SinglyListNode cur = head;

                int i=0;
                while (0<=--index & cur!=null) {
                        cur = cur.next;
                        System.out.println("index "+ index);
                }

                if(index==-1) return cur.val;
                return -1;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
                SinglyListNode cur = new SinglyListNode(val);
                cur.next = head;
                head = cur;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
                if(head== null) head = new SinglyListNode(val);

                SinglyListNode cur = head;
                while (cur.next!=null) cur = cur.next;
                cur.next = new SinglyListNode(val);
        }

        /** Add a node of value val before the index-th node in the linked list.
         * If index equals to the length of linked list, the node will be appended to the end of linked list.
         * If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
                if(index==0) {
                        addAtHead(val);
                        return;
                }

                SinglyListNode node = new SinglyListNode(val);
                SinglyListNode cur = head;
                for (int i=1; i<index && cur!=null;i++)
                        cur=cur.next;
                if(cur!=null){
                        node.next = cur.next;
                        cur.next = node;
                }

        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
                if(head==null) return;

                SinglyListNode cur = head;

                if(index==0) {
                        head=cur.next;
                        return;
                }

                for(int i=0; i<index-2 && cur!=null; i++)
                        cur = cur.next;

                if( cur!=null && cur.next!=null)
                        cur.next = cur.next.next;
        }

        public void print(String desc){
                System.out.println(desc);
                SinglyListNode cur = head;
                while (cur!=null){
                     System.out.println(cur.val + ",");
                     cur = cur.next;
                }
        }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
