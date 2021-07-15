

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10808_알파벳_개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int size = S.length();
		int[] cnt = new int[26];
		for (int i = 0; i < size; i++) cnt[S.charAt(i) - 'a']++;
		for (int i = 0; i < 26; i++) System.out.print(cnt[i]+" ");
	}
}
