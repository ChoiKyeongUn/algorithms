

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
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
		Tet[] tets = new Tet[19];
		tets[0] = new Tet(new int[] {0, 1, 2, 3}, new int[] {0, 0, 0, 0}, 4, 1); 
		tets[1] = new Tet(new int[] {0, 0, 0, 0}, new int[] {0, 1, 2, 3}, 1, 4); 
		tets[2] = new Tet(new int[] {0, 1, 0, 1}, new int[] {0, 0, 1, 1}, 2, 2); 
		tets[3] = new Tet(new int[] {0, 0, 0, 1}, new int[] {0, 1, 2, 2}, 2, 3); 
		tets[4] = new Tet(new int[] {0, 0, 1, 2}, new int[] {0, 1, 0, 0}, 3, 2); 
		tets[5] = new Tet(new int[] {0, 1, 1, 1}, new int[] {0, 0, 1, 2}, 2, 3); 
		tets[6] = new Tet(new int[] {0, 1, 2, 2}, new int[] {1, 1, 1, 0}, 3, 2); 
		tets[7] = new Tet(new int[] {0, 0, 1, 1}, new int[] {0, 1, 1, 2}, 2, 3); 
		tets[8] = new Tet(new int[] {0, 1, 1, 2}, new int[] {1, 1, 0, 0}, 3, 2); 
		tets[9] = new Tet(new int[] {0, 1, 1, 2}, new int[] {0, 0, 1, 0}, 3, 2); 
		tets[10] = new Tet(new int[] {0, 1, 1, 1}, new int[] {1, 0, 1, 2}, 2, 3); 
		tets[11] = new Tet(new int[] {1, 0, 1, 2}, new int[] {0, 1, 1, 1}, 3, 2); 
		tets[12] = new Tet(new int[] {0, 0, 1, 0}, new int[] {0, 1, 1, 2}, 2, 3);
		tets[13] = new Tet(new int[] {1, 1, 1, 0}, new int[] {0, 1, 2, 2}, 2, 3);
		tets[14] = new Tet(new int[] {0, 0, 1, 2}, new int[] {0, 1, 1, 1}, 3, 2);
		tets[15] = new Tet(new int[] {0, 1, 0, 0}, new int[] {0, 0, 1, 2}, 2, 3);
		tets[16] = new Tet(new int[] {0, 1, 2, 2}, new int[] {0, 0, 0, 1}, 3, 2);
		tets[17] = new Tet(new int[] {1, 1, 0, 0}, new int[] {0, 1, 1, 2}, 2, 3);
		tets[18] = new Tet(new int[] {0, 1, 1, 2}, new int[] {0, 0, 1, 1}, 3, 2);
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < 19; i++) {
			Tet cur = tets[i];
			int cur_dx[] = cur.dx, cur_dy[] = cur.dy, cur_x_len = cur.x_len, cur_y_len = cur.y_len;
			
			for (int start_y = 0; start_y <= N-cur_y_len; start_y++)
				for (int start_x = 0; start_x <= M-cur_x_len; start_x++) {
					int score = 0;
					for (int j = 0; j < 4; j++)	score += scores[start_y+cur_dy[j]][start_x+cur_dx[j]];
					if(score > result) result = score;
				}
		}
		System.out.println(result);
	}
}
