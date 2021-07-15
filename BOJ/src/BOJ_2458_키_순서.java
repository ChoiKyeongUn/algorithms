

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2458_키_순서 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M, result = 0;
	static boolean[][] adjMatrix;
	
	public static void main(String[] args) throws Exception {
		input();
		floyd();
		solve();
		System.out.println(result);
	}

	private static void solve() {
		for (int i = 0; i < N; i++) {
			int out = 0, in = 0;
			for (int j = 0; j < N; j++) {
				if(adjMatrix[i][j]) {
					++out;
				}
				if(adjMatrix[j][i]) {
					++in;
				}
			}
			if(out + in == N - 1) {
				++result;
			}
		}
	}


	private static void floyd() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j || !adjMatrix[j][i]) continue;
				for (int k = 0; k < N; k++) {
					if(i==k || j==k || adjMatrix[j][k] || !adjMatrix[i][k]) continue;
						adjMatrix[j][k] = true;
				}
			}
		}
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}

	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		
		adjMatrix = new boolean[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = stoi(st.nextToken())-1;
			int to = stoi(st.nextToken())-1;
			adjMatrix[start][to] = true;
		}
	}
}
