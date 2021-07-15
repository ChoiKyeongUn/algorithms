package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1997_떡_먹는_호랑이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int K = sc.nextInt();
		int coef[][] = new int[D][2];
		coef[0][0] = 1;
		coef[0][1] = 0;
		coef[1][0] = 0;
		coef[1][1] = 1;
		for (int i = 2; i < D; i++) {
			coef[i][0] = coef[i-1][0] + coef[i-2][0];
			coef[i][1] = coef[i-1][1] + coef[i-2][1];
		}
		
		int n = coef[D-1][0];
		int m = coef[D-1][1];
		
		int A = 0;
		int B = 0;
		while(true) {
			if((K - n*A) % m == 0) {
				B = (K - n*A) / m;
				break;
			}
			++A;
		}
		System.out.println(A);
		System.out.println(B);
	}
}
