package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_2814_이진수 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0)
				return;

			String strRes = "";
			int res = 0;

			while (N != 0) {
				int temp = N % 10;
				if(!strRes.equals("") || temp != 0)
				strRes += Integer.toString(temp);
				res += temp;
				N /= 10;
			}
			System.out.println(strRes + " " + res);
		}
	}
}
