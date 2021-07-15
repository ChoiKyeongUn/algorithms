

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_가장_긴_증가하는_부분_수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		int lis[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if(num[j] < num[i] && lis[i] < lis[j] + 1) lis[i] = lis[j] + 1;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) max = Math.max(max, lis[i]);
		System.out.println(max);
	}
}
