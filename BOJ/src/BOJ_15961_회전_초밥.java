

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전_초밥 {
	static int N, d, k, c, sushi[], result = 1, eated[], cnt = 1;
	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(result);
	}

	private static void solve() {
		for (int i = 0; i < k; i++) {
			eated[sushi[i]]++;
			if(eated[sushi[i]] == 1 && sushi[i] != c) ++cnt;
		}
		
		result = Math.max(result, cnt);
		
		int start = 0, end = k-1;
		
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
		for (int i = 0; i < k; i++) {
			sushi[N+i] = sushi[i];
		}
		
		eated = new int[d+1];
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
