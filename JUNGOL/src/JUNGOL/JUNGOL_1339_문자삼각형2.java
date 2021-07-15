package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1339_문자삼각형2 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		if (n < 1 || n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR");
		} else {

			char[][] arr = new char[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = ' ';
				}
			}
			char cur = 'A';

			for (int i = n / 2; i >= 0; i--) {
				for (int j = i; j < n - i; j++) {
					arr[j][i] = cur;
					cur++;
					if (cur > 'Z')
						cur = 'A';
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
