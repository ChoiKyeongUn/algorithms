package JUNGOL;

import java.util.Scanner;

public class JUNGOL_2858_쇠막대기 {
	public static void main(String[] args) {
		String pipe = new Scanner(System.in).nextLine();
		int result = 0, part = 1, len = pipe.length();
		
		for (int i = 1; i < len; i++) {
			char cur = pipe.charAt(i);
			char prev = pipe.charAt(i - 1);
			
			if(cur == '(') {
				++part;
			} else {
				if(prev != cur) {
					--part;
					part = Math.max(0, part);
					result += part;
				} else {
					++result;
					--part;
				}
			}
		}
		System.out.println(result);
	}
}
