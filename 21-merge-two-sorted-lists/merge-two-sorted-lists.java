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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newnode = new ListNode(0);
        ListNode q1=newnode;
        ListNode node1=list1;
        ListNode node2=list2;
        while (node1 != null && node2 != null)
        {
            if(node1.val>=node2.val)
            {
                q1.next=node2;
                node2=node2.next;
            }
            else{
                q1.next=node1;
                node1=node1.next;
            }
            q1=q1.next;
        }
        while(node1!=null)
        {
            q1.next=node1;
            node1=node1.next;
            q1=q1.next;
        }
        while(node2!=null)
        {
            q1.next=node2;
            node2=node2.next;
            q1=q1.next;
        }
        return newnode.next;
    }
}