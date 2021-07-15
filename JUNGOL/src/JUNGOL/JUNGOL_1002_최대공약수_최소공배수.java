package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1002_최대공약수_최소공배수 {
	static int n, nums[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		nums = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = stoi(st.nextToken());
		}
		
		int yak = nums[0];
		int bae = nums[0];
		
		for (int i = 1; i < n; i++) {
			yak = getYak(yak, nums[i]);
			bae = bae * nums[i] / getYak(bae, nums[i]);
		}
		
		System.out.println(yak + " " + bae);
	}
	
	private static int getYak(int yak, int i) {
		int left = yak;
		int right = i;
		
		while(left % right != 0) {
			int temp = right;
			right = left % right;
			left = temp;
		}
		
		return right;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
