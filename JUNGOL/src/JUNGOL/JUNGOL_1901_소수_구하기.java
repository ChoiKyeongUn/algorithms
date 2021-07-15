package JUNGOL;

import java.util.Arrays;
import java.util.Scanner;

public class JUNGOL_1901_소수_구하기 {
	static int N, nums[];
	static boolean checked[];
	public static void main(String[] args) {
		input();
		check();
		result();
	}

	private static void result() {
		for(int num: nums) {
			if(checked[num]) {
				System.out.println(num);
				continue;
			}
			boolean flag = false;
			int gap = 1;
			while(true) {
				int sNum = num - gap;
				int lNum = num + gap;
				if(checked[sNum]) {
					System.out.print(sNum + " ");
					flag = true;
				}
				if(checked[lNum]) {
					System.out.print(lNum + " ");
					flag = true;
				}
				if(flag) {
					System.out.println();
					break;
				}
				++gap;
			}
		}
	}

	private static void check() {
		for (int i = 2; i * i <= 1000000; i++) {
			if(!checked[i]) continue;
			for (int j = 2; i * j <= 1000000; j++) {
				checked[i*j] = false;
			}
		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		checked = new boolean[1000001];
		Arrays.fill(checked, true);
		checked[0] = false;
		checked[1] = false;
	}
}
