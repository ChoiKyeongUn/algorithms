package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1493_수의새로운연산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int start_y_p; int start_y_q, x = 0, y = 0;

			int i = 1;
			while(true) {
				if ((i*i-i+2)/2 > p) {
					start_y_p = i - 1;
					break;
				}
				++i;
			}
			
			i = 1;
			while(true) {
				if ((i*i-i+2)/2 > q) {
					start_y_q = i - 1;
					break;
				}
				++i;
			}
			
			int x_offset_p = p - (start_y_p * start_y_p - start_y_p + 2) / 2;
			int x_offset_q = q - (start_y_q * start_y_q - start_y_q + 2) / 2;
			
			x += 1 + x_offset_p;
			x += 1 + x_offset_q;
			
			y += start_y_p - x_offset_p;
			y += start_y_q - x_offset_q;
			
			int result = (x * x + x) / 2 + x * (y - 1) + (y * (y - 1)) / 2 - y + 1;
			sb.append(result);
			System.out.println(sb);
		}

	}
}
