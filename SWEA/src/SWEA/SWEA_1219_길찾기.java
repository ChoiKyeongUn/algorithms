package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1219_길찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tc:
		for (int TC = 0; TC < 10; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int[] next1 = new int[100];
			int[] next2 = new int[100];
			boolean[] visited = new boolean[100];
			int routes = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < routes; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (next1[from] == 0) next1[from] = to;
				else next2[from] = to;
			}
			Queue<Integer> queue = new LinkedList<>();
			queue.add(0);
			visited[0] = true;
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				int n1 = next1[cur];
				int n2 = next2[cur];
				if (n1 != 0 && !visited[n1]) {
					visited[n1] = true;
					queue.add(n1);
					if(n1 == 99) {
						sb.append(1);
						System.out.println(sb);
						continue Tc;
					}
				}
				if (n2 != 0 && !visited[n2]) {
					visited[n2] = true;
					queue.add(n2);
					if(n2 == 99) {
						sb.append(1);
						System.out.println(sb);
						continue Tc;
					}
				}
			}
			sb.append(0);
			System.out.println(sb);
		}
	}
}
