

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2605_줄_세우기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] students = new int[N];
		for (int i = 0; i < N; i++) students[i] = i+1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int paper = Integer.parseInt(st.nextToken());
			for (int j = 0; j < paper; j++) {
				int temp = students[i-j];
				students[i-j] = students[i-j-1];
				students[i-j-1] = temp;
			}
		}
		for (int i = 0; i < N; i++) System.out.print(students[i]+" ");
	}
}
