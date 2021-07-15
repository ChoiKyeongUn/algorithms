import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과_사다리_게임 {
	
	static int map[][];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}

	private static void bfs() {
		visited[1] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		int cnt = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				int cur = q.poll();
				
				for (int i = 1; i <= 6; i++) {
					int next = cur + i;
					if(next >= 100) {
						System.out.println(cnt);
						return;
					}
					for (int j = 0; j < 2; j++) {
						if(map[next][j] != 0) {
							next = map[next][j];
						}
					}
					if(!visited[next]) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
			++cnt;
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		map = new int[101][2];
		visited = new boolean[101];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[stoi(st.nextToken())][0] = stoi(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			map[stoi(st.nextToken())][1] = stoi(st.nextToken());
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
