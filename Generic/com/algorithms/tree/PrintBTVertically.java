package com.algorithms.tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrintBTVertically {

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	private TreeMap<Integer, List<Node>> hashMap = new TreeMap<Integer, List<Node>>();

	private void parseBT(Node root, int dist) {
		if (root == null) {
			return;
		}
		List<Node> nodeList = hashMap.get(dist);
		if (nodeList == null) {
			nodeList = new ArrayList<PrintBTVertically.Node>();
		}
		nodeList.add(root);
		hashMap.put(dist, nodeList);
		parseBT(root.left, dist - 1);
		parseBT(root.right, dist + 1);
	}

	private void printVertically(Node root) {
		parseBT(root, 0);
		for (Map.Entry<Integer, List<Node>> entry : hashMap.entrySet()) {
			for (Node node : entry.getValue()) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		PrintBTVertically obj = new PrintBTVertically();
		Node root = obj.new Node(1);
		root.left = obj.new Node(2);
		root.right = obj.new Node(3);
		root.left.left = obj.new Node(4);
		root.left.right = obj.new Node(5);
		root.right.left = obj.new Node(6);
		root.right.right = obj.new Node(7);
		root.right.left.right = obj.new Node(8);
		root.right.right.right = obj.new Node(9);
		obj.printVertically(root);
	}

}
