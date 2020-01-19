package com.algorithms.search;

public class BinarySearch {

	private int search(int[] arr, int l, int h, int key) {
		if (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (key < arr[mid]) {
				return search(arr, l, mid - 1, key);
			} else {
				return search(arr, mid + 1, h, key);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch object = new BinarySearch();
		int arr[] = { 2, 3, 4, 20, 58, 66, 79, 83, 90, 134, 191 };
		int index = object.search(arr, 0, arr.length - 1, 90);
		if (index != -1) {
			System.out.println("Element found at " + index);
		} else {
			System.out.println("Element not found");
		}
	}

}
