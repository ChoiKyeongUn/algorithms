

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5525_IOIOI {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("IOI");
		for (int i = 1; i < N; i++) sb.append("OI");
		char[] pattern = sb.toString().toCharArray();
		char[] text = br.readLine().toCharArray();
		int p_len = pattern.length, t_len = text.length;
		int[] fail = new int[p_len];
		for (int i = 1, j = 0; i < p_len; i++) {
			while(j > 0 && pattern[i] != pattern[j]) j = fail[j-1];
			if(pattern[i] == pattern[j]) fail[i] = ++j;
		}
		int cnt = 0;
		for (int i = 0, j = 0; i < t_len; i++) {
			while(j > 0 && text[i] != pattern[j]) j = fail[j-1];
			if(text[i] == pattern[j]) {
				if(j == p_len - 1) {
					++cnt;
					j = fail[j];
				} else ++j;
			}
		}
		System.out.println(cnt);
	}
}
