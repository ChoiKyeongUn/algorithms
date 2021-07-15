package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M, C, result, first[], second[], honey[][];
	
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
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				
				for (int k = 0; k < M; k++) {
					first[k] = honey[i][j+k];
				}
				
				for (int k = j+M; k < N-M+1; k++) {
					for (int k2 = 0; k2 < M; k2++) {
						second[k2] = honey[i][k+k2];
					}
					updateResult();
				}
				
				for (int j2 = i+1; j2 < N; j2++) {
					for (int k = 0; k < N-M+1; k++) {
						for (int k2 = 0; k2 < M; k2++) {
							second[k2] = honey[j2][k+k2];
						}
						updateResult();
					}
				}
			}
		}
	}

	private static void updateResult() {
		int end = 1<<M;
		int max1 = 0, max2 = 0;
		int[] selected1 = new int[M], selected2 = new int[M];
		for (int bm = 1; bm < end; bm++) {
			int size1 = 0, size2 = 0;
			for (int i = 0; i < M; i++) {
				if((bm & (1<<i)) != 0) {
					selected1[size1++] = first[i];
					selected2[size2++] = second[i];
				}
			}
			int total = 0;
			for (int i = 0; i < size1; i++) {
				total += selected1[i];
			}
			if(total <= C) {
				total = 0;
				for (int i = 0; i < size1; i++) {
					total += selected1[i] * selected1[i];
				}
				max1 = Math.max(max1, total);
			}
			
			total = 0;
			for (int i = 0; i < size2; i++) {
				total += selected2[i];
			}
			if(total <= C) {
				total = 0;
				for (int i = 0; i < size2; i++) {
					total += selected2[i] * selected2[i];
				}
				max2 = Math.max(max2, total);
			}
			
		}
		result = Math.max(result, max1 + max2);
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
		first = new int[M];
		second = new int[M];
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
