

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1541_잃어버린_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		int minus_cnt = 0;
		String[] nums, sub;
		int result = 0;
		for (int i = 0, size = in.length(); i < size; i++) if(in.charAt(i) == '-') ++minus_cnt;
		if(minus_cnt == 0) {
			nums = new String[1];
			nums[0] = in;
		}
		else nums = in.split("-");
		
		int plus_cnt = 0;
		for (int i = 0, size = nums[0].length(); i < size; i++) if(nums[0].charAt(i) == '+') ++plus_cnt;
		if(plus_cnt == 0) result = Integer.parseInt(nums[0]);
		
		else {
			sub = nums[0].split("\\+");
			for (int i = 0, size = sub.length; i < size; i++) {
				result += Integer.parseInt(sub[i]);
			}
		}
		
		for (int i = 1, size = nums.length; i < size; i++) {
			plus_cnt = 0;
			for (int j = 0, sub_size = nums[i].length(); j < sub_size; j++) if(nums[i].charAt(j) == '+') ++plus_cnt;
			if(plus_cnt == 0) result -= Integer.parseInt(nums[i]);
			else {
				int zz = 0;
				sub = nums[i].split("\\+");
				for (int k = 0, zz_size = sub.length; k < zz_size; k++) {
					zz += Integer.parseInt(sub[k]);
				}
				result -= zz;
			}
		}
		System.out.println(result);
	}
}