package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1031_빙고 {
	static int nums[][];
	static boolean checked[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		nums = new int[5][5];
		checked = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				nums[i][j] = stoi(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int cur = stoi(st.nextToken());
				if(check(cur)) {
					System.out.println(i * 5 + j + 1);
					return;
				}
			}
		}
	}
	
	private static boolean check(int n) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(nums[i][j] == n) {
					checked[i][j] = true;
				}
			}
		}
		
		int line = 0;
		for (int i = 0; i < 5; i++) {
			if(width(i)) {
				++line;
			}
			if(height(i)) {
				++line;
			}
		}
		
		if(left()) {
			++line;
		}
		
		if(right()) {
			++line;
		}
		
		if(line >= 3) {
			return true;
		}
		return false;
	}

	private static boolean right() {
		for (int i = 0; i < 5; i++) {
			if(!checked[i][4 - i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean left() {
		for (int i = 0; i < 5; i++) {
			if(!checked[i][i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean height(int i) {
		return checked[0][i] &&
			   checked[1][i] &&
			   checked[2][i] &&
			   checked[3][i] &&
			   checked[4][i];
	}

	private static boolean width(int i) {
		return checked[i][0] &&
			   checked[i][1] &&
			   checked[i][2] &&
			   checked[i][3] &&
			   checked[i][4];
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
