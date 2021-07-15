package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10912_외로운_문자_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean[] check;
		String alpha;
		int temp;
		StringBuilder sb;
		boolean flag;
		for (int tc = 1; tc <= T; tc++) {
			check = new boolean[26];
			alpha = br.readLine();
			for (int i = 0; i < alpha.length(); i++) {
				temp = alpha.charAt(i) - 'a';
				if (check[temp]) check[temp] = false;
				else check[temp] = true;
			}
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			flag = true;
			for (int i = 0; i < check.length; i++)
				if (check[i]) {
					sb.append((char)(i+'a'));
					flag = false;
				}
			if(flag) sb.append("Good");
			System.out.println(sb);
		}
	}
}
