package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1438_색종이_초 {
	static boolean paper[][] = new boolean[100][100];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			for (int j = a; j < a + 10; j++) {
				for (int j2 = b; j2 < b + 10; j2++) {
					paper[j][j2] = true;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(paper[i][j]) {
					++result;
				}
			}
		}
		System.out.println(result);
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
