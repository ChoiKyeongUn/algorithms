package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1430_숫자의_개수 {
	static int a, b, c, cnt[] = new int[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = stoi(br.readLine());
		b = stoi(br.readLine());
		c = stoi(br.readLine());
		
		String num = Integer.toString(a*b*c);
		for (int i = 0, len = num.length(); i < len; i++) {
			++cnt[num.charAt(i) - '0'];
		}
		
		for(int i : cnt) {
			System.out.println(i);
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
