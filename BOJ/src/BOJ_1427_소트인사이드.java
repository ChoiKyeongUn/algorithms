

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1427_소트인사이드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] nums = sc.nextLine().toCharArray();
		Arrays.sort(nums);
		for (int i = nums.length-1; i >= 0; i--) System.out.print(nums[i]);
	}
}
