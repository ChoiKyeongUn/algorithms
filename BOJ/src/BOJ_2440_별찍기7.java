

import java.util.Scanner;

public class BOJ_2440_별찍기7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = N; i > 0; i--) {
			for (int j = 0; j < i-1; j++) System.out.print(" ");
			for (int j = 0; j < 2*(N-i+1)-1; j++) System.out.print("*");
			System.out.println();
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) System.out.print(" ");
			for (int j = 0; j < 2*(N-i)-1; j++) System.out.print("*");
			System.out.println();
		}
	}
}
