

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2752_세수정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[3];
		for (int i = 0; i < 3; i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
	}
}
