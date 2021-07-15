

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2480_주사위_세개 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		if(a==b && b==c) {
			System.out.println(10000+1000*a);
		} else if(a==b) {
			System.out.println(1000+100*a);
		} else if(b==c) {
			System.out.println(1000+100*b);
		} else if (a==c) {
			System.out.println(1000+100*c);
		} else {
			int max = a > b ? a > c ? a : c : b > c ? b : c;
			System.out.println(100*max);
		}
	}
}
