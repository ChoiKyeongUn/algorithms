

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] counts = new int[8001];
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			counts[nums[i]+4000]++;
		}
		Arrays.sort(nums);
		double sum = 0;
		for (int i = 0; i < N; i++) sum += nums[i];
		int maxcnt = counts[0], maxidx = 0, cnt = 1;
		for (int i = 1; i < 8001; i++) {
			if(counts[i] > counts[maxidx]) {
				maxidx = i;
				cnt = 1;
			}
			else if (counts[i] == counts[maxidx]) {
				cnt++;
				if(cnt==2) maxidx = i;
			}
		}
		
		if(sum < 0.0) System.out.println((int)(sum/(double)N-0.5));
		else System.out.println((int)(sum/(double)N+0.5));
		System.out.println(nums[N/2]);
		System.out.println(maxidx-4000);
		System.out.println(nums[N-1]-nums[0]);
	}
}
