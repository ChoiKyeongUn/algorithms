

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_4195_친구_네트워크 {
	static int F, parents[], cnts[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> map = null;
		for (int ______ = 0; ______ < T; ______++) {
			int F = Integer.parseInt(br.readLine());
			parents = new int[F*2];
			cnts = new int[F*2];
			int size = 0;
			map = new TreeMap<>();
			for (int i = 0; i < F; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < 2; j++) {
					String name = temp[j];
					if(map.get(name) == null) {
						map.put(name, size);
						parents[size] = size;
						cnts[size++] = 1;
					}
				}
				union(map.get(temp[0]), map.get(temp[1]));
				System.out.println(cnts[find(map.get(temp[0]))]);
			}
		}
	}
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return;
		parents[bRoot] = aRoot;
		cnts[aRoot] += cnts[bRoot];
	}
}
