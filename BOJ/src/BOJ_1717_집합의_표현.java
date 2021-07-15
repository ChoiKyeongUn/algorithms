

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의_표현 {
	static int n, m, parents[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		make();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());;
			int b = Integer.parseInt(st.nextToken());
			switch(oper) {
			case 0:
				union(a, b);
				break;
			default:
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}

	private static void make() {
		for (int i = 0; i <= n; i++) parents[i] = i;
	}
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	
}
