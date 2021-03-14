package demo;

/**
 * @author：hanzhigang
 * @Date : 2020/11/22 10:57 AM
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null){
            return head;
        }
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }

        ListNode dummyhead = new ListNode(0,head);
        for(int sublength = 1; sublength < length; sublength <<= 1){
            ListNode prehead = dummyhead,prev = dummyhead.next;
            while(prev != null){
                ListNode head1 = prev;
                for(int i = 1; prev.next!= null && i < sublength; i++){
                    prev = prev.next;
                }
                ListNode head2 = prev.next;
                prev.next = null;
                prev = head2;
                for(int i = 1; prev != null && prev.next != null && i< sublength; i++){
                    prev = prev.next;
                }
                ListNode next = null;
                if(prev != null){
                    next = prev.next;
                    prev.next = null;
                }
                ListNode merged = merge(head1,head2);
                prehead.next = merged;
                while(prehead.next != null){
                    prehead = prehead.next;
                }
                prev = next;
            }
        }
        return dummyhead.next;
    }

    // 将一分为二的链表合并排序
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        ListNode temp1 = l1,temp2 = l2;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                prev.next = temp1;
                temp1 = temp1.next;
            }else{
                prev.next = temp2;
                temp2 = temp2.next;
            }
            prev = prev.next;
        }
        prev.next = temp1 == null ? temp2 : temp1;

        return prehead.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode next1 = new ListNode(5);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(0);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        SortList sortList = new SortList();
        System.out.println(sortList.sortList(head));
    }
}
