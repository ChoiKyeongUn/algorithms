/**
 * 다익스트라를 이용한 풀이!
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한_최단_경로 {
	
	// mustGo : 크기가 3인 배열, 거쳐야 하는 정점이 시작점, 그리고 주어지는 두 점인데
	//          이 점들의 정점 번호를 저장하는 배열!
	// min_dist : 거쳐야 하는 각 세 정점을 다익스트라를 돌릴때 사용하는 최소거리배열
	//            크기는 3xN
	static int N, E, mustGo[], min_dist[][];
	
	// 최종 답 구할때 너무 INF값이 커져버리면 Overflow가 발생할 수 있어서
	// INF를 적당한 값으로 정했습니다.
	// (아무리 극단적인 경우여도 거리는 2400000(800*1000*3) 이상이 나올 수 없기 때문에 이 이상 값이면 모두 가능!)
	static final int INF = 10000000;
	
	// 입력되는 그래프를 인접리스트 방식으로 구현
	static List<int[]>[] graph;
	
	public static void main(String[] args) throws Exception {
		// 입력처리 및 필요한 배열 생성, 초기화
		input();
		
		// 거쳐야만 하는 세 점 모두 각각 다익스트라를 돌림.
		for (int i = 0; i < 3; i++) {
			dijkstra(i);
		}
		
		// 시작점으로부터 두 정점을 꼭 거쳐서 가는 방법
		// 1. 시작점 -> 첫번째 정점 -> 두번째 정점 -> 도착점
		// 2. 시작점 -> 두번째 정점 -> 첫번째 정점 -> 도착점
		int res1 = min_dist[0][mustGo[1]] + min_dist[1][mustGo[2]] + min_dist[2][N-1];
		int res2 = min_dist[0][mustGo[2]] + min_dist[2][mustGo[1]] + min_dist[1][N-1];
		// 둘 중 작은 값을 구하고
		int result = Math.min(res1, res2);

		// 만약 INF보다 크다면 도달할 수 없다는 뜻이므로 -1 출력!
		System.out.println(result >= INF ? -1 : result);
	}
	
	private static void dijkstra(int i) {
		// pq를 이용한 다익스트라
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> (o1[1] - o2[1]));
		boolean[] visited = new boolean[N];
		pq.offer(new int[] {mustGo[i], 0});
		
		while(!pq.isEmpty()) {
			if(visited[mustGo[1]] && visited[mustGo[2]] && visited[N-1]) break;
			int[] cur = pq.poll();
			int cur_node = cur[0];
			int cur_dist = cur[1];
			
			if(visited[cur_node]) continue;
			
			visited[cur_node] = true;
			
			for(int[] to : graph[cur_node]) {
				if(visited[to[0]]) continue;
				if(min_dist[i][to[0]] > cur_dist + to[1]) {
					min_dist[i][to[0]] = cur_dist + to[1];
					pq.offer(new int[] {to[0], min_dist[i][to[0]]});
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		E = stoi(st.nextToken());
		graph = new ArrayList[N];
		// 인접리스트 생성
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<int[]>();
		
		// 인접리스트 정보 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken()) - 1;
			int to = stoi(st.nextToken()) - 1;
			int cost = stoi(st.nextToken());
			
			// 무방향 그래프이므로 시작지 <-> 도착지 비용이 같음
			graph[from].add(new int[] {to, cost});
			graph[to].add(new int[] {from, cost});
		}
		
		mustGo = new int[3];
		
		st = new StringTokenizer(br.readLine());

		// 거쳐야 하는 정점 입력받아 배열에 저장(시작점 포함!)
		mustGo[0] = 0;
		mustGo[1] = stoi(st.nextToken()) - 1;
		mustGo[2] = stoi(st.nextToken()) - 1;
		
		// 거쳐야 하는 정점들로부터 다익스트라를 돌리기 위해 최소거리 배열 생성
		// 자기 자신의 정점을 제외한 나머지 정점들은 모두 무한대로 초기화!
		min_dist = new int[3][N];
		for (int i = 0; i < 3; i++) {
			Arrays.fill(min_dist[i], INF);
		}
		min_dist[0][mustGo[0]] = 0;
		min_dist[1][mustGo[1]] = 0;
		min_dist[2][mustGo[2]] = 0;
	}
	
	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
