

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1914_하노이탑 {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger bigNumber = new BigInteger("2");
		bigNumber = bigNumber.pow(N);
		bigNumber = bigNumber.subtract(new BigInteger("1"));
		System.out.println(bigNumber);
		if (N <= 20)
			hanoi(N, 1, 2, 3);

	}
	
	static void hanoi(int n, int start, int temp, int goal) {
		if (n == 0) {
			cnt++;
			return;
		}
		
		hanoi(n-1, start, goal, temp);
		System.out.println(start+" "+goal);
		hanoi(n-1, temp, start, goal);
	}
}
