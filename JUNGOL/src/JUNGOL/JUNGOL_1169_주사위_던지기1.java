package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1169_주사위_던지기1 {
	static int N, M;
	static int selected[];
	static boolean checked[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[N];
		checked = new boolean[6];
		dice(0, 1);
	}
	
	private static void dice(int idx, int start) {
		if(M == 1) {
			if(idx == N) {
				for(int s: selected) {
					System.out.print(s + " ");
				}
				System.out.println();
				return;
			}
			
			for (int i = 1; i <= 6; i++) {
				selected[idx] = i;
				dice(idx+1, 0);
			}
		} else if(M == 2) {
			if(idx == N) {
				for(int s: selected) {
					System.out.print(s + " ");
				}
				System.out.println();
				return;
			}
			
			for (int i = start; i <= 6; i++) {
				selected[idx] = i;
				dice(idx+1, i);
			}
		} else {
			if(idx == N) {
				for(int s: selected) {
					System.out.print(s + " ");
				}
				System.out.println();
				return;
			}
			
			for (int i = 1; i <= 6; i++) {
				if(checked[i-1]) continue;
				checked[i-1] = true;
				selected[idx] = i;
				dice(idx+1, 0);
				checked[i-1] = false;
			}
		}
	}
}
