package JUNGOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JUNGOL_1516_단어_세기 {
	static class Word implements Comparable<Word>{
		String word;
		int cnt;
		
		public Word(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return this.word + " : " + this.cnt;
		}

		@Override
		public int compareTo(Word o) {
			return this.word.compareTo(o.word);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		List<Word> list = new ArrayList<>();
		while(true) {
			list.clear();
			String in = sc.nextLine();
			if(in.equals("END")) {
				break;
			}
			st = new StringTokenizer(in);
			while(st.hasMoreTokens()) {
				String next = st.nextToken();
				boolean flag = false;
				for(Word word: list) {
					if(word.word.equals(next)) {
						++word.cnt;
						flag = true;
						break;
					}
				}
				if(!flag) {
					list.add(new Word(next, 1));
				}
			}
			Collections.sort(list);
			
			for(Word word: list) {
				System.out.println(word);
			}
		}
		
	}
}
