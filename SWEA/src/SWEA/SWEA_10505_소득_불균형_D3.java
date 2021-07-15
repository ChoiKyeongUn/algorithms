package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10505_소득_불균형_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), N, sum, cnt;
		double avg;
		int[] incomes;
		StringTokenizer st;
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			incomes = new int[N];
			st = new StringTokenizer(br.readLine());
			sum = 0;
			for (int i = 0; i < N; i++) {
				incomes[i] = Integer.parseInt(st.nextToken());
				sum += incomes[i];
			}
			avg = (double)(sum) / N;
			cnt = 0;
			for (int i = 0; i < N; i++) if(incomes[i] <= avg) cnt++;
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(cnt);
			System.out.println(sb);
		}
	}
}
