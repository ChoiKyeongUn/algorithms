

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	static int N, r, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int result = func(0, 1<<N, 0, 1<<N);
		System.out.println(result);
	}
	
	static int func(int startx, int endx, int starty, int endy) {
		
		if(endx - startx == 2 || endy - starty == 2) {
			r %= 2;
			c %= 2;
			return r*2+c;
		}
		
		int size = endx - startx;
		int temp = size*size/4;
		if (c >= startx && c < startx+size/2 && r >= starty && r < starty+size/2)
			return func(startx, startx+size/2, starty, starty+size/2);
		else if (c >= startx+size/2 && c < startx+size && r >= starty && r < starty+size/2)
			return func(startx+size/2, startx+size, starty, starty+size/2) + temp;
		else if (c >= startx && c < startx+size/2 && r >= starty+size/2 && r < starty+size)
			return func(startx, startx+size/2, starty+size/2, starty+size) + 2*temp;
		else
			return func(startx+size/2, startx+size, starty+size/2, starty+size) + 3*temp;
	}
}
