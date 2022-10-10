import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16948 {
    public static int[] dx = {-2, -2, 0, 0, 2, 2};
    public static int[] dy = {-1, 1, -2, 2, -1, 1};
    public static int[][] arr;
    public static boolean[][] visited;
    public static int N;

    public static int r1, c1; //departures
    public static int r2, c2; //arrives

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r1, c1});
        visited[r1][c1] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int k = 0; k < 6; k++) {
                int x = tmp[0] + dx[k];
                int y = tmp[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (visited[x][y]) continue;
                    visited[x][y] = true;
                    arr[x][y] = arr[tmp[0]][tmp[1]] +1;
                    // depth를 배열 자체에 저장 시켜서 최단 경로 구하기
                    q.offer(new int[]{x, y});
                }
            }

        }
        if(arr[r2][c2] ==0){
            System.out.println(-1);
        }else System.out.println(arr[r2][c2]);



    }

}

