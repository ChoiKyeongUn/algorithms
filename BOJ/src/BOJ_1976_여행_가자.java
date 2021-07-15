

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행_가자 {
	static int N, M, parents[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		make();
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) union(i, j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int parent = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			int temp = find(Integer.parseInt(st.nextToken()));
			if(parent != temp) {
				System.out.println("NO");
				return;
			}
			parent = temp;
		}
		System.out.println("YES");
	}
	static void make() {
		for (int i = 1; i <= N; i++) parents[i] = i;
	}
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
