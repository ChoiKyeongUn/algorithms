

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			if(st.countTokens() == 1) break;
			int k = Integer.parseInt(st.nextToken());
			int[] num = new int[k];
			for (int i = 0; i < k; i++) num[i] = Integer.parseInt(st.nextToken());
			int[] for_comb = new int[k];
			for (int i = 1; i <= 6; i++) for_comb[k-i] = 1;
//			System.out.println(Arrays.toString(num));
			int[] store;
			Stack<int[]> stack = new Stack<>();
			do {
//				System.out.println(Arrays.toString(for_comb));
				store = new int[6];
				int idx = 0;
				for (int i = 0; i < k; i++) {
					if (for_comb[i] == 1) store[idx++] = num[i];
				}
				stack.add(store);
			} while(np(for_comb, k));
			while(!stack.isEmpty()) {
				int[] cur = stack.pop();
				for (int i = 0; i < 6; i++) {
					System.out.print(cur[i]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	static boolean np(int[] arr, int size) {
		int i = size - 1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		if(i == 0) return false;
		
		int j = size - 1;
		while(arr[i-1] >= arr[j]) --j;
		swap(arr, i-1, j);
		
		int k = size - 1;
		while(i < k) swap(arr, i++, k--);
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
