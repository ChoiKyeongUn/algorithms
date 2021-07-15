package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1251_하나로_D4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) { // TestCase 시작
			sb.append("#").append(tc).append(" "); // "#tc " 부분 stringbuilder에 넣기 
			
			// 입력 부분
			int N = Integer.parseInt(br.readLine());
			long[][] lands = new long[N][2]; // lands[i][0] = i번째 섬의 x좌표, lands[i][1] = i번째 섬의 y좌표
			StringTokenizer st = null;

			// 좌표 입력받는 부분
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					lands[j][i] = Long.parseLong(st.nextToken());
			} // 좌표 입력받기 끝
			
			// 세율 입력 받기
			double E = Double.parseDouble(br.readLine());

			// 간선 만들기 시작
			// 따로 간선이 주어지지 않으니까 모든 섬을 연결하는 간선을 직접 만들어줌
			
			// 섬이 N개일때 모든 최대 간선수는 N*(N-1)/2개 (연결 그래프의 최대 간선수)
			int edgeLen = N*(N-1)/2; 

			// KRUSKAL 알고리즘을 사용하기 위해 간선리스트를 만듦
			double[][] edgeList = new double[edgeLen][3]; // edgeList[i][0] = 시작 정점, edgeList[i][1] = 도착 정점, edgeList[i][2] = 비용
			
			// N*(N-1)/2개의 간선을 간선리스트에 집어넣음
			int idx = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) { 
					edgeList[idx][0] = (double)i;
					edgeList[idx][1] = (double)j;
					double width = (double)(lands[i][0] - lands[j][0]);
					double height = (double)(lands[i][1] - lands[j][1]);
					double cost = (Math.pow(width, 2) + Math.pow(height, 2)) * E;
					edgeList[idx++][2] = cost;
				}
			}
			
			// 간선리스트를 비용순 오름차순으로 정렬
			Arrays.sort(edgeList, (o1, o2) -> Double.compare(o1[2], o2[2]));
			int[] parent = make(N);
			
			int cnt = 0;
			double result = 0.0;
			// KRUSKAL
			for (int i = 0; i < edgeLen; i++) {
				int a = (int)edgeList[i][0];
				int b = (int)edgeList[i][1];
				double dist = edgeList[i][2];
				if(!union(a, b, parent)) continue;
				++cnt;
				result += dist;
				if(cnt == N-1) break;
			}
			sb.append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}
	
	static int[] make(int N) {
		int[] parent = new int[N];
		for (int i = 0; i < N; i++) parent[i] = i;
		return parent;
	}
	
	static int find(int a, int[] parent) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a], parent);
	}
	
	static boolean union(int a, int b, int[] parent) {
		int aRoot = find(a, parent);
		int bRoot = find(b, parent);
		if(aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		
		return true;
	}
}