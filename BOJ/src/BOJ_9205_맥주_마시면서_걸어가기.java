

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205_맥주_마시면서_걸어가기 {
	public static void main(String[] args) throws Exception {
		final int INF = 100000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] coors = new int[n+2][2];
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				coors[i][0] = Integer.parseInt(st.nextToken());
				coors[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] distance = new int[n+2][n+2];
			for (int i = 0; i < n+1; i++) {
				for (int j = i+1; j < n+2; j++) {
					int temp = Math.abs(coors[i][0] - coors[j][0]) + Math.abs(coors[i][1] - coors[j][1]);
					if(temp > 1000) {
						distance[i][j] = INF;
						distance[j][i] = INF;
					} else {
						distance[i][j] = 1;
						distance[j][i] = 1;
					}
					 
				}
			}
			
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					if(i==j) continue;
					for (int j2 = 0; j2 < n+2; j2++) {
						if(i==j2 || j==j2) continue;
						distance[j][j2] = Math.min(distance[j][j2], distance[j][i] + distance[i][j2]); 
					}
				}
			}
			if(distance[0][n+1] >= 100000) System.out.println("sad");
			else System.out.println("happy");
		}
	}
}
