

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노2 {
	static class Tet {
		int dx[], dy[], x_len, y_len;
		public Tet(int[] dx, int[] dy, int x_len, int y_len) {
			this.dx = dx;
			this.dy = dy;
			this.x_len = x_len;
			this.y_len = y_len;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] scores = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) scores[i][j] = Integer.parseInt(st.nextToken());
		}
		Tet[] tets = new Tet[5];
		tets[0] = new Tet(new int[] {0, 1, 2, 3}, new int[] {0, 0, 0, 0}, 4, 1); 
		tets[1] = new Tet(new int[] {0, 1, 0, 1}, new int[] {0, 0, 1, 1}, 2, 2); 
		tets[2] = new Tet(new int[] {0, 0, 0, 1}, new int[] {0, 1, 2, 2}, 2, 3); 
		tets[3] = new Tet(new int[] {0, 0, 1, 1}, new int[] {0, 1, 1, 2}, 2, 3); 
		tets[4] = new Tet(new int[] {0, 1, 2, 1}, new int[] {0, 0, 0, 1}, 3, 2); 

		int result = Integer.MIN_VALUE;
		
		// 각 테트로미노 마다
		for (int i = 0; i < 5; i++) {
			Tet origin = tets[i];
			int[] origin_dy = origin.dy;
			int[] origin_dx = origin.dx;
			int origin_x_len = origin.x_len;
			int origin_y_len = origin.y_len;
			// 0 : 비반전, 1 : 반전
			int[] mirror_dx = origin_dx.clone();
			int[] mirror_dy = origin_dy.clone();
			for (int j = 0; j < 2; j++) {
				// 반전/비반전 처리
				if(j == 1) 
					for (int j2 = 0; j2 < 4; j2++) mirror_dx[j2] = origin_x_len - 1 - mirror_dx[j2];
				
				// 회전(각도 = j2*90')
				for (int j2 = 0; j2 < 4; j2++) {
					// 회전 처리 후
					int rotate_x_len = j2%2 == 0 ? origin_x_len : origin_y_len;
					int rotate_y_len = j2%2 == 0 ? origin_y_len : origin_x_len;
					
					
					
					// 점수 처리 후
					for (int start_y = 0; start_y <= N-rotate_y_len; start_y++) 
						for (int start_x = 0; start_x <= M-rotate_x_len; start_x++) {
							int score = 0;
							for (int k = 0; k < 4; k++) score += scores[start_y+mirror_dy[k]][start_x+mirror_dx[k]];
							result = Math.max(result, score);
						}
					
					int[] temp_dy = mirror_dy.clone();
					mirror_dy = mirror_dx.clone();
					mirror_dx = temp_dy;
					for (int k = 0; k < 4; k++)	mirror_dx[k] = rotate_y_len - 1 - mirror_dx[k];
				}
			}
		}
		System.out.println(result);
	}
}
