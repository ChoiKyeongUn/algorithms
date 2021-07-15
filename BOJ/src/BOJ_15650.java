

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
	static int N, M;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		isSelected = new boolean[N+1];
		func(0, 1);
		System.out.println(sb);
	}
	static void func(int cnt, int start) {
		if(cnt == M) {
			for (int num : numbers) sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			func(cnt+1, i+1);
		}
	}
}
