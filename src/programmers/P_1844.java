package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_1844 {


    public int solution(int[][] maps) {
        int answer = -1;
        //매우 쉬운 BFS
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Point> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new Point(0, 0, 1)); //시작할때 부터 1
        while (!q.isEmpty()) {
            Point current = q.poll();
            if (current.x == maps.length - 1 && current.y == maps[0].length - 1) {

                answer = current.count;
            }
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1) {
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, current.count + 1));
                }
            }
        }
        return answer;
    }

    class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
