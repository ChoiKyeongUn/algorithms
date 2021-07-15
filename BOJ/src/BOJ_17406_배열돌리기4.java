

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {
	
	static int K, min = Integer.MAX_VALUE;
	static int[][] rotate;
	static int[] permutation;
	static boolean[] isSelected;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 배열 저장
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		} 
		
		// rotate : 돌리는 방법, permutation : 돌리는 순서 저장
		rotate = new int[K][3]; 
		permutation = new int[K]; 
		isSelected = new boolean[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rotate[i][0] = r;
			rotate[i][1] = c;
			rotate[i][2] = s;
		}
		Perm(0);
		System.out.print(min);
	}
	
	static void Perm(int cnt) {
		if (cnt == K) {
			// 원본 배열을 arr2에 복사
			int[][] arr2 = new int[arr.length][arr[0].length];
			for (int i = 0; i < arr2.length; i++)
				for (int j = 0; j < arr2[0].length; j++)
					arr2[i][j] = arr[i][j];
			
			int value;
			for(int idx: permutation)
				rotate(arr2, rotate[idx][0], rotate[idx][1], rotate[idx][2]);
			for (int i = 0; i < arr2.length; i++) {
				value = 0;
				for (int j = 0; j < arr2[0].length; j++)
					value += arr2[i][j];
				if (min > value) min = value;
			}
			return;
		}

		for (int i = 0; i < K; i++) {
			if (isSelected[i])
				continue;
			permutation[cnt] = i;
			isSelected[i] = true;
			Perm(cnt + 1);
			isSelected[i] = false;
		}
	}


	static void rotate(int[][] arr, int r, int c, int s) {

		int[][] arr2 = new int[2 * s + 1][2 * s + 1];
		for (int i = r - s - 1; i < r + s; i++)
			for (int j = c - s - 1; j < c + s; j++)
				arr2[i - r + s + 1][j - c + s + 1] = arr[i][j];
		
		int M = 2*s+1; // M은 arr2의 사이즈 (arr의 부분정사각형의 사이즈)
		for (int i = 0; i < s; i++) {
			int temp = arr2[i][i];
			for (int j = i; j < M - 1 - i; j++)
				arr2[j][i] = arr2[j+1][i];
			
			for (int j = i; j < M - 1 - i; j++)
				arr2[M-i-1][j] = arr2[M-i-1][j+1];
			
			for (int j = M-1-i; j > i; j--)
				arr2[j][M-i-1] = arr2[j-1][M-i-1];
			
			for (int j = M-1-i; j > i; j--)
				arr2[i][j] = arr2[i][j-1];
			
			arr2[i][i+1] = temp;
		}
		
		for (int i = 0; i < M; i++)
			for (int j = 0; j < M; j++)
				arr[r-s-1+i][c-s-1+j] = arr2[i][j];
	}
}