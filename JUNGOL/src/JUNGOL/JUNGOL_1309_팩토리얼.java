package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1309_팩토리얼 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		recursion(N, 1l);
	}
	
	private static void recursion(int n, long i) {
		if(n > 1) {
			System.out.println(n + "!" + " = " + n + " * " + (n-1) + "!");
			recursion(n-1, i*n);
		} else {
			System.out.println("1! = 1");
			System.out.println(i);
			return;
		}
		
	}
}
