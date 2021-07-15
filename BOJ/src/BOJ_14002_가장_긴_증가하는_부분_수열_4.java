

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14002_가장_긴_증가하는_부분_수열_4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		int lis[] = new int[N];
		int prev[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			lis[i] = 1;
			prev[i] = i;
			for (int j = 0; j < i; j++) {
				if(num[j] < num[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
					prev[i] = j;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(max < lis[i]) {
				max = lis[i];
				idx = i;
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.add(idx);
		while(idx != prev[idx]) {
			stack.add(prev[idx]);
			idx = prev[idx];
		}
		System.out.println(max);
		while(!stack.isEmpty()) System.out.print(num[stack.pop()] + " ");
	}
}
