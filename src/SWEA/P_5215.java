package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_5215 {
    //햄버거 다이어트
    static int T;
    static int N, L; //재료의 수 제한 칼로리
    static Burger[] burgers;
    static boolean[] visited;
    //그리디 알고리즘, 정렬로 풀 수 없음 , BFS 완전탐색
    static int result;
    //완전탐색으로 풀 경우 입력값이 커지면 시간초과 DP로 해결


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            burgers = new Burger[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int kal = Integer.parseInt(st.nextToken());
                burgers[i] = new Burger(score, kal);
            }
            result = Integer.MIN_VALUE;

            //완전탐색시 2^20승 N 입력값이 많으면 완전탐색 불가능
            BFS(0, 0);

            System.out.println("#" + t + " " + result);
        }

    }

    static void BFS(int start, int maxKal) {
        if (maxKal <= L) {
            int sum = 0;
            for (int i = 0; i < burgers.length; i++) {
                if (visited[i]) {
                    sum += burgers[i].score;
                }
            }
            result = Math.max(result, sum);
        } else {
            return;
        }
        for (int i = start; i < burgers.length; i++) {
            visited[i] = true;
            BFS(i + 1, maxKal + burgers[i].kal);
            visited[i] = false;
        }
    }

    static class Burger {
        int score;
        int kal;

        public Burger(int score, int kal) {
            this.score = score;
            this.kal = kal;
        }
    }
}
