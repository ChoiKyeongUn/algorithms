import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_13913_숨바꼭질_4 {
	
	static int n, k;
	
	public static void main(String[] args) {
		input();
		bfs();
	}
	
	private static void bfs() {
		if(n == k) {
			System.out.println(0 + "\n" + n);
			return;
		}
		Queue<int[]> q = new LinkedList<>();
		int[][] visited = new int[100001][2];
		for (int i = 0; i < 100001; i++) {
			visited[i][0] = Integer.MAX_VALUE;
			visited[i][1] = i;
		}
		visited[n][0] = 0;
		q.offer(new int[] {n, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curNode = cur[0];
			int curTime = cur[1];
			
			check(q, visited, curNode, curNode - 1, curTime + 1);
			check(q, visited, curNode, curNode + 1, curTime + 1);
			check(q, visited, curNode, curNode * 2, curTime + 1);
		}
		Stack<Integer> stack = new Stack<>();
		int cur = k;
		while(true) {
			stack.push(cur);
			if(cur == visited[cur][1]) {
				break;
			}
			cur = visited[cur][1];
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(visited[k][0]);
		System.out.println(sb);
	}

	private static void check(Queue<int[]> q, int[][] visited, int prev, int node, int time) {
		if(isInRange(node) && visited[node][0] > time) {
			q.offer(new int[] {node, time});
			visited[node][0] = time;
			visited[node][1] = prev;
		}
	}

	private static boolean isInRange(int node) {
		return 0 <= node && node <= 100000;
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
	}
}
