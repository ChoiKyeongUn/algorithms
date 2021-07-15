package Programmers;

import java.util.Arrays;

public class Programmers_순위_검색 {
	
	static int[][][][][] score, prefix;
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150",
						 "python frontend senior chicken 210",
						 "python frontend senior chicken 150",
						 "cpp backend senior pizza 260",
						 "java backend junior chicken 80",
						 "python backend senior chicken 50"};
		
		String[] query = {"java and backend and junior and pizza 100",
						  "python and frontend and senior and chicken 200",
						  "cpp and - and senior and pizza 250",
						  "- and backend and senior and - 150",
						  "- and - and - and chicken 100",
						  "- and - and - and - 150"};
		
		System.out.println(Arrays.toString(solution(info, query)));
	}

	private static int[] solution(String[] info, String[] query) {
		int size = query.length;
		int[] answer = new int[size];
		
		score = new int[4][3][3][3][100001];
		prefix = new int[4][3][3][3][100001];
		
		for (String in: info) {
			String[] div = in.split(" ");
			int idx1 = 0, idx2 = 0, idx3 = 0, idx4 = 0;
			int score = Integer.parseInt(div[4]);
			
			if(div[0].equals("java")) idx1 = 1;
			else if(div[0].equals("python")) idx1 = 2;
			
			if(div[1].equals("frontend")) idx2 = 1;
			
			if(div[2].equals("senior")) idx3 = 1;
			
			if(div[3].equals("pizza")) idx4 = 1;
			
			increase(idx1, idx2, idx3, idx4, score);
			prefix();
		}
		
		for (int i = 0; i < size; i++) {
			String[] div = query[i].split(" ");
			String lang = div[0];
			String tech = div[2];
			String type = div[4];
			String food = div[6];
			int sc = Integer.parseInt(div[7]);
			int idx1 = 0, idx2 = 0, idx3 = 0, idx4 = 0;
			if(lang.equals("java")) idx1 = 1;
			else if(lang.equals("python")) idx1 = 2;
			else if(lang.equals("-")) idx1 = 3;
			
			if(tech.equals("frontend")) idx2 = 1;
			else if(tech.equals("-")) idx2 = 2;
			
			if(type.equals("senior")) idx3 = 1;
			else if(type.equals("-")) idx3 = 2;
			
			if(food.equals("pizza")) idx4 = 1;
			else if(food.equals("-")) idx4 = 2;
			
			answer[i] = prefix[idx1][idx2][idx3][idx4][100000];
			if(sc != 0) {
				answer[i] -= prefix[idx1][idx2][idx3][idx4][sc-1];
			}
		}
		return answer;
	}

	private static void prefix() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					for (int k = 0; k < 3; k++) {
						prefix[i][j][j2][k][0] = score[i][j][j2][k][0];
					}
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					for (int k = 0; k < 3; k++) {
						for (int k2 = 1; k2 <= 100000; k2++) {
							prefix[i][j][j2][k][k2] = prefix[i][j][j2][k][k2-1] + score[i][j][j2][k][k2];
						}
					}
				}
			}
		}
	}

	private static void increase(int idx1, int idx2, int idx3, int idx4, int s) {
		++score[idx1][idx2][idx3][idx4][s];
		++score[3][idx2][idx3][idx4][s];
		++score[idx1][2][idx3][idx4][s];
		++score[idx1][idx2][2][idx4][s];
		++score[idx1][idx2][idx3][2][s];
		++score[3][2][idx3][idx4][s];
		++score[3][idx2][2][idx4][s];
		++score[3][idx2][idx3][2][s];
		++score[idx1][2][2][idx4][s];
		++score[idx1][2][idx3][2][s];
		++score[idx1][idx2][2][2][s];
		++score[3][2][2][idx4][s];
		++score[3][2][idx3][2][s];
		++score[3][idx2][2][2][s];
		++score[idx1][2][2][2][s];
		++score[3][2][2][2][s];
	}
}
