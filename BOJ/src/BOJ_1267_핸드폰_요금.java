

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1267_핸드폰_요금 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = 0;
		int M = 0;
		for (int i = 0; i < N; i++) {
			int yo = Integer.parseInt(st.nextToken());
			Y += 10 + 10*(yo/30);
			M += 15 + 15*(yo/60);
		}
		
		if(Y > M) System.out.println("M" + " " + M);
		else if (Y < M) System.out.println("Y" + " " + Y);
		else System.out.println("Y M " + Y);
	}
}
