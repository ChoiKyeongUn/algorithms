

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2587_대표값2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum += num[i];
		}
		Arrays.sort(num);
		System.out.println(sum/5);
		System.out.println(num[2]);
	}
}
