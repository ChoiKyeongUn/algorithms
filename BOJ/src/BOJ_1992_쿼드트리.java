

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1992_쿼드트리 {
	static int N;
	static char[][] img;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		img = new char[N][N];
//		String temp;
//		for (int i = 0; i < N; i++) {
//			temp = br.readLine();
//			for (int j = 0; j < N; j++)
//				img[i][j] = temp.charAt(j);
//		}

		// 테스트케이스 자동 생성
		while (true) {
			int M = 6;
			N = 1 << M;
			img = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					img[i][j] = (char) ((int) (Math.random() * 2) + '0');
				}
			}
			for (int i = 0; i < N; i++)
				System.out.println(Arrays.toString(img[i]));
			System.out.println(
					"\n==================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");
			String result1 = divide(0, 0, N);
			String result2 = divide(0, N, 0, N);
			System.out.println(result1);
//		 이건 왜 안되는지 모르겠다..
			System.out.println(
					"\n==================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");
			System.out.println(result2);
			System.out.println(
					"\n==================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");
			if (result1.equals(result2)) {
				System.out.println("same");
				clearScreen();
			} else {
				int idx = 0;
				for (int i = 0; i < Math.min(result1.length(), result2.length()); i++) {
					if (result1.charAt(i) != result2.charAt(i)) {
						idx = i;
						break;
					}
				}
				System.out.println("diff, " + "idx = " + idx);
				break;
			}
		}
	}

	public static void clearScreen() {
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
	}

	private static boolean check_same(int y, int x, int m) {
		for (int i = y; i < y + m; i++)
			for (int j = x; j < x + m; j++)
				if (img[y][x] != img[i][j])
					return false;
		return true;

	}

	private static String divide(int y, int x, int m) {
		if (check_same(y, x, m)) {
			return Character.toString(img[y][x]);
		} else {
			String result = "(";
			int half = m / 2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					result += divide(y + i * half, x + j * half, half);
				}
			}
			result += ")";
			return result;
		}

	}

	private static String divide(int startX, int endX, int startY, int endY) {
		int size = endX - startX;
		if (size == 1)
			return Character.toString(img[startY][startX]);

		String LU = divide(startX, startX + size / 2, startY, startY + size / 2);
		String RU = divide(startX + size / 2, startX + size, startY, startY + size / 2);
		String LD = divide(startX, startX + size / 2, startY + size / 2, startY + size);
		String RD = divide(startX + size / 2, startX + size, startY + size / 2, startY + size);

		if (LU.equals(RU) && LU.equals(LD) && LU.equals(RD))
			return LU;
		return "(" + LU + RU + LD + RD + ")";
	}
}
