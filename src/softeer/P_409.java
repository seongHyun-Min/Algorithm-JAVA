package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class P_409 {
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> q;
    static int count; //BFS 호출 횟수
    static ArrayList<Integer> arr; //BFS시 방문 배열 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }
        count = 0;
        arr = new ArrayList<>();
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    //BFS 실행
                    count++;
                    arr.add(BFS(i, j)); //방문횟수 리턴
                }
            }
        }
        Collections.sort(arr);
        System.out.println(count);
        for(int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }

    static int BFS(int x, int y) {

        q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Point current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] ==1) {
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] =true;
                        count++;
                    }
                }
            }
        }
        return count;

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
}
