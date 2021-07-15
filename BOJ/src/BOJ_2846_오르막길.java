import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2846_오르막길 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = stoi(st.nextToken());
		}
		
		int sum = 0, result = 0;
		
		for(int i = 0; i < N-1; i++) {
			if(num[i] < num[i+1]) sum += (num[i+1] - num[i]);
			
			else sum = 0;
			
			result = Math.max(result, sum);
		}
		System.out.println(result);
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
