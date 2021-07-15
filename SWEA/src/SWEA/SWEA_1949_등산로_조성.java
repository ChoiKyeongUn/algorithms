package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949_등산로_조성 {
	static int N, K, MAX, value;
	static boolean[][] visited;
	static int[][] mt;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) { // Test Case 시작
			sb.append("#").append(tc).append(" ");
			
			// N, K 입력 받기, 가장 긴 등산로 0으로 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 등산로 크기
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			MAX = 0; // 최대 등산로 길이
			
			// 등산로 입력, visited 배열 만들기, 가장 높은 봉우리 찾기
			mt = new int[N][N]; // 등산로 저장
			visited = new boolean[N][N]; // 방문여부 저장
			int max_height = 0; // 가장 높은 봉우리
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					mt[i][j] = Integer.parseInt(st.nextToken());
					if (max_height < mt[i][j]) max_height = mt[i][j];
				}
			}
			
			
			
			
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < N; j++)
					// 가장 높은 봉우리일때만 dfs
					if (mt[i][j] == max_height) {
						visited[i][j] = true;
						dfs(i, j, true, 1);
						visited[i][j] = false;
					}
			sb.append(MAX).append("\n");
		} // Test Case 끝
		System.out.println(sb);
	}
	
	// i : 현재 위치의 y좌표, j : 현재 위치의 x좌표, b : 깎을 수 있는지 여부(true : 가능, false : 불가능), k2 : 현재 등산로 길이
	private static void dfs(int i, int j, boolean b, int k2) {
		if(k2 > MAX) MAX = k2;
		
		for (int k = 0; k < 4; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
			if(ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
				// 다음 칸이 현재 칸보다 낮을 떄
				if(mt[ny][nx] < mt[i][j]) {
					visited[ny][nx] = true;  // 방문 체크 후
					dfs(ny, nx, b, k2+1);    // dfs
					visited[ny][nx] = false; // 방문 체크 해제
				}
				// 다음 칸이 현재 칸보다 높을 때
				else {
					// 이미 한 번 깎아서 더 이상 못깎는 경우 다음 방향으로
					if(!b) continue;
					
					else { // 깎을 수 있는 경우
						// 다음 칸을 깎아서 현재 칸보다 더 낮게 만들 수 있는 경우
						if(mt[ny][nx] - mt[i][j] < K) {
							value = mt[ny][nx]; 		// 다음 칸을 깎고 다시 돌려놓고 다음 케이스를 진행해야 하기 때문에 다음 칸의 원래 높이 저장
							mt[ny][nx] = mt[i][j] - 1;	// 다음 칸을 현재 칸보다 1만큼 낮게 만듦
							visited[ny][nx] = true;		// 다음 칸 방문 체크 후
							dfs(ny, nx, false, k2+1);	// dfs
							visited[ny][nx] = false;	// 방문 체크 해제
							mt[ny][nx] = value;			// 다시 원래대로 돌려놓음
						// 아무리 깎아도 현재 칸보다 낮게 만들 수 없는 경우 다음 방향으로
						} else continue;
					}
				}
			}
		}
	}
}
