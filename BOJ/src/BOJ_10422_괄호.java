

import java.util.Scanner;

public class BOJ_10422_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N  = sc.nextInt();
			if(N%2==1) {
				System.out.println(0);
				continue;
			}
			int[] num = new int[N/2];
			num[0] = 1;
			for (int j = 1; j < N/2; j++) num[j] = num[j-1]*2%1000000007;
			System.out.println(num[N/2-1]);
		}
	}
}
