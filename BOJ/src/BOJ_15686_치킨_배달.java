

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨_배달 {
	static int ans = Integer.MAX_VALUE;
	static int N, M;
	static int[] sel;
	static class Loc {
		int y, x;

		public Loc(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static int calc(Loc l1, Loc l2) {
		return Math.abs(l1.x - l2.x) + Math.abs(l1.y - l2.y);
	}

	static List<Loc> chickens = new ArrayList<>();
	static List<Loc> homes = new ArrayList<>();
	// 집과 치킨집 과의 거리
	static int[][] dist = new int[13][100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int temp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				temp = Integer.parseInt(st.nextToken());
				if (temp == 0) continue;
				if (temp == 1) homes.add(new Loc(i, j));
				else		   chickens.add(new Loc(i, j));
			}
		}
		
		// 미리 반복적인 거리 계산을 저장한다.
		for (int i = 0; i < chickens.size(); i++) {
			for (int j = 0; j < homes.size(); j++) {
				dist[i][j] = calc(chickens.get(i), homes.get(j));
			}
		}
		
		// 치킨 거리 구하기
		sel = new int[M];
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			solve();
			return;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			sel[cnt] = i;
			comb(cnt+1, i+1);
		}
	}

	private static void solve() {
		int sum = 0;
		for (int i = 0; i < homes.size(); i++) {
			int minDist = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				minDist = Math.min(dist[sel[j]][i], minDist);
			}
			sum += minDist;
		}
		ans = Math.min(ans, sum);
	}
}
