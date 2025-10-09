from linked_list_node import LinkedListNode
from print_list import print_list_with_forward_arrow


def reverse_linked_list(head):
    curr = head
    prev, next = None, None
    while curr:
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    return prev
        
if __name__ == "__main__":
    head = LinkedListNode(1)
    head.next = LinkedListNode(2)
    head.next.next = LinkedListNode(3)
    head.next.next.next = LinkedListNode(4)
    head.next.next.next.next = LinkedListNode(5)
    print_list_with_forward_arrow(head)
    head = reverse_linked_list(head)
    print_list_with_forward_arrow(head)