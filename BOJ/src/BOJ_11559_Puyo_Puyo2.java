

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559_Puyo_Puyo2 {
	
	static class Puyo {
		int y, x;
		char value;
		public Puyo(int y, int x, char value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}		
	}
	
	static char[][] field = new char[12][6];
	static int cnt, dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		// 필드 입력
		input();
		int result = 0;
		while(true) {
			// 뿌갤 수 있는 뿌요모임의 수
			cnt = bfs();
			// 아무 뿌요도 못뿌개면 반복문 탈출
			if(cnt == 0) break;
			++result;
			// 빈 자리 메꾸기
			move();
		}
		System.out.println(result);
	}

	private static void move() {
		for (int x = 0; x < 6; x++) {
			// 위에 뿌요가 있는지 여부
			boolean flag = true;
			for (int y = 11; y >= 1; y--) {
				// 더이상 위에 뿌요가 없으면 반복문 옆칸 ㄱㄱ
				if(!flag) break;
				if(field[y][x] == '.') {
					int ny = y-1;
					while(ny >= 0) {
						if(field[ny][x] != '.') {
							field[y][x] = field[ny][x];
							field[ny][x] = '.';
							break;
						}
						ny--;
					}
					if(ny <= 0) {
						flag = false;
					}
				}
			}
		}
	}
	
	private static int bfs() {
		// 뿌갤 수 있는 뿌요모임의 수
		int ret = 0;
		boolean[][] visited = new boolean[12][6];
		Queue<Puyo> q = new LinkedList<Puyo>();
		Queue<Puyo> tmp = new LinkedList<Puyo>();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if(field[i][j] != '.' && !visited[i][j]) {
					int ea = 0;
					q.offer(new Puyo(i, j, field[i][j]));
					visited[i][j] = true;
					
					tmp.clear();
					while(!q.isEmpty()) {
						Puyo cur = q.poll();
						int cur_y = cur.y;
						int cur_x = cur.x;
						char cur_value = cur.value;
						++ea;
						tmp.offer(cur);
						
						for (int k = 0; k < 4; k++) {
							int ny = cur_y + dy[k];
							int nx = cur_x + dx[k];
							if(0 <= ny && ny < 12 && 0 <= nx && nx < 6 && !visited[ny][nx] && field[ny][nx] == cur_value) {
								visited[ny][nx] = true;
								q.offer(new Puyo(ny, nx, cur_value));
							}
						}
					}
					if(ea >= 4) {
						++ret;
						while(!tmp.isEmpty()) {
							Puyo cur = tmp.poll();
							field[cur.y][cur.x] = '.';
						}
					}
				}
			}
		}
		
		return ret;
	}
	
	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 6; j++) {
				field[i][j] = temp.charAt(j);
			}
		}
	}
}
