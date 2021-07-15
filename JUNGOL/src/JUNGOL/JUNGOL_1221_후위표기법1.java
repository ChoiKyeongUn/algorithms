package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUNGOL_1221_후위표기법1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String z = br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		while(st.hasMoreTokens()) {
			String cur = st.nextToken();
			switch(cur) {
			case "*":
				stack.push(stack.pop() * stack.pop());
				break;
			case "/":
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
				break;
			case "+":
				stack.push(stack.pop() + stack.pop());
				break;
			case "-":
				stack.push(-stack.pop() + stack.pop());
				break;
			default:
				stack.push(Integer.parseInt(cur));
			}
		}
		System.out.println(stack.peek());
	}
}
