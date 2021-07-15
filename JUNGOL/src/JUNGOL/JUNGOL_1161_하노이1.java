package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1161_하노이1 {
	static int n;
	public static void main(String[] args) {
		n = new Scanner(System.in).nextInt();
		rec(n, 1, 2, 3);
	}
	
	private static void rec(int n, int start, int temp, int end) {
		if(n == 0) {
			return;
		}
		
		rec(n-1, start, end, temp);
		System.out.println(n + " : " + start + " -> " + end);
		rec(n-1, temp, start, end);
	}
}
