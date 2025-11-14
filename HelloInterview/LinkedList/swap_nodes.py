class ListNode:
    def __init__(self, val: int = 0, next: 'ListNode' = None):
        self.val = val
        self.next = next

class Solution:
    def swapPairs(self, head: ListNode):
        dummy = ListNode(0, head)
        prev, cur = dummy, head
        while cur and cur.next:
            sec_pair = cur.next.next
            second = cur.next
            
            second.next = cur
            cur.next = sec_pair
            prev.next = second
            
            prev = cur
            cur = sec_pair
            
        return dummy.next
    
    def print_list(self, head):
        while head:
            print(head.val)
            head = head.next
    
solution = Solution()
head = ListNode(5, ListNode(4, ListNode(3, ListNode(2, ListNode(1)))))
result = solution.swapPairs(head)
print(solution.print_list(result))
