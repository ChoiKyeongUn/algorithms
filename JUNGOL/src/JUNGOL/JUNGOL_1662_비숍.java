package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JUNGOL_1662_비숍 {
	
	static int n, len[], weight, max[];
	static boolean left[], right[];
	static List<int[]>[] parts = new ArrayList[2];
	
	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0, 0);
		dfs(0, 0, 1);
		System.out.println(max[0] + max[1]);
	}

	private static void dfs(int idx, int cnt, int color) {
		if(idx == len[color]) {
			max[color] = Math.max(max[color], cnt);
			return;
		}
		
		int[] cur = parts[color].get(idx);
		int curY = cur[0], curX = cur[1];
		
		
		int l = curX + curY;
		int r = curX - curY + weight;
		if(!left[l] && !right[r]) {
			left[l] = true;
			right[r] = true;
			dfs(idx+1, cnt+1, color);
			left[l] = false;
			right[r] = false;
		}
		dfs(idx+1, cnt, color);
	}

	private static void input() throws Exception {
		for (int i = 0; i < 2; i++) {
			parts[i] = new ArrayList<>();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		String temp;
		char cur;
		for (int i = 0; i < n; i++) {
			temp = br.readLine();
			for (int j = 0, idx = 0; j < n; j++, idx+=2) {
				cur = temp.charAt(idx);
				if(cur == '1') {
					parts[Math.abs(j - i) % 2].add(new int[] {i, j});
				}
			}
		}
		left = new boolean[2 * n - 1];
		right = new boolean[2 * n - 1];
		len = new int[2];
		max = new int[2];
		len[0] = parts[0].size();
		len[1] = parts[1].size();
		weight = n - 1;
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
