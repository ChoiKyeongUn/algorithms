package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JUNGOL_2217_DNA_조합 {
	static int n, np[], result = Integer.MAX_VALUE;
	static String dnas[];
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(result);
	}

	private static void solve() {
		do {
			String temp = dnas[np[0]];
			for (int i = 1; i < n; i++) {
				String cur = dnas[np[i]];
				int tLen = temp.length();
				int cLen = cur.length();
				int len = Math.min(tLen, cLen);
				for (int j = len; j >= 0; j--) {
					if(possible(temp, cur, j)) {
						temp = merge(temp, cur, j);
						break;
					}
				}
//				if(temp.length() > result) {
//					break;
//				}
			}
			if(temp.length() == 10 || temp.length() == 11) {
				System.out.println(Arrays.toString(np));
				System.out.println(temp);
				System.out.println(temp.length());
			}
			result = Math.min(result, temp.length());
		} while(np());
	}

	private static String merge(String temp, String cur, int len) {
		for (int i = len, size = cur.length(); i < size; i++) {
			temp += cur.charAt(i);
		}
		return temp;
	}

	private static boolean possible(String temp, String cur, int len) {
		return temp.substring(temp.length() - len, temp.length())
			   .equals(cur.substring(0, len));
	}

	private static boolean np() {
		int i = n - 1;
		while(i > 0 && np[i-1] > np[i]) --i;
		if(i == 0) {
			return false;
		}
		
		int j = n - 1;
		while(np[i-1] >= np[j]) --j;
		swap(i-1, j);
		
		int k = n - 1;
		while(i < k) swap(i++, k--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int temp = np[i];
		np[i] = np[j];
		np[j] = temp;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		dnas = new String[n];
		np = new int[n];
		for (int i = 0; i < n; i++) {
			dnas[i] = br.readLine();
			np[i] = i;
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
