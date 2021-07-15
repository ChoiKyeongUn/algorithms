package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1658_최대공약수와최소공배수 {
	static int n, m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		
		int left = n, right = m;
		while(left % right != 0) {
			int temp = right;
			right = left % right;
			left = temp;
		}
		
		System.out.println(right);
		System.out.println(n*m/right);
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
