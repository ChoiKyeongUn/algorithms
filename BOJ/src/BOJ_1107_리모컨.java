

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	static int N, M, N_len = 0, result;
	static boolean[] possible = new boolean[10];
	static int[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		N_len = temp.length();
		N = Integer.parseInt(temp);
		M = Integer.parseInt(br.readLine());
		Arrays.fill(possible, true);
		
		result = Math.abs(N - 100);
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) possible[Integer.parseInt(st.nextToken())] = false;
		}
		
		for (int i = Math.max(1, N_len - 1); i <= N_len+1; i++) {
			selected = new int[i];
			permutation(0, i);
		}
		System.out.println(result);
	}

	private static void permutation(int cnt, int goal) {
		if(cnt == goal) {
			int channel = 0;
			int mul = 1;
			for (int num: selected) {
				channel += mul * num;
				mul *= 10;
			}
			
			result = Math.min(result, Math.abs(channel - N) + goal);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(!possible[i]) continue;
			selected[cnt] = i;
			permutation(cnt+1, goal);
		}
	}
}
