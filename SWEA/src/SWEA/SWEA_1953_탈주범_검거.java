package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범_검거 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	/**
	 * result : 테케별 결과
	 * N : 지도의 세로 길이
	 * M : 지도의 가로 길이
	 * R : 범인이 처음에 들어가는 맨홀의 세로축 위치
	 * C : 범인이 처음에 들어가는 맨홀의 가로축 위치
	 * L : 탈출 후 소요된 시간
	 * land[][] : 전체 지도 정보 저장하는 배열
	 * dy, dx : 순서대로 상/하/좌/우
	 * tunnel : 각 터널 타입별 이동 가능한 방향 저장, 0은 터널이 없는 부분이므로 빈 배열로 초기화!
	 */
	static int result, N, M, R, C, L, land[][],
			   dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1},
			   tunnel[][] = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3},
					        {0, 3}, {1, 3}, {1, 2}, {0, 2}};
	
	public static void main(String[] args) throws Exception {
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			bfs();
			saveResult(tc);
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {R, C});
		boolean[][] visited = new boolean[N][M];
		visited[R][C] = true;
		
		int time = 0;
		
		while(!queue.isEmpty()) {
			// 시간 별로 영역을 넓혀가며 bfs해야 하기 때문에 각 시간 별로 queue의 사이즈만큼만 bfs를 돌림!
			int qSize = queue.size();
			if(++time >= L) break;
			for (int i = 0; i < qSize; i++) {
				int[] cur = queue.poll();
				int cur_y = cur[0];
				int cur_x = cur[1];
				int cur_type = land[cur_y][cur_x];
				
				for(int dir: tunnel[cur_type]) {
					int ny = cur_y + dy[dir];
					int nx = cur_x + dx[dir];
					// 다음 칸이 미방문 상태이고, 터널이 있는 곳이고, 서로 이어져 있는 경우에만 queue에 집어넣음!
					// 서로 이어져 있는지는 possible함수를 통해 확인
					if(isInRange(ny, nx) && !visited[ny][nx] && land[ny][nx] != 0 && possible(ny, nx, cur_y, cur_x)) {
						++result;
						queue.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					}
				}
			}
		}
	}

	
	/**
	 * 역으로 다음 칸에서
	 * 갈수 있는 방향을 바라보면서
	 * 현재 칸을 올 수 있는지 확인해 보고
	 * 만약 현재 칸으로 못오는 경우
	 * 서로 이어져 있지 않다는 것이기 때문에
	 * false를, 현재 칸으로 올 수 있다면 서로 이어져 있다는 것이기 때문에
	 * true 반환
	 */
	private static boolean possible(int ny, int nx, int cur_y, int cur_x) {
		int nType = land[ny][nx];
		for(int dir: tunnel[nType]) {
			int nny = ny + dy[dir];
			int nnx = nx + dx[dir];
			if(isInRange(ny, nx) && nny == cur_y && nnx == cur_x) return true;
		}
		return false;
	}

	private static boolean isInRange(int ny, int nx) {
		return 0 <= ny && ny < N && 0 <= nx && nx < M;
	}

	private static void input() throws Exception {
		result = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		L = stoi(st.nextToken());
		land = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < M; j++, idx+=2) {
				land[i][j] = temp.charAt(idx) - '0';
			}
		}
	}

	private static void saveResult(int tc) {
		sb.append("#").append(tc).append(" ").append(result).append("\n");
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
