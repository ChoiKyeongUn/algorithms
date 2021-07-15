

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int num;
		for (int i = 0; i < K; i++) {
			num = Integer.parseInt(br.readLine());
			if(num != 0) stack.push(num);
			else stack.pop();
		}
		int sum = 0;
		while(!stack.isEmpty()) sum += stack.pop();
		System.out.println(sum);
	}
}
