package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class coor {
	int y, x;

	public coor(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}

public class Miro {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] miro = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					miro[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < miro.length; i++)
				System.out.println(Arrays.toString(miro[i]));
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(escape_miro(miro, N));
			System.out.println(sb);
			
		}
	}

	static int escape_miro(int[][] miro, int N) {
		Queue<coor> que = new LinkedList<coor>();
		boolean[][] visited = new boolean[N][N];

		que.offer(new coor(0, 0));
		visited[0][0] = true;
		while (!que.isEmpty()) {
			coor present = que.poll();
			if (present.y == N - 1 && present.x == N - 1) return miro[present.y][present.x];
			if (present.y - 1 > 0 && miro[present.y - 1][present.x] == 0) {
				que.offer(new coor(present.y - 1, present.x));
				miro[present.y-1][present.x] = miro[present.y][present.x]+1;
			}
			if (present.y + 1 < N && miro[present.y + 1][present.x] == 0) {
				que.offer(new coor(present.y + 1, present.x));
				miro[present.y+1][present.x] = miro[present.y][present.x]+1;
			}
			if (present.x - 1 > 0 && miro[present.y][present.x - 1] == 0) {
				que.offer(new coor(present.y, present.x - 1));
				miro[present.y][present.x-1] = miro[present.y][present.x]+1;
			}
			if (present.x + 1 < N && miro[present.y][present.x + 1] == 0) {
				que.offer(new coor(present.y, present.x + 1));
				miro[present.y][present.x+1] = miro[present.y][present.x]+1;
			}
		}
		return -1;
	}
}