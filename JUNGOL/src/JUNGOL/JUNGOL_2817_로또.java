package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_2817_로또 {
	static int k, nums[], selected[];
	public static void main(String[] args) throws Exception {
		input();
		comb(0, 0);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = stoi(st.nextToken());
		nums = new int[k];
		for (int i = 0; i < k; i++) {
			nums[i] = stoi(st.nextToken());
		}
		selected = new int[6];
	}

	private static void comb(int idx, int start) {
		if(idx == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < k; i++) {
			selected[idx] = nums[i];
			comb(idx+1, i+1);
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
