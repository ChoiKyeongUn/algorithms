package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1240_제곱근 {
	static long n;
	public static void main(String[] args) {
		n = new Scanner(System.in).nextLong();
		
		long start = 1;
		long end = 3037000499l;
		while(start < end) {
			long mid = (start + end) / 2l;
			long pow = mid * mid;
			if(n == pow) {
				System.out.println(mid);
				return;
			}
			if(pow < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if(end * end > n) {
			System.out.println(end - 1);
		} else {
			System.out.println(end);			
		}
	}
}
