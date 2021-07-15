package JUNGOL;

import java.util.Scanner;

public class JUNGOL_2857_세로읽기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		char c[][] = new char[5][15];
		for (int i = 0; i < 5; i++) {
			c[i] = sc.nextLine().toCharArray();
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				try {
					result += c[j][i];
				} catch(Exception e) {
					
				}
			}
		}
		System.out.println(result);
	}
}
