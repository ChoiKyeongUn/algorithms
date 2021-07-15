package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1822_짚신벌레 {
	static int a, b, d, N;
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
	
	private static void solve() {
		
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = stoi(st.nextToken());
		b = stoi(st.nextToken());
		d = stoi(st.nextToken());
		N = stoi(st.nextToken());
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
