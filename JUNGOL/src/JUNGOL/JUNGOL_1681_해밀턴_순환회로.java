package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1681_해밀턴_순환회로 {
	
	static int n, result, adjMatrix[][];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		input();
		solve(0, 0, 0, "");
		System.out.println(result);
	}

	private static void solve(int cnt, int i, int total, String path) {
		if(cnt == n-1) {
			if(adjMatrix[i][0] != 0) {
				result = Math.min(result, total + adjMatrix[i][0]);				
			}
			return;
		}
		
		for (int j = 0; j < n; j++) {
			if(adjMatrix[i][j] == 0 || visited[j]) {
				continue;
			}
			int sum = total + adjMatrix[i][j];
			if(sum < result) {
				visited[j] = true;
				solve(cnt + 1, j, sum, path + Integer.toString(j));
				visited[j] = false;
			}
		}
	}

	private static void input() throws Exception {
		result = Integer.MAX_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = stoi(br.readLine());
		visited = new boolean[n];
		adjMatrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				adjMatrix[i][j] = stoi(st.nextToken());
			}
		}
		visited[0] = true;
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
