

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2491_수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		int[] increase = new int[N];
		int[] decrease = new int[N];
		increase[0] = 1; decrease[0] = 1;
		for (int i = 1; i < N; i++) {
			if (num[i] >= num[i-1]) increase[i] = increase[i-1] + 1;
			else increase[i] = 1;
			if (num[i] <= num[i-1]) decrease[i] = decrease[i-1] + 1;
			else decrease[i] = 1;
		}
		int max = Integer.MIN_VALUE;
		for (int n : increase) max = Math.max(n,  max); 
		for (int n : decrease) max = Math.max(n,  max);
		System.out.println(max);
	}
}
