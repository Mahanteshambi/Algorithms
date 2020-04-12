package com.algorithms.tree.bst;

import java.util.Stack;

public class BSTFromPreOrder {

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	class Index {
		int data;
	}

	public static void main(String[] args) {
		BSTFromPreOrder obj = new BSTFromPreOrder();
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		Node root = obj.constructBST(pre, pre[0], obj.new Index(), Integer.MIN_VALUE, Integer.MAX_VALUE);
		obj.inorderTraversal(root);
		root = obj.constructTree(pre, pre.length);
		System.out.println();
		obj.inorderTraversal(root);
	}

	private Node constructBST(int[] pre, int key, Index index, int min, int max) {
		if (index.data >= pre.length) {
			return null;
		}
		Node root = null;
		if (key > min && key < max) {
			root = new Node(key);
			index.data++;
			if (index.data < pre.length) {
				root.left = constructBST(pre, pre[index.data], index, min, key);
				root.right = constructBST(pre, pre[index.data], index, key, max);
			}
		}
		return root;
	}

	private Node constructTree(int pre[], int size) {

		Node root = new Node(pre[0]);
		Stack<Node> s = new Stack<Node>();
		s.push(root);

		for (int i = 1; i < size; ++i) {
			Node temp = null;
			while (!s.isEmpty() && pre[i] > s.peek().data) {
				temp = s.pop();
			}

			if (temp != null) {
				temp.right = new Node(pre[i]);
				s.push(temp.right);
			} else {
				temp = s.peek();
				temp.left = new Node(pre[i]);
				s.push(temp.left);
			}
		}

		return root;
	}

	private void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data + ",");
		inorderTraversal(root.right);
	}

}
