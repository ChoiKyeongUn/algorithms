package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class JUNGOL_1205_조커 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> num = new HashSet<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt_zero = 0, temp;
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(st.nextToken());
			if (temp == 0) cnt_zero++;
			else num.add(temp);
		}
		List<Integer> list = new ArrayList<>(num);
		list.sort((e1, e2) -> (e1 - e2));
		final int SIZE = list.size();

		int max = 0;
		for (int i = 0; i < SIZE; i++) {
			int continueous = 1;
			int temp_cnt_zero = cnt_zero;
			for (int j = i+1; j < SIZE; j++) {
				int curNum = list.get(j);
				int prevNum = list.get(j-1);
				if (curNum == prevNum) {
					break;
				} else if (curNum == prevNum+1) {
					continueous++;
				} else if(curNum - prevNum - 1 <= temp_cnt_zero) {
					continueous += (curNum - prevNum);
					temp_cnt_zero -= (curNum - prevNum - 1);
				}
				else break;
			}
			continueous += temp_cnt_zero;
			if (max < continueous) max = continueous;
		}
		if(max == 0) System.out.println(cnt_zero);
		else System.out.println(max);
	}
}