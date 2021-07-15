

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15591_MooTube {
	static int N, Q;
	public static void main(String[] args) throws Exception {
		input();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		Q = stoi(st.nextToken());
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
