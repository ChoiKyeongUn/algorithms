

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, X, result, land[][];
	static boolean[] covered;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(result);
	}
	
	private static void solve() {
		for (int i = 0; i < N; i++) {
			covered = new boolean[N];
			if(possible_width(i)) ++result;
			covered = new boolean[N];
			if(possible_height(i)) ++result;
		}
	}

	private static boolean possible_height(int i) {
		for (int j = 0; j < N; j++) {
			int cur_height = land[j][i];
			// 윗편 체크
			if(j != 0) {
				int ny = j-1;
				int nHeight = land[ny][i];
				if(nHeight < cur_height-1) return false;
				if(nHeight == cur_height -1) {
					int cnt = 0;
					while(ny >= 0 && cnt < X) {
						if(land[ny][i] != nHeight) return false;
						if(covered[ny]) return false;
						++cnt;
						--ny;
					}
					if(cnt < X) return false;
					for (int k = 1; k <= X; k++) {
						covered[j-k] = true;
					}
				}
			}
			// 아랫편 체크
			if(j != N-1) {
				int ny = j+1;
				int nHeight = land[ny][i];
				if(nHeight < cur_height-1) return false;
				if(nHeight == cur_height -1) {
					int cnt = 0;
					while(ny < N && cnt < X) {
						if(land[ny][i] != nHeight) return false;
						if(covered[ny]) return false;
						++cnt;
						++ny;
					}
					if(cnt < X) return false;
					for (int k = 1; k <= X; k++) {
						covered[j+k] = true;
					}
				}
			}
		}
		return true;
	}

	private static boolean possible_width(int i) {
		for (int j = 0; j < N; j++) {
			int cur_height = land[i][j];
			// 왼쪽편 체크
			if(j != 0) {
				int nx = j-1;
				int nHeight = land[i][nx];
				if(nHeight < cur_height-1) return false;
				if(nHeight == cur_height -1) {
					int cnt = 0;
					while(nx>=0 && cnt < X) {
						if(land[i][nx] != nHeight) return false;
						if(covered[nx]) return false;
						++cnt;
						--nx;
					}
					if(cnt < X) return false;
					for (int k = 1; k <= X; k++) {
						covered[j-k] = true;
					}
				}
			}
			// 오른쪽편 체크
			if(j != N-1) {
				int nx = j+1;
				int nHeight = land[i][nx];
				if(nHeight < cur_height-1) return false;
				if(nHeight == cur_height -1) {
					int cnt = 0;
					while(nx < N && cnt < X) {
						if(land[i][nx] != nHeight) return false;
						if(covered[nx]) return false;
						++cnt;
						++nx;
					}
					if(cnt < X) return false;
					for (int k = 1; k <= X; k++) {
						covered[j+k] = true;
					}
				}
			}
		}
		return true;
	}
	
	

	private static void saveResult(int tc) {
		sb.append("#").append(tc).append(" ").append(result).append("\n");
	}

	private static void input() throws Exception {
		result = 0;
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		X = stoi(st.nextToken());
		land = new int[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < N; j++, idx+=2) {
				land[i][j] = temp.charAt(idx) - '0';
			}
		}
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
