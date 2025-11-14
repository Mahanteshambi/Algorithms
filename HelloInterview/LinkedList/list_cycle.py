class ListNode:
    def __init__(self, val: int = 0, next: 'ListNode' = None):
        self.val = val
        self.next = next

class Solution:
    def hasCycle(self, head: ListNode):
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False
    
head = ListNode(5, ListNode(4, ListNode(3, ListNode(2, ListNode(0)))))
head.next.next.next.next.next= head.next.next
solution = Solution()
result = solution.hasCycle(head)
assert(result == True)