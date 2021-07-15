package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {
	static int[] price_list = new int[4];
	static int[] months = new int[13];
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) { // TestCase 시작
			min = Integer.MAX_VALUE;	// 최소 금액 저장 (처음엔 정수의 최대치로 초기화)
			sb.append("#").append(tc).append(" ");
			
			// 이용요금과 월별 이용 계획 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) price_list[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) months[i] = Integer.parseInt(st.nextToken());
			
			// 각 월별로 총 세가지의 경우를 모두 탐색(dfs 이용)
			dfs(2, months[1]*price_list[0]); 	// 1. 해당하는 달을
			dfs(2, price_list[1]);
			dfs(4, price_list[2]);
			min = Math.min(min, price_list[3]);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	// month : 이번에 
	private static void dfs(int month, int price) {
		if(month > 12) {
			min = Math.min(min, price);
			return;
		}
		
		dfs(month+1, price+months[month]*price_list[0]);
		dfs(month+1, price+price_list[1]);
		dfs(month+3, price+price_list[2]);
	}
}
