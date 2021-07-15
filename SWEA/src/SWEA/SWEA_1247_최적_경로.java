package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적_경로 {
	static class loc {
		int x, y;
		public loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			loc[] custs = new loc[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 회사의 좌표 저장
			loc company = new loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			// 집의 좌표 저장
			loc home = new loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			// 고객들의 좌표 저장
			for (int i = 0; i < N; i++)
				custs[i] = new loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			// 고객들의 인덱스를 가지고 순열을 만들며 완탐
			int[] perm = new int[N];
			for (int i = 0; i < N; i++) perm[i] = i;
			
			int min_distance = Integer.MAX_VALUE;
			do {
				int dist = measure_total_dist(company, home, custs, perm);
				if (min_distance > dist) min_distance = dist;
			}while(np(perm, N));
			sb.append(min_distance);
			System.out.println(sb);
		}
	}
	
	// 총 이동거리 계산
	private static int measure_total_dist(loc company, loc home, loc[] custs, int[] perm) {
		// 먼저 회사와 처음방문할 고객과의 거리를 더함
		int dist = Math.abs(company.x - custs[perm[0]].x) + Math.abs(company.y - custs[perm[0]].y);
		// 현재 방문한 고객 <-> 다음 방문할 고객의 거리를 차례대로 모두 더함
		for (int i = 0, len = perm.length-1; i < len; i++) {
			dist += Math.abs(custs[perm[i]].x - custs[perm[i+1]].x) + Math.abs(custs[perm[i]].y - custs[perm[i+1]].y);
		}
		// 마지막으로 방문한 고객 <-> 집 간의 거리를 더함
		dist += Math.abs(home.x - custs[perm[perm.length-1]].x) + Math.abs(home.y - custs[perm[perm.length-1]].y);
		return dist;
	}


	private static boolean np(int[] perm, int N) {
		int i = N - 1;
		while(i > 0 && perm[i-1] >= perm[i]) --i;
		if(i == 0) return false;
		
		int j = N - 1;
		while(perm[i-1] >= perm[j]) --j;
		swap(perm, i-1, j);
		
		int k = N - 1;
		while(i < k) swap(perm, i++, k--);
		
		return true;
	}
	
	private static void swap(int[] perm, int i, int j) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;
	}
}
