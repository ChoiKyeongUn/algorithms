import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BOJ_1525_퍼즐 {
	
	static Map<String, Boolean> checked = new HashMap<>();
	static boolean[][][][][] visited = new boolean[9][9][9][9][9];
	static Queue<int[][]> q = new LinkedList<>();
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}

	private static void bfs() {
		int result = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				int[][] cur = q.poll();
				
				if(complete(cur)) {
					System.out.println(result);
					return;
				}
				
				int[] curZero = getZero(cur);
				int curY = curZero[0];
				int curX = curZero[1];
				
				for (int dir = 0; dir < 4; dir++) {
					int nY = curY + dy[dir];
					int nX = curX + dx[dir];
					
					if(isInRange(nY, nX)) {
						int[][] copy = copy(cur);
						swap(copy, curY, curX, nY, nX);
						if(!check(copy)) {
							q.offer(copy);
						}
					}
				}
			}
			++result;
		}
		System.out.println(-1);
	}

	private static void swap(int[][] arr, int y1, int x1, int y2, int x2) {
		int temp = arr[y1][x1];
		arr[y1][x1] = arr[y2][x2];
		arr[y2][x2] = temp;
	}

	private static int[][] copy(int[][] arr) {
		int[][] res = new int[5][5];
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				res[i][j] = arr[i][j];
			}
		}
		return res;
	}

	private static boolean isInRange(int y, int x) {
		return 1 <= y && y <= 3 && 1 <= x && x <= 3;
	}

	private static int[] getZero(int[][] cur) {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if(cur[i][j] == 0) {
					return new int[] {i, j};
				}
			}
		}
		return null;
	}

	private static boolean complete(int[][] cur) {
		return cur[1][1] == 1 &&
			   cur[1][2] == 2 &&
			   cur[1][3] == 3 &&
			   cur[2][1] == 4 &&
			   cur[2][2] == 5 &&
			   cur[2][3] == 6 &&
			   cur[3][1] == 7 &&
			   cur[3][2] == 8 &&
			   cur[3][3] == 0;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] puzzle = new int[5][5];
		for (int i = 1; i <= 3; i++) {
			String temp = br.readLine();
			for (int j = 1, idx = 0; j <= 3; j++, idx+=2) {
				puzzle[i][j] = temp.charAt(idx) - '0';
			}
		}
		
		check(puzzle);
		q.offer(puzzle);
	}

	private static boolean check(int[][] puzzle) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				sb.append(puzzle[i][j]);
			}
		}
		if(checked.getOrDefault(sb.toString(), false)) {
			return true;
		} else {
			checked.put(sb.toString(), true);
			return false;
		}
	}
}
