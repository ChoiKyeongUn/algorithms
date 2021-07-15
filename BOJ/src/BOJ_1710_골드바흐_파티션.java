

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1710_골드바흐_파티션 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N = 10000;
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) nums[i] = i+2;
		
		for (int i = 2; i <= 1000; i++) {
			if(nums[i-2] == 0) continue;
			for (int j = i+i; j < N; j+=i) {
				nums[j-2] = 0;
			}
		}
		
		System.out.println(Arrays.toString(nums));
		
//		for (int tc = 0; tc < T; tc++) {
//			
//		}
	}
}
