package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class JUNGOL_1314_문자사각형2 {
	static int n;
	 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        char[][] arr = new char[n][n];
        char cur = 'A';
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    arr[j][i] = cur;
                    cur++;
                    if(cur > 'Z') cur = 'A';
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    arr[j][i] = cur;
                    cur++;
                    if(cur > 'Z') cur = 'A';
                }
            }
        }
         
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
         
    }
 
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
