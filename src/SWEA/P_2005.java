package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2005 {
    static int[][] arr;
    static int T;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            arr[0][0] = 1;

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j == 0 || j == N - 1) { //처음과 끝은 항상 1
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    }
                }
            }
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
