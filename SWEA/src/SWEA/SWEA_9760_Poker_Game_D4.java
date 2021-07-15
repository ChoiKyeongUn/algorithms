package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9760_Poker_Game_D4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String result, card[];
	static int[] checked;
	
	public static void main(String[] args) throws Exception {
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			result = solve();
			saveResult(tc);
		}
		System.out.println(sb);
	}
	
	private static String solve() {
		
		makeArr();
		
		if(straight() && flush()) {
			return "Straight Flush";
		} else if(four()) {
			return "Four of a Kind";
		} else if(three() && one()) {
			return "Full House";
		} else if(flush()) {
			return "Flush";
		} else if(straight()) {
			return "Straight";
		} else if(three()) {
			return "Three of a kind";
		} else if(two()) {
			return "Two pair";
		} else if(one()) {
			return "One pair";
		} else {
			return "High card";
		}
	}

	private static boolean two() {
		int cnt = 0;
		for (int i = 0; i < 13; i++) {
			if(checked[i] == 2) {
				++cnt;
			}
		}
		if(cnt == 2) {
			return true;
		}
		return false;
	}

	private static boolean one() {
		for (int i = 0; i < 13; i++) {
			if(checked[i] == 2) {
				return true;
			}
		}
		return false;
	}

	private static boolean three() {
		for (int i = 0; i < 13; i++) {
			if(checked[i] == 3) {
				return true;
			}
		}
		return false;
	}

	private static void makeArr() {
		for (String str : card) {
			char temp = str.charAt(1);
			if(temp == 'A') {
				++checked[0];
				++checked[13];
			} else if(temp == 'T') {
				++checked[9];
			} else if(temp == 'J') {
				++checked[10];
			} else if(temp == 'Q') {
				++checked[11];
			} else if(temp == 'K') {
				++checked[12];
			} else {
				++checked[temp - '0' - 1];
			}
		}
	}

	private static boolean four() {
		for (int i = 0; i < 13; i++) {
			if(checked[i] == 4) {
				return true;
			}
		}
		return false;
	}

	private static boolean flush() {
		return (card[0].charAt(0) == card[1].charAt(0)) &&
			   (card[1].charAt(0) == card[2].charAt(0)) && 
			   (card[2].charAt(0) == card[3].charAt(0)) &&
			   (card[3].charAt(0) == card[4].charAt(0));
	}

	private static boolean straight() {	
		for (int i = 0; i < 10; i++) {
			boolean flag = true;
			for (int j = 0; j < 5; j++) {
				if(checked[i+j] == 0) {
					flag = false;
					break;
				}
			}
			if(flag) return true;
		}
		return false;
	}

	private static void saveResult(int tc) {
		sb.append("#").append(tc).append(" ").append(result).append("\n");
	}

	private static void input() throws Exception {
		card = new String[5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			card[i] = st.nextToken();
		}
		
		checked = new int[14];
		
		result = "";
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
