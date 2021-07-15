package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4355_무인도탈출 {
	static int result, N, boxes[][];
	static boolean used[];
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			solve();
			saveResult(tc);
		}
		System.out.println(sb.toString());
	}

	private static void solve() {
		
	}

	private static void saveResult(int tc) {
		sb.append("#" + tc + " " + result + "\n");
	}

	private static void input() throws Exception {
		N = stoi(br.readLine());
		boxes = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			boxes[i][0] = stoi(st.nextToken());
			boxes[i][1] = stoi(st.nextToken());
			boxes[i][2] = stoi(st.nextToken());
		}
		
		used = new boolean[N];
		result = 0;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
