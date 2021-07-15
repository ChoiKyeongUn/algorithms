package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1146_선택정렬 {
	static int n, nums[];
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		for (int i = 0; i < n - 1; i++) {
			int min = nums[i];
			int idx = i;
			for (int j = i + 1; j < n; j++) {
				if(min > nums[j]) {
					min = nums[j];
					idx = j;
				}
			}
			int temp = nums[i];
			nums[i] = min;
			nums[idx] = temp;
			
			for (int j = 0; j < n; j++) {
				System.out.print(nums[j] + " ");
			}
			System.out.println();
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = stoi(st.nextToken());
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
