

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_경비원 {
	static int width;
	static int height;
	static int N;
	static int[][] shops;
	static int dir, dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		shops = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			shops[i][0] = Integer.parseInt(st.nextToken());
			shops[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		dir = Integer.parseInt(st.nextToken());
		dist = Integer.parseInt(st.nextToken());
		int total = 0;
		for (int i = 0; i < N; i++) {
			total += getMinDistance(i);
		}
		System.out.println(total);
	}
	
	private static int getMinDistance(int i) {
		if(dir == shops[i][0]) return Math.abs(dist - shops[i][1]);
		
		switch(dir) {
		case 1:
			switch(shops[i][0]) {
			case 2: return height + Math.min(dist+shops[i][1], 2*width-dist-shops[i][1]);
			case 3: return dist+shops[i][1];		
			case 4:	return width - dist + shops[i][1];
			}
		case 2:
			switch(shops[i][0]) {
			case 1: return height + Math.min(dist+shops[i][1], 2*width - dist - shops[i][1]); 
			case 3: return dist + height - shops[i][1];
			case 4: return width - dist + height - shops[i][1];
			}
		case 3:
			switch(shops[i][0]) {
			case 1: return dist + shops[i][1];
			case 2: return height - dist + shops[i][1];
			case 4: return width + Math.min(dist+shops[i][1], 2*height - dist - shops[i][1]);
			}
		case 4:
			switch(shops[i][0]) {
			case 1: return dist + width - shops[i][1];
			case 2: return height - dist + width - shops[i][1];
			case 3: return width + Math.min(dist + shops[i][1], 2*height - dist - shops[i][1]);
			}
		}
		return 0;
	}

}
