

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1162_도로포장 {
	
	static int N, M, K;
	static List<long[]>[] adjList;
	
	public static void main(String[] args) throws Exception {
		input();
	}
	



	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		
		adjList = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<long[]>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = stoi(st.nextToken());
			int node2 = stoi(st.nextToken());
			int cost = stoi(st.nextToken());
			
			adjList[node1].add(new long[] {node2, cost});
			adjList[node2].add(new long[] {node1, cost});
		}
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
