package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382_방향_전환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int to_move_x = Math.abs(x1 - x2);
			int to_move_y = Math.abs(y1 - y2);
			int total = 0;
			int min = Math.min(to_move_x, to_move_y);
			int max = Math.max(to_move_x, to_move_y);
			total += 2*min;
			max -= min; min = 0;
			if(max % 2 == 0) total += max*2;
			else total += max*2-1;
			sb.append(total);
			System.out.println(sb);
		}
	}
}
