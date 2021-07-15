package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1021_장난감조립 {
	
	static int n, m, need[][];
	static boolean checked[], isComplex[];
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		recursion(n);
		for (int i = 1; i <= n; i++) {
			if(!isComplex[i]) {
				System.out.println(i + " " + need[n][i]);
			}
		}
	}

	private static void recursion(int idx) {
		if(checked[idx]) {
			return;
		}
		checked[idx] = true;
		for (int i = 1; i <= n; i++) {
			int temp = need[idx][i];
			if(temp != 0) {
				if(isComplex[i]) {
					recursion(i);
				}
				for (int j = 1; j <= n; j++) {
					if(need[i][j] != 0 && !isComplex[j]) {
						need[idx][j] += need[i][j] * temp;
					}
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = stoi(br.readLine());
		m = stoi(br.readLine());
		need = new int[n+1][n+1];
		checked = new boolean[n+1];
		isComplex = new boolean[n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = stoi(st.nextToken());
			need[num][stoi(st.nextToken())] = stoi(st.nextToken());
			isComplex[num] = true;
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
