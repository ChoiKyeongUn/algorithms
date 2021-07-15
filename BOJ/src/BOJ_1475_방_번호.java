

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1475_방_번호 {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[9];
		String N = br.readLine();
		for (int i = 0, size = N.length(); i < size; i++) {
			char num = N.charAt(i);
			if(num == '9') count[6]++;
			else count[num - '0']++;
		}
		int max = 0;
		for (int i = 0; i < 9; i++) {
			if(i != 6) {
				if (max < count[i]) {
					max = count[i];
				}
			} else {
				if (max < (count[i]+1)/2) {
					max = (count[i]+1)/2;
				}
			}
		}
		System.out.println(max);
	}
}
