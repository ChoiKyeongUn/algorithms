

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14502_연구소 {
	static class Loc {
		int y, x;
		public Loc(int y, int x) { this.y = y; this.x = x; }
		@Override
		public String toString() { return "Loc [y=" + y + ", x=" + x + "]"; }
	}
	
	static int N, M, map[][], eSize = 0, vSize = 0, for_comb[];
	static Loc[] emptys, virus;
	static int result = -1;
	static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		N = temp.charAt(0) - '0';
		M = temp.charAt(2) - '0';
		map = new int[N][M];
		emptys = new Loc[N*M]; // 빈 칸을 저장할 배열(빈 칸이 몇개가 있을지 모르기 때문에 일단 미로의 크기만큼 배열을 만들어주고
							   //			       이 배열의 사이즈를 뜻하는 eSize를 만들어서 이를 통해 접근, 입력을 받을 때 빈칸이면 eSize++ 
		virus = new Loc[N*M];  // 빈 칸을 저장할 배열(바이러스가 몇개가 있을지 모르기 때문에 일단 미로의 크기만큼 배열을 만들어주고
		   //			       	 			       이 배열의 사이즈를 뜻하는 vSize를 만들어서 이를 통해 접근, 입력을 받을 때 바이러스면 vSize++
		for (int i = 0; i < N; i++) {
			temp = br.readLine();
			for (int j = 0, idx = 0; j < M; j++, idx+=2) {
				map[i][j] = temp.charAt(idx) - '0';
				if(map[i][j] == 0) emptys[eSize++] = new Loc(i, j);
				if(map[i][j] == 2) virus[vSize++] = new Loc(i, j);
			}
		}
		
		for_comb = new int[eSize]; // NextPermutation 알고리즘을 사용하기 위해 만드는 배열, 빈 칸들 중 3개를 택해야 하기 때문에
								   // 전체 크기는 빈 칸의 개수와 같고, 마지막 세 수는 1로, 나머지는 0으로 만들어줌.
		for (int i = 0; i < 3; i++) for_comb[eSize-1-i] = 1;
		
		do {
			bfs();
		} while(np());
		System.out.println(result);
	}
	
	private static void bfs() {
		// 조합이 바뀔 때마다 
		int[][] copy_map = new int[N][M];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) copy_map[i][j] = map[i][j];
		
		boolean[][] visited = new boolean[N][M];
		int remain_empty = eSize - 3;
		for (int i = 0; i < eSize; i++) {
			if(for_comb[i] == 1) {
				Loc e = emptys[i];
				int y = e.y;
				int x = e.x;
				copy_map[y][x] = 1;
			}
		}
		Queue<Loc> q = new LinkedList<Loc>();
		for (int i = 0; i < vSize; i++) {
			q.offer(virus[i]);
			visited[virus[i].y][virus[i].x] = true;
		}
		
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			int cur_y = cur.y;
			int cur_x = cur.x;
			for (int i = 0; i < 4; i++) {
				int ny = cur_y + dy[i];
				int nx = cur_x + dx[i];
				if(ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && copy_map[ny][nx] == 0) {
					visited[ny][nx] = true;
					copy_map[ny][nx] = 2;
					q.offer(new Loc(ny, nx));
					--remain_empty;
				}
			}
		}
		
		if(result < remain_empty) result = remain_empty;
	}

	private static boolean np() {
		int i = eSize-1;
		while(i > 0 && for_comb[i-1] >= for_comb[i]) --i;
		if(i == 0) return false;
		
		int j = eSize-1;
		while(for_comb[i-1] >= for_comb[j]) --j;
		swap(i-1, j);
		
		int k = eSize-1;
		while(i < k) swap(i++, k--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int temp = for_comb[i];
		for_comb[i] = for_comb[j];
		for_comb[j] = temp;
	}
}
