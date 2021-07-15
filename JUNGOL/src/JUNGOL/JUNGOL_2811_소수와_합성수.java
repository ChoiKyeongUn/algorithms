package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_2811_소수와_합성수 {
	static int nums[] = new int[5];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 5; i++) {
			nums[i] = stoi(st.nextToken());
		}
		
		for(int num: nums) {
			if(num == 1) {
				System.out.println("number one");
			} else if(isPrime(num)) {
				System.out.println("prime number");
			} else {
				System.out.println("composite number");
			}
		}
	}
	
	private static boolean isPrime(int num) {
		for (int i = 2; i <= num / i; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
