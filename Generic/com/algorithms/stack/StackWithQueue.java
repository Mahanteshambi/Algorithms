package com.algorithms.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	int currSize = 0;

	private void push(int x) {
		currSize++;
		q2.add(x);

		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}

		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
	}

	private int pop() {
		if (q1.isEmpty()) {
			return -1;
		}
		currSize--;
		return q1.poll();
	}

	public static void main(String[] args) {
		StackWithQueue obj = new StackWithQueue();
		obj.push(10);
		obj.push(20);
		obj.push(30);
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
	}

}
