

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054_가장_긴_바이토닉_부분_수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N], LIS = new int[N], RLIS = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		int result = 0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			RLIS[N-1-i] = 1;
			for (int j = 0; j < i; j++) {
				if(num[j] < num[i] && LIS[i] < LIS[j] + 1) LIS[i] = LIS[j] + 1;
				if(num[N-1-j] < num[N-1-i] && RLIS[N-1-i] < RLIS[N-1-j] + 1) RLIS[N-1-i] = RLIS[N-1-j] + 1;				
			}
		}
		for (int i = 0; i < N; i++) {
			int temp = LIS[i] + RLIS[i];
			if(temp > result) result = temp;
		}
		System.out.println(result - 1);
	}
}
