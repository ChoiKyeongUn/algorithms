

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarps = new int[9];
		for (int i = 0; i < 9; i++)	dwarps[i] = Integer.parseInt(br.readLine());
		int[] for_comb = new int[9];
		for (int i = 0; i < 7; i++)	for_comb[8 - i] = 1;
		int sum;
		int[] selected = new int[7];
		do {
			sum = 0;
			for (int i = 0; i < 9; i++)
				if (for_comb[i] == 1)
					sum += dwarps[i];
			if (sum == 100) {
				int idx = 0;
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 9; i++)
					if (for_comb[i] == 1) selected[idx++] = dwarps[i];
				Arrays.sort(selected);
				for (int h : selected) sb.append(h).append("\n");
				System.out.println(sb);
				return;
			}
		} while(np(for_comb, 9));
	}
	
	
	public static boolean np(int[] arr, int size) {
		int i = size - 1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		if (i == 0) return false;
		
		int j = size - 1;
		while(arr[i-1] >= arr[j]) --j;
		swap(arr, i-1, j);
		
		int k = size - 1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
