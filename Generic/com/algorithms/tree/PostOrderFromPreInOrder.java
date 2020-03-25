package com.algorithms.tree;

import java.util.HashMap;

public class PostOrderFromPreInOrder {

	private int preIndex = 0;

	private void postOrder(int[] in, int[] pre, HashMap<Integer, Integer> hashMap, int start, int end) {
		if (start > end) {
			return;
		}

		int iIndex = hashMap.get(pre[preIndex++]);
		postOrder(in, pre, hashMap, start, iIndex - 1);
		postOrder(in, pre, hashMap, iIndex + 1, end);
		System.out.print(in[iIndex] + ", ");
	}

	private void postOrderFromPreInOrder(int[] in, int[] pre) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			hashMap.put(in[i], i);
		}
		postOrder(in, pre, hashMap, 0, in.length - 1);
	}

	public static void main(String[] args) {
		int in[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };
		PostOrderFromPreInOrder obj = new PostOrderFromPreInOrder();
		obj.postOrderFromPreInOrder(in, pre);
	}

}
