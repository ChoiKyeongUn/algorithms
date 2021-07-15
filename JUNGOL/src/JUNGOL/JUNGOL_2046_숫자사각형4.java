package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_2046_숫자사각형4 {
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		
		switch(m) {
		case 1:
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 1; j <= n; j++) {
					if(i % 2 == 0) {
						System.out.print(j + " ");
					} else {
						System.out.print(n - j + 1 + " ");
					}
				}
				System.out.println();
			}
			break;
		default:
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					System.out.print(i * j + " ");
				}
				System.out.println();
			}
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
