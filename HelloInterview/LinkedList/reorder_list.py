class ListNode:
    def __init__(self, val: int = 0, next: 'ListNode' = None):
        self.val = val
        self.next = next

class Solution:
    def revers(self, head):
        prev = None
        cur = head
        while cur:
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        return prev
    
    def reorderList(self, head: ListNode):
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        second_half = self.revers(slow)
        slow.next = None
        first, second = head, second_half
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next
        return head
        
    def print_list(self, head):
        while head:
            print(head.val)
            head = head.next
    
head = ListNode(5, ListNode(4, ListNode(3, ListNode(2, ListNode(1)))))
solution = Solution()
result = solution.reorderList(head)
solution.print_list(result)