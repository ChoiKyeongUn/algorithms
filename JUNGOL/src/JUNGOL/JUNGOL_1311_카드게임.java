package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JUNGOL_1311_카드게임 {
	static boolean card[][] = new boolean[4][10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Integer> map = new HashMap<>();
		map.put('R', 0);
		map.put('B', 1);
		map.put('Y', 2);
		map.put('G', 3);
		int max = 0;
		for (int i = 0; i < 5; i++) {
			String temp = br.readLine();
			char color = temp.charAt(0);
			int num = temp.charAt(2) - '0';
			card[map.get(color)][num] = true;
			max = Math.max(max, num);
		}
		
		int result = 0;
		if(sameColor() != 0 && straight() != 0) {
			result = 900 + straight();
		} else if(fourCard() != 0) {
			result = 800 + fourCard();
		} else if(fullHouse() != 0) {
			result = 700 + fullHouse();
		} else if(sameColor() != 0) {
			result = 600 + sameColor();
		} else if(straight() != 0) {
			result = 500 + straight();
		} else if(triple() != 0) {
			result = 400 + triple();
		} else if(twoPair() != 0) {
			result = 300 + twoPair();
		} else if(onePair() != 0) {
			result = 200 + onePair();
		} else {
			result = 100 + max();
		}
		
		System.out.println(result);
	}
	private static int max() {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 10; j++) {
				if(card[i][j]) {
					result = Math.max(result, j);
				}
			}
		}
		return result;
	}
	private static int twoPair() {
		int cnt[] = new int[10];
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 10; j++) {
				if(card[i][j]) {
					++cnt[j];
				}
			}
		}
		int flag = 0;
		int max = 0, min = 10;
		for (int i = 1; i < 10; i++) {
			if(cnt[i] == 2) {
				++flag;
				max = Math.max(max, i);
				min = Math.min(min, i);
			}
		}
		if(flag == 2) {
			return max * 10 + min;
		}
		return 0;
	}
	private static int fullHouse() {
		if(triple() != 0 && onePair() != 0) {
			return triple() * 10 + onePair();
		}
		return 0;
	}
	private static int onePair() {
		int cnt[] = new int[10];
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 10; j++) {
				if(card[i][j]) {
					++cnt[j];
				}
			}
		}
		for (int i = 1; i < 10; i++) {
			if(cnt[i] == 2) {
				return i;
			}
		}
		return 0;
	}
	private static int triple() {
		int cnt[] = new int[10];
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 10; j++) {
				if(card[i][j]) {
					++cnt[j];
				}
			}
		}
		for (int i = 1; i < 10; i++) {
			if(cnt[i] == 3) {
				return i;
			}
		}
		return 0;
	}
	private static int fourCard() {
		int cnt[] = new int[10];
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 10; j++) {
				if(card[i][j]) {
					++cnt[j];
				}
			}
		}
		for (int i = 1; i < 10; i++) {
			if(cnt[i] == 4) {
				return i;
			}
		}
		return 0;
	}
	private static int straight() {
		boolean checked[] = new boolean[10];
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 10; j++) {
				if(card[i][j]) {
					checked[j] = true;
				}
			}
		}
		for (int i = 1; i <= 5; i++) {
			if(checked[i]) {
				for (int j = 0; j < 5; j++) {
					if(!checked[i+j]) {
						return 0;
					}
				}
				return i + 4;
			}
		}
		return 0;
	}
	private static int sameColor() {
		int cnt[] = new int[4];
		int max = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 10; j++) {
				if(card[i][j]) {
					++cnt[i];
				}
				max = Math.max(max, j);
			}
		}
		for (int i = 0; i < 4; i++) {
			if(cnt[i] == 5) {
				return max;
			}
		}
		return 0;
	}
}
