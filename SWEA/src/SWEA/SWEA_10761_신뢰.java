package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_10761_신뢰 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] B = new int[N];
			int[] O = new int[N];
			int oidx = 0, bidx = 0;
			for (int i = 0; i < 2 * N; i++) {
				if(st.nextToken().charAt(0) == 'B') B[bidx++] = Integer.parseInt(st.nextToken());
				else O[oidx++] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(B));
			System.out.println(Arrays.toString(O));
		}
	}
}
