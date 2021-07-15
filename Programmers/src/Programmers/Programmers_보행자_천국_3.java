package Programmers;

import java.util.LinkedList;
import java.util.Queue;

class p_coor {
	int y, x, dir;

	public p_coor(int y, int x, int dir) {
		super();
		this.y = y;
		this.x = x;
		this.dir = dir;
	}
}

public class Programmers_보행자_천국_3 {
	static int MOD = 20170805;

	public static void main(String[] args) {
		int m = 3;
		int n = 6;
		int[][] cityMap = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
		int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		boolean[][] visited = new boolean[m][n];
		Queue<p_coor> que = new LinkedList<p_coor>();
		que.add(new p_coor(0, 0, 0));
		visited[0][0] = true;
		p_coor present;
		int present_x, present_y, present_dir, cnt = 0, n_x, n_y;
		while (!que.isEmpty()) {
			present = que.poll();
			present_x = present.x;
			present_y = present.y;
			present_dir = present.dir;
			if (cityMap[present_y][present_x] == 0) {
				if (present_x < n - 1 && !visited[present_y][present_x + 1] && cityMap[present_y][present_x + 1] != 1) {
					if (present_y == m - 1 && present_x + 1 == n - 1)
						cnt++;
					else {
						visited[present_y][present_x + 1] = true;
						que.add(new p_coor(present_y, present_x + 1, 0));
					}
				}
				if (present_x > 0 && !visited[present_y][present_x - 1] && cityMap[present_y][present_x - 1] != 1) {
					if (present_y == m - 1 && present_x - 1 == n - 1)
						cnt++;
					else {
						visited[present_y][present_x - 1] = true;
						que.add(new p_coor(present_y, present_x - 1, 1));
					}
				}
				if (present_y < m - 1 && !visited[present_y + 1][present_x] && cityMap[present_y + 1][present_x] != 1) {
					if (present_y + 1 == m - 1 && present_x == n - 1)
						cnt++;
					else {
						visited[present_y + 1][present_x] = true;
						que.add(new p_coor(present_y + 1, present_x, 2));
					}
				}
				if (present_y > 0 && !visited[present_y - 1][present_x] && cityMap[present_y - 1][present_x] != 1) {
					if (present_y - 1 == m - 1 && present_x == n - 1)
						cnt++;
					else {
						visited[present_y - 1][present_x] = true;
						que.add(new p_coor(present_y - 1, present_x, 3));
					}
				}
			}
			else if(cityMap[present_y][present_x] == 2) {
				n_y = present_y + move[present_dir][0];
				n_x = present_x + move[present_dir][1];
				if (n_y >= 0 && n_y < m && n_x >= 0 && n_x < n && !visited[n_y][n_x] && cityMap[n_y][n_x] != 1) {
					if (n_y == m-1 && n_x == n-1) cnt++;
					else {
						visited[n_y][n_x] = true;
						que.add(new p_coor(n_y, n_x, present_dir));
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
