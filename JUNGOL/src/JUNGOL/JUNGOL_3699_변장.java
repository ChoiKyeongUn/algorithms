package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class JUNGOL_3699_변장 {

	static class Category {
		String category;
		int cnt;

		public Category(String category, int cnt) {
			this.category = category;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Category> list = new ArrayList<>();
		int TC = stoi(br.readLine());

		while (TC-- > 0) {
			list.clear();
			int N = stoi(br.readLine());
			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String temp = st.nextToken();
				boolean isExist = false;
				for (Category c : list) {
					if(c.category.equals(temp)) {
						isExist = true;
						++c.cnt;
						break;
					}
				}
				if(!isExist) {
					list.add(new Category(temp, 1));
				}
			}
			
			int size = list.size();
			int result = 1;
			
			for(Category c: list) {
				result *= c.cnt + 1;
			}
			System.out.println(result - 1);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
