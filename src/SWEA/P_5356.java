package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_5356 {
    static char[][] arr;

    static int[][] isIn;
    static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            arr = new char[5][15];
            isIn = new int[5][15];
            String result = "";
            for (int i = 0; i < 5; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < tmp.length(); j++) {
                    arr[i][j] = tmp.charAt(j);
                    isIn[i][j] = 1;
                }
            }
            // input

            // 세로 출력
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    if (isIn[j][i] == 1) {
                        result += arr[j][i];
                    }
                }
            }
            System.out.println("#" + t + " " + result);
        }


    }
}
