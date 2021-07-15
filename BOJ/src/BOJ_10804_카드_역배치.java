

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10804_카드_역배치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cards = new int[21];
		StringTokenizer st;
		for (int i = 1; i < 21; i++) cards[i] = i;
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			while(start < end) {
				int temp = cards[start];
				cards[start] = cards[end];
				cards[end] = temp;
				++start; --end;
			}
		}
		
		for (int i = 1; i <= 20; i++) {
			System.out.print(cards[i] + " ");
		}
	}
}
