package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11048 {
    static int N, M;
    static int[][] arr;
    static int[][] dp;

    //우 , 하, 우+하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        //input
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //dp O(NM)
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                //1,1에서 부터 N , M까지 가는 최대 값을 dp 에저장
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + arr[i][j];
                //dp[1][1] = max(dp[0][1] , dp[1][0] , dp[0][0]) + arr[1][1] // 초기값은 max 값이 전부 0 = arr[1][1]
                //dp[1][2] = max(dp[0][2], dp[1][1], dp[0][1]) + arr[1][2] // dp[1][2]의 최대값은 [1][2]가 될수 있는 수
                //arr[0][2] , arr[1][1], arr[0][1] 에서 만 arr[1][2]로 올수 있기 때문

            }
        }
        System.out.println(dp[N][M]);

    }
}

/* 완전탐색 O(3^NM) 시간초과
    static void DFS(int x, int y, int count) {
        count += arr[x][y];
        if (x == N - 1 && y == M - 1) {
            result = Math.max(result, count);
        } else {
            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    DFS(nx, ny, count);
                }
            }
        }
    }

 */

