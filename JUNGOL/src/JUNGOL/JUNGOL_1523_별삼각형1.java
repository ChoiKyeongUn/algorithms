package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1523_별삼각형1 {
	static int n, m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		if(n < 0 || n > 100 || m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		switch(m) {
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		default:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2*i+1; j++) {
					System.out.print("*");
				}
				for (int j = 0; j < n - i; j++) {
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
