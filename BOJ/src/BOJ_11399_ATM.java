

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] times = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) times[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(times);
		int result = 0;
		for (int i = 0; i < N; i++) result += times[i] * (N-i);
		System.out.println(result);
	}
}
