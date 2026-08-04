class Solution:

  def mergeKLists(self, lists):
    if not lists:
      return None

    head = lists[0]
    for i in range(1, len(lists)):
      head = self.mergeTwoLists(head, lists[i])

    return head

  def mergeTwoLists(self, l1, l2):
    dummy = ListNode(0)
    curr = dummy

    while l1 and l2:
      if l1.val < l2.val:
        curr.next = l1
        l1 = l1.next
      else:
        curr.next = l2
        l2 = l2.next
      curr = curr.next

    if l1:
      curr.next = l1
    if l2:
      curr.next = l2

    return dummy.next