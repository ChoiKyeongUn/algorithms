

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11328_Strfry {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		outer:
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String origin = st.nextToken();
			String want = st.nextToken();
			int[] cnt_o = new int[26];
			int[] cnt_w = new int[26];
			int size_o = origin.length();
			int size_w = want.length();

			
			for (int j = 0; j < size_o; j++) cnt_o[origin.charAt(j) - 'a']++;
			for (int j = 0; j < size_w; j++) cnt_w[want.charAt(j) - 'a']++;
			
			for (int j = 0; j < 26; j++) {
				if(cnt_o[j] != cnt_w[j]) {
					System.out.println("Impossible");
					continue outer;
				}
			}
			System.out.println("Possible");
		}
	}
}
