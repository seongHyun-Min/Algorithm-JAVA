import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_4485 {
    static class point implements Comparable<point>{
        int x, y, weight;

        public point(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(point o) {
            return this.weight - o.weight;
        }
    }
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1 ,0};
    static int[][] arr; //리스트
    static int[][] dist; // 거리 리스트
    static boolean[][] visited; //방문 리스트

    static int N; // 행렬

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt =0;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            arr = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dijkstra();
            cnt++;
            System.out.printf("Problem %d: " +dist[N-1][N-1] +"\n", cnt);

        }
    }
    public static void dijkstra(){
        PriorityQueue<point> pq = new PriorityQueue<point>();
        dist[0][0] = arr[0][0];
        pq.offer(new point(0, 0, dist[0][0]));

        while(!pq.isEmpty()){
            point current = pq.poll();


            for(int i=0; i<4; i++){
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                if(x>=0 && y>=0 && x<N && y<N){
                    if(visited[x][y]) continue;
                    visited[x][y] = true;
                    if(dist[x][y] > dist[current.x][current.y] + arr[x][y]){
                        dist[x][y] =dist[current.x][current.y] + arr[x][y];
                        pq.offer(new point(x, y, dist[x][y]));
                    }

                }
            }
        }
    }
}
