package programmers;

public class P_87946 {
    static boolean[] visited;
    static int result;

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        result = 0;
        DFS(k, dungeons);
        return result;
    }

    public static void DFS(int k, int[][] dungeons) {
        // 1 2 3  //모든 경우의수를 탐색해야돼 최대 8개 8!
        // 1 3 2
        // 2 1 3
        // 2 3 1
        // 3 2 1
        // 3 1 2
        boolean isVisitedAll = true;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {//처음에 방문 하지 않았고 최소 필요도보다 작다면 방문
                visited[i] = true;
                DFS(k - dungeons[i][1], dungeons);
                visited[i] = false;
                isVisitedAll = false;
                //DFS함수가 더이상 for문을 돌지 않으면 isVisitedALl =ture
            }
        }
        if (isVisitedAll) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sum++;
                }
            }
            result = Math.max(result, sum);
        }
    }
}
