package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_0205_쇠막대기자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			int cnt = 0;
			String paren = br.readLine();
			for (int i = 0; i < paren.length(); i++) {
				switch(paren.charAt(i)) {
				case '(':
					cnt++;
					break;
				case ')':
					cnt--;
					switch(paren.charAt(i-1)) {
					case '(':
						sum += cnt;
						break;
					case ')':
						sum ++;
						break;
					}
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(sum);
			System.out.println(sb);
		}
	}
}
