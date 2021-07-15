

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12904_A와B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		while(true) {
			if(T.equals(S)) {
				System.out.println(1);
				return;
			}
			int tLen = T.length();
			if(tLen == S.length()) break;
			
			char last = T.charAt(tLen-1);
			switch(last) {
			case 'A':
				T = T.substring(0, tLen-1);
				break;
			case 'B':
				char[] temp = T.toCharArray();
				String change = "";
				for (int i = tLen-2; i >= 0; i--) change += temp[i];
				T = change;
			}
		}
		System.out.println(0);
	}
}
