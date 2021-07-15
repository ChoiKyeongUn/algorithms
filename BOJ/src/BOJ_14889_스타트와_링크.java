

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와_링크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] p = new int[N][N]; // 시너지 능력치표를 저장
		int[] for_comb = new int[N]; // NextPermutation 알고리즘을 이용해서 조합을 만들기 위해 만든 배열
		int[] team1 = new int[N/2], team2 = new int[N/2]; // team1 : team1의 멤버들(인덱스) 저장, team2 : team2의 멤버들(인덱스) 저장
		for (int i = 0; i < N/2; i++) for_comb[N - 1 - i] = 1; // for_comb를 반으로 나눠 왼쪽은 0으로, 오른쪽은 1로 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) p[i][j] = Integer.parseInt(st.nextToken());
		}
		int result = Integer.MAX_VALUE;
		do { // 조합을 이용해서 team1멤버와 team2멤버를 뽑음
			int team1_total = 0, team2_total = 0, team1_idx = 0, team2_idx = 0;
			for (int i = 0; i < N; i++) if(for_comb[i] == 0) team1[team1_idx++] = i; else team2[team2_idx++] = i; // 만약 자신의 인덱스가 for_comb에서 0이면 team1, 1이면 team2
			for (int i = 0; i < N/2; i++)
				for (int j = 0; j < N/2; j++)
					if(i != j) {
						team1_total += p[team1[i]][team1[j]]; // team1의 모든 시너지 합을 team1의 총 능력치에 더함
						team2_total += p[team2[i]][team2[j]]; // team2의 모든 시너지 합을 team2의 총 능력치에 더함
					}
			
			int gap = Math.abs(team1_total - team2_total);
			if(result > gap) result = gap;
		} while(np(for_comb, N));
		
		System.out.println(result);
	}

	private static boolean np(int[] for_comb, int len) {
		int i = len - 1;
		while(i > 0 && for_comb[i-1] >= for_comb[i]) --i;
		if(i == 0) return false;
		
		int j = len - 1;
		while(for_comb[i-1] >= for_comb[j]) --j;
		swap(for_comb, i-1, j);
		
		int k = len - 1;
		while(i < k) swap(for_comb, i++, k--);
		
		return true;
	}

	private static void swap(int[] for_comb, int i, int j) {
		int temp = for_comb[i];
		for_comb[i] = for_comb[j];
		for_comb[j] = temp;
	}
}
