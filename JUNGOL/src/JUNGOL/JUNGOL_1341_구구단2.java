package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class JUNGOL_1341_구구단2 {
    static int s, e;
    static boolean flag;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = stoi(st.nextToken());
        e = stoi(st.nextToken());
 
        if (s < e) {
            flag = true;
        } else {
            flag = false;
        }
 
        print(s);
    }
 
    private static void print(int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.printf("%d * %d = %2d   ", num, i*3+j, num*(i*3+j));
            }
            System.out.println();
        }
         
        if(num == e) {
            return;
        } else {
            System.out.println();
            if(flag) {
                print(num + 1);
            } else {
                print(num - 1);
            }
        }
    }
 
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}