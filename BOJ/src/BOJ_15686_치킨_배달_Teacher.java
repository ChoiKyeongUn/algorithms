

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15686_치킨_배달_Teacher {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 도시 정보 (지도)
		int[][] city = new int[N][N];
		// 집들의 위치(좌표)
		int[][] house;
		// 치킨집들의 위치(좌표)
		int[][] chicken;
		// 각각 집의 개수와 치킨집의 개수
		int house_cnt = 0, chicken_cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				// 현재 위치가 집일때는 집의 개수 증가, 치킨집일때는 치킨집의 개수 증가
				if (city[i][j] == 1)
					house_cnt++;
				if (city[i][j] == 2)
					chicken_cnt++;
			}
		}
		// 구한 집의 개수와 치킨 집의 개수만큼의 크기를 갖는 house, chicken 배열 생성
		house = new int[house_cnt][2];
		chicken = new int[chicken_cnt][2];
		// idx1, 2 : 0부터 시작해서 집과 치킨집의 좌표를 저장하기 위해 house와 chicken의 인덱스로 사용
		int idx1 = 0, idx2 = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				// 현재 위치가 집이면 house에 좌표를 저장하고, idx1 증가
				if (city[i][j] == 1) {
					house[idx1][0] = i;
					house[idx1][1] = j;
					idx1++;
				}
				// 현재 위치가 치킨집이면 chicken에 좌표를 저장하고, idx2 증가
				if (city[i][j] == 2) {
					chicken[idx2][0] = i;
					chicken[idx2][1] = j;
					idx2++;
				}
			}
		// NextPermutation을 이용해서 치킨집을 M개 만큼 뽑기 위해 사용할 배열 
		int[] for_comb = new int[chicken_cnt];
		// for_comb의 끝에서부터 M개만큼 1로 바꿔줌 (가장 작은 순열로 만들기 위해)
		for (int i = 0; i < M; i++)
			for_comb[chicken_cnt-1-i] = 1;
		
		// min : 최종결과(도시의 치킨거리의 최소값), temp : 한 집에서 여러 치킨집들과 비교할 때 그 치킨집과의 거리를 저장, inner_min : 한 집과 여러 치킨집들과의 거리들 중 가장 작은 거리
		// sum : 각 집들의 최소 치킨 거리의 합
		int min = Integer.MAX_VALUE, temp, inner_min, sum;
		
		do {
			sum = 0;
			for (int i = 0; i < house_cnt; i++) {
				inner_min = Integer.MAX_VALUE;
				for (int j = 0; j < chicken_cnt; j++) {
					if(for_comb[j] == 1) {
						temp = Math.abs(house[i][1] - chicken[j][1]) + Math.abs(house[i][0] - chicken[j][0]);
						if (temp < inner_min) inner_min = temp;
					}
				}
				sum += inner_min;
			}
			if (sum < min) min = sum;
		} while(np(for_comb, chicken_cnt));
		System.out.println(min);
	}
	
	static void print2darr(int[][] arr, int size) {
		System.out.println("================================");
		for (int i = 0; i < size; i++) System.out.println(Arrays.toString(arr[i]));
		System.out.println("================================");
	}
	
	static boolean np(int[] arr, int size) {
		int i = size-1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		if(i == 0) return false;
		
		int j = size-1;
		while(arr[i-1] >= arr[j]) --j;
		swap(arr, i-1, j);
		
		int k = size-1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
