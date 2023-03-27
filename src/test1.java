import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test1 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -0, 1};
    static boolean[][] visited;
    static int[][] graph;

    static Count[][] count;

    static int N, M, R, C;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            sum = 0;
            graph = new int[N + 1][M + 1];
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < M; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            count = new Count[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    count[i][j] = new Count();
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (graph[i][j] == 1){
                        if ( (i == 1 && j == 1) || (i == N  && j == M ) ) continue;
                        sum += (Math.abs(C - j) + Math.abs(R- i));
                    }
                }
                shortPath();
                System.out.println("#" + t + " " + count[N][M].count + " " + (sum - count[N][M].bread));
            }
        }
    }

    public static void shortPath() {
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[N + 1][M + 1];
        visited[1][1] = true;
        queue.offer(new Node(1, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = dr[i] + node.x;
                int y = dc[i] + node.y;

                if (x < 1 || x > N || y < 1 || y > M) continue;
                if (graph[x][y] == 1 || (x == N  && y == M)) {
                    int next1 = count[node.x][node.y].count + 1;
                    int next2 = count[node.x][node.y].bread + (x == N  && y == M  ? 0 : (Math.abs(C - y) + Math.abs(R- x)));
                    if (!visited[x][y]) {
                        count[x][y] = new Count(next1, next2);
                        visited[x][y] = true;
                        queue.offer(new Node(x, y));
                    } else if (visited[x][y]) {
                        if (next1 < count[x][y].count) {
                            count[x][y] = new Count(next1, next2);
                            queue.offer(new Node(x, y));
                        }
                    }

                }
            }

        }
    }
static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y =y;
        }
}


static class Count {
    int count;
    int bread;

    public Count(){};

    public Count(int count, int bread) {
        this.count = count;
        this.bread = bread;

    }
}
}
