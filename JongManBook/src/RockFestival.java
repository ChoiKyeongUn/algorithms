import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RockFestival {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[] price = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) price[i] = Integer.parseInt(st.nextToken());
			double res = Double.MAX_VALUE;
			for (int i = L; i <= N; i++) {
				for (int j = 0; j < N-i; j++) {
					double temp = 0.0;
					for (int j2 = 0; j2 < i; j2++) {
						temp += price[j+j2];
					}
					temp /= (double)(i);
					if(res > temp) res = temp;
				}
			}
			System.out.println(res);
		}
	}
}
