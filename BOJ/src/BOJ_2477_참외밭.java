

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		
		int[] length = new int[6];
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			length[i] = Integer.parseInt(st.nextToken());
		}
		
		int max_len1 = Integer.MIN_VALUE;
		int max_len2 = Integer.MIN_VALUE;
		
		int min_len1 = Integer.MAX_VALUE;
		int min_len2 = Integer.MAX_VALUE;
		
		for (int i = 0, j = 1; i < 6; i+=2, j+=2) {
			if (max_len1 < length[i]) max_len1 = length[i];
			if (max_len2 < length[j]) max_len2 = length[j];
		}

		for (int i = 0, j = 1; i < 6; i+=2, j+=2) {
			if (length[(i+5)%6] + length[(i+1)%6] == max_len2) min_len1 = length[i];
			if (length[(j+5)%6] + length[(j+1)%6] == max_len1) min_len2 = length[j];
		}
		int result = (max_len1 * max_len2 - min_len1 * min_len2) * K;
		System.out.println(result);
	}
}
