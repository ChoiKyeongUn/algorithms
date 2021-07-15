import java.util.HashMap;
import java.util.Map;

public class test {
	static class Test {
		int y, x;
		public Test(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
	
	public static void main(String[] args) {
		Map<Test, Integer> map = new HashMap<Test, Integer>();
		map.put(new Test(0, 0), 1);
		System.out.println(map.get(new Test(0, 0)));
	}
}