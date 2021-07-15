package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1814_삽입정렬_횟수_세기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int nums[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = stoi(st.nextToken());
		}
		int result = 0;
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
			result += i - idx;
		}
		System.out.println(result);
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
