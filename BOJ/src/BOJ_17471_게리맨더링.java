

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N, population[], result = 100000000, set1[], set2[], size1, size2;
	static List<Integer>[] graph;
	public static void main(String[] args) throws Exception {
		input();
		subset();
		System.out.println(result == 100000000 ? -1 : result);
	}

	private static void subset() {
		for (int bitMask = 1; bitMask < (1<<N) - 1; bitMask++) {
			size1 = 0;
			size2 = 0;
			for (int i = 0; i < N; i++) {
				if((bitMask & (1<<i)) != 0) {
					set1[size1++] = i+1;
				} else {
					set2[size2++] = i+1;
				}
			}
			
			if(isPossible()) {
				int total_pop1 = 0;
				int total_pop2 = 0;
				for (int i = 0; i < size1; i++) {
					total_pop1 += population[set1[i]];
				}
				for (int i = 0; i < size2; i++) {
					total_pop2 += population[set2[i]];
				}
				int gap = Math.abs(total_pop1 - total_pop2);
			
				result = Math.min(result, gap);
			}
		}
		
	}

	private static boolean isPossible() {
		if(bfs(set1, size1) && bfs(set2, size2)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean bfs(int[] set, int size) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		queue.offer(set[0]);
		visited[set[0]] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int next : graph[cur]) {
				if(isInSet(set, size, next) && !visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}

		for (int i = 0; i < size; i++) {
			if(!visited[set[i]]) return false;
		}
		return true;
	}

	private static boolean isInSet(int[] set, int size, int next) {
		for (int i = 0; i < size; i++) {
			if(set[i] == next) return true;
		}
		return false;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		population = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			population[i] = stoi(st.nextToken());
		}
		graph = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = stoi(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int to = stoi(st.nextToken());
				graph[i].add(to);
				graph[to].add(i);
			}
		}
		
		set1 = new int[N];
		set2 = new int[N];
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
