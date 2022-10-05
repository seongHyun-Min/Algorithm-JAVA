import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2206 {
    static int N, M; //행 렬
    static int[][] arr; //인접 리스트

    static int[][] dist; //거리 측정 배열
    static boolean[][][] visited; // 방문 리스트 3차원으로 선언 해줘야한다 그 이유는 벽을 부수는지 부수지 않는지 케이스 구분

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M][2];
        // visited[N][M][0] = 벽을 한번도 부수지 않은 경우의 방문 여부
        // visited[N][M][1] = 벽을 한번 부순 방문 배열 여부
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }
        // System.out.println(Arrays.deepToString(arr))
        if (N - 1 == 0 && M - 1 == 0) { //시작점과 출발점이 같다면 1 출력
            System.out.println(1);
            System.exit(0);
        }
        q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});

        while (!(q.isEmpty())) {
            int[] tmp = q.poll();
            // tmp = [0, 0, 0]

            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];

                if (x >= 0 && y >= 0 && x < N && y < M) { //ArrayIndex Out
                    if (arr[x][y] == 1) { // 벽이 존재 한다면
                        if (tmp[2] == 0 && !visited[x][y][1]) {
                            visited[x][y][tmp[2]] = true;
                            dist[x][y] = dist[tmp[0]][tmp[1]] + 1;
                            q.offer(new int[]{x, y, 1}); //벽한번 뚫음
                        }
                    } else { // else if arr[x][y] ==0 벽이 아닐 경우
                        if (!visited[x][y][tmp[2]]) {
                            visited[x][y][tmp[2]] = true;
                            dist[x][y] = dist[tmp[0]][tmp[1]] + 1;
                            q.offer(new int[]{x, y, tmp[2]});
                        }
                    }

                    if (x == N - 1 && y == M - 1) {
                        System.out.println(dist[x][y] +1);
                        System.exit(0);

                    }
                }
            }
        }
        System.out.println(-1);

    }
}