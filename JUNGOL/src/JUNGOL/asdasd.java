package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class asdasd {
	static int N;
	static int input[][];
	static int result = 0;
	static int maxCore = 0;
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static List<int[]> core;
	static void connect(int depth,int cnt,int length) {
	//	System.out.println(depth);
	//	print();
		if(depth == core.size()) {
			if(cnt > maxCore) {
				maxCore = cnt;
				result = length;
			}else if(cnt == maxCore) {
				result = Math.min(result, length);
			}
		}else {
			int[] now = core.get(depth);
			int nowValue = 100 + depth;
			if(now[0] == 0 || now[0] == N-1 || now[1] == 0 || now[1] == N-1) {
				connect(depth+1,cnt+1,length);
				return;
			}
			connect(depth+1,cnt,length);
			for(int i = 0 ; i < 4; i++) {
				int tempLength = 0;
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				boolean cando = true;
				while(nx>=0 && nx < N && ny >= 0 && ny < N) {
					if(input[ny][nx] == 0) {
						tempLength++;
						input[ny][nx] = nowValue;
					}else{
						cando = false;
						break;
					}
					ny+=dy[i];
					nx+=dx[i];
				}

				if(cando) {
					connect(depth+1,cnt+1,length + tempLength);
				}
				ny = now[0] + dy[i];
				nx = now[1] + dx[i];
				while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(input[ny][nx] == nowValue) {
						input[ny][nx] = 0;
					}
					ny+=dy[i];
					nx+=dx[i];
				}
				
			}
		}
	}
	static void print() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.printf("%4d " ,input[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T ; t++) {
			result = 0;
			maxCore = 0;
			core = new ArrayList<>();
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			input = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < N ; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
					if(input[i][j] == 1) {
						core.add(new int[] {i,j});
					}
				}
			}
			connect(0,0,0);
			System.out.println("#"+t+" "+result);
		}
	}
}