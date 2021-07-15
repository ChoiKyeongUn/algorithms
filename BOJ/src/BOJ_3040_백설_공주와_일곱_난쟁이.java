

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설_공주와_일곱_난쟁이 {
	static int[] dwarps;
	static int[] selected_dwarps;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarps = new int[9];
		for (int i = 0; i < 9; i++) dwarps[i] = Integer.parseInt(br.readLine());
		selected_dwarps = new int[7];
		comb(0, 0);
		System.out.println(sb);
	}
	
	static void comb(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) sum += selected_dwarps[i];
			if(sum == 100) {
				for (int i = 0; i < 7; i++) {
					sb.append(selected_dwarps[i]).append("\n");
				}
			}
			return;
		}
		
		for (int i = start; i < dwarps.length; i++) {
			selected_dwarps[cnt] = dwarps[i];
			comb(cnt+1, i+1);
		}
	}
}
