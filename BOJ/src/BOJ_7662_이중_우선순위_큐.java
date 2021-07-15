

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_7662_이중_우선순위_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			for (int i = 0; i < k; i++) {

				String[] oper = br.readLine().split(" ");
				char operator = oper[0].charAt(0);
				int num = Integer.parseInt(oper[1]);
				if (operator == 'I')
					map.put(num, map.getOrDefault(num, 0) + 1);
				else {
					if (map.isEmpty())
						continue;
					int key = num == 1 ? map.lastKey() : map.firstKey();
					if (map.put(key, map.get(key) - 1) == 1) {
						map.remove(key);
					}
				}
				
			}
			if (map.isEmpty())
				System.out.println("EMPTY");
			else
				System.out.println(map.lastKey() + " " + map.firstKey());
		}
	}
}
