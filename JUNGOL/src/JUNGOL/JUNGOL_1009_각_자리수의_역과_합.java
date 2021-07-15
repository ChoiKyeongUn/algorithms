package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUNGOL_1009_각_자리수의_역과_합 {
	static String N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		int result = 0;
		int mul = 1;
		for (int i = 0, len = N.length(); i < len; i++) {
			result += mul * (N.charAt(len - 1 - i) - '0');
			mul *= 2;
		}
		System.out.println(result);
	}
}
