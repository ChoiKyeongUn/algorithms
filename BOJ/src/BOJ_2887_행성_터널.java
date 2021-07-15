

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2887_행성_터널 {
	
	static int N, parent[], node[][], edge[][];
	static long result = 0;
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(result);
	}

	private static void solve() {
		make();
		for (int i = 0; i < 3*(N-1); i++) {
			if(union(edge[i][0], edge[i][1])) {
				result += edge[i][2];
			}
		}
	}

	private static void make() {
		parent = new int[N];
		for (int i = 1; i < N; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int a) {
		if(parent[a] == a) return a;
		return  parent[a] = find(parent[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		parent[bRoot] = aRoot;
		return true;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		StringTokenizer st = null;
		node = new int[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			node[i][0] = stoi(st.nextToken());
			node[i][1] = stoi(st.nextToken());
			node[i][2] = stoi(st.nextToken());
			node[i][3] = i;
		}
		
		edge = new int[(N-1)*3][3];
		
		Arrays.sort(node, (o1, o2) -> (o1[0] - o2[0]));
		for (int i = 0; i < N-1; i++) {
			edge[i][0] = node[i][3];
			edge[i][1] = node[i+1][3];
			edge[i][2] = node[i+1][0] - node[i][0];
		}
		
		Arrays.sort(node, (o1, o2) -> (o1[1] - o2[1]));
		for (int i = N-1; i < 2*(N-1); i++) {
			edge[i][0] = node[i - (N-1)][3];
			edge[i][1] = node[i+1 - (N-1)][3];
			edge[i][2] = node[i+1 - (N-1)][1] - node[i - (N-1)][1];
		}
		
		Arrays.sort(node, (o1, o2) -> (o1[2] - o2[2]));
		for (int i = 2*(N-1); i < 3*(N-1); i++) {
			edge[i][0] = node[i - 2*(N-1)][3];
			edge[i][1] = node[i+1 - 2*(N-1)][3];
			edge[i][2] = node[i+1 - 2*(N-1)][2] - node[i - 2*(N-1)][2];
		}
		
		Arrays.sort(edge, (o1, o2) -> (o1[2] - o2[2]));
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
