

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕_배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
			
		int cnt = 0;
		while (N % 5 != 0 && N >= 0) {
			cnt++;
			N -= 3;
		}
		if (N < 0) cnt = -1;
		else cnt += N / 5;

		System.out.println(cnt);
	}
}