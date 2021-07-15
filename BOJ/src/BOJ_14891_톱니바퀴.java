

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
	static String[] wheel;
	static boolean[] visited;
	static int K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wheel = new String[4];
		StringBuilder sb = null;
		for (int i = 0; i < 4; i++) {
			String temp = br.readLine();
			sb = new StringBuilder();
			for (int j = 0; j < 8; j++) {
				sb.append(temp.charAt(j) == '0' ? 'N' : 'S');
			}
			wheel[i] = sb.toString();
		}
		
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			visited = new boolean[4];
			rotate(num-1, dir);
		}
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if(wheel[i].charAt(0) == 'N') continue;
			result += 1<<i;
		}
		System.out.println(result);
	}
	private static void rotate(int num, int dir) {
		if(num < 0 || num >= 4 || visited[num]) {
			return;
		}
		visited[num] = true;
		int left = num - 1;
		char cur_nine = wheel[num].charAt(6);
		int right = num + 1;
		char cur_three = wheel[num].charAt(2);
		if(dir == 1) {
			wheel[num] = wheel[num].charAt(7) + wheel[num].substring(0, 7);
		} else {
			char temp = wheel[num].charAt(0);
			wheel[num] = wheel[num].substring(1) + temp;
		}
		
		if(left >= 0) {
			char c = wheel[left].charAt(2);
			if(cur_nine != c) rotate(left, dir == 1 ? -1 : 1);
		}
		if(right < 4) {
			char c = wheel[right].charAt(6);
			if(cur_three != c) rotate(right, dir == 1 ? -1 : 1);
		}
	}
}
