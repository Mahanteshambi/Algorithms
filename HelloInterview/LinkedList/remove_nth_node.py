class ListNode:
    def __init__(self, val: int = 0, next: 'ListNode' = None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int):
        slow = fast = head
        for _ in range(n):
            fast = fast.next
        if not fast:
            return head.next
        while fast.next:
            slow = slow.next
            fast = fast.next
        
        slow.next = slow.next.next
        return head
    
    def print_list(self, head):
        while head:
            print(head.val)
            head = head.next
    
head = ListNode(5, ListNode(4, ListNode(3, ListNode(2, ListNode(1)))))
solution = Solution()
# solution.print_list(head)
# solution.removeNthFromEnd(head, 2)
# solution.print_list(head)
# print('=========')
head = ListNode(1)
result = solution.removeNthFromEnd(head, 1)
solution.print_list(result)