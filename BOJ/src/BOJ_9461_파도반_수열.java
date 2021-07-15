

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9461_파도반_수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			if (N < 4) System.out.println(1);
			else if (N < 6) System.out.println(2);
			else {
				long m = 1, n = 2, k = 2;
				long result = 0;
				for (int j = 0; j < N - 5; j++) {
					result = m + n;
					m = n;
					n = k;
					k = result;
				}
				System.out.println(result);
			}
		}
	}
}
