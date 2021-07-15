package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUNGOL_1102_스택 {
	public static void main(String[] args) throws Exception {
		solve();
	}

	private static void solve() throws Exception {
		Stack<Integer> stack = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		StringTokenizer st;
		while(n-- > 0) {
			String command = br.readLine();
			st = new StringTokenizer(command);
			String com = st.nextToken();
			switch(com) {
			case "i":
				stack.push(stoi(st.nextToken()));
				break;
			case "o":
				if(!stack.isEmpty()) {
					System.out.println(stack.pop());
				} else {
					System.out.println("empty");
				}
				break;
			default:
				System.out.println(stack.size());
			}
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
