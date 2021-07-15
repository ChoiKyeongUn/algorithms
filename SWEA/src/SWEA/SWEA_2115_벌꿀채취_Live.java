package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취_Live {
	
	static int N, M, C, maxSum = 0;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+tc+" "+getMaxBenefit());
		}
	}

	private static int getMaxBenefit() {
		return processCombination();
	}
	
	private static int processCombination() {
		int result = 0, aBenefit, bBenefit;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				
				maxSum = 0;
				makeMaxSubset(i, j, 0, 0, 0);
				aBenefit = maxSum;
				
				maxSum = 0;
				bBenefit = 0;
				for (int j2 = j+M; j2 < N-M+1; j2++) {
					makeMaxSubset(i, j2, 0, 0, 0);
					if(bBenefit < maxSum) bBenefit = maxSum;
				}
				
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 < N-M+1; j2++) {
						makeMaxSubset(i2, j2, 0, 0, 0);
						if(bBenefit < maxSum) bBenefit = maxSum;
					}
				}
				
				if(result < aBenefit + bBenefit) result = aBenefit + bBenefit;
			}
		}
		return result;
	}
	
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powerSum) {
		
		if(sum > C) return;
		if(cnt == M) {
			if(maxSum < powerSum) maxSum = powerSum;
			return;
		}
		
		makeMaxSubset(i, j+1, cnt+1, sum+map[i][j], powerSum + (map[i][j]*map[i][j]));
		makeMaxSubset(i, j+1, cnt+1, sum, powerSum);
	}
}
