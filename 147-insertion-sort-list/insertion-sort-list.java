/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode temp=head;
        while(temp!=null){
            ListNode agla=temp.next;
            ListNode pichla=dummy;
            while(pichla.next!=null && pichla.next.val<=temp.val)
                pichla=pichla.next;
            temp.next=pichla.next;
            pichla.next=temp;
            temp=agla;
        }
        return dummy.next;
    }
}