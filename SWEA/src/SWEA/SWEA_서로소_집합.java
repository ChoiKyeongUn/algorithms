package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_서로소_집합 {
    static int N;
    static int M;
    static int[] parents;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N+1];
            makeSet();
            StringBuilder inSb = new StringBuilder();
             
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int oper = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                 
                switch(oper) {
                case 0:
                    union(a, b);
                    break;
                default:
                    int aRoot = findSet(a);
                    int bRoot = findSet(b);
                    if(aRoot == bRoot) inSb.append(1);
                    else inSb.append(0);
                }
            }
             
            sb.append(inSb).append("\n");
        }
        System.out.println(sb);
    }
     
    static void makeSet() {
        for (int i = 0; i < N; i++) parents[i] = i;
    }
     
    static int findSet(int n) {
        if(n == parents[n]) return n;
        return parents[n] = findSet(parents[n]);
    }
     
    static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return;
         
        parents[bRoot] = aRoot;
    }
}