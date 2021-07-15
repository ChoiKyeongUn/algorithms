package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), result, N, idx_first, idx_second, total_first, total_second;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[][] tastes;
		int[] for_comb, food_first, food_second;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			tastes = new int[N][N];
			for_comb = new int[N];
			food_first = new int[N/2];
			food_second = new int[N/2];
			idx_first = 0; idx_second = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					tastes[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N/2; i++) for_comb[N - 1 - i] = 1;
			result = Integer.MAX_VALUE;
			do {
				total_first = 0; total_second = 0;
				idx_first = 0; idx_second = 0;
				for (int i = 0; i < N; i++)
					if(for_comb[i] == 0) food_first[idx_first++] = i;
					else food_second[idx_second++] = i;
				
				for (int i = 0; i < idx_first; i++) for (int j = 0; j < idx_first; j++) total_first += tastes[food_first[i]][food_first[j]];
				for (int i = 0; i < idx_second; i++) for (int j = 0; j < idx_second; j++) total_second += tastes[food_second[i]][food_second[j]];
				
				result = Math.min(result, Math.abs(total_first - total_second));
					
			} while(np(for_comb, N));
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean np(int[] for_comb, int N) {
		int i = N-1;
		while(i > 0 && for_comb[i-1] >= for_comb[i]) --i;
		if(i == 0) return false;
		
		int j = N-1;
		while(for_comb[j] <= for_comb[i-1]) --j;
		int temp = for_comb[j];
		for_comb[j] = for_comb[i-1];
		for_comb[i-1] = temp;
		
		int k = N-1;
		while(i < k) {
			temp = for_comb[i];
			for_comb[i] = for_comb[k];
			for_comb[k] = temp;
			i++; k--;
		}
		return true;
	}
}
