

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	static boolean[][][] checked;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), x, y, width, height;
		StringTokenizer st;
		checked = new boolean[N][101][101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());

			for (int j = 0; j < i; j++)
				for (int k = x; k < x+width; k++)
					for (int m = y; m < y+height; m++)
						checked[j][k][m] = false;
			
			for (int k = x; k < x+width; k++)
				for (int m = y; m < y+height; m++)
					checked[i][k][m] = true;
		}
		
		int sum;
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < 101; j++) {
				for (int j2 = 0; j2 < 101; j2++) {
					if (checked[i][j][j2]) sum += 1;
				}
			}
			System.out.println(sum);
		}
	}
}
