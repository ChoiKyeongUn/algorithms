

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1647_도시_분할_계획 {
	
	static int N, M, result = 0, parent[], edges[][];
	
	public static void main(String[] args) throws Exception {
		input();
		kruskal();
		System.out.println(result);
	}

	private static void kruskal() {
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int[] edge = edges[i];
			int a = edge[0];
			int b = edge[1];
			int cost = edge[2];
			if(union(a, b)) {
				++cnt;
				if(cnt != N-1) {
					result += cost;
				} else {
					break;					
				}
			}
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		parent = new int[N+1];
		edges = new int[M][3];
		make();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = stoi(st.nextToken());
			edges[i][1] = stoi(st.nextToken());
			edges[i][2] = stoi(st.nextToken());
		}
		
		Arrays.sort(edges, (o1, o2) -> (o1[2] - o2[2]));
	}

	private static void make() {
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
