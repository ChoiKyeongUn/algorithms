

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두_수의_합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(nums);
		int total = 0;
		for (int i = 0, size = nums.length; i < size; i++) {
			int first = nums[i];
			if (first >= x) break;
			else {
				for (int j = i+1; j < size; j++) {
					int second = nums[j];
					if(first+second == x) total++;
					if(first+second > x) break;
				}
			}
		}
		System.out.println(total);
	}
}
		