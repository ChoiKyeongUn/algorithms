package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1027_좋은수열 {

	static int n;
	static boolean flag = false;

	public static void main(String[] args) {
		n = new Scanner(System.in).nextInt();
		dfs(0, "", 0);
	}

	private static void dfs(int idx, String res, int prev) {
		if(idx == n) {
			flag = true;
			System.out.println(res);
			return;
		}
		
		if(flag) {
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if(flag) {
				 return;
			}
			if(prev == i) {
				continue;
			}
			String temp = res + i;
			if(possible(temp)) {
				dfs(idx + 1, temp, i);
			}
		}
	}

	private static boolean possible(String temp) {
		int strLen = temp.length();
		for (int len = 2; len <= strLen / 2; len++) {
			for (int start = 0; start <= strLen - len * 2; start++) {
				String left = temp.substring(start, start+len);
				String right = temp.substring(start+len, start+len+len);
				if(left.equals(right)) {
					return false;
				}
			}
		}
		return true;
	}
}
