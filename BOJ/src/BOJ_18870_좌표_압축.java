

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18870_좌표_압축 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] copy = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)	nums[i] = Integer.parseInt(st.nextToken());
		System.arraycopy(nums, 0, copy, 0, N);
		Arrays.sort(copy);
		int[] neew = new int[N];
		int size = 1;
		neew[0] = copy[0];
		for (int i = 1; i < N; i++) if (neew[size-1] != copy[i]) neew[size++] = copy[i];		
		StringBuilder sb = new StringBuilder();
		for (int i : nums) {
			int left = 0;
			int right = size-1;
			while(left <= right) {
				int mid = (left + right) / 2;
				if(neew[mid] > i) right = mid - 1;
				else if(neew[mid] < i) left = mid + 1;
				else {
					sb.append(mid).append(" ");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
