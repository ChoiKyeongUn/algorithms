

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15829 {
	static int M = 1234567891;
	static int r = 31;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		long sum = 0;
		long R = 1;
		
		for (int i = 0; i < s.length(); i++) {
			sum = (sum + (s.charAt(i) - 'a' + 1) * R) % M;
			R = (R*r) % M;
		}
		
		System.out.println(sum);
	}
}
