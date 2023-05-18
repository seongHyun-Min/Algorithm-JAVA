package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_5789 {
    static int T;
    static int N, Q;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            arr = new int[N + 1];
            for (int i = 1; i <= Q; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                for (int k = start; k <= end; k++) {
                    arr[k] = i;
                }
            }
            System.out.print("#" + t + " ");
            for(int i=1; i<=N; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }
}
