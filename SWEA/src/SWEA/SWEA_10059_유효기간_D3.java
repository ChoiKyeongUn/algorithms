package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10059_유효기간_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), cnt;
		String date, first_two, last_two;
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			date = br.readLine();
			first_two = date.substring(0, 2);
			last_two = date.substring(2, 4);
			cnt = 0;
			if ((first_two.charAt(0) == '0' && first_two.charAt(1) != '0') || (first_two.charAt(0) == '1' && (first_two.charAt(1) == '0' || first_two.charAt(1) == '1' || first_two.charAt(1) == '2')))
				cnt++;
			if ((last_two.charAt(0) == '0' && last_two.charAt(1) != '0') || (last_two.charAt(0) == '1' && (last_two.charAt(1) == '0' || last_two.charAt(1) == '1' || last_two.charAt(1) == '2')))
				cnt += 10;
			switch(cnt) {
			case 1:
				sb.append("MMYY");
				break;
			case 10:
				sb.append("YYMM");
				break;
			case 11:
				sb.append("AMBIGUOUS");
				break;
			case 0:
				sb.append("NA");
				break;
			}
			System.out.println(sb);
		}
	}
}
