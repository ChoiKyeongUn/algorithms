

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		K = K > N - K ? N - K : K;
		int mod = 10007;
		int ja = 1, mo = 1;
		for (int i = 0; i < K; i++) {
			ja = (ja * (N - i)) % mod;
			mo = (mo * (i + 1)) % mod;
		}
		int result = ja / mo;
		System.out.println(result);
	}
}
