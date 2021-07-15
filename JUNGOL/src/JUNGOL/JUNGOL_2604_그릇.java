package JUNGOL;

import java.util.Scanner;

public class JUNGOL_2604_그릇 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 10;
		String dish = sc.nextLine();
		for (int i = 1, len = dish.length(); i < len; i++) {
			if(dish.charAt(i) == dish.charAt(i-1)) {
				result += 5;
			} else {
				result += 10;
			}
		}
		System.out.println(result);
	}
}
