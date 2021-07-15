package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M, C, result, h[], honey[][], max[][];
	
	public static void main(String[] args) throws Exception {
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			solve();
			saveResult(tc);
		}
		System.out.println(sb);
	}

	private static void solve() {
		getMax();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				for (int j2 = j+M; j2 < N-M+1; j2++) {
					result = Math.max(result, max[i][j] + max[i][j2]);
				}
				for (int j2 = i+1; j2 < N; j2++) {
					for (int k = 0; k < N-M+1; k++) {
						result = Math.max(result, max[i][j] + max[j2][k]);
					}
				}
			}
		}
	}

	private static void getMax() {
		int end = 1<<M;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				int m = 0;
				for (int bm = 1; bm < end; bm++) {
					int size = 0;
					for (int k = 0; k < M; k++) {
						if((bm & (1<<k)) != 0) {
							h[size++] = honey[i][j+k];
						}
					}
					int total = 0;
					for (int k = 0; k < size; k++) {
						total += h[k];
					}
					if(total <= C) {
						total = 0;
						for (int k = 0; k < size; k++) {
							total += h[k]*h[k];
						}
					}
					m = Math.max(m, total);
				}
				max[i][j] = m;
			}
		}
	}

	private static void saveResult(int tc) {
		sb.append("#").append(tc).append(" ").append(result).append("\n");
	}

	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		C = stoi(st.nextToken());
		result = 0;
		honey = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				honey[i][j] = stoi(st.nextToken());
			}
		}
		max = new int[N][N-M+1];
		h = new int[M];
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
