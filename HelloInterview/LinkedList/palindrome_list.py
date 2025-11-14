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
    def isPalindrome(self, head: ListNode):
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        second_half = self.revers(slow)
        while second_half:
            if head.val != second_half.val:
                return False
            head = head.next
            second_half = second_half.next
        return True
    
solution = Solution()
head = ListNode(5, ListNode(4, ListNode(3, ListNode(4, ListNode(5)))))
result = solution.isPalindrome(head)
assert(result == True)