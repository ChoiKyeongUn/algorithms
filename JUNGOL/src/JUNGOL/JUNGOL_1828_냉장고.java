package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1828_냉장고 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] chems = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			chems[i][0] = Integer.parseInt(st.nextToken());
			chems[i][1] = Integer.parseInt(st.nextToken());
		}
		// 최고 온도가 낮은 순으로 정렬한 후,
		Arrays.sort(chems, (o1, o2) -> (o1[1] - o2[1]));
		// 냉장고 수를 하나로, 현재 최고온도를 첫 원소의 최고온도로 초기화
		int refri = 1;
		int high = chems[0][1];
		// 순서대로 순회하면서 최저 온도가 현재 최고온도보다 작은 경우 냉장고수 증가
		for (int i = 1; i < chems.length; i++)
			if (high < chems[i][0]) {
				high = chems[i][1];
				refri++;
			}
		System.out.println(refri);
	}
}
