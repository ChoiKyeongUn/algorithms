package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1352_양팔저울 {
	
	static int n, weights[], m, query[];
	static boolean[] possible = new boolean[30001];
	
	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0);
		for (int i = 0; i <= 30000; i++) {
			if(possible[i]) {
				System.out.println(i - 15000);
			}
		}
	}

	private static void dfs(int cnt, int w) {
		int temp = w + 15000;
		if(cnt == n || possible[temp]) {
			return;
		}
		
		possible[temp] = true;
		dfs(cnt+1, w+weights[cnt]);
		dfs(cnt+1, w);
		dfs(cnt+1, w-weights[cnt]);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		weights = new int[n];
		for (int i = 0; i < n; i++) {
			weights[i] = stoi(st.nextToken());
		}
		m = stoi(br.readLine());
		query = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			query[i] = stoi(st.nextToken());
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
