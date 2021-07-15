

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지_안녕 {
	
	static class Dust {
		int y, x, amount;
		public Dust(int y, int x, int amount) {
			super();
			this.y = y;
			this.x = x;
			this.amount = amount;
		}
	}
	
	static int R, C, T, room[][], dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};
	static int upAirPurifier_y, downAirPurifier_y;
	static Queue<Dust> queue = new LinkedList<Dust>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		T = stoi(st.nextToken());
		room = new int[R][C];
		boolean isAir = false;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = stoi(st.nextToken());
				if(!isAir && room[i][j] == -1) {
					isAir = true;
					upAirPurifier_y = i;
					downAirPurifier_y = i+1;
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			queuing();
			diffusion();
			rotation();
		}
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j] > 0) result += room[i][j];
			}
		}
		System.out.println(result);
	}
	
	private static void rotation() {
		upper_rotation();
		lower_rotation();
	}

	private static void lower_rotation() {
		for (int i = downAirPurifier_y+1; i < R-1; i++) {
			room[i][0] = room[i+1][0];
		}
		for (int i = 0; i < C-1; i++) {
			room[R-1][i] = room[R-1][i+1];
		}
		for (int i = R-1; i > downAirPurifier_y; i--) {
			room[i][C-1] = room[i-1][C-1];
		}
		for (int i = C-1; i > 1; i--) {
			room[downAirPurifier_y][i] = room[downAirPurifier_y][i-1];
		}
		room[downAirPurifier_y][1] = 0;
	}

	private static void upper_rotation() {
		for (int i = upAirPurifier_y-1; i > 0; i--) {
			room[i][0] = room[i-1][0];
		}
		for (int i = 0; i < C-1; i++) {
			room[0][i] = room[0][i+1];
		}
		for (int i = 0; i < upAirPurifier_y; i++) {
			room[i][C-1] = room[i+1][C-1];
		}
		for (int i = C-1; i > 1; i--) {
			room[upAirPurifier_y][i] = room[upAirPurifier_y][i-1];
		}
		room[upAirPurifier_y][1] = 0;
	}

	private static void diffusion() {
		while(!queue.isEmpty()) {
			Dust cur = queue.poll();
			int cur_y = cur.y;
			int cur_x = cur.x;
			int cur_amount = cur.amount;
			int diff_amount = cur_amount/5;
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int ny = cur_y + dy[i];
				int nx = cur_x + dx[i];
				if(0 <= ny && ny < R && 0 <= nx && nx < C && room[ny][nx] != -1) {
					++cnt;
					room[ny][nx] += diff_amount;
				}
			}
			room[cur_y][cur_x] -= diff_amount*cnt;
		}
	}

	private static void queuing() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j] > 0) {
					queue.offer(new Dust(i, j, room[i][j]));
				}
			}
		}
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
