package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_3517_Tutorial_이진탐색 {
	static int n, a[], q, b[];
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		StringBuilder sb = new StringBuilder();
		for (int num: b) {
			sb.append(binarySearch(0, n - 1, num)).append(" ");
		}
		System.out.println(sb);
	}

	private static int binarySearch(int start, int end, int num) {
		if(start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		int cur = a[mid];
		if(cur == num) {
			return mid;
		}
		if(cur > num) {
			return binarySearch(start, mid - 1, num);
		}
		return binarySearch(mid + 1, end, num);
		
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = stoi(st.nextToken());
		}
		q = stoi(br.readLine());
		b = new int[q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			b[i] = stoi(st.nextToken());
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
