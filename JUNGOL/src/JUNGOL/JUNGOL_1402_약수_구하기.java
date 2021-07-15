package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1402_약수_구하기 {
	static int n, k, yak[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		k = stoi(st.nextToken());
		yak = new int[n];
		
		for (int i = 1, idx = 0; i <= n; i++) {
			if(n % i == 0) {
				yak[idx++] = i;
			}
		}
		
		System.out.println(yak[k-1]);
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
