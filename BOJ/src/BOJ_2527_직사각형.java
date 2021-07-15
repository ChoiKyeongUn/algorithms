

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527_직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] coor;
		int rect1_width, rect1_height, rect2_width, rect2_height, total_width, total_height, max_width, max_height;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			coor = new int[4][2];
			for (int j = 0; j < 4; j++)	for (int j2 = 0; j2 < 2; j2++) coor[j][j2] = Integer.parseInt(st.nextToken());
			rect1_width = coor[1][0] - coor[0][0];
			rect1_height = coor[1][1] - coor[0][1];
			rect2_width = coor[3][0] - coor[2][0];
			rect2_height = coor[3][1] - coor[2][1];
			max_width = rect1_width + rect2_width;
			max_height = rect1_height + rect2_height;
			total_width = Math.max(Math.abs(coor[3][0] - coor[0][0]), Math.abs(coor[1][0] - coor[2][0]));
			total_height = Math.max(Math.abs(coor[3][1] - coor[0][1]), Math.abs(coor[1][1] - coor[2][1]));
			
			if (total_width < max_width && total_height < max_height) System.out.println("a");
			else if ((total_width == max_width && total_height < max_height) || (total_width < max_width && total_height == max_height)) System.out.println("b");
			else if (total_width == max_width && total_height == max_height) System.out.println("c");
			else System.out.println("d");
		}
	}
}
