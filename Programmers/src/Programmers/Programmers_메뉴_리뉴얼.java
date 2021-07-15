package Programmers;

public class Programmers_메뉴_리뉴얼 {
	
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course1 = {2,3,4};
		// result = { "AC", "ACDE", "BCFG", "CDE" }
		System.out.println(solution(orders1, course1));
		
		String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course2 = {2,3,5};
		// result = { "ACD", "AD", "ADE", "CD", "XYZ" }
		System.out.println(solution(orders2, course2));
		
		String[] orders3 = {"XYZ", "XWY", "WXA"};
		int[] course3 = {2,3,4};
		// result = { "WX", "XY" }
		System.out.println(solution(orders3, course3));
	}
}
