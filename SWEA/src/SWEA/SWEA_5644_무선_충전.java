package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5644_무선_충전 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		String temp = null;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int[] person_1 = new int[M];
			int[] person_2 = new int[M];
			int[][] AP = new int[A][4];
			boolean[][][] range = new boolean[A][10][10];
			temp = br.readLine();
			for (int i = 0, idx = 0; i < M; i++, idx+=2) person_1[i] = temp.charAt(idx) - '0';
			temp = br.readLine();
			for (int i = 0, idx = 0; i < M; i++, idx+=2) person_2[i] = temp.charAt(idx) - '0';
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) AP[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				int zz = AP[i][2];
				for (int j = -zz; j <= zz; j++)
					for (int j2 = -zz; j2 <= zz; j2++) {
						int cur_x = AP[i][0] -1 + j2, cur_y = AP[i][1] -1 + j;
						if(cur_y >= 0 && cur_y < 10 && cur_x >= 0 && cur_x < 10 && Math.abs(j) + Math.abs(j2) <= AP[i][2])
							range[i][cur_y][cur_x] = true;
					}
			}
			
			int p1_y = 0, p1_x = 0, p2_y = 9, p2_x = 9, idx = 0;
			boolean[] per1_on = new boolean[A];
			boolean[] per2_on = new boolean[A];
			int total = 0;
			while(true) {
				int max = 0;
				for (int i = 0; i < A; i++) {
					per1_on[i] = false;
					per2_on[i] = false;
				}
				for (int i = 0; i < A; i++) {
					if(range[i][p1_y][p1_x]) per1_on[i] = true;
					if(range[i][p2_y][p2_x]) per2_on[i] = true;
				}
				int select_1 = -1, select_2 = -1;
				for (int i = 0; i < A; i++) {
					if(per1_on[i]) select_1 = i;
					for (int j = 0; j < A; j++) {
						int temp_num = 0;
						if(per2_on[j]) select_2 = j;
						
						if(select_1 == -1 && select_2 == -1) continue;
						if(select_1 == select_2) temp_num += AP[select_1][3];
						else {
							if(select_1 != -1) temp_num += AP[select_1][3];
							if(select_2 != -1) temp_num += AP[select_2][3];
						}
						if (temp_num > max) max = temp_num;
					}
				}
				total+=max;
				if(idx >= M) break;
				int next_1 = person_1[idx], next_2 = person_2[idx++];
				switch(next_1) {
				case 1: p1_y -= 1; break;
				case 2: p1_x += 1; break;
				case 3: p1_y += 1; break;
				case 4: p1_x -= 1; break;
				}
				switch(next_2) {
				case 1: p2_y -= 1; break;
				case 2: p2_x += 1; break;
				case 3: p2_y += 1; break;
				case 4: p2_x -= 1; break;
				}
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}
}
