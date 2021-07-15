package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8458_원점으로_집합 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, result, coors[][];
	
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
		int max = Math.abs(coors[0][0]) + Math.abs(coors[0][1]);
		for (int i = 1; i < N; i++) {
			int temp = Math.abs(coors[i][0]) + Math.abs(coors[i][1]);
			if(max%2 != temp%2) {
				return;
			}
			if(max < temp) {
				max = temp;
			}
		}
		System.out.println("------------");
		System.out.println("max = " + max);
		System.out.println("sqrt = " + Math.sqrt(1.0 + 8.0*max));
		double geun = (-1.0+Math.sqrt(1.0+8.0*(double)max))/2.0;
		System.out.println("geun = " + geun);
		result = (int) Math.ceil(geun);
		System.out.println("result = " + result);
		System.out.println("------------");
	}

	private static void input() throws Exception {
		N = stoi(br.readLine());
		coors = new int[N][2];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coors[i][0] = stoi(st.nextToken());
			coors[i][1] = stoi(st.nextToken());
		}
		result = -1;
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
