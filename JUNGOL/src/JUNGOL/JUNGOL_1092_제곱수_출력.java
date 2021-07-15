package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1092_제곱수_출력 {
	static int n, m;
	static final int mod = 20091024;
	
	public static void main(String[] args) {
		input();
		System.out.println(pow(n, m));
	}

	private static long pow(int num, int exp) {
		if(exp == 0) {
			return 1;
		}
		
		long n = pow(num, exp / 2);
		long temp = n * n % mod;
		
		if(exp % 2 == 0) {
			return temp;
		}
		return num * temp % mod;
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.close();
	}
}
