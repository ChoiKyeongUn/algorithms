

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12871_무한_문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		int left = s.length(), right = t.length();
		while(true) {
			int temp = left % right;
			if(temp == 0) break;
			left = right;
			right = temp;
		}
		int sLen = s.length(), tLen = t.length();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < tLen/right; i++) sb1.append(s);
		for (int i = 0; i < sLen/right; i++) sb2.append(t);
		
		if(sb1.toString().equals(sb2.toString())) System.out.println(1);
		else System.out.println(0);

	}
}
