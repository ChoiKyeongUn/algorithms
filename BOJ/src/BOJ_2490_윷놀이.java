

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2490_윷놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 3; i++) {
			int one = 0;
			String temp = br.readLine();
			for (int j = 0; j < 7; j+=2) {
				if(temp.charAt(j) == '1') ++one;
			}
			if (one == 0) {
				System.out.println('D');
			} else if (one == 1) {
				System.out.println('C');
			} else if (one == 2) {
				System.out.println('B');
			} else if (one == 3) {
				System.out.println('A');
			} else {
				System.out.println('E');
			}
		}
	}
}
