

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_20437_문자열_게임_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int res1 = 10001, res2 = -1;
			char[] W = br.readLine().toCharArray();
			int K = Integer.parseInt(br.readLine());
			
			
			
			
			if(res1 == 10001 && res2 == -1) sb.append(-1).append("\n");
			else sb.append(res1).append(" ").append(res2);
		}
		
		System.out.println(sb);
	}
}
