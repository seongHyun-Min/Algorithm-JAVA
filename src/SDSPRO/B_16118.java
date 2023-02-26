package SDSPRO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class B_11403 {
    static int[][] arr;
    static int N;

    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        result = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(arr[i][k] ==1 && arr[k][j] ==1){
                        arr[i][j] =1;
                    }

                    }
                }
            }


        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}