

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬_디펜스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M];
		int[][] copy_map = new int[N + 1][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 3; i++)
			map[N][M - 1 - i] = 1;
		
		int max_score = Integer.MIN_VALUE;
		do {
			// 각 궁수의 위치 별로 게임을 새로하기 위해 copy_map에 map을 복사(deepcopy) 
			for (int i = 0; i < N + 1; i++)
				for (int j = 0; j < M; j++)
					copy_map[i][j] = map[i][j];
			// 이번 게임의 점수
			int sum = 0;
			
			while (true) {
				// 몬스터가 아직 남아있으면 진행 / 없으면 진행 x
				boolean flag = true;
				// 궁수들이 이번 턴에 죽일 몬스터를 체크
				boolean[][] check = new boolean[N][M];
				for (int col = 0; col < M; col++) {
					if (copy_map[N][col] == 1) {
						check_target(copy_map, check, N, M, D, col);
					}
				}
				
				// 몬스터를 죽이고 죽인 수만큼 sum 증가
				for (int i = 0; i < N; i++)
					for (int j = 0; j < M; j++)
						if (check[i][j]) {
							copy_map[i][j] = 0;
							++sum;
						}
				
				// 위에있던 몬스터들 밑으로 내림
				for (int i = N - 2; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						copy_map[i+1][j] = copy_map[i][j];
						copy_map[i][j] = 0;
					}
				}
				
				// 만약 몬스터가 남아있지 않으면 게임 종료
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (copy_map[i][j] == 1)
							flag = false;
					}
				}
				
				if (flag)
					break;
			}
			if (sum > max_score) max_score = sum;
		} while (np(map[N], M));
		System.out.println(max_score);
	}

	static void check_target(int[][] map, boolean[][] check, int N, int M, int D, int col) {
		int dist, min_dist = Integer.MAX_VALUE;
		int x = -1, y = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					dist = Math.abs(N - i) + Math.abs(col - j);
					if (dist > D)
						continue;
					if (dist < min_dist || (dist == min_dist && j < x)) {
						min_dist = dist;
						y = i;
						x = j;
					}
				}
			}
		}
		if (x != -1)
			check[y][x] = true;
	}

	static boolean np(int[] archers, int M) {
		int i = M - 1;
		while (i > 0 && archers[i - 1] >= archers[i])
			--i;
		if (i == 0)
			return false;

		int j = M - 1;
		while (archers[i - 1] >= archers[j])
			--j;
		swap(archers, i - 1, j);

		int k = M - 1;
		while (i < k)
			swap(archers, i++, k--);
		return true;
	}

	static void swap(int[] archers, int i, int j) {
		int temp = archers[i];
		archers[i] = archers[j];
		archers[j] = temp;
	}
}
