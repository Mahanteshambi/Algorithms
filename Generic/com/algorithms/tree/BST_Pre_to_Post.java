package com.algorithms.tree;

public class BST_Pre_to_Post {

	class Index {
		int data;
	}

	private void preOrderToPostOrder(int[] pre, Index index, int min, int max) {
		if (index.data == pre.length) {
			return;
		}

		if (pre[index.data] < min || pre[index.data] > max) {
			return;
		}
		int value = pre[index.data];
		index.data++;
		preOrderToPostOrder(pre, index, min, value);
		preOrderToPostOrder(pre, index, value, max);
		System.out.print(value + ", ");
	}

	public static void main(String[] args) {
		BST_Pre_to_Post obj = new BST_Pre_to_Post();
		int[] pre = { 40, 30, 35, 80, 100 };
		obj.preOrderToPostOrder(pre, obj.new Index(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

}
