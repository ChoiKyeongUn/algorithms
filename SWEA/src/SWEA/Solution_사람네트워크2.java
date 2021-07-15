package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_사람네트워크2 {

    static final int INF = 1000000;
    static int N, adjMatrix[][];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; ++t) {
            sb.append("#" + t + " ");
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            adjMatrix = new int[N][N];

            for (int i = 0; i < N; ++i) { // 입력시작
                for (int j = 0; j < N; ++j) {
                    adjMatrix[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && adjMatrix[i][j] == 0) {
                        adjMatrix[i][j] = INF;
                    }
                }
            } // 입력 끝
            for (int k = 0; k < N; ++k) {
                for (int i = 0; i < N; ++i) {
                    if(k==i) continue;
                    for (int j = 0; j < N; ++j) {
                        if(k==j || i==j) continue;
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                    }
                }
            }
            
//            for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(adjMatrix[i]));
//			}
            
            int min = INF;
            for (int i = 0; i < N; ++i) {
                int tmp = 0;
                for (int c : adjMatrix[i]) {
                    tmp += c;
                }
                min = Math.min(min, tmp);
            }
            sb.append(min + "\n");
        } // end of testcase
        System.out.println(sb.toString());
    } // end of main
} // end of Solution