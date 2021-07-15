package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1856_숫자사각형2 {
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i % 2 == 0) {
					System.out.print(i * m + j + " ");
				} else {
					System.out.print((i + 1) * (m) - (j - 1) + " ");
				}
			}
			System.out.println();
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
