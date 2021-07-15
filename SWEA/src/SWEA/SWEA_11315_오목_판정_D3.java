package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11315_오목_판정_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[][] omok;
		String temp;
		int cnt, temp_idx, temp_idx2;
		boolean flag;
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			omok = new char[N][N];
			for (int i = 0; i < N; i++) {
				temp = br.readLine();
				for (int j = 0; j < omok.length; j++)
					omok[i][j] = temp.charAt(j);
			}
			flag = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (omok[i][j] == 'o') {
						cnt = 1;
						temp_idx = j+1;
						while(temp_idx < N && omok[i][temp_idx] == 'o') {
							temp_idx++;
							cnt++;
						}
						if (cnt < 5) cnt = 1;
						else {
							flag = false;
							break;
						}
						
						temp_idx = i+1;
						while(temp_idx < N && omok[temp_idx][j] == 'o') {
							temp_idx++;
							cnt++;
						}
						if (cnt < 5) cnt = 1;
						else {
							flag = false;
							break;
						}
						
						temp_idx = i+1;
						temp_idx2 = j+1;
						while(temp_idx < N && temp_idx2 < N && omok[temp_idx][temp_idx2] == 'o') {
							temp_idx++;
							temp_idx2++;
							cnt++;
						}
						if (cnt < 5) cnt = 1;
						else {
							flag = false;
							break;
						}
						
						temp_idx = i+1;
						temp_idx2 = j-1;
						while(temp_idx < N && temp_idx2 >= 0 && omok[temp_idx][temp_idx2] == 'o') {
							temp_idx++;
							temp_idx2--;
							cnt++;
						}
						if (cnt < 5) cnt = 1;
						else {
							flag = false;
							break;
						}
					}
				}
				if (!flag) break;
			}
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			if(!flag) sb.append("YES");
			else sb.append("NO");
			System.out.println(sb);
			
		} // end of tc
	} // end of main
} // end of class
