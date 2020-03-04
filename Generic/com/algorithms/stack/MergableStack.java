package com.algorithms.stack;

public class MergableStack {

	private void push(Stack s, int item) {
		s.add(item);
	}

	private int pop(Stack s) {
		return s.remove();
	}

	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
		}
	}

	class Stack {
		Node lastNode;
		Node firstNode;

		protected void add(int x) {
			Node currNode = new Node(x);
			if (firstNode == null) {
				firstNode = lastNode = currNode;
			} else {
				currNode.next = firstNode;
				firstNode = currNode;
			}
		}

		protected int remove() {
			if (firstNode == null) {
				return -1;
			}
			int x = firstNode.data;
			firstNode = firstNode.next;
			return x;
		}

		protected void printStack() {
			System.out.println("Stack content: ");
			Node node = firstNode;
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
			System.out.println();
		}

		protected void mergeStack(Stack s) {
			this.lastNode.next = s.firstNode;
			s.firstNode = null;
		}
	}

	public static void main(String[] args) {
		MergableStack obj = new MergableStack();
		Stack s1 = obj.new Stack();
		Stack s2 = obj.new Stack();
		obj.push(s1, 10);
		obj.push(s1, 20);
		obj.push(s1, 30);

		obj.push(s2, 11);
		obj.push(s2, 12);
		obj.push(s2, 13);

		s1.printStack();
		s2.printStack();

		int x = obj.pop(s1);
		System.out.println("Top of stack s1: " + ((x == -1) ? "Stack is empty" : x));
		x = obj.pop(s2);
		System.out.println("Top of stack s2: " + ((x == -1) ? "Stack is empty" : x));
		s1.printStack();
		s2.printStack();

		s1.mergeStack(s2);
		System.out.println("Stack content after merge");
		s1.printStack();
		s2.printStack();

		obj.push(s2, 14);
		obj.push(s2, 15);
		obj.push(s2, 16);

		obj.push(s1, 40);
		s1.mergeStack(s2);
		System.out.println("Stack content after merge");
		s1.printStack();
		s2.printStack();

		x = obj.pop(s1);
		System.out.println("Top of stack s1: " + ((x == -1) ? "Stack is empty" : x));

		s1.printStack();
		s2.printStack();
	}

}
