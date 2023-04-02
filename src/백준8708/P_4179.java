package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_4179 {
    static int N, M;
    static char[][] arr;
    static boolean[][] visitedJ;
    static boolean[][] visitedF;
    static Queue<Point> jihun;
    static Queue<Point> fire;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int result;
    //지훈이와 불은 벽이 있는 공간은 통과하지 못함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visitedJ = new boolean[N][M];
        visitedF = new boolean[N][M];
        jihun = new LinkedList<>();
        fire = new LinkedList<>();

        //input
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp.charAt(j);
                if (arr[i][j] == 'J') {
                    jihun.offer(new Point(i, j, 0));
                    visitedJ[i][j] = true;
                } else if (arr[i][j] == 'F') {
                    fire.offer(new Point(i, j, 0));
                    visitedF[i][j] = true;
                }
            }
        }
        result = Integer.MAX_VALUE;
        BFS();
        if (result == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }

    }

    static void BFS() {

        while (!jihun.isEmpty() || !fire.isEmpty()) {

            int Fsize = fire.size();
            for (int i = 0; i < Fsize; i++) {
                Point current = fire.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (visitedF[nx][ny] || arr[nx][ny] == '#') continue;
                    visitedF[nx][ny] = true;
                    arr[nx][ny] = 'F';
                    fire.offer(new Point(nx, ny, current.time + 1));
                }
            }
            int jSize = jihun.size();
            for (int i = 0; i < jSize; i++) {
                Point current = jihun.poll();
                if (current.x == 0 || current.y == 0 || current.x == N - 1 || current.y == M - 1) {
                    result = Math.min(result, current.time + 1);
                }
                for (int j = 0; j < 4; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (visitedJ[nx][ny] || arr[nx][ny] != '.') continue;
                    visitedJ[nx][ny] = true;
                    arr[nx][ny] = 'J';
                    jihun.offer(new Point(nx, ny, current.time + 1));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;

        }
    }

}