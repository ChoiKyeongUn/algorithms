package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class SWEA_5648_원자_소멸_시뮬레이션 {
	static class Atom {
		double x, y;
		int dir, energy;
		public Atom(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}
		@Override
		public String toString() {
			return "Atom [x=" + x + ", y=" + y + ", dir=" + dir + ", energy=" + energy + "]";
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			Atom[] atoms = new Atom[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				atoms[i] = new Atom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			boolean[] checked = new boolean[N];
			for (int i = 0; i < 4005; i++) {
				for (int j = 0; j < N; j++) {
					if(checked[j]) continue;
					switch(atoms[j].dir) {
					case 0: atoms[j].y += 0.5; break;
					case 1: atoms[j].y -= 0.5; break;
					case 2: atoms[j].x -= 0.5; break;
					case 3: atoms[j].x += 0.5; break;
					}
				}
				for (int j = 0; j < N-1; j++) {
					if(checked[j]) continue;
					double cur_y = atoms[j].y;
					double cur_x = atoms[j].x;
					int cur_energy = atoms[j].energy;
					boolean flag = false;
					for (int j2 = i+1; j2 < N; j2++) {
						if(checked[j2]) continue;
						double ny = atoms[j2].y;
						double nx = atoms[j2].x;
						int nenergy = atoms[j2].energy;
						if(cur_y == ny && cur_x == nx) {
							flag = true;
							checked[j2] = true;
							result += nenergy;
						}
					}
					if(flag) result += cur_energy;
				}
			}
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}
