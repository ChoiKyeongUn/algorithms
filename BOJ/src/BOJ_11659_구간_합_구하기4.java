

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659_구간_합_구하기4 {
	static int N, M, num[], prefix[];
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		input();
		query();
		System.out.println(sb);
	}

	private static void query() throws Exception {
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = stoi(st.nextToken());
			int B = stoi(st.nextToken());
			sb.append(prefix[B] - prefix[A-1]).append("\n");
		}
	}

	private static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		num = new int[N+1];
		prefix = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			num[i] = stoi(st.nextToken());
			prefix[i] = prefix[i-1]+num[i];
		}
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
