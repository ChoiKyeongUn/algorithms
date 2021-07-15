package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_Contact {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int len, start, size, cur, max;
		StringTokenizer st;
		int[][] adj_matrix;
		boolean[] visited;
		Queue<Integer> queue;
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			adj_matrix = new int[100][100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len/2; i++) 	adj_matrix[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
			visited = new boolean[100];
			queue = new LinkedList<Integer>();
			queue.add(start - 1);
			visited[start-1] = true;
			max = 0;
			while(!queue.isEmpty()) {
				size = queue.size();
				max = Integer.MIN_VALUE;
				for (int i = 0; i < size; i++) {
					cur = queue.poll();
					if(max < cur) max = cur;
					for (int j = 0; j < 100; j++) {
						if(adj_matrix[cur][j] == 1 && !visited[j]) {
							visited[j] = true;
							queue.add(j);
							if(max < j) max = j;
						}
					}
				}
			}
			sb.append(max+1).append("\n");
		}
		System.out.println(sb);
	}

	private static void print(int[][] adj_matrix, int i) {
		for (int j = 0; j < i; j++) System.out.println(Arrays.toString(adj_matrix[j]));
	}
}
