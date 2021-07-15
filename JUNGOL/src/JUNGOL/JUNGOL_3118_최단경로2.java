package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JUNGOL_3118_최단경로2 {

	static int n, m, minDistance[];
	static final int INF = 100000 * 20000 + 1;
	static List<int[]> adjList[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		input();
		dijkstra();
		System.out.println(minDistance[n]);
	}

	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
		pq.offer(new int[] { 1, 0 });
		int cur[], curNode, curDist;
		while (!pq.isEmpty()) {
			if (visited[n]) {
				break;
			}
			cur = pq.poll();
			curNode = cur[0];

			if (visited[curNode]) {
				continue;
			}

			visited[curNode] = true;
			curDist = cur[1];

			for (int[] next : adjList[curNode]) {
				int nextNode = next[0];
				if (visited[nextNode]) {
					continue;
				}
				int nextDist = next[1] + curDist;
				if (minDistance[nextNode] > nextDist) {
					minDistance[nextNode] = nextDist;
					pq.offer(new int[] {nextNode, nextDist});
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());

		adjList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken());
			int to = stoi(st.nextToken());
			int cost = stoi(st.nextToken());
			adjList[from].add(new int[] { to, cost });
		}

		visited = new boolean[n + 1];
		minDistance = new int[n + 1];
		Arrays.fill(minDistance, INF);
		minDistance[1] = 0;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
