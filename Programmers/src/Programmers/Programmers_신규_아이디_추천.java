package Programmers;

import java.util.Arrays;

public class Programmers_신규_아이디_추천 {
	
	public static String Solution(String new_id) {
		String answer = "";
		
		new_id = new_id.toLowerCase();

		char[] arr = new_id.toCharArray();
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			char cur = arr[i];
			if((cur >= '0' && cur <= '9') || (cur >= 'a' && cur <= 'z')) {
				answer += cur;
				continue;
			}
			if(cur != '-' && cur != '_') {
				if(cur != '.') {
					continue;
				} else {
					if("".equals(answer)) answer += arr[i];
					else {
						if(answer.charAt(answer.length()-1) == '.') continue;
						else answer += cur;
					}
				}
			} else {
				answer += cur;
			}
		}
		

		
		if(answer.length() > 0 &&answer.charAt(0) == '.') answer = answer.substring(1, answer.length());
		if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);

		
		if("".equals(answer)) answer = "a";

		
		if(answer.length() >= 16) {
			answer = answer.substring(0, 15);
			while(true) {
				if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
				else break;
			}
		}

		char temp = answer.charAt(answer.length()-1);
		
		while(answer.length() < 3) {
			answer += temp;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(Solution(new_id));
	}
}
