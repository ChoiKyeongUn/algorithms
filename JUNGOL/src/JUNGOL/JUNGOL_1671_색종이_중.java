package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1671_색종이_중 {
	static boolean paper[][] = new boolean[100][100];
	static int dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine()), result = 0;
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			for (int j = a; j < a + 10; j++) {
				for (int j2 = b; j2 < b + 10; j2++) {
					paper[j][j2] = true;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(!paper[i][j]) {
					continue;
				}
				boolean flag = false;
				for (int dir = 0; dir < 4; dir++) {
					int nY = i + dy[dir];
					int nX = j + dx[dir];
					if(!isInRange(nY, nX) || !paper[nY][nX]) {
						++result;
					}
				}
			}
		}
		
		System.out.println(result);
	}

	private static boolean isInRange(int y, int x) {
		return 0 <= y && y < 100 && 0 <= x && x < 100;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
