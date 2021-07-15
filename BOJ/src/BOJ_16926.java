

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int rotate = 0; rotate < R; rotate++)
			for (int i = 0; i < Math.min(N, M) / 2; i++) {
				int temp = arr[i][i];
				for (int j = i; j < M - i - 1; j++)
					arr[i][j] = arr[i][j + 1];
				
				for (int j = i; j < N - i - 1; j++)
					arr[j][M - 1 - i] = arr[j + 1][M - 1 - i];
				
				for (int j = M - 1 - i; j > i; j--)
					arr[N - 1 - i][j] = arr[N - 1 - i][j - 1];
				
				for (int j = N - 1 - i; j > i; j--)
					arr[j][i] = arr[j - 1][i];
				
				arr[i + 1][i] = temp;
			}
		
		// 출력 형식때문에 틀린 줄도 모르고 1시간 헤맴..
//		for (int i = 0; i < N; i++) {
//			StringBuilder sb = new StringBuilder();
//			for (int j = 0; j < M; j++) {
//				sb.append(arr[i][j]).append(" ");
//			}
//			sb.setLength(sb.length()-1);
//			System.out.println(sb);
//		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-2);
		System.out.println(sb);
	}
}
//	}
