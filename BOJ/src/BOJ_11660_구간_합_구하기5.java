

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11660_구간_합_구하기5 {
	static int N, M, num[][], prefix[][], query[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		input();
		query();
		System.out.println(sb);
	}

	private static void query() {
		for (int i = 0; i < M; i++) {
			int x1 = query[i][0];
			int y1 = query[i][1];
			int x2 = query[i][2];
			int y2 = query[i][3];
			int result = 0;
			for (int x = x1; x <= x2; x++) {
				result += prefix[x][y2] - prefix[x][y1-1];
			}
			sb.append(result).append("\n");
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		num = new int[N+1][N+1];
		prefix = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				num[i][j] = stoi(st.nextToken());
				prefix[i][j] = prefix[i][j-1] + num[i][j];
			}
		}
		
		query = new int[M][4];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			query[i][0] = stoi(st.nextToken());
			query[i][1] = stoi(st.nextToken());
			query[i][2] = stoi(st.nextToken());
			query[i][3] = stoi(st.nextToken());
		}
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
