import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1613_역사 {
	
	static int n, k, s, question[][], topology[];
	static boolean[][] adjMatrix;
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		topology = new int[n];
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		
		node:
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(adjMatrix[j][i]) continue node;
			}
			q.offer(i);
			visited[i] = true;
		}
		
		int idx = 0;
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int cur = q.poll();
				topology[cur] = time;
				
				for(int j = 0; j < n; j++) {
					adjMatrix[cur][j] = false;
				}
			}
			
			node1:
			for(int i = 0; i < n; i++) {
				if(visited[i]) continue;
				for(int j = 0; j < n; j++) {
					if(adjMatrix[j][i]) continue node1;
				}
				q.offer(i);
				visited[i] = true;
			}
			++time;
		}
		
//		System.out.println(Arrays.toString(topology));
		StringBuilder sb = new StringBuilder();
		for (int[] ques : question) {
			int topo1 = topology[ques[0]];
			int topo2 = topology[ques[1]];
			if(topo1 == topo2) sb.append(0).append("\n");
			else if(topo1 > topo2) sb.append(1).append("\n");
			else sb.append(-1).append("\n");
		}
		System.out.println(sb);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		k = stoi(st.nextToken());
		adjMatrix = new boolean[n][n];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken()) - 1;
			int to = stoi(st.nextToken()) - 1;
			adjMatrix[from][to] = true;
		}
		
		s = stoi(br.readLine());
		question = new int[s][2];
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			question[i][0] = stoi(st.nextToken()) - 1;
			question[i][1] = stoi(st.nextToken()) - 1;
		}
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
