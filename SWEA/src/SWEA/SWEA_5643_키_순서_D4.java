package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5643_키_순서_D4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int INF = 1000;
	static int N, M, adjMatrix[][], result, in[], out[];
	
	public static void main(String[] args) throws Exception {
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			floyd();
			solve();
			saveResult(tc);
		}
		System.out.println(sb);
	}

	private static void solve() {
		for (int i = 0; i < N; i++) {
			int out = 0, in = 0;
			for (int j = 0; j < N; j++) {
				if(adjMatrix[i][j] == 1) {
					++out;
				}
				if(adjMatrix[j][i] == 1) {
					++in;
				}
			}
			if(out + in == N - 1) {
				++result;
			}
		}
	}

	private static void printArr() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(adjMatrix[i]));
		}
	}

	private static void floyd() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				for (int k = 0; k < N; k++) {
					if(i==k || j==k) continue;
					if(adjMatrix[j][i] == 1 && adjMatrix[j][k] == INF && adjMatrix[i][k] == 1) {
						adjMatrix[j][k] = 1;
					}
				}
			}
		}
	}

	private static void saveResult(int tc) {
		sb.append("#").append(tc).append(" ").append(result).append("\n");
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}

	private static void input() throws Exception {
		result = 0;
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		adjMatrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(adjMatrix[i], INF);
		}
		
		StringTokenizer st = null;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = stoi(st.nextToken())-1;
			int to = stoi(st.nextToken())-1;
			adjMatrix[start][to] = 1;
		}
		
		in = new int[N];
		out = new int[N];
	}
}
