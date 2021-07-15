package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {

	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] tree = new char[N + 1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
			}
			flag = true;
			dfs(tree, N, 1);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			if (flag)
				sb.append("1");
			else
				sb.append("0");
			System.out.println(sb);
		}
	}

	static void dfs(char[] tree, int len, int current) {
		if (current > len)
			return;
		
		if(current*2>len) // 리프 노드일때 만약 그 노드가 연산자이면
			if(tree[current] == '*' || tree[current] == '/' || tree[current] == '+' || tree[current] == '-')
				flag = false;
		
		if(current*2+1<len) // 리프 노드가 아닐때 만약 그 노드가 숫자이면
			if(tree[current] != '*' && tree[current] != '/' && tree[current] != '+' && tree[current] != '-')
				flag = false;
		dfs(tree, len, current * 2);
		dfs(tree, len, current * 2 + 1);
	}
}
