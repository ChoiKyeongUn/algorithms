package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1251_하나로pq_D4 {
	private static int N;
	private static long[][] adjMatrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			int[] x = new int[N], y = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) x[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) y[i] = Integer.parseInt(st.nextToken());
			
			double E = Double.parseDouble(br.readLine());
			
			adjMatrix = new long[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = getDistance(x[i], x[j], y[i], y[j]);
				}
			}
			
			System.out.println("#"+tc+" "+Math.round((double)makeMST() * E));
		}
	}

	private static long makeMST() {
		
		long[] minEdge = new long[N];
		boolean[] visited = new boolean[N];
		
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0;
		
		long result = 0;
		int cnt = 0;
		
		while(true) {
			
			long min = Integer.MAX_VALUE;
			int minNo = 0;
			for (int i = 0; i < N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					minNo = i;
					min = minEdge[i];
				}
			}
			
			visited[minNo] = true;
			result += min;
			if(++cnt == N) break;
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[minNo][i] < minEdge[i]) {
					minEdge[i] = adjMatrix[minNo][i];
				}
			}
		}
		
		return result;
	}

	static long getDistance(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	
	static class Vertex {
		int no;
		long cost;
	}
}
