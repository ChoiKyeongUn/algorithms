package JUNGOL;

import java.util.Scanner;

public class JUNGOL_2514_문자열_찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0;
		String str = sc.nextLine();
		
		for (int i = 0, len = str.length(); i < len - 2; i++) {
			String temp = str.substring(i, i + 3);
			if(temp.equals("KOI")) ++a;
			if(temp.equals("IOI")) ++b;
		}
		
		System.out.println(a);
		System.out.println(b);
	}
}
