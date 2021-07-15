

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1786_찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		KMP(text, pattern);
	}
	
	static int[] fail(char[] pattern) {
		int patternSize = pattern.length;
		int[] fail = new int[patternSize];
		
		for (int i = 1, j = 0; i < patternSize; i++) {
			while(j > 0 && pattern[i] != pattern[j]) j = fail[j-1];
			if(pattern[i] == pattern[j]) fail[i] = ++j;
		}
		
		return fail;
	}
	
	static void KMP(char[] text, char[] pattern) {
		int[] fail = fail(pattern);
		int textSize = text.length, patternSize = pattern.length;
		
		for (int i = 0, j = 0; i < textSize; i++) {
			while(j > 0 && text[i] != pattern[j]) j = fail[j-1];
			
			if(text[i] == pattern[j])
				if(j == patternSize - 1) {
					System.out.println("문자열 매칭 완료");
					System.out.println(i-j+2);
					j = fail[j];
				} else ++j;
		}
	}
}
