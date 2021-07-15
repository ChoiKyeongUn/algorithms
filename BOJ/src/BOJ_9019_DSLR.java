

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR {
	static class Info {
		int num;
		String oper;
		public Info(int num, String oper) {
			this.num = num;
			this.oper = oper;
		}
		@Override
		public String toString() {
			return "Info [num=" + num + ", oper=" + oper + "]";
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			Queue<Info> queue = new LinkedList<Info>();
			boolean[] checked = new boolean[10000];
			
			queue.add(new Info(A, ""));
			checked[A] = true;
			char[] opers = {'D', 'S', 'L', 'R'};
			W:
			while(!queue.isEmpty()) {
				int queue_size = queue.size();
				for (int i = 0; i < queue_size; i++) {
					Info cur = queue.poll();
					int cur_num = cur.num;
					String cur_oper = cur.oper;
					if(cur_num == B) {
						System.out.println(cur_oper);
						break W;
					}
					int[] nextnum = new int[4];
					nextnum[0] = (cur_num*2)%10000;
					nextnum[1] = cur_num == 0 ? 9999 : cur_num-1;
					int th = cur_num/1000, h = (cur_num%1000)/100, t = (cur_num%100)/10, o = cur_num%10;
					nextnum[2] = h*1000+t*100+o*10+th;
					nextnum[3] = o*1000+th*100+h*10+t;
					for (int j = 0; j < 4; j++) {
						if(!checked[nextnum[j]]) {
							checked[nextnum[j]] = true;
							queue.add(new Info(nextnum[j], cur_oper+opers[j]));
						}
					}
				}
			}
		}
	}
}
