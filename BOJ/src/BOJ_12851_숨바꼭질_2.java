import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12851_숨바꼭질_2 {
	
	static int n, k, result = 0, cnt = 0;
	static boolean flag = false;
	
	public static void main(String[] args) {
		input();
		bfs();
	}

	private static void bfs() {
		if(n == k) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[n] = 0;
		q.offer(n);
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				int cur = q.poll();
				
				if(cur == k) {
					flag = true;
					++result;
					continue;
				}
				
				check(q, visited, cur - 1);
				check(q, visited, cur + 1);
				check(q, visited, cur * 2);
			}
			if(flag) {
				break;
			}
			++cnt;
		}
		
		System.out.println(cnt);
		System.out.println(result);
	}

	private static void check(Queue<Integer> q, int[] visited, int n) {
		if(isInRange(n) && visited[n] >= cnt) {
			visited[n] = cnt;
			q.offer(n);
		}
	}

	private static boolean isInRange(int n) {
		return 0 <= n && n <= 100000;
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
	}
}
