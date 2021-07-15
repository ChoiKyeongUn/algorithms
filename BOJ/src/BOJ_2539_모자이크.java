import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_2539_모자이크 {

	static int n, m, k, l, paper[][], max = 0;
	static int left = 1, right = 1000000;

	public static void main(String[] args) throws Exception {
		input();
		binarySearch();
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		l = sc.nextInt();

		paper = new int[l][2];

		for (int i = 0; i < l; i++) {
			paper[i][0] = sc.nextInt();
			max = Math.max(max, paper[i][0]);
			paper[i][1] = sc.nextInt();
		}

		Arrays.sort(paper, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
	}

	private static void binarySearch() {
		if (left > right) {
			System.out.println(left);
			return;
		}

		int mid = (left + right) / 2;

		if (isCovered(mid)) {
			right = mid - 1;
		} else {
			left = mid + 1;
		}
		binarySearch();
	}

	private static boolean isCovered(int len) {
		if (len < max) {
			return false;
		}
		boolean[] covered = new boolean[m + 1];
		int cnt = k;

		for (int[] p : paper) {
			int cur = p[1];
			if (cnt == 0) {
				break;
			}
			if (!covered[cur]) {
				--cnt;
				for (int i = cur; i < cur + len && i <= m; i++) {
					covered[i] = true;
				}
			}
		}

		for (int[] p : paper) {
			int cur = p[1];
			if (!covered[cur]) {
				return false;
			}
		}

		return true;
	}
}
