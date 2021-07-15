package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JUNGOL_1219_모자이크 {
	
	static int n, m, k, l, paper[][], max = 0;
	static int left = 1, right = 1000000;
	
	public static void main(String[] args) throws Exception {
		input();
		binarySearch();
	}
	
	private static void binarySearch() {
		if(left > right) {
			System.out.println(left);
			return;
		}
		
		int mid = (left + right) / 2;
		if(isCovered(mid)) {
			right = mid - 1;
		} else {
			left = mid + 1;
		}
		
		binarySearch();
	}

	private static boolean isCovered(int n) {
		if(max > n) {
			return false;
		}
		boolean[] covered = new boolean[m + 1];
		int cnt = k;
		for (int[] p: paper) {
			int cur = p[1];
			if(cnt == 0) {
				break;
			}
			if(!covered[cur]) {
				--cnt;
				for (int i = cur; i < cur + n && i <= m; i++) {
					covered[i] = true;
				}
			}
		}
		
		for (int[] p: paper) {
			int cur = p[1];
			if(!covered[cur]) {
				return false;
			}
		}
		return true;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		k = stoi(br.readLine());
		l = stoi(br.readLine());
		
		paper = new int[l][2];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			paper[i][0] = stoi(st.nextToken());
			paper[i][1] = stoi(st.nextToken());
			max = Math.max(max, paper[i][0]);
		}
		
		Arrays.sort(paper, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
