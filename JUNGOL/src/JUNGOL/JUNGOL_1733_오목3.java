package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JUNGOL_1733_오목3 {
	static class Stone {
		// 차례대로 행, 열, 색깔
		int r, c, color;

		public Stone(int r, int c, int color) {
			super();
			this.r = r;
			this.c = c;
			this.color = color;
		}
	}

	static int[][] omok;
	static int first_x = 19, last_x = 0, first_y = 19, last_y = 0, y_size, x_size;
	static ArrayList<Stone> al;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp;
		al = new ArrayList<Stone>();
		int color;

		// 칸들에 대한 정보를 받아오면서 돌이 있는 칸만 저장
		for (int i = 0; i < 19; i++) {
			temp = br.readLine();
			for (int j = 0, idx = 0; j < 19; j++, idx += 2) {
				color = temp.charAt(idx) - '0';
				
				if (color != 0) {
					// first_x / last_x : 돌이 존재하는 가장 왼쪽 / 오른쪽 좌표
					// first_y / last_y : 돌이 존재하는 가장 위쪽 / 아래쪽 좌표
					// 돌이 존재하는 가장 왼쪽 / 오른쪽 좌표와 가장 위쪽 / 아래쪽의 좌표를 저장하고 오목 판을 재구성 하기 위함  
					if (j < first_x) first_x = j;
					if (j > last_x)  last_x = j;
					if (i < first_y) first_y = i;
					if (i > last_y)  last_y = i;
					// 오목돌에 대한 정보를 al에 저장(행, 열, 색깔)
					al.add(new Stone(i, j, color));
				}
			}
		}
		
		// y_size : 오목판을 재구성할 때 필요한 세로축 사이즈
		// ex) 만약 가장 아래쪽 좌표가 7이였고, 가장 위쪽 좌표가 2였으면 [2 3 4 5 6 7] 총 6칸이 필요 -> 필요한 칸수 = 아래쪽 좌표 - 위쪽 좌표 + 1
		// x_size : 오목판을 재구성할 때 필요한 가로축 사이즈
		// ex) 만약 가장 왼쪽 좌표가 2였고, 오른쪽 좌표가 6이였으면 [2 3 4 5 6] 총 5칸이 필요 -> 필요한 칸수 = 오른쪽 좌표 - 왼쪽 좌표 + 1
		y_size = last_y - first_y + 1;
		x_size = last_x - first_x + 1;
		omok = new int[y_size][x_size];
		
		// 저장된 오목돌들을 새로 재구성한 오목판에 놓음
		for (Stone s : al)
			omok[s.r - first_y][s.c - first_x] = s.color;
		
		// 새로 재구성한 오목판을 한칸 한칸씩 순회하면서
		for (int i = 0; i < y_size; i++)
			for (int j = 0; j < x_size; j++)
				// 그 칸에 돌이 놓였을때만 그 돌을 시작으로 오목 승리 조건을 만족하는지 확인
				if (omok[i][j] != 0)
					
					if (is_omok(i, j)) {
						// 만약 오목이면 현재 돌의 색깔 출력
						System.out.println(omok[i][j]);
						// i, j는 원래 오목판에서의 좌표가 아닌 새로 재구성한 오목판에서의 좌표이므로
						// offset을 더해줌.
						System.out.println((i+first_y+1) + " " + (j+first_x+1));
						return;
					}
		
		// 위 반복문을 빠져나오면 아무 돌도 오목 승리 조건을 만족하지 못했다는 것
		System.out.println(0);
	}
	
	// 차례대로 우상단쪽 대각선, 오른쪽, 우하단쪽 대각선, 아래쪽
	static int[] dy = { -1, 0, 1, 1 };
	static int[] dx = { 1, 1, 1, 0 };

	private static boolean is_omok(int i, int j) {
		int color = omok[i][j];
		int ny, nx;
dir:	for (int k = 0; k < 4; k++) {
			// 만약 현재 돌의 바로 전 위치에 같은 색의 돌이 있다면 이 다음부터 오목이여도 육목
			ny = i - dy[k];
			nx = j - dx[k];
			if (nx >= 0 && ny >= 0 && ny < y_size)
				if (omok[i - dy[k]][j - dx[k]] == color) continue;
			
			// 바로 이전 위치에 같은 색의 돌이 없다면 현재 위치부터 오목인지 확인
			for (int k2 = 1; k2 <= 4; k2++) {
				ny = i + dy[k] * k2;
				nx = j + dx[k] * k2;
				if (ny < 0 || ny > y_size-1 || nx < 0 || nx > x_size-1 || omok[ny][nx] != color) continue dir;
			}
			
			// 현재 위치에서부터 지금 바라보는 방향으로 오목이여도 마지막 돌 다음 칸에 같은 색의 돌이 있다면 육목
			ny = i + 5*dy[k];
			nx = j + 5*dx[k];
			if(nx < x_size && ny >= 0 && ny < y_size)
				if (omok[i + dy[k] * 5][j + dx[k] * 5] == color) continue;
			
			// 한번도 continue를 만나지 않음 -> 오목
			return true;
		}
		
		// 위 반복문을 빠져나오면 현재 위치에서는 오목이 없음.
		return false;
	}
}