

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1919_애너그램_만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] cnt = new int[2][26];
		for (int i = 0; i < 2; i++) {
			String s = br.readLine();
			int size = s.length();
			for (int j = 0; j < size; j++) cnt[i][s.charAt(j) - 'a']++;
		}
		
		int sum = 0;
		for (int i = 0; i < 26; i++) sum += Math.abs(cnt[0][i] - cnt[1][i]);
		System.out.println(sum);
	}
}
