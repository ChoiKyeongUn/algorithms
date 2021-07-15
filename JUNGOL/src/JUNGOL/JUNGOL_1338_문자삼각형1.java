package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1338_문자삼각형1 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = ' ';
			}
		}
		char cur = 'A';
		
		for (int i = 0; i < n; i++) {
			int end = n-1;
			for (int j = i; j < n; j++) {
				arr[j][end--] = cur;
				cur++;
				if(cur > 'Z') cur = 'A';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
