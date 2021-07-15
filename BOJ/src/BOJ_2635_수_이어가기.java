

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2635_수_이어가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 2, cnt, nNum, fNum, sNum;
		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		for (int i = 0; i <= N; i++) {
			que.clear();
			que.add(N);
			que.add(i);
			cnt = 2; fNum = N; sNum = i;
			while(true) {
				nNum = fNum - sNum;
				if (nNum < 0) break;
				fNum = sNum;
				sNum = nNum;
				cnt++;
				que.add(nNum);
			}
			if (cnt > max) {
				max = cnt;
				result.clear();
				for (int j = 0, size = que.size(); j < size; j++) {
					result.add(que.poll());
				}
			}
		}
		System.out.println(max);
		for (int i = 0, size = result.size(); i < size; i++) {
			System.out.print(result.poll() + " ");
		}
	}
}
