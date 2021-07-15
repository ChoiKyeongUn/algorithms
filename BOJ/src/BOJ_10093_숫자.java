

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10093_숫자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		if(A > B) {
			long temp = A;
			A = B;
			B = temp;
		}
		if (A == B) {
			System.out.println(0);
			return;
		}
		System.out.println(B - A - 1);
		for (long i = A+1; i < B; i++) {
			System.out.print(i+" ");
		}
	}
}
