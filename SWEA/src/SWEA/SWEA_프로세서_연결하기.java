package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_프로세서_연결하기 {
	
	static int N, max, totalCnt, min, map[][];
	static int dr[] = {-1, 1, 0, 0,};
	static int dc[] = {0, 0, -1, 1};
	static ArrayList<int[]> list; // 고려애햐하는 코어만 담고 있는 리스트(가장자리 코어는 배제)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0, idx = 0; j < N; j++, idx += 2) {
					map[i][j] = temp.charAt(idx) - '0';
					if (i == 0 || j == 0 || i == N-1 || j == N-1) continue; // 가장자리 코어
					if (map[i][j] == 1) {
						list.add(new int[] {i, j});
						totalCnt++;
					}
				}
			}
			go(0, 0);
			System.out.println("#"+tc+" "+min);
		}
	}
	
	private static void go(int index, int cCnt) { // index : 부분집합에 고려할 코어 인덱스, cCnt : 연결된 코어 개수
		
		if(index == totalCnt) {
			int res = getLength();
			
			if (max < cCnt) {
				max = cCnt;
				min = res;
			} else if (max == cCnt) {
				if (min > res) min = res;
			}
			return;
		}
		
		// 코어 선택 전선 놓아보기(4방향으로 놓아보기)
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		for (int d = 0; d < 4; d++) {
			if (isAvailable(r, c, d)) {
				// 전선 놓기
				setStatus(r, c, d, 2);
				// 다음 코어로 넘어가기
				go(index+1, cCnt+1);
				// 놓았던 전선 되돌려 놓기
				setStatus(r, c, d, 0);
			}
		}
		// 코어 비선택
		go(index+1, cCnt);
	}
	
	private static int getLength() {
		int sum = 0;
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) if(map[i][j] == 2) sum++;
		return sum;
	}
	
	private static void setStatus(int r, int c, int d, int s) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) break;
			map[nr][nc] = s;
		}
	}
	
	private static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) break; // 계속해서 해당 방향으로 직진 해서 경계 벗어남. : 전원 연결 가능
			if(map[nr][nc] != 0) return false; // 코어나 전선이 놓아져있어 불가능.
		}
		return true;
	}
}
