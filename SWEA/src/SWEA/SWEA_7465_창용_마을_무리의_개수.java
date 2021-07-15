package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465_창용_마을_무리의_개수 {
	static int N, M, parents[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			make(); // 1부터 N까지 크기 N의 단위 집합을 만들고
			// 입력에서 나오는대로 집합을 합쳐나감
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			// 총 종교 수 = Root수(대표값의 가지수)이므로 Root수를 구해서 출력한다.
			int cnt = 0;
			for (int j = 1; j <= N; j++) if(j == parents[j]) ++cnt;
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	static void make() {
		for (int i = 1; i <= N; i++) parents[i] = i;
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
