package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1227_미로2 {
	static class Loc {
		int y, x;
		public Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		Tc:
		for (int tc = 0; tc < 10; tc++) {
			int TC = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(TC).append(" ");
			int[][] miro = new int[100][100];
			boolean[][] visited = new boolean[100][100];
			Queue<Loc> queue = new LinkedList<>();
			for (int i = 0; i < 100; i++) {
				String temp = br.readLine(); 
				for (int j = 0; j < 100; j++) { 
					miro[i][j] = temp.charAt(j) - '0';
					if (miro[i][j] == 2) {
						queue.add(new Loc(i, j));
						visited[i][j] = true;
					}
				}
			}
			
			while(!queue.isEmpty()) {
				Loc cur = queue.poll();
				int cur_y = cur.y;
				int cur_x = cur.x;
				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if(ny >= 0 && ny < 100 && nx >= 0 && nx < 100 && !visited[ny][nx] && miro[ny][nx] != 1) {
						queue.add(new Loc(ny, nx));
						visited[ny][nx] = true;
						if (miro[ny][nx] == 3) {
							sb.append(1);
							System.out.println(sb);
							continue Tc;
						}
					}
				}
			}
			sb.append(0);
			System.out.println(sb);
		}
	}
}
