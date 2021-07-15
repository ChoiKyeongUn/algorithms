

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자_끼워넣기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] for_comb = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < temp; j++) for_comb[idx++] = i;
		}
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; 
		do {
			int result = nums[0];
			for (int i = 1; i < N; i++) {
				switch(for_comb[i-1]) {
				case 0:
					result += nums[i];
					break;
				case 1:
					result -= nums[i];
					break;
				case 2:
					result *= nums[i];
					break;
				case 3:
					result /= nums[i];
					break;
				}
			}
			if(max < result) max = result;
			if(min > result) min = result;
		} while(np(for_comb, N-1));
		System.out.println(max);
		System.out.println(min);
	}

	private static boolean np(int[] arr, int len) {
		int i = len-1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		if(i == 0) return false;
		
		int j = len-1;
		while(arr[i-1] >= arr[j]) --j;
		swap(arr, i-1, j);
		
		int k = len-1;
		while(i < k) swap(arr, i++, k--);
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
