package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOl_1158_삽입정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int nums[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = stoi(st.nextToken());
		}
		
		for (int i = 1; i < n; i++) {
			int cur = nums[i];
			int idx = i;
			while(idx != 0) {
				if(nums[idx-1] > cur) {
					--idx;
				} else {
					break;
				}
			}
			for (int j = i - 1; j >= idx; j--) {
				nums[j+1] = nums[j];
			}
			nums[idx] = cur;
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
