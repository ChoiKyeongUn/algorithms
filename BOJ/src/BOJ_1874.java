

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), maxnum = 0, num;
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for (int tc = 1; tc <= n; tc++) {
			num = Integer.parseInt(br.readLine());
			if(num>maxnum) {
				for (int i = maxnum+1; i <= num; i++) {
					sb.append("+").append("\n");
					stack.push(i);
				}
				sb.append("-").append("\n");
				maxnum = num;
				stack.pop();
			}
			else {
				if(stack.peek() != num) {
					flag = false;
					break;
				}
				sb.append("-").append("\n");
				stack.pop();
			}
		}
		if(!flag) System.out.println("NO");
		else {
			sb.setLength(sb.length()-1);
			System.out.println(sb);
		}
	}
}
