

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1911_흙길_보수하기 {
	
	// 웅덩이의 처음, 시작 저장
	static class loc implements Comparable<loc>{
		int start, end;
		public loc(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(loc o) {
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		loc[] locs = new loc[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			locs[i] = new loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(locs);
		
		int cnt = 0;
		
		// 널빤지 놓기
		for (int j = 0; j < N-1; j++) {
			int plus = (locs[j].end - locs[j].start + L - 1) / L;
			cnt += plus;
			int cover = locs[j].start + plus * L;
			if (locs[j+1].start <= cover) {
				locs[j+1].start = cover;
			}
		}
		cnt += (locs[N-1].end - locs[N-1].start + L - 1) / L;
		System.out.println(cnt);
	}
}
