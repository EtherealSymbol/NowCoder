import java.util.*;

public class NC207 {

    public static ListNode sortLinkedList(ListNode head) {
//        ListNode ans = head;
        if (head == null || head.next==null) {
            return head;
        }
        Deque<ListNode> qi = new LinkedList<>(); // 偶数队
        Deque<ListNode> qj = new LinkedList<>(); // 奇数队
//        Stack<ListNode> si = new Stack<>(); //
        ListNode p=head;
//        q.addFirst(p);
        while(p!=null){
            qi.addLast(p);
            p=p.next;
            if(p!=null){
                qj.addFirst(p);
                p=p.next;
            }
        }
        // qi不可能为空
        if(qj.isEmpty()){
            head=qi.pop();
            p=head;
            while(!qi.isEmpty()){
                p.next=qi.pop();
                p=p.next;
            }
        }
        if (qi.getFirst().val < qj.getFirst().val){
            head=qi.pop();
        }else{
            head=qj.pop();
        }
        System.out.println("AAA");
        p=head;
        while (!qi.isEmpty() && !qj.isEmpty()){
            while(!qi.isEmpty() && !qj.isEmpty() && qi.peek().val<=qj.peek().val){
                p.next=qi.pop();
                p=p.next;
//                System.out.println("BBB");
            }

            while(!qi.isEmpty() && !qj.isEmpty() && qj.peek().val<qi.peek().val){
                p.next=qj.pop();
                p=p.next;
//                System.out.println("CCC");
            }
        }
        while(!qi.isEmpty()){
            p.next=qi.pop();
            p=p.next;
        }
        while(!qj.isEmpty()){
            p.next=qj.pop();
            p=p.next;
        }
        p.next=null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode p =head;
        for (int i = 1; i < 4; i++) {
            p.next = new ListNode(i);
            p=p.next;
            p.next = new ListNode(4-i);
            p=p.next;
        }
        p = head.next;
        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }
        head = sortLinkedList(head.next);
        p = head;
        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}