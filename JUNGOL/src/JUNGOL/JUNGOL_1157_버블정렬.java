package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1157_버블정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int nums[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			nums[i] = stoi(st.nextToken());
		}
		
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
			for (int j = 0; j < n; j++) {
				System.out.print(nums[j] + " ");
			}
			System.out.println();
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
