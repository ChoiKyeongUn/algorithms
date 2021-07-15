

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] nums;
		int size, result;
		for (int tc = 1; tc <= T; tc++) {
			size = Integer.parseInt(br.readLine());
			if (size == 1) result = 1;
			else if (size == 2) result = 2;
			else if (size == 3) result = 4;
			else {
				nums = new int[size];
				nums[0] = 1;
				nums[1] = 2;
				nums[2] = 4;
				for (int i = 3; i < size; i++)
					nums[i] = nums[i-3]+nums[i-2]+nums[i-1];
				result = nums[size-1];
			}
			System.out.println(result);
		}
	}
}
