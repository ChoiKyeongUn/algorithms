

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2531_회전_초밥 {
	/**
	 * N : 회전 초밥 수
	 * d : 초밥 종류
	 * k : 연속으로 먹어야 하는 초밥 수
	 * c : 쿠폰 초밥 종류
	 * sushi : 전체 회전 초밥
	 * result : 최종 결과(최대 먹은 초밥 종류 수)
	 * eated : 현재 종류별로 초밥을 몇개 먹었는지 저장하는 배열
	 * cnt : 현재 몇종류의 초밥을 먹었는지 (쿠폰으로 먹을수 있는 초밥이 있기 때문에 처음에 1로 초기화)
	 */
	static int N, d, k, c, sushi[], result = 1, eated[], cnt = 1;
	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(result);
	}

	private static void solve() {
		// 처음에 있는 초밥부터 k개 먹는 경우
		for (int i = 0; i < k; i++) {
			eated[sushi[i]]++;
			if(eated[sushi[i]] == 1 && sushi[i] != c) ++cnt;
		}
		
		result = Math.max(result, cnt);
		
		int start = 0, end = k-1;
		
		// 두번째 초밥부터 k개 먹는 경우 ~ N번째 초밥부터 k개 먹는 경우
		for (int i = 1; i < N; i++) {
			if(eated[sushi[start]] == 1 && sushi[start] != c) --cnt;
			--eated[sushi[start++]];
			++end;
			if(eated[sushi[end]] == 0 && sushi[end] != c) ++cnt;
			++eated[sushi[end]];
			result = Math.max(result, cnt);
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		d = stoi(st.nextToken());
		k = stoi(st.nextToken());
		c = stoi(st.nextToken());
		
		sushi = new int[N+k];
		for (int i = 0; i < N; i++) {
			sushi[i] = stoi(br.readLine());
		}
		// 배열의 인덱스를 벗어나지 않게 하기위해 앞에서부터 k개 만큼 초밥들을 뒤에 붙임
		for (int i = 0; i < k; i++) {
			sushi[N+i] = sushi[i];
		}
		
		eated = new int[d+1];
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
