package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1692_곱셈 {
	static int a, b;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = stoi(br.readLine());
		b = stoi(br.readLine());
		
		System.out.println(a * (b % 10));
		System.out.println(a * ((b / 10) % 10));
		System.out.println(a * (b / 100));
		System.out.println(a * b);
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
