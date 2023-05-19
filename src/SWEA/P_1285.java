package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1285 {
    static int T;
    static int N;
    static int[] arr;
    static int count;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;
            count = 0;
            for (int i = 0; i < N; i++) {
                min = Math.min(Math.abs(arr[i]), min);
            }
            for (int i = 0; i < N; i++) {
                if (Math.abs(arr[i]) == min) count++;
            }
            System.out.println("#" + t + " " + min + " " + count);
        }


    }
}
