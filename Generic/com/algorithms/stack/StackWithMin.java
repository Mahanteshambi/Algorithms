package com.algorithms.stack;

import java.util.Stack;

public class StackWithMin {

	class MinStack {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> minStack = new Stack<Integer>();
		int top = -1;

		protected void push(int x) {
			if (stack.isEmpty()) {
				stack.push(x);
				minStack.push(x);
			} else {
				if (x < stack.peek()) {
					minStack.push(x);
				}
				stack.push(x);
			}
		}

		protected int pop() {
			int x = -1;
			if (!stack.isEmpty()) {
				x = stack.pop();
				if (minStack.peek() == x) {
					minStack.pop();
				}

			} else {
				System.out.println("Stack is empty!");
			}
			return x;
		}

		protected int min() {
			int x = -1;
			if (!minStack.isEmpty()) {
				x = minStack.peek();
			}
			return x;
		}
	}

	public static void main(String[] args) {
		StackWithMin obj = new StackWithMin();
		MinStack minStack = obj.new MinStack();
		minStack.push(15);
		minStack.push(12);
		minStack.push(14);
		System.out.println("Minimum ele: " + ((minStack.min() == -1) ? "Stack is empty" : minStack.min()));
		minStack.pop();
		System.out.println("Minimum ele: " + ((minStack.min() == -1) ? "Stack is empty" : minStack.min()));
		minStack.push(25);
		minStack.push(8);
		System.out.println("Minimum ele: " + ((minStack.min() == -1) ? "Stack is empty" : minStack.min()));
		minStack.pop();
		minStack.pop();
		minStack.pop();
		System.out.println("Minimum ele: " + ((minStack.min() == -1) ? "Stack is empty" : minStack.min()));
		minStack.pop();
		System.out.println("Minimum ele: " + ((minStack.min() == -1) ? "Stack is empty" : minStack.min()));
	}

}
