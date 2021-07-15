package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1761_숫자_야구 {
	static int n, q[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		q = new int[n][5];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = stoi(st.nextToken());
			q[i][0] = temp / 100;
			temp %= 100;
			q[i][1] = temp / 10;
			q[i][2] = temp % 10;
			q[i][3] = stoi(st.nextToken());
			q[i][4] = stoi(st.nextToken());
		}
		
		int result = 0;
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if(i == j) continue;
				for (int k = 1; k <= 9; k++) {
					if(i == k || j == k) continue;
					if(possible(i, j, k)) ++result;
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean possible(int h, int t, int o) {
		for (int i = 0; i < n; i++) {
			int s = 0, b = 0;
			int ch = q[i][0];
			int ct = q[i][1];
			int co = q[i][2];
			int as = q[i][3];
			int ab = q[i][4];
			if(ch == h) {
				++s;
			}
			if(ct == t) {
				++s;
			}
			if(co == o) {
				++s;
			}
			if(ch == t || ch == o) {
				++b;
			}
			if(ct == h || ct == o) {
				++b;
			}
			if(co == h || co == t) {
				++b;
			}
			if(s != as || b != ab) {
				return false;
			}
		}
		return true;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
