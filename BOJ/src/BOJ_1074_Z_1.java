

import java.util.Scanner;

// 백준 1074 Z 
public class BOJ_1074_Z_1 {
	static long result;

	public static long dfs(long powNum, int r, int c) {
		if (powNum == 2) { // 2x2일 경우
			// 1사분면일경우
			if (r % powNum == 0 && c % powNum == 0) {
				return result;
			}
			// 2사분면일경우 1사분면칸수를 더해준다
			if (r % powNum == 0 && c % powNum == 1) {
				return result + 1;
			}
			// 3사분면일경우 1,2사분면칸수를 더해준다
			if (r % powNum == 1 && c % powNum == 0) {
				return result + 2;
			}
			// 4사분면일경우 1,2,3사분면칸수를 더해준다.
			return result + 3;

		} else { // 2x2가 아닐 경우

			// 1사분면일경우
			if ((r % powNum < (powNum / 2)) && (c % powNum < (powNum / 2))) {
				return dfs(powNum / 2, r, c);
			}

			// 한면의 크기
			long cnt = (powNum / 2) * (powNum / 2);

			// 2사분면일경우 1사분면의 모든 칸수를 더해주며 재귀호출
			if (r % powNum < (powNum / 2) && (c % powNum > (powNum / 2 - 1))) {
				result += cnt * 1;
			}
			// 3사분면일경우 1,2사분면의 모든 칸수를 더해주며 재귀호출
			else if ((r % powNum > (powNum / 2 - 1)) && (c % powNum < (powNum / 2))) {
				result += cnt * 2;
			}
			// 4사분면일경우 1,2,3사분면의 모든 칸수를 더해주며 재귀호출
			else {
				result += cnt * 3;
			}
			return dfs(powNum / 2, r, c);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		long powNum = (long) Math.pow(2, N);
		System.out.println(dfs(powNum, r, c));
	}
}