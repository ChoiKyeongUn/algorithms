

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리_만들기_2 {
	
	static class Loc {
		int y, x;
		public Loc(int y, int x) { this.y = y; this.x = x; }
		public String toString() { return "Loc [y=" + y + ", x=" + x + "]"; }
	}
	
	static int N, M, lSize = 0, landNum = 0, country[][], dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1 ,1},
			   adjMatrix[][], edgeList[][], edgeSize = 0, parent[];
	static boolean[][] visited;
	static final int INF = 10000;
	static Loc[] lands;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		country = new int[N][M];
		lands = new Loc[N*M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < M; j++, idx+=2) {
				country[i][j] = temp.charAt(idx) - '0';
				if(country[i][j] == 1) lands[lSize++] = new Loc(i, j);
			}
		}
		
		numbering();
		
//		for (int i = 0; i < N; i++) System.out.println(Arrays.toString(country[i]));
//		for (int i = 0; i < N; i++) System.out.println(Arrays.toString(visited[i]));
		
		adjMatrix = new int[landNum][landNum];
		for (int i = 0; i < landNum; i++) {
			Arrays.fill(adjMatrix[i], INF);
			adjMatrix[i][i] = 0;
		}
		
		for (int i = 0; i < lSize; i++) 
			tryMakeBridge(i);
		
//		for (int i = 0; i < landNum; i++) System.out.println(Arrays.toString(adjMatrix[i]));
//		System.out.println("-----------------");
		
		edgeList = new int[landNum*(landNum-1)/2][3];
		
		for (int i = 0; i < landNum-1; i++) {
			for (int j = i+1; j < landNum; j++) {
				if(adjMatrix[i][j] != INF) {
					edgeList[edgeSize][0] = i;
					edgeList[edgeSize][1] = j;
					edgeList[edgeSize++][2] = adjMatrix[i][j];
				}
			}
		}
		
		for (int i = edgeSize; i < landNum*(landNum-1)/2; i++) edgeList[i][2] = INF;
		
		Arrays.sort(edgeList, (o1, o2) -> o1[2] - o2[2]);
		
		for (int i = 0; i < edgeSize; i++) System.out.println(Arrays.toString(edgeList[i]));
		
		System.out.println(Kruskal());
	}
	
	private static int Kruskal() {
		make();
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < edgeSize; i++) {
			int[] cur = edgeList[i];
			int from = cur[0];
			int to = cur[1];
			int distance = cur[2];
			
			if(union(from, to)) {
				++cnt;
				result += distance;
			}
			
			if(cnt == landNum-1) return result;
		}
		return -1;
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}

	private static void make() {
		parent = new int[landNum];
		for (int i = 0; i < landNum; i++) parent[i] = i;
	}

	private static void tryMakeBridge(int i) {
		Loc cur = lands[i];
		int cur_y = cur.y;
		int cur_x = cur.x;
		int cur_landNum = country[cur_y][cur_x];
		
		for (int j = 0; j < 4; j++) {
			int y = cur_y, x = cur_x, cnt = 0;
			while(true) {
				y += dy[j];
				x += dx[j];
				if(y < 0 || y >= N || x < 0 || x >= M || country[y][x] == cur_landNum) break;
				if(country[y][x] != 0) {
					if(cnt==1 || country[y][x] == cur_landNum) break;
					int to_landNum = country[y][x];
					adjMatrix[cur_landNum-1][to_landNum-1] = Math.min(adjMatrix[cur_landNum-1][to_landNum-1], cnt);
					adjMatrix[to_landNum-1][cur_landNum-1] = adjMatrix[cur_landNum-1][to_landNum-1];
					break;
				}
				cnt++;
			}
		}
	}
	private static void numbering() {
		visited = new boolean[N][M];
		Queue<Loc> q = new LinkedList<Loc>();
		for (int i = 0; i < lSize; i++) {
			Loc cur = lands[i];
			int cur_y = cur.y;
			int cur_x = cur.x;
			if(visited[cur_y][cur_x]) continue;
			q.offer(cur);
			visited[cur_y][cur_x] = true;
			country[cur_y][cur_x] = ++landNum;
			while(!q.isEmpty()) {
				Loc l = q.poll();
				int y = l.y;
				int x = l.x;
				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if(ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && country[ny][nx] == 1) {
						country[ny][nx] = landNum;
						visited[ny][nx] = true;
						q.offer(new Loc(ny, nx));
					}
				}
			}
		}
	}
}
