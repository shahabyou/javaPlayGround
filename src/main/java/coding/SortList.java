package main.java.coding;

public class SortList {

    public static void main(String[] args) {
        ListNode n = new ListNode(4);
        n.next = new ListNode(2);
        n.next.next = new ListNode(1);
        n.next.next.next = new ListNode(3);
        n = sortList(n);
        int i=0;
    }
 public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode p = null;
        ListNode s = head;
        ListNode f = head;
        while(f!=null && f.next!=null){
            p=s;
            s=s.next;
            f=f.next.next;
        }

        p.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(s);
        head = new ListNode(0);
        ListNode cur = head;
        while(left!=null && right!=null){
            if(left.val<right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if(right!=null){
            cur.next = right;
        }

        if(left!=null){
            cur.next = left;
        }

        return head.next;
    }

    static ListNode  merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }
}
