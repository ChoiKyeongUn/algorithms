package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUNGOL_3106_진법_변환 {
	static int A, B;
	static String N, input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		while(true) {
			input = br.readLine();
			if(input.trim().equals("0")) {
				break;
			}
			
			long num = 0;
			st = new StringTokenizer(input);
			A = stoi(st.nextToken());
			N = st.nextToken();
			B = stoi(st.nextToken());
			
			long mul = 1;
			
			for (int i = 0, len = N.length(); i < len; i++) {
				char cur = N.charAt(len - 1 - i);
				if(cur >= 'A' && cur <= 'Z') {
					num += mul * (cur - 'A' + 10);
				} else {
					num += mul * (cur - '0');
				}
				mul *= A;
			}
			
			stack.clear();
			
			while(num != 0l) {
				stack.push((int)(num % (long)B));
				num /= (long)B;
			}
			if(stack.isEmpty()) {
				System.out.print(0);
			}
			while(!stack.isEmpty()) {
				int cur = stack.pop();
				if(cur >= 10) {
					System.out.print((char)(cur - 10 + 'A'));
				} else {
					System.out.print(cur);
				}
			}
			System.out.println();
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
