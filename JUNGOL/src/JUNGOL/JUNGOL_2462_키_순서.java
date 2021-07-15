package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_2462_키_순서 {
	
	static int n, m, students[][], result = 0;
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		for (int i = 1; i <= n; i++) {
			dfs(i);
		}
		int tmp;
		for (int i = 1; i <= n; i++) {
			tmp = 0;
			for (int j = 1; j <= n; j++) {
				tmp += students[i][j] + students[j][i];
			}
			if(tmp == n - 1) {
				++result;
			}
		}
		System.out.println(result);
	}

	private static void dfs(int i) {
		if(students[0][i] == 1) {
			return;
		}
		students[0][i] = 1;
		for (int j = 1; j <= n; j++) {
			if(i != j && students[i][j] == 1) {
				dfs(j);
				for (int j2 = 1; j2 <= n; j2++) {
					if(students[j][j2] == 1) {
						students[i][j2] = 1;
					}
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		students = new int[n+1][n+1];
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			students[a][b] = 1;
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
