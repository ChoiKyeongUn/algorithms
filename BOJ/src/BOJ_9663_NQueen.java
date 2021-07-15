

import java.util.Scanner;

public class BOJ_9663_NQueen {
	static int cnt = 0, N;
	static boolean[] left, right, vertical;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		left = new boolean[2*N-1];
		right = new boolean[2*N-1];
		vertical = new boolean[N];
		dfs(0);
		System.out.println(cnt);
	}
	private static void dfs(int i) {
		if(i == N) {
			++cnt;
			return;
		}
		
		for (int j = 0; j < N; j++) {
			if(left[i+j] || right[N-1+j-i] || vertical[j]) continue;
			left[i+j] = true;
			right[N-1+j-i] = true;
			vertical[j] = true;
			dfs(i+1);
			left[i+j] = false;
			right[N-1+j-i] = false;
			vertical[j] = false;
		}
	}
}
