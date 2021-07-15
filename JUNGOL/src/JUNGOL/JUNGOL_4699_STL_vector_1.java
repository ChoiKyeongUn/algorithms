package JUNGOL;

import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JUNGOL_4699_STL_vector_1 {
	
	static int n, order[];
	static List<Integer> lists[];
	
	public static void main(String[] args) throws Exception {
		input();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		lists = new ArrayList[n];
		order = new int[n];
		for (int i = 0; i < n; i++) {
			lists[i] = new ArrayList<>();
		}
		StringTokenizer st;
		int cnt;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cnt = stoi(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				lists[i].add(stoi(st.nextToken()));
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			order[i] = stoi(st.nextToken());
		}
		for(int o: order) {
			for (int i = 0, len = lists[o].size(); i < len; i++) {
				System.out.print(lists[o].get(i) + " ");
			}
			System.out.println();
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
}
