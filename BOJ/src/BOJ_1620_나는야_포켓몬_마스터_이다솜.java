

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620_나는야_포켓몬_마스터_이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> num_idx = new HashMap<>();
		Map<String, Integer> str_idx = new HashMap<>();		
		for (int i = 1; i <= N; i++) {
			String temp = br.readLine();
			num_idx.put(i, temp);
			str_idx.put(temp, i);
		}
		
		for (int i = 0; i < M; i++) {
			String want = br.readLine();
			char c = want.charAt(0);
			if(c >= '0' && c <= '9') System.out.println(num_idx.get(Integer.parseInt(want)));
			else System.out.println(str_idx.get(want));
		}
	}
}
