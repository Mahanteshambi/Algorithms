package com.algorithms.queue;

public class CircularQueue {

	int front, rear, size;
	int arr[];

	CircularQueue(int size) {
		arr = new int[size];
		front = rear = -1;
	}

	private boolean isFull() {
//		return (size == arr.length);
		return (front == 0 && rear == arr.length - 1) || ((rear + 1) % arr.length == front);
	}

	private boolean isEmpty() {
		return (front == -1 && rear == -1) || (front == rear);
	}

	private void enqueue(int x) {
		if (isFull()) {
			System.out.println("Can't insert" + x + ", queue is full");
		} else {
			System.out.println("Inserting " + x);
			rear = (rear + 1) % arr.length;
//			if (front == -1) {
//				front++;
//			}
			arr[rear] = x;
			size++;
		}
	}

	private int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return -1;
		} else {
			int x;
//			if (front == 0) {
//				x = arr[front];
//				front = (front + 1) % arr.length;
//			} else {
//				front = (front + 1) % arr.length;
//				x = arr[front];
//			}
			front = (front + 1) % arr.length;
			x = arr[front];
			arr[front] = 0;

			size--;
			return x;
		}
	}

	public static void main(String[] args) {
		CircularQueue obj = new CircularQueue(5);
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);
		obj.enqueue(5);
		obj.enqueue(6);
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		obj.enqueue(7);
		obj.enqueue(8);
		obj.enqueue(9);
		obj.enqueue(10);
		obj.enqueue(11);
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
	}

}
