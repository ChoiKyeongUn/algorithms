package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382_방향_전환2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int result, x1, y1, x2, y2;
	public static void main(String[] args) throws Exception {
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			solve();
			saveResult(tc);
		}
		System.out.println(sb);
	}
	
	private static void saveResult(int tc) {
		sb.append("#").append(tc).append(" ").append(result).append("\n");
	}

	private static void solve() {
		int xGap = Math.abs(x1 - x2);
		int yGap = Math.abs(y1 - y2);
		int max = Math.max(xGap, yGap);
		int min = Math.min(xGap, yGap);
		result += 2*min;
		max -= min; min = 0;
		if(max % 2 == 0) result += max*2;
		else result += max*2-1;
	}

	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		x1 = stoi(st.nextToken());
		y1 = stoi(st.nextToken());
		x2 = stoi(st.nextToken());
		y2 = stoi(st.nextToken());
		result = 0;
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
