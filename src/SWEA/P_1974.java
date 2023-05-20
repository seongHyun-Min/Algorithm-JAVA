package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1974 {

    static int T;
    static int[][] arr = new int[9][9];
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                result = 1; //초기 result = 1
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //행 먼저검사
            for (int i = 0; i < 9; i++) {
                visited = new boolean[10];
                if (result == 0) break;
                for (int j = 0; j < 9; j++) {
                    visited[arr[i][j]] = true;
                }
                //검사
                for (int j = 1; j <= 9; j++) {
                    //중복이 있다면 어느 곳에서 분명히 false가 발생
                    if (!visited[j]) {
                        result = 0;
                    }
                }
            }
            //열 검사
            for (int i = 0; i < 9; i++) {
                visited = new boolean[10];
                if (result == 0) break;
                for (int j = 0; j < 9; j++) {
                    visited[arr[j][i]] = true;
                }
                //검사
                for (int j = 1; j <= 9; j++) {
                    //중복이 있다면 어느 곳에서 분명히 false가 발생
                    if (!visited[j]) {
                        result = 0;
                    }
                }
            }
            //3 바이 3 검사
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    visited = new boolean[10];
                    if (result == 0) break;
                    for (int r = i; r < i + 3; r++) {
                        for (int c = j; c < j + 3; c++) {
                            visited[arr[r][c]] = true;
                        }
                    }
                    //검사
                    for (int k = 1; k <= 9; k++) {
                        //중복이 있다면 어느 곳에서 분명히 false가 발생
                        if (!visited[k]) {
                            result = 0;
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
