package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_3282 {

    static int T;
    static int N, K;
    static int[][] dp;
    //N번쨰 물건까지 고려했을떄 부피 K까지 담았을떄 최대 가치 저장
    static Knapsack[] knapsack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            dp = new int[N + 1][K + 1];
            knapsack = new Knapsack[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int weight = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                knapsack[i] = new Knapsack(weight, price);
            }
            //dp 시작
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= K; j++) {
                    if (knapsack[i].weight <= j) {
                        //물건을 담을수 있다면
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - knapsack[i].weight] + knapsack[i].price);
                    }else{
                        dp[i][j] = dp[i-1][j]; //못담으면 이전과 같은 배열로 생성
                    }
                }
            }
            System.out.println("#" + t + " " + dp[N][K]);


        }
    }

    static class Knapsack {
        int weight;
        int price;


        public Knapsack(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}