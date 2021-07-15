package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1071_약수와_배수 {
	static int n, m, nums[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = stoi(st.nextToken());
		}
		m = stoi(br.readLine());
		
		int yakSum = 0, baeSum = 0;
		
		for(int num: nums) {
			if(m % num == 0) {
				yakSum += num;
			}
			if(num % m == 0) {
				baeSum += num;
			}
		}
		System.out.println(yakSum);
		System.out.println(baeSum);
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
