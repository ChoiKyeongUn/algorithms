

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의_개수 {
	static int N;
	static int[][] papers;
	static int[] cnt = new int[3];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		papers = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) papers[i][j] = Integer.parseInt(st.nextToken());
		}
		func(0, 0, N);
		for (int i = 0; i < 3; i++) System.out.println(cnt[i]);
	}
	
	private static void func(int i, int j, int n) {
		int[] c = new int[3];
		for (int k = 0; k < n; k++) for (int k2 = 0; k2 < n; k2++) c[papers[i+k][j+k2]+1]++;
		for (int k = 0; k < 3; k++)
			if(c[k] == n*n) {
				cnt[k]++;
				return;
			}
		
		for (int k = 0; k < 3; k++) {
			for (int k2 = 0; k2 < 3; k2++) {
				func(i+k*n/3, j+k2*n/3, n/3);
			}
		}
	}
}
