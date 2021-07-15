package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_2259_참외밭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = stoi(br.readLine());
		
		int len[] = new int[6];
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			len[i] = stoi(st.nextToken());
		}
		
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		
		for (int i = 0, j = 1; i < 6; i+=2, j+=2) {
			max1 = Math.max(max1, len[i]);
			max2 = Math.max(max2, len[j]);
		}
		
		for (int i = 0, j = 1; i < 6; i+=2, j+=2) {
			if(len[(i+5)%6] + len[(i+1)%6] == max2) {
				min1 = len[i];
			}
			if(len[(j+5)%6] + len[(j+1)%6] == max1) {
				min2 = len[j];
			}
		}
		System.out.println(k * (max1 * max2 - min1 * min2));
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
