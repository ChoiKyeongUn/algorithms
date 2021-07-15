package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUNGOL_2097_지하철 {
	
	static int n, m, adjMatrix[][], minDistance[][];
	static final int INF = 100 * 100 + 1;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		input();
		dijkstra();
		printResult();
	}

	private static void printResult() {
		System.out.println(minDistance[m-1][0]);
		Stack<Integer> stack = new Stack<>();
		
		int cur = m-1;
		while(true) {
			stack.push(cur);
			if(minDistance[cur][1] == cur) {
				break;
			}
			cur = minDistance[cur][1];
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + 1 + " ");
		}
	}

	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
		pq.offer(new int[] {0, 0});
		
		while(!pq.isEmpty()) {
			if(visited[m-1]) {
				break;
			}
			
			int[] cur = pq.poll();
			int curNode = cur[0];
			
			if(visited[curNode]) {
				continue;
			}
			
			visited[curNode] = true;
			int curDist = cur[1];
			
			for (int i = 0; i < n; i++) {
				if(!visited[i] && i != curNode) {
					if(minDistance[i][0] > curDist + adjMatrix[curNode][i]) {
						minDistance[i][0] = curDist + adjMatrix[curNode][i];
						minDistance[i][1] = curNode;
						pq.offer(new int[] {i, minDistance[i][0]});
					}
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		adjMatrix = new int[n][n];
		minDistance = new int[n][2];
		visited = new boolean[n];
		for (int i = 1; i < n; i++) {
			minDistance[i][0] = INF;
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				adjMatrix[i][j] = stoi(st.nextToken());
			}
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
