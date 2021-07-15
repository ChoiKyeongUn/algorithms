

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {
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
		} // 원본 배열 입력받기

		st = new StringTokenizer(br.readLine());
		int[] operation = new int[R];
		for (int i = 0; i < R; i++)
			operation[i] = Integer.parseInt(st.nextToken()); // 실행할 연산들 순서대로 저장
		
		int[][] temp;
		int swap;
		for (int oper : operation) // 저장된 연산을 순서대로 실행
			switch (oper) {
			case 1: // 1번 연산(상하 반전)
				for (int i = 0; i < N / 2; i++)
					for (int j = 0; j < M; j++) {
						swap = arr[i][j];
						arr[i][j] = arr[N - 1 - i][j];
						arr[N - 1 - i][j] = swap;
					}
				break;
			case 2: // 2번 연산(좌우 반전)
				for (int i = 0; i < N; i++)
					for (int j = 0; j < M / 2; j++) {
						swap = arr[i][j];
						arr[i][j] = arr[i][M - 1 - j];
						arr[i][M - 1 - j] = swap;
					}
				break;
			case 3: // 3번 연산(90도 회전)
				temp = new int[M][N];
				for (int i = 0; i < N; i++)
					for (int j = 0; j < M; j++)
						temp[j][N-1-i] = arr[i][j];
				arr = temp;
				swap = M;
				M = N;
				N = swap;
				break;
			case 4: // 4번 연산(-90도 회전)
				temp = new int[M][N];
				for (int i = 0; i < N; i++)
					for (int j = 0; j < M; j++)
						temp[M-1-j][i] = arr[i][j];
				arr = temp;
				swap = M;
				M = N;
				N = swap;
				break;
			case 5: // 5번 연산(90도 분할 회전)
				temp = new int[N/2][M/2];
				for (int i = 0; i < temp.length; i++)
					for (int j = 0; j < temp[0].length; j++)
						temp[i][j] = arr[i][j];
				
				for (int i = 0; i < N/2; i++)
					for (int j = 0; j < M/2; j++)
						arr[i][j] = arr[i+N/2][j];
				
				for (int i = N/2; i < N; i++)
					for (int j = 0; j < M/2; j++)
						arr[i][j] = arr[i][j+M/2];
				
				for (int i = N/2; i < N; i++)
					for (int j = M/2; j < M; j++)
						arr[i][j] = arr[i-N/2][j];
				
				for (int i = 0; i < N/2; i++)
					for (int j = M/2; j < M; j++)
						arr[i][j] = temp[i][j-M/2];
				break;
			case 6: // 6번 연산(-90도 분할 회전)
				temp = new int[N/2][M/2];
				for (int i = 0; i < temp.length; i++)
					for (int j = 0; j < temp[0].length; j++)
						temp[i][j] = arr[i+N/2][j];
				
				for (int i = N/2; i < N; i++)
					for (int j = 0; j < M/2; j++)
						arr[i][j] = arr[i-N/2][j];
				
				for (int i = 0; i < N/2; i++)
					for (int j = 0; j < M/2; j++) 
						arr[i][j] = arr[i][j+M/2];
				
				for (int i = 0; i < N/2; i++)
					for (int j = M/2; j < M; j++)
						arr[i][j] = arr[i+N/2][j];
				
				for (int i = N/2; i < N; i++)
					for (int j = M/2; j < M; j++)
						arr[i][j] = temp[i-N/2][j-M/2];
				break;
			}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				sb.append(arr[i][j]).append(" ");
			sb.append("\n");
		}
		sb.setLength(sb.length()-2);
		System.out.println(sb);
	}
}
