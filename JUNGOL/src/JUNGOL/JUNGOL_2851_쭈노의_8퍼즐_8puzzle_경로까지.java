package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class JUNGOL_2851_쭈노의_8퍼즐_8puzzle_경로까지 {
	
	static Map<String, String> visited = new HashMap<>();
	static Queue<String> q = new LinkedList<>();
	static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}

	private static void bfs() {
		int result = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				String cur = q.poll();
				String status = visited.get(cur);
				
				if(cur.equals("123456780")) {
					System.out.println(result);
					if(result != 0) {
						System.out.println(status);
					}						
					return;
				}
				
				char[][] cPuzzle = new char[3][3];
				int curY = 0, curX = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						cPuzzle[i][j] = cur.charAt(i * 3 + j);
						if(cPuzzle[i][j] == '0') {
							curY = i;
							curX = j;
						}
					}
				}
				
				for (int dir = 0; dir < 4; dir++) {
					int nY = curY + dy[dir];
					int nX = curX + dx[dir];
					
					if(isInRange(nY, nX)) {
						check(cPuzzle, status, curY, curX, nY, nX);
					}
				}
			}
			++result;
		}
		
	}

	private static void check(char[][] cPuzzle, String status, int curY, int curX, int nY, int nX) {
		char[][] copy = new char[3][3];
		copy(cPuzzle, copy);
		swap(copy, curY, curX, nY, nX);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(copy[i][j]);
			}
		}
		
		String str = sb.toString();
		sb.setLength(0);
		sb.append(status);
		if(visited.getOrDefault(str, null) == null) {
			sb.append(copy[curY][curX]).append(" ");
			q.offer(str);
			visited.put(str, sb.toString());
		}
	}

	private static void swap(char[][] arr, int y1, int x1, int y2, int x2) {
		char temp = arr[y1][x1];
		arr[y1][x1] = arr[y2][x2];
		arr[y2][x2] = temp;
	}

	private static void copy(char[][] from, char[][] to) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				to[i][j] = from[i][j];
			}
		}
	}

	private static boolean isInRange(int y, int x) {
		return 0 <= y && y < 3 && 0 <= x && x < 3;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < 3; j++, idx+=2) {
				char cur = temp.charAt(idx);
				sb.append(cur == 'X' ? '0' : cur);
			}
		}
		String str = sb.toString();
		q.offer(str);
		visited.put(str, "");
	}
}
