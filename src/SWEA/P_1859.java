package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백만 장자 프로젝트 D2
// 뒤에서 부터  max값 보다 작으면 항상 이익
//  max값이 크면 max 값 갱신

public class P_1859 {
    static int T;
    static int N;
    static long profit;
    static int[] price;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            price = new int[N];
            st = new StringTokenizer(br.readLine());
            profit = 0;
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (price[i] > max) {
                    //max값이 갱신
                    max = price[i];
                } else {
                    //max 값이 아니라면 무조건 이익
                    profit += max - price[i];
                }
            }

            System.out.println("#" + t + " " + profit);
        }
    }
}