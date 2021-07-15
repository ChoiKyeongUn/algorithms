

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Coor_2667 {
	int y, x;
	public Coor_2667(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}

public class BOJ_2667 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] apt = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		String temp;
		for (int i = 0; i < N; i++) {
			temp = br.readLine();
			for (int j = 0; j < N; j++)
				apt[i][j] = temp.charAt(j);
		}
		Queue<Coor_2667> queue = new LinkedList<Coor_2667>();
		int cnt, present_x, present_y, total = 0;
		Coor_2667 get;
		StringBuilder sb = new StringBuilder();
		int[] cnts = new int[(N*N+1)/2];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(apt[i][j] == '1' && !visited[i][j]) {
					cnt = 1;
					queue.add(new Coor_2667(i, j));
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						get = queue.poll();
						present_y = get.y;
						present_x = get.x;
						if (present_y > 0 && !visited[present_y-1][present_x] && apt[present_y-1][present_x] == '1') {
							cnt++;
							visited[present_y-1][present_x] = true;
							queue.add(new Coor_2667(present_y-1, present_x));
						}
						if (present_y < N-1 && !visited[present_y+1][present_x] && apt[present_y+1][present_x] == '1') {
							cnt++;
							visited[present_y+1][present_x] = true;
							queue.add(new Coor_2667(present_y+1, present_x));
						}
						if (present_x > 0 && !visited[present_y][present_x-1] && apt[present_y][present_x-1] == '1') {
							cnt++;
							visited[present_y][present_x-1] = true;
							queue.add(new Coor_2667(present_y, present_x-1));
						}
						if (present_x < N-1 && !visited[present_y][present_x+1] && apt[present_y][present_x+1] == '1') {
							cnt++;
							visited[present_y][present_x+1] = true;
							queue.add(new Coor_2667(present_y, present_x+1));
						}
					}
					total++;
					cnts[idx++] = cnt;
				}
			}
		}
		Arrays.sort(cnts);
		System.out.println(total);
		for (int i = 0; i < (N*N+1)/2; i++)
			if(cnts[i] != 0) System.out.println(cnts[i]);
	}
}
