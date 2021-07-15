

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가_만든_맛있는_음식 {
	static int N;
	static int[] sour;
	static int[] bitter;
	static boolean[] isSelected;
	static StringTokenizer st;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		subset(0);
		System.out.println(min);
	}

	static void subset(int cnt) {
		if (cnt == N) {
			int sour_mul = 1, bitter_sum = 0;
			int foods = 0;
			for (int i = 0; i < N; i++)
				if (isSelected[i]) {
					sour_mul *= sour[i];
					bitter_sum += bitter[i];
					foods++;
				}
			if (foods > 0) {
				int temp = sour_mul > bitter_sum ? sour_mul - bitter_sum : bitter_sum - sour_mul;
				if (min > temp)
					min = temp;
			}
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
	}
}
