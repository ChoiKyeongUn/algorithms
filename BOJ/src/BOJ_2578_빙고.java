

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	static int[][] bin;
	static boolean[][] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bin = new int[5][5];
		checked = new boolean[5][5];
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)
				bin[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int temp = Integer.parseInt(st.nextToken());
				for (int k = 0; k < 5; k++)
					for (int k2 = 0; k2 < 5; k2++)
						if (bin[k][k2] == temp) {
							checked[k][k2] = true;
							int lines = getLines();
							if (lines >= 3) {
								System.out.println(i * 5 + j + 1);
								return;
							}
						}

			}
		}

	}

	private static int getLines() {
		int lines = 0;
		for (int i = 0; i < 5; i++) {
			int cnt1 = 0, cnt2 = 0;
			for (int j = 0; j < 5; j++) {
				if (checked[i][j]) cnt1++;
				if (checked[j][i]) cnt2++;
			}
			if (cnt1 == 5) lines++;
			if (cnt2 == 5) lines++;
		}
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < 5; i++) {
			if(checked[i][i]) cnt1++;
			if(checked[i][4-i]) cnt2++;
		}
		if (cnt1 == 5) lines++;
		if (cnt2 == 5) lines++;
		return lines;
	}
}
