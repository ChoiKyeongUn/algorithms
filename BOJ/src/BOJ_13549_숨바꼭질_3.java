import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549_숨바꼭질_3 {
	
	static int n, k;
	
	public static void main(String[] args) {
		input();
		bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int visited[] = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[n] = 0;
		q.offer(new int[] {n, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curNode = cur[0];
			int curTime = cur[1];
			
			check(q, visited, curNode - 1, curTime + 1);
			check(q, visited, curNode + 1, curTime + 1);
			check(q, visited, curNode * 2, curTime);
		}
		System.out.println(visited[k]);
	}

	private static void check(Queue<int[]> q, int[] visited, int node, int time) {
		if(isInRange(node) && visited[node] > time) {
			q.offer(new int[] {node, time});
			visited[node] = time;
		}
	}

	private static boolean isInRange(int node) {
		return 0 <= node && node <= 100000;
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
	}
}
