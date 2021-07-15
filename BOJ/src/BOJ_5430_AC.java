

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5430_AC {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		TestCase:
		for (int tc = 1; tc <= T; tc++) {
			String oper = br.readLine();
			int len = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			Deque<Integer> dq = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(temp.substring(1, temp.length()-1), ",");
			for (int i = 0; i < len; i++) dq.offer(Integer.parseInt(st.nextToken()));
			boolean mode = true;
			for (int i = 0, operSize = oper.length(); i < operSize; i++) {
				char cur = oper.charAt(i);
				switch(cur) {
				case 'R':
					if(mode) mode = false;
					else mode = true;
					break;
				case 'D':
					if(dq.isEmpty()) {
						sb.append("error").append("\n");
						continue TestCase;
					}
					if(mode) dq.pollFirst();
					else dq.pollLast();
				}
			}
			sb.append("[");
			if(dq.size() == 0) {
				sb.append("]").append("\n");
				continue;
			}
			if(mode) while(!dq.isEmpty()) sb.append(dq.pollFirst()).append(",");
			else while(!dq.isEmpty()) sb.append(dq.pollLast()).append(","); 
			sb.setLength(sb.length()-1);
			sb.append("]").append("\n");
		}
		System.out.println(sb);
	}
}
