package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_9997_미니멀리즘_시계 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		int theta;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			theta = Integer.parseInt(br.readLine());
			sb.append(theta/30).append(" ");
			sb.append((theta%30)*2);
			System.out.println(sb);
		}
	}
}
