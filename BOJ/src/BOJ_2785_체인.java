

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_2785_체인 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] chains = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)	chains[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(chains);
		int cnt = 0;
		int start = 0;
		int end = N - 1;
		while(true) {
			if(start >= end) break;
			cnt++;
			chains[start]--;
			chains[end-1] += chains[end];
			end--;
			if(chains[start] == 0) start++;
		}
		System.out.println(cnt);
	}
}
