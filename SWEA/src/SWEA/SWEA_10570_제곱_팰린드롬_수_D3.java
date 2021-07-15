package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10570_제곱_팰린드롬_수_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		StringTokenizer st;
		int A, B, cnt, compare;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			cnt = 0;
			for (int num = A; num <= B; num++) {
				for (int i = 1; i <= 32; i++) {
					if (i*i > num) break;
					if (i*i == num) {
						if(i >= 10 && i/10 != i%10) break;
						compare = 1;
						if(num >= 10 && num < 100 && num/10 != num%10) break;
						if(num >= 100 && num/100 != num%10) break;
						cnt++;
						break;
					}
				}
			}
			sb.append(cnt);
			System.out.println(sb);
			
		}
	}
}
