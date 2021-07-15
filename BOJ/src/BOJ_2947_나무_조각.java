

import java.util.Scanner;

public class BOJ_2947_나무_조각 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
		
		while(!isSorted(arr)) {
			step(arr, 0, 1);
			step(arr, 1, 2);
			step(arr, 2, 3);
			step(arr, 3, 4);
		}
	}

	private static void step(int[] arr, int i, int j) {
		if(arr[i] > arr[j]) {
			swap(arr, i, j);
			printArr(arr);
		}
	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < 5; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static boolean isSorted(int[] arr) {
		if(arr[0] != 1 || arr[1] != 2 || arr[2] != 3 || arr[3] != 4 || arr[4] != 5) return false;
		return true;
	}
}
