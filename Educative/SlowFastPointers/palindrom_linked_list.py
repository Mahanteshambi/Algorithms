from linked_list_node import LinkedListNode
from linked_list_reverse import reverse_linked_list

def palindrome(head):
    slow, fast = head, head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    sec = reverse_linked_list(slow)
    slow = head
    while sec:
        if slow.data != sec.data:
            return False
        else:
            slow = slow.next
            sec = sec.next
    return True

if __name__ == "__main__":
    head = LinkedListNode(6)
    head.next = LinkedListNode(1)
    head.next.next = LinkedListNode(0)
    head.next.next.next = LinkedListNode(5)
    head.next.next.next.next = LinkedListNode(1)
    head.next.next.next.next.next = LinkedListNode(6)
    print(palindrome(head))