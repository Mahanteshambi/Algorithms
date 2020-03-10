package com.algorithms.queue;

public class MinHeap {

	int[] heap;
	int size, capacity;

	MinHeap(int capacity) {
		heap = new int[capacity];
		this.capacity = capacity;
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int left(int i) {
		return (2 * i) + 1;
	}

	private int right(int i) {
		return (2 * i) + 2;
	}

	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private boolean isLeaf(int i) {
		if (i >= size / 2 && i <= size) {
			return true;
		}
		return false;
	}

	private void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	private void printHeap() {
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i] + ", ");
		}
		System.out.println();
	}

	private void minHeapify(int i) {
		if (!isLeaf(i)) {
			if (heap[i] > heap[left(i)] || heap[i] > heap[right(i)]) {
				if (heap[left(i)] < heap[right(i)]) {
					swap(i, left(i));
					minHeapify(left(i));
				} else {
					swap(i, right(i));
					minHeapify(right(i));
				}
			}
		}
	}

	private void insert(int x) {
		if (size == capacity - 1) {
			System.out.println("Heap is full!");
			return;
		}
		int i = size++;
		heap[i] = x;
		while (i != 0 && heap[i] < heap[parent(i)]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	private int remove() {
		if (size == 0) {
			return -1;
		} else if (size == 1) {
			size--;
			return heap[0];
		}
		int root = heap[0];
		heap[0] = heap[size - 1];
		size--;
		minHeapify(0);
		return root;
	}

	private void decreaseValue(int i, int value) {
		heap[i] = value;
		while (i != 0 && heap[i] < heap[parent(i)]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(10);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		minHeap.printHeap();
		System.out.println("Min value: " + minHeap.remove());
		minHeap.minHeap();
		minHeap.printHeap();
		System.out.println("Decreasing value at 3 to 2");
		minHeap.decreaseValue(3, 2);
		minHeap.printHeap();
	}

}
