

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int set = 0;
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int oper;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String operator = st.nextToken();
			switch(operator) {
			case "add":
				oper = Integer.parseInt(st.nextToken());
				set |= (1 << oper);
				break;
			case "remove":
				oper = Integer.parseInt(st.nextToken());
				set &= ~(1 << oper);
				break;
			case "check":
				oper = Integer.parseInt(st.nextToken());
				if((set & (1 << oper)) == 0) sb.append(0).append("\n");
				else sb.append(1).append("\n");
				break;
			case "toggle":
				oper = Integer.parseInt(st.nextToken());
				set ^= (1 << oper);
				break;
			case "all":
				for (int j = 1; j <= 20; j++) set |= (1 << j);
				break;
			default:
				set = 0;
			}
		}
		System.out.println(sb);
	}
}
