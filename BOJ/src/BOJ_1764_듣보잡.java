

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] d = new String[N];
		String[] b = new String[M];
		for (int i = 0; i < N; i++) d[i] = br.readLine();
		for (int i = 0; i < M; i++) b[i] = br.readLine();
		Arrays.sort(d);	Arrays.sort(b);
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = M-1;
			while(left < right) {
				int mid = (left + right) / 2;
				int result = d[i].compareTo(b[mid]);
				if(result < 0) right = mid - 1;
				else if(result > 0) left = mid + 1;
				else {
					sb.append(d[i]).append("\n");
					++cnt;
					break;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}
