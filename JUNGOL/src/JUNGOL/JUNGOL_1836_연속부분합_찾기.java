package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1836_연속부분합_찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int nums[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = stoi(st.nextToken());
		}
		
		int max = 0;
		int pre = 0;
		for (int i = 0; i < n; i++) {
			pre = Math.max(pre + nums[i], 0);
			max = Math.max(pre, max);
		}
		System.out.println(max);
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
