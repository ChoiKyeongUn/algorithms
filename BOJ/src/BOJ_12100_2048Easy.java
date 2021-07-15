

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100_2048Easy { // Gold 2
	static int N, board[][], dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 }, result = 0;
	static int copyBoard[][][];

	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(result);
	}

	private static void solve() {
		for (int dir0 = 0; dir0 < 4; dir0++) {
			copy(board, copyBoard[0]);
			move(copyBoard[0], dir0);
			
			for (int dir1 = 0; dir1 < 4; dir1++) {
				copy(copyBoard[0], copyBoard[1]);
				move(copyBoard[1], dir1);
				
				for (int dir2 = 0; dir2 < 4; dir2++) {
					copy(copyBoard[1], copyBoard[2]);
					move(copyBoard[2], dir2);
					
					for (int dir3 = 0; dir3 < 4; dir3++) {
						copy(copyBoard[2], copyBoard[3]);
						move(copyBoard[3], dir3);
						
						for (int dir4 = 0; dir4 < 4; dir4++) {
							copy(copyBoard[3], copyBoard[4]);
							move(copyBoard[4], dir4);
							update();
						}
					}
				}
			}
		}
	}
	
	

	private static void update() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int block = copyBoard[4][i][j];
				result = Math.max(result, block);
			}
		}
	}

	private static void printArr(int[][] b) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// dir : 0 ~ 3, 상 하 좌 우
	private static void move(int[][] b, int dir) {
		int start = 0;
		int step = 1;
		if (dir % 2 == 1) {
			start = N - 1;
			step = -1;
		}

		if (dir / 2 == 0) {
			for (int x = 0; x < N; x++) {
				boolean[] isMerge = new boolean[N];
				for (int y = start; 0 <= y && y < N; y += step) {
					if(b[y][x] != 0) {
						int cur_y = y;
						int ny = y + dy[dir];
						int value = b[y][x];
						while(true) {
							if(ny < 0 || ny >= N || (b[ny][x] != 0 && b[ny][x] != value)) {
								b[y][x] = 0;
								b[cur_y][x] = value;
								break;
							}
							if(b[ny][x] == value) {
								if(!isMerge[cur_y]) {
									isMerge[cur_y] = true;
									b[y][x] = 0;
									b[ny][x] *= 2;
								} else {
									b[y][x] = 0;
									b[cur_y][x] = value;
								}
								break;
							}
							cur_y = ny;
							ny += dy[dir];
						}
					}
				}
			}
		} else {
			for (int y = 0; y < N; y++) {
				boolean[] isMerge = new boolean[N];
				for (int x = start; 0 <= x && x < N; x+=step) {
					if(b[y][x] != 0) {
						int cur_x = x;
						int nx = x + dx[dir];
						int value = b[y][x];
						while(true) {
							if(nx < 0 || nx >= N || (b[y][nx] != 0 && b[y][nx] != value)) {
								b[y][x] = 0;
								b[y][cur_x] = value;
								break;
							}
							if(b[y][nx] == value) {
								if(!isMerge[cur_x]) {
									isMerge[cur_x] = true;
									b[y][x] = 0;
									b[y][nx] *= 2;									
								} else {
									b[y][x] = 0;
									b[y][cur_x] = value;
								}
								break;
							}
							cur_x = nx;
							nx += dx[dir];
						}
					}
				}
			}
		}
	}

	private static void copy(int[][] from, int[][] to) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				to[i][j] = from[i][j];
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		board = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}
		copyBoard = new int[5][N][N];
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
