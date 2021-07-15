

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16953_AB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(), B = sc.nextInt();
		
		int cnt = 1;
		while(true) {
			if(B < A) {
				System.out.println(-1);
				return;
			}
			if(B == A) {
				System.out.println(cnt);
				return;
			}
			++cnt;
			if(B%2 == 0) B /= 2;
			else if(B%10 == 1) B /= 10;
			else {
				System.out.println(-1);
				return;
			}
		}
	}
}
