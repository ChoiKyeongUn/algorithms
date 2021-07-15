

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_9375_패션왕_신해빈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			TreeMap<String, Integer> clothes = new TreeMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String key = st.nextToken();
				clothes.put(key, clothes.getOrDefault(key, 0) + 1);
			}
			String[] keys = clothes.keySet().toArray(new String[clothes.size()]);
			int key_num = keys.length;
			int[] cnts = new int[key_num];
			for (int i = 0; i < key_num; i++) cnts[i] = clothes.get(keys[i]);
			int result = 0;
			int for_bit_masking = 1;
			for (int bit = 1; bit < 1 << key_num; bit++) {
				int mul = 1;
				for (int i = 0; i < key_num; i++) {
					if((bit & (1 << i)) != 0) {
						mul *= cnts[i];
					}
				}
				result += mul;
			}
			System.out.println(result);
		}
	}
}
