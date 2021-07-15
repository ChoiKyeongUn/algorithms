

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방_배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] students = new int[6][2];
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int S, Y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			students[Y-1][S] += 1;
		}
		
		int sum = 0;
		for (int i = 0; i < 6; i++) for (int j = 0; j < 2; j++) {
			sum += students[i][j] / K;
			if (students[i][j] % K > 0) sum += 1; 
		}
		System.out.println(sum);
		
	}
}
