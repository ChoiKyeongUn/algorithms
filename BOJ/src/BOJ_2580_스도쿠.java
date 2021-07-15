

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	static int size, cnt = 0, sdoku[][];
	static boolean[][] latitude, vertical, box;
	static Loc[] locs;
	static boolean flag = false;
	static class Loc {
		int y, x;
		public Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sdoku = new int[9][9];
		latitude = new boolean[9][10];
		vertical = new boolean[9][10];
		box = new boolean[9][10];
		StringTokenizer st = null;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = Integer.parseInt(st.nextToken());
				if(sdoku[i][j] == 0) ++size;
				latitude[i][sdoku[i][j]] = true;
				vertical[j][sdoku[i][j]] = true;
			}
		}
	
		
		locs = new Loc[size];
		size = 0;
		for (int i = 0; i < 3; i++)	for (int j = 0; j < 3; j++)	for (int j2 = 0; j2 < 3; j2++)	for (int k = 0; k < 3; k++) {
			int tmp_y = i*3+j2;
			int tmp_x = j*3+k;
			int tmp_num = sdoku[tmp_y][tmp_x];
			int idx = 3*i+j;
			box[idx][tmp_num] = true;
			if(tmp_num == 0) locs[size++] = new Loc(tmp_y, tmp_x); 
		}
		
		dfs(0);
	}

	private static void dfs(int i) {
		if(i == size) {
			printSdoku();
			flag = true;
			return;
		}
		if(flag) return;
		int cur_y = locs[i].y;
		int cur_x = locs[i].x;
		for (int j = 1; j <= 9; j++) {
			if(latitude[cur_y][j] || vertical[cur_x][j] || box[cur_y/3*3+cur_x/3][j]) continue;
			latitude[cur_y][j] = true;
			vertical[cur_x][j] = true;
			box[cur_y/3*3+cur_x/3][j] = true;
			sdoku[cur_y][cur_x] = j;
			dfs(i+1);
			latitude[cur_y][j] = false;
			vertical[cur_x][j] = false;
			box[cur_y/3*3+cur_x/3][j] = false;
			sdoku[cur_y][cur_x] = 0;
		}
	}

	private static void printSdoku() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(sdoku[i][j]+" ");
			System.out.println();
		}
	}
}
