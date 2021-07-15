package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_9778_카드_게임_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), N, temp, sum, lower_cards, higher_cards, gap;
		int[] cards;
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			cards = new int[12];
			for (int i = 2; i < 10; i++) cards[i] = 4;
			cards[10] = 16;
			cards[11] = 4;
			sum = 0;
			for (int i = 0; i < N; i++) {
				temp = Integer.parseInt(br.readLine());
				sum += temp;
				cards[temp]--;
			}
			lower_cards = 0; higher_cards = 0;
			gap = 21 - sum;
			for (int i = 2; i <= 11; i++) {
				if(gap < i) higher_cards += cards[i];
				else lower_cards += cards[i];
			}
			if (lower_cards > higher_cards) sb.append("GAZUA");
			else sb.append("STOP");
			System.out.println(sb);
		}
	}
}
