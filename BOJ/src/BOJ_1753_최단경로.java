

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static int V, E, K; // V : 정점 개수, E : 간선 개수, K : 최단 거리를 구할 정점
	static ArrayList<int[]>[] adjList; // 인접리스트
	static ArrayList<int[]> target_adjList; // 최단 거리를 구할 정점의 인접리스트
	static boolean[] visited;
	static int[] min_dist; // 최단 거리 저장
	static int cur; // 선택된 정점을 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		// 인접리스트 초기화
		adjList = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) adjList[i] = new ArrayList<int[]>();
		
		// 간선 정보를 입력받아 인접리스트에 삽입
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new int[] {to, weight});	
		}
		
		target_adjList = adjList[K];
		visited = new boolean[V+1];
		min_dist = new int[V+1];
		// 최단 거리를 저장하는 배열을 처음엔 무한으로 초기화
		Arrays.fill(min_dist, Integer.MAX_VALUE);
		for (int i = 0, size = target_adjList.size(); i < size; i++) {
			int[] temp = target_adjList.get(i);
			int to = temp[0];
			int weight = temp[1];
			// 입력에서 두 정점 간의 간선은 여러 개일 수도 있다고 했음에 주의!
			min_dist[to] = Math.min(min_dist[to], weight);
		}
		min_dist[K] = 0;
		visited[K] = true;
		
		while(getCur()) {
			ArrayList<int[]> cur_list = adjList[cur];
			for (int i = 0, size = cur_list.size(); i < size; i++) {
				int[] cur_arr = cur_list.get(i);
				int to = cur_arr[0];
				int weight = cur_arr[1];
				if(!visited[to]) min_dist[to] = Math.min(min_dist[to], weight + min_dist[cur]);
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(min_dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(min_dist[i]);
		}
	}
	// 현재 가장 거리가 짧은 정점을 선택하는 함수
	private static boolean getCur() {
		int min = Integer.MAX_VALUE;
		int temp = -1;
		for (int i = 1; i <= V; i++) {
			if(!visited[i] && min_dist[i] < min) {
				min = min_dist[i];
				temp = i;
			}
		}
		// 선택된 게 없으면 false를 반환해서 while문 탈출
		if(temp == -1) return false;
		cur = temp;
		visited[cur] = true;
		return true;
	}
}
