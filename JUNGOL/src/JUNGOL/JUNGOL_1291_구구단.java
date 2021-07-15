package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1291_구구단 {
	static int s, e;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s = stoi(st.nextToken());
			e = stoi(st.nextToken());
			if (s >= 2 && s <= 9 && e >= 2 && e <= 9) {
				break;
			} else {
				System.out.println("INPUT ERROR!");
			}
		}

		if (s < e) {
			flag = true;
		} else {
			flag = false;
		}

		for (int i = 1; i <= 9; i++) {
			print(s, i);
			System.out.println();
		}

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	private static void print(int num, int mul) {
		if (flag && e < num) {
			return;
		}
		if (!flag && e > num) {
			return;
		}

		System.out.printf("%d * %d = %2d   ", num, mul, num * mul);
		if (flag) {
			print(num + 1, mul);
		} else {
			print(num - 1, mul);
		}
	}
}
