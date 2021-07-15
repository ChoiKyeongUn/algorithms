package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4008_숫자_만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), N = 0, oper_cnt = 0, idx = 0, min = 0, max = 0, result = 0, tmp_num = 0, oper_num = 0;
		StringBuilder sb = new StringBuilder();
		// + - * /
		int[] oper = null, nums = null;
		StringTokenizer st = null;
		String temp = null;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			oper = new int[N-1];
			idx = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < 4; i++)	{
				oper_cnt = Integer.parseInt(st.nextToken());
				for (int j = 0; j < oper_cnt; j++) oper[idx++] = i;
			}
			
			nums = new int[N];
			temp = br.readLine();
			for (int i = 0, index = 0; i < N; i++, index+=2) nums[i] = temp.charAt(index) - '0';
			
			do {
				idx = 0;
				result = nums[0];
				for (int i = 1; i < N; i++) {
					tmp_num = nums[i];
					oper_num = oper[idx++];
					switch(oper_num) {
					case 0:
						result += tmp_num;
						break;
					case 1:
						result -= tmp_num;
						break;
					case 2:
						result *= tmp_num;
						break;
					case 3:
						result /= tmp_num;
						break;
					}
				}
				if(min > result) min = result;
				if(max < result) max = result;
			} while(np(oper, N-1));
			sb.append(max - min).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean np(int[] oper, int len) {
		int i = len - 1;
		while(i > 0 && oper[i-1] >= oper[i]) --i;
		if(i == 0) return false;
		
		int j = len - 1;
		while(oper[i-1] >= oper[j]) --j;
		swap(oper, i-1, j);
		
		int k = len - 1;
		while(i < k) swap(oper, i++, k--);
		
		return true;
	}

	private static void swap(int[] oper, int i, int j) {
		int temp = oper[i];
		oper[i] = oper[j];
		oper[j] = temp;
	}
}
