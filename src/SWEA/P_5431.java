package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_5431 {
    static int T;

    static boolean[] submit;
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            submit = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < S; i++) {
                int num = Integer.parseInt(st.nextToken());
                submit[num] = true;
            }
            System.out.print("#" + t + " ");
            for(int i=1; i<=N; i++){
                if(!submit[i]){
                    System.out.print(i + " ");
                }
                System.out.println();

            }
        }


    }
}
