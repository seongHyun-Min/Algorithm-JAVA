import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14442 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, K;
    static int[][] arr;
    static boolean[][][] visited;
    static int[][] dist;

    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M][K + 1];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }
        if (N - 1 == 0 && M - 1 == 0) {
            System.out.println(1);
            System.exit(0);
        }
        q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});

        while (!(q.isEmpty())) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];
                if (x >= 0 && y >= 0 && x < N && y < M) { //ArrayIndexOut
                    if (arr[x][y] == 1) { //벽이면
                        if (tmp[2] < K && !visited[x][y][tmp[2]]) {
                            visited[x][y][tmp[2]] = true;
                            dist[x][y] = dist[tmp[0]][tmp[1]] + 1;
                            q.offer(new int[]{x, y, tmp[2] + 1}); //벽을 하나 통과할때마다 하나씩 올려줘
                        }
                    } else { //벽이 아니라면
                        if (!visited[x][y][tmp[2]]) {
                            visited[x][y][tmp[2]] = true;
                            dist[x][y] = dist[tmp[0]][tmp[1]] + 1;
                            q.offer(new int[]{x, y, tmp[2]}); // 벽을 통과하지 않았으니 올리지않은 그 상태로 큐에 삽입
                        }
                    }
                    if (x == N - 1 && y == M - 1) {
                        System.out.println(dist[x][y] + 1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
