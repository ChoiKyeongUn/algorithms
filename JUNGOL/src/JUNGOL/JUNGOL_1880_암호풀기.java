package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1880_암호풀기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char enc[] = new char[26];
		String code = sc.nextLine();
		
		for (int i = 0; i < 26; i++) {
			enc[i] = code.charAt(i);
		}
		
		String str = sc.nextLine();
		String result = "";
		
		for (int i = 0, len = str.length(); i < len; i++) {
			char cur = str.charAt(i);
			if(cur == ' ') {
				result += " ";
			} else if('A' <= cur && cur <= 'Z') {
				result += (char)(enc[cur - 'A'] + ('A' - 'a'));
			} else {
				result += (char)(enc[cur - 'a']);
			}
		}
		
		System.out.println(result);
	}
}
