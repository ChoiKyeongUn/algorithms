

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1799_비숍 {
	
	static int N, board[][], blackResult = 0, whiteResult = 0, blackSize, whiteSize;
	static boolean[] left, right;
	static List<int[]> blackList, whiteList;
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(blackResult + whiteResult);
	}

	private static void solve() {
		dfs(blackList, blackSize, 0, 0, 0);
		dfs(whiteList, whiteSize, 0, 0, 1);
	}

	private static void dfs(List<int[]> list, int size, int i, int sum, int type) {
		if(i == size) {
			if(type == 0) {
				blackResult = Math.max(blackResult, sum);
			} else {
				whiteResult = Math.max(whiteResult, sum);
			}
			return;
		}
		
		int[] cur = list.get(i);
		int curY = cur[0];
		int curX = cur[1];
		int leftSum = curY + curX;
		int rightGap = curY - curX + N - 1;
		
		if(!left[leftSum] && !right[rightGap]) {
			left[leftSum] = true;
			right[rightGap] = true;
			dfs(list, size, i+1, sum+1, type);
			left[leftSum] = false;
			right[rightGap] = false;
		}
		
		dfs(list, size, i+1, sum, type);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		board = new int[N][N];
		blackList = new ArrayList<int[]>();
		whiteList = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < N; j++, idx+=2) {
				board[i][j] = temp.charAt(idx) - '0';
				if(board[i][j] == 1) {
					if((i + j) % 2 == 0) {
						blackList.add(new int[] {i, j});
					} else {
						whiteList.add(new int[] {i, j});
					}
				}
			}
		}
		
		left = new boolean[2*N-1];
		right = new boolean[2*N-1];
		blackSize = blackList.size();
		whiteSize = whiteList.size();
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
