

import java.util.Scanner;

public class BOJ_11727_2xn타일링_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1) System.out.println(1);
		else if(n == 2) System.out.println(3);
		else {
			int first = 1;
			int second = 3;
			int third = 0;
			for (int i = 0; i < n-2; i++) {
				third = ((first*2 % 10007) + (second % 10007)) % 10007;
				first = second;
				second = third;
			}
			System.out.println(third);
		}
	}
}
