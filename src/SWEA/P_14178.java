package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_14178 {
    static int T;
    static int N, D;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int count;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            int target = (D * 2) + 1;
            if (N % target == 0) {
                count = N / target;
            } else {
                count = (N / target) + 1;
            }
            System.out.println("#" + t + " " + count);
        }


    }
}
