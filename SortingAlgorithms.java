
public class SortingAlgorithms {

	public static void main(String[] args) {
		int[] array = { 12, 11, 13, 5, 6, 7 };
		SortingAlgorithms instance = new SortingAlgorithms();
		System.out.println("Original array: ");
		instance.printSolution(array);

		System.out.println();
		System.out.println("Bubble sort o/p: ");
		BubbleSort bubbleSort = instance.new BubbleSort();
		bubbleSort.sort(array, array.length);
		instance.printSolution(array);

		System.out.println();
		System.out.println("Selection sort o/p: ");
		int[] selectionArray = { 12, 11, 13, 5, 6, 7 };
		SelectionSort selectionSort = instance.new SelectionSort();
		selectionSort.sort(selectionArray, selectionArray.length);
		instance.printSolution(selectionArray);

		System.out.println();
		System.out.println("Insertion sort o/p: ");
		int[] insertionArray = { 12, 11, 13, 5, 6, 7 };
		InsertionSort insertionSort = instance.new InsertionSort();
		insertionSort.insertionSort(insertionArray, insertionArray.length);
		instance.printSolution(insertionArray);

		System.out.println();
		System.out.println("Merge sort o/p: ");
		int[] mergeArray = { 12, 11, 13, 5, 6, 7 };
		MergeSort mergeSort = instance.new MergeSort();
		mergeSort.sort(mergeArray, 0, mergeArray.length - 1);
		instance.printSolution(mergeArray);

		System.out.println();
		System.out.println("Quick sort o/p: ");
		int[] quickArray = { 12, 11, 13, 5, 6, 7 };
		QuickSort quickSort = instance.new QuickSort();
		quickSort.quickSort(quickArray, 0, quickArray.length - 1);
		instance.printSolution(quickArray);

		System.out.println();
		System.out.println("Heap sort o/p: ");
		int[] heapArray = { 12, 11, 13, 5, 6, 7 };
		HeapSort heapSort = instance.new HeapSort();
		heapSort.heapSort(heapArray, heapArray.length);
		instance.printSolution(heapArray);

	}

	class BubbleSort {
		private void sort(int[] array, int n) {
			boolean swapped;
			for (int i = 0; i < n - 1; i++) {
				swapped = false;
				for (int j = 0; j < n - i - 1; j++) {
					if (array[j] > array[j + 1]) {
						swap(array, j, j + 1);
						swapped = true;
					}
				}
				if (!swapped) {
					break;
				}
			}
		}

		private void swap(int[] array, int i, int j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	class SelectionSort {
		private void sort(int[] array, int n) {
			int j = 0;
			for (int i = 0; i < n - 1; i++) {
				int m = 0;
				for (j = 1; j < n - i; j++) {
					if (array[j] > array[m]) {
						m = j;
					}
				}
				if (j - 1 != m) {
					swap(array, j - 1, m);
				}
			}
		}

		private void swap(int[] array, int i, int j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	class InsertionSort {
		void insertionSort(int arr[], int n) {
			int i, key, j;
			for (i = 1; i < n; i++) {
				key = arr[i];
				j = i - 1;
				while (j >= 0 && arr[j] > key) {
					arr[j + 1] = arr[j];
					j = j - 1;
				}
				arr[j + 1] = key;
			}
		}
	}

	class MergeSort {
		private void sort(int[] array, int l, int r) {
			if (l < r) {
				int mid = l + (r - l) / 2;
				sort(array, l, mid);
				sort(array, mid + 1, r);
				merge(array, l, mid, r);
			}
		}

		private void merge(int[] array, int l, int mid, int r) {
			int i = l, j, k, n1 = mid - l + 1, n2 = r - mid;
			int[] lArray = new int[n1];
			int[] rArray = new int[n2];
			for (i = 0; i < n1; i++) {
				lArray[i] = array[l + i];
			}
			for (j = 0; j < n2; j++) {
				rArray[j] = array[mid + 1 + j];
			}
			i = 0;
			j = 0;
			k = l;
			while (i < n1 && j < n2) {
				if (lArray[i] < rArray[j]) {
					array[k] = lArray[i++];
				} else if (lArray[i] > rArray[j]) {
					array[k] = rArray[j++];
				}
				k++;
			}
			while (i < n1) {
				array[k++] = lArray[i++];
			}

			while (j < n2) {
				array[k++] = rArray[j++];
			}

		}

	}

	class QuickSort {
		private void quickSort(int[] array, int l, int r) {
			if (l < r) {
				int pivot = partition(array, l, r);
				quickSort(array, l, pivot - 1);
				quickSort(array, pivot + 1, r);
			}
		}

		private int partition(int[] array, int l, int r) {
			int pivot = array[r];
			int i = l;
			for (int j = l; j < r; j++) {
				if (array[j] < pivot) {
					swap(array, i++, j);
				}
			}
			swap(array, i, r);
			return i;
		}

		private void swap(int[] array, int i, int j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

	}

	class HeapSort {
		private void heapSort(int[] array, int n) {
			for (int i = (n / 2) - 1; i >= 0; i--) {
				heapify(array, n, i);
			}
			for (int i = n - 1; i >= 0; i--) {
				int temp = array[0];
				array[0] = array[i];
				array[i] = temp;
				heapify(array, i, 0);
			}
		}

		private void heapify(int[] array, int n, int i) {
			int largest = i;
			int left = (2 * i) + 1;
			int right = (2 * i) + 2;

			if (left < n && array[left] > array[largest]) {
				largest = left;
			}
			if (right < n && array[right] > array[largest]) {
				largest = right;
			}
			if (i != largest) {
				int temp = array[i];
				array[i] = array[largest];
				array[largest] = temp;
				heapify(array, n, largest);
			}
		}
	}

	private void printSolution(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
