

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2036_수열의_점수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> plus = new ArrayList<>();	
		List<Integer> minus = new ArrayList<>();
		long sum = 0;
		boolean isZero = false;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num < 0) minus.add(num);
			else if (num > 1) plus.add(num);
			else if (num == 1) ++sum;
			else isZero = true;
		}
		
		plus.sort((o1, o2) -> (o2 - o1));
		minus.sort((o1, o2) -> (o1 - o2));
		
		int m_size = minus.size();
		int p_size = plus.size();
		
		for (int i = 0; i < m_size - 1; i+=2) sum += (long)((long)minus.get(i) * (long)minus.get(i+1));
		if (m_size % 2 == 1 && !isZero)	sum += minus.get(m_size-1);
		
		for (int i = 0; i < p_size - 1; i+=2) sum += (long)((long)plus.get(i) * (long)plus.get(i+1));
		if (p_size % 2 == 1) sum += plus.get(p_size-1);
		System.out.println(sum);
	}
}
