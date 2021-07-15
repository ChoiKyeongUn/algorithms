

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413_단어_뒤집기_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		for (int i = 0, size = input.length(); i < size; i++) {
			char cur = input.charAt(i);
			if(cur == '<') {
				while(!stack.isEmpty()) System.out.print(stack.pop());
				while(cur != '>') {
					System.out.print(cur);
					cur = input.charAt(i++);
				}
				System.out.print(cur);
			}
			stack.add(cur);
		}
		while(!stack.isEmpty()) System.out.print(stack.pop());
	}
}
