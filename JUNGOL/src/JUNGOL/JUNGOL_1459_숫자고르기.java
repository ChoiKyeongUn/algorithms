package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class JUNGOL_1459_숫자고르기 {

	static int N, size = 0, nums[];
	static boolean[] checked, selected;
	static Stack<Integer> stack = new Stack<>(), mid = new Stack<>();

	public static void main(String[] args) throws Exception {
		input();
		for (int i = 1; i <= N; i++) {
			if (!checked[i]) {
				checked[i] = true;
				int target = nums[i];
				if(i == target || !checked[target]) {
					check(i);					
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (selected[i]) {
				++cnt;
			}
		}
		System.out.println(cnt);
		for (int i = 1; i <= N; i++) {
			if (selected[i]) {
				System.out.println(i);
			}
		}
	}

	private static void check(int num) {
		stack.push(num);
		checked[num] = true;
		
		int target = nums[num];
		if (!checked[target]) {
			check(target);
		} else {
			boolean flag = false;
			while (!stack.isEmpty()) {
				int cur = stack.pop();
				mid.push(cur);
				if (cur == target) {
					flag = true;
					stack.clear();
					break;
				}
			}
			if(flag) {
				while(!mid.isEmpty()) {
					selected[mid.pop()] = true;
				}				
			}
			mid.clear();
			return;
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		nums = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = stoi(br.readLine());
		}
		checked = new boolean[N + 1];
		selected = new boolean[N + 1];
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
