

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호_만들기 {
	static int L, C; // L : 암호의 길이, C : 사용했을법한 문자의 개수
	static char[] chars; // chars : 사용했을법한 문자들을 저장하는 배열
	static String temp; // 문자를 입력받기 위해 잠시 사용하는 문자열
	static boolean[] visited; // dfs로 각 문자들을 탐색하기 위해 사용할 방문여부 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		chars = new char[C];
		temp = br.readLine();
		visited = new boolean[C];
		for (int i = 0, idx = 0; i < C; i++, idx+=2) chars[i] = temp.charAt(idx);
		
		Arrays.sort(chars); // 가능한 암호를 사전순으로 출력해야 하기 때문에 문자들을 일단 정렬
		for (int i = 0; i < C; i++) {
			visited[i] = true; // 백트래킹 시작
			dfs(1, Character.toString(chars[i]));
			visited[i] = false;
		}
	}
	private static void dfs(int cnt, String string) {
		if(cnt == L) { // 암호가 만들어졌으면 모음의 개수가 1개 이상인지, 자음의 개수도 2개 이상인지 확인하고 맞다면 출력
			int aeiou = 0; // 모음 개수 저장
			int naeiou = 0; // 자음 개수 저장
			for (int i = 0; i < cnt; i++)
				if(string.charAt(i) == 'a' ||
				   string.charAt(i) == 'e' ||
				   string.charAt(i) == 'i' ||
				   string.charAt(i) == 'o' ||
				   string.charAt(i) == 'u')	++aeiou;
				else ++naeiou;
			if(aeiou > 0 && naeiou > 1) System.out.println(string);
			return;
		}
		
		for (int i = 0; i < C; i++) {
			if(visited[i]) continue; // 만약 현재 문자열 다음에 추가할 문자가 이미 사용한 문자라면 가지치기
			if(string.charAt(cnt-1) >= chars[i]) continue; // 만약 현재 문자열 다음에 추가할 문자가 이미 나온 문자보다 사전상으로 앞 순서인 문자라면 가지치기
			visited[i] = true; // dfs
			dfs(cnt+1, string+chars[i]);
			visited[i] = false;
		}
	}
}
