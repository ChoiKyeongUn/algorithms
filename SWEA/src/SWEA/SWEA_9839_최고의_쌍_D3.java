package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_9839_최고의_쌍_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), N, num = 0, temp;
		StringTokenizer st;
		int[] numbers;
		boolean flag;
		Stack<Integer> stack;
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			numbers = new int[N];
			for (int i = 0; i < N; i++)	numbers[i] = Integer.parseInt(st.nextToken());
			flag = false;
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i+1; j < N; j++) {
					stack = new Stack<Integer>();
					num = numbers[i] * numbers[j];
					temp = num;
					while(temp != 0) {
						stack.push(temp%10);
						temp /= 10;
					}
					
					temp = stack.pop();
					while(!stack.isEmpty()) {
						if (temp != stack.peek() - 1)
							break;
						else
							temp = stack.pop();
					}
					if(stack.isEmpty()) {
						flag = true;
						break;
					}
				}
				if (flag) break;
			}
			
			if (flag) sb.append(num);
			else sb.append(-1);
			System.out.println(sb);
		}
	}
}
