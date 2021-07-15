package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JUNGOL_1697_큐 {
	public static void main(String[] args) throws Exception {
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		StringTokenizer st;
		
		Queue<Integer> queue = new LinkedList<>();
		
		while(n-- > 0) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "i":
				queue.offer(stoi(st.nextToken()));
				break;
			case "o":
				if(!queue.isEmpty()) {
					System.out.println(queue.poll());
				} else {
					System.out.println("empty");
				}
				break;
			default:
				System.out.println(queue.size());
			}
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
