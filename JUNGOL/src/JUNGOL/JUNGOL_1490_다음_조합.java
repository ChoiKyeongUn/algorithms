package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1490_다음_조합 {
	
	static int n, k, disp[], selected[];
	static boolean flag = false, stop = false;
	
	public static void main(String[] args) throws Exception {
		input();
		comb(0, 1);
		if(!stop) {
			System.out.println("NONE");
		}
	}

	private static void comb(int idx, int start) {
		if(idx == k) {
			if(flag) {
				for (int i = 0; i < k; i++) {
					System.out.print(selected[i] + " ");
				}
				stop = true;
				return;
			}
			for (int i = 0; i < k; i++) {
				if(selected[i] != disp[i]) {
					return;
				}
			}
			flag = true;
			return;
		}
		if(stop) {
			return;
		}
		for (int i = start; i <= n; i++) {
			if(stop) {
				return;
			}
			selected[idx] = i;
			comb(idx + 1, i + 1);
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		k = stoi(st.nextToken());
		disp = new int[k];
		selected = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			disp[i] = stoi(st.nextToken());
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
