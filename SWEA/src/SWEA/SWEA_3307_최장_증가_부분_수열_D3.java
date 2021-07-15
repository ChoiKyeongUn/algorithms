package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_최장_증가_부분_수열_D3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			int[] lis = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if(num[i] > num[j] && lis[i] < lis[j] + 1) lis[i] = lis[j]+1;
				}
			}
			
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) if(max < lis[i]) max = lis[i];
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
