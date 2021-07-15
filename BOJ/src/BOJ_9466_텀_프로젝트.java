

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9466_텀_프로젝트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T, n, result, students[];
	static boolean flag, visited[];
	static Stack<Integer> history = new Stack<Integer>();
	public static void main(String[] args) throws Exception {
		T = stoi(br.readLine());
		for (int i = 0; i < T; i++) {
			input();
			for (int j = 1; j < n+1; j++) {
				if(!visited[j]) {
					dfs(j);
				}
			}
			saveResult();
		}
		System.out.println(sb);
	}
	
	private static void dfs(int j) {
		history.push(j);
		visited[j] = true;
		int next = students[j];
		if(visited[next]) {
			int cnt = 0;
			while(!history.isEmpty()) {
				int cur = history.pop();
				++cnt;
				if(cur == next) {
					cnt = 0;
					break;
				}
			}
			while(!history.isEmpty()) {
				history.pop();
				++cnt;
			}
			result += cnt;
			return;
		}
		dfs(next);
	}

	private static void saveResult() {
		sb.append(result).append("\n");
	}

	private static void input() throws Exception {
		history.clear();
		n = stoi(br.readLine());
		students = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			students[i] = stoi(st.nextToken());
		}
		visited = new boolean[n+1];
		result = 0;
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}