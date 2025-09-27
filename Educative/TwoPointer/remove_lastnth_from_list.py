# Definition for a Linked List node
class LinkedListNode:
    def __init__(self, data, next=None):
        self.data = data
        self.next = next

class LinkedList:
    # __init__ will be used to make a LinkedList type object.
    def __init__(self):
        self.head = None

    # insert_node_at_head method will insert a LinkedListNode at head
    # of a linked list.
    def insert_node_at_head(self, node):
        if self.head:
            node.next = self.head
            self.head = node
        else:
            self.head = node

    # create_linked_list method will create the linked list using the
    # given integer array with the help of InsertAthead method.
    def create_linked_list(self, lst):
        for x in reversed(lst):
            new_node = LinkedListNode(x)
            self.insert_node_at_head(new_node)
    
    # __str__(self) method will display the elements of linked list.
    def __str__(self):
        result = ""
        temp = self.head
        while temp:
            result += str(temp.data)
            temp = temp.next
            if temp:
                result += ", "
        result += ""
        return result

def remove_nth_last_node(head, n):
    
    # Replace this placeholder return statement with your code
    left = head
    right = head
    while n>0:
        if not right.next:
            return head.next
        right = right.next
        n -= 1
    while right.next:
        right = right.next
        left = left.next
    left.next = left.next.next
    return head

linked_list = LinkedList()
linked_list.create_linked_list([23,28,10,5,67,39,70,28])
print("Original list: ", linked_list)
updated_head = remove_nth_last_node(linked_list.head, 9)
updated_list = LinkedList()
updated_list.head = updated_head
print("Updated list: ", updated_list)