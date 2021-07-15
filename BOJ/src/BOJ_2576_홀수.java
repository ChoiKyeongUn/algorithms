

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2576_홀수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = 100;
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num % 2 == 1) {
				sum += num;
				if (min > num) min = num;
			}
		}
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
