

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17219_비밀번호_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			sb.append(map.get(temp)).append("\n");
		}
		System.out.println(sb);
	}
}
