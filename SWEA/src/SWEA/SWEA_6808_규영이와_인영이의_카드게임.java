package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와_인영이의_카드게임 {
	static int[] kyu;
	static int[] in;
	static int[] choose;
	static boolean[] isSelected;
	static int win = 0, lose = 0, playcount = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[] isSelected_card;
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			isSelected_card = new boolean[19];
			kyu = new int[9];
			in = new int[9];
			choose = new int[9];
			isSelected = new boolean[9];
			int idx = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				isSelected_card[kyu[i]] = true;
			}
			for (int i = 1; i < 19; i++)
				if (!isSelected_card[i])
					in[idx++] = i;
			play(0);
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose);
			System.out.println(sb);
			win = 0; lose = 0;
		}
	}

	static void play(int cnt) {
		if (cnt == 9) {
			int score_kyu = 0, score_in = 0;
			for (int i = 0; i < 9; i++) {
				if (choose[i] > kyu[i])
					score_in += (choose[i] + kyu[i]);
				else
					score_kyu += (kyu[i] + choose[i]);
			}
			if (score_kyu > score_in)
				win++;
			else
				lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue;

			choose[cnt] = in[i];
			isSelected[i] = true;
			play(cnt + 1);
			isSelected[i] = false;

		}
	}
}
