

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 1) System.out.println(1);
		else if (n == 2) System.out.println(2);
		else {
			int value1 = 1, value2 = 2;
			int temp;
			for (int i = 0; i < n-2; i++) {
				temp = value2;
				value2 = (value1 + value2)%10007;
				value1 = temp;
			}
			System.out.println(value2);
		}
	}
}