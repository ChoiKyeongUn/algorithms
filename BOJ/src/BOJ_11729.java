

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = pow(2, N) - 1;
		sb.append(temp).append("\n");
		hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}
	static void hanoi(int N, int start, int temp, int end) {
		if (N == 0) return;
		hanoi(N-1, start, end, temp);
		sb.append(start).append(" ").append(end).append("\n");
		hanoi(N-1, temp, start, end);
	}
	static int pow(int N, int exp) {
		if(exp == 0) return 1;
		if(exp == 1) return N;
		int temp = pow(N, exp/2);
		if(exp%2 == 1) return temp*temp*N;
		return temp*temp;
	}
}
