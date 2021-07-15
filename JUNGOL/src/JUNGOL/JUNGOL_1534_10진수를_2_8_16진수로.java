package JUNGOL;

import java.util.Scanner;
import java.util.Stack;

public class JUNGOL_1534_10진수를_2_8_16진수로 {
	static int num, bin;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		bin = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		while(num != 0) {
			stack.push(num % bin);
			num /= bin;
		}
		while(!stack.isEmpty()) {
			int num = stack.pop();
			if(num >= 10) {
				System.out.print((char)(num - 10 + 'A'));
			} else {
				System.out.print(num);
			}
		}
	}
}
