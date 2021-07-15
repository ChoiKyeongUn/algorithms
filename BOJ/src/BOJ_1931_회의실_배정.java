

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931_회의실_배정 {
	static class Time implements Comparable<Time>{
		int start, end;
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Time o) {
			if(this.end != o.end) return this.end - o.end;
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Time[] times = new Time[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			times[i] = new Time(start, end);
		}
		Arrays.sort(times);
		int cnt = 1;
		int end = times[0].end;
		for (int i = 1; i < N; i++) {
			if(end <= times[i].start) {
				++cnt;
				end = times[i].end;
			}
		}
		System.out.println(cnt);
	}
}
