package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5644_무선_충전2 {
	
	static class AP {
		int x, y, C, P;
		public AP(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = stoi(st.nextToken());
			int A = stoi(st.nextToken());
			int[] aMove = new int[M+1], bMove = new int[M+1];
			String temp = br.readLine();
			for (int i = 1, idx = 0; i <= M; i++, idx+=2) {
				aMove[i] = temp.charAt(idx) - '0';
			}

			temp = br.readLine();
			for (int i = 1, idx = 0; i <= M; i++, idx+=2) {
				bMove[i] = temp.charAt(idx) - '0';
			}

			AP[] aps = new AP[A];
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int t_x = stoi(st.nextToken());
				int t_y = stoi(st.nextToken());
				int cover = stoi(st.nextToken());
				int power = stoi(st.nextToken());
				aps[i] = new AP(t_x-1, t_y-1, cover, power);
			}
			
			int a_y = 0, a_x = 0, b_y = 9, b_x = 9;
			
			int result = 0;
			
			int[] dy = {0, -1, 0, 1, 0}, dx = {0, 0, 1, 0, -1};
			
			for (int i = 0; i < M+1; i++) {
				a_y += dy[aMove[i]];
				a_x += dx[aMove[i]];
				b_y += dy[bMove[i]];
				b_x += dx[bMove[i]];
				
				boolean[] aCover = new boolean[A];
				boolean[] bCover = new boolean[A];
				
				for (int j = 0; j < A; j++) {
					if(Math.abs(aps[j].y - a_y) + Math.abs(aps[j].x - a_x) <= aps[j].C) aCover[j] = true;
					if(Math.abs(aps[j].y - b_y) + Math.abs(aps[j].x - b_x) <= aps[j].C) bCover[j] = true;
				}
				
				int max = 0;
				for (int j = 0; j < A; j++) {
					for (int j2 = 0; j2 < A; j2++) {
						int zz = 0;
						if(j == j2) {
							if(aCover[j] || bCover[j]) zz = aps[j].P;
						} else {
							if(aCover[j] && bCover[j2]) zz = aps[j].P + aps[j2].P;
							else if(aCover[j]) zz = aps[j].P;
							else if(bCover[j2]) zz = aps[j2].P;
						}
						
						if(zz > max) max = zz;
					}
				}
				
				result += max;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
