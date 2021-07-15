package Programmers;

import java.util.Stack;

public class Programmers_크레인_인형뽑기_게임 {
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		int len = board.length;
		Stack<Integer> stack = new Stack<Integer>();
		for (int move : moves) {
			--move;
			for (int i = 0; i < len; i++) {
				int value = board[i][move];
				if(value != 0) {
					if(!stack.isEmpty() && stack.peek() == value) {
						answer += 2;
						stack.pop();
						
					} else {
						stack.push(value);
					}
					board[i][move] = 0;
					break;
				}
			}
			
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] board = { {0, 0, 0, 0, 0},
						  {0, 0, 1, 0, 3},
						  {0, 2, 5, 0, 1},
						  {4, 2, 4, 4, 2},
						  {3, 5, 1, 3, 1} };
		
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		
		System.out.println(solution(board, moves));
	}
}
