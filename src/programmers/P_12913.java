package programmers;

public class P_12913 {
    int solution(int[][] land) {
        //전형적인 DP 문제 내려가기
        int answer = 0;
        int dp[][] = new int[land.length][4];
        //첫번째 땅 저장
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
            //기존에 있던 땅 저장
        }
        for (int i = 1; i < land.length; i++) {
            dp[i][0] = land[i][0] + Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][3]));
            //밑에서 내려오는 땅중 제일 최대값 + 자기자신
            dp[i][1] = land[i][1] + Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3]));
            dp[i][2] = land[i][2] + Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]));
            dp[i][3] = land[i][3] + Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
        }
        //동일한 문제지만 열의 개수가 4가 아닌 M으로 주어진다면 점화식을 이중 포문으로 구성후
        // for(int i=1; i <n; i++) {
        //   for(int j=0; j<M; j++) {
        //   int maxVal = 0;
        //    if(i != J) {
               // maxVal = Math.max(maxVal, dp[i-1],[k]); //자기자신을 제거한 최대 max값 계산
        // }
        // } 이 이후에 dp 값 계산
        //    dp[i][j] = land[i][j] + maxVal;

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return answer;
    }
}