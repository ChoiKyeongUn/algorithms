

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] land = new int[N][M];
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
				if (land[i][j] > max)
					max = land[i][j];
				if (land[i][j] < min)
					min = land[i][j];
			}
		}

		int time, brick, min_time = Integer.MAX_VALUE, max_land = -1;
		for (int i = min; i <= max; i++) {
			time = 0;
			brick = B;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if (land[j][j2] > i) {
						time += (2 * (land[j][j2] - i));
						brick += (land[j][j2] - i);
					} else if (land[j][j2] < i) {

						time += (i - land[j][j2]);
						brick -= (i - land[j][j2]);

					}
				}
			}
			if (brick >= 0) {
				if (time <= min_time) {
					min_time = time;
					max_land = i;
				}
			}
		}
		System.out.println(min_time + " " + max_land);
	}
}
