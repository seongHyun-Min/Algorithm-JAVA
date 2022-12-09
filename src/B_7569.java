import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7569 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dz = {-1, 1};
    static int[][][] arr;
    static boolean[][][] visited;

    static Queue<int[]> q;
    static int M, N, H; // M:열 , N:행, H: 높이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N][M][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }

        visited = new boolean[N][M][H];
        q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k][i] == 1) {
                        q.offer(new int[]{j, k, i}); //익은 토마토 모두 삽입
                        visited[j][k][i] = true;
                    }
                }
            }
        }
        bfs();
        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k][i] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k][i] > max) {
                        max = arr[j][k][i];
                    }
                }
            }
        }

        if(max ==1){
            System.out.println(0);
        }else System.out.println( max-1);




    }
    public static void bfs(){
        //익은 토마토 모두 방문처리
        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int i=0; i<4; i++){
                int x = dx[i] +current[0];
                int y = dy[i] +current[1];
                if(x>=0 && x<N && y>=0 && y<M){
                    if(visited[x][y][current[2]]) continue;
                    visited[x][y][current[2]] =true;
                    if(arr[x][y][current[2]] ==0){
                        arr[x][y][current[2]] = arr[current[0]][current[1]][current[2]] +1;
                        q.offer(new int[]{x, y, current[2]});
                    }
                }
            }
            for(int i=0; i<2; i++){
                int z = dz[i] + current[2];
                if(z>=0 && z<H){
                    if(visited[current[0]][current[1]][z]) continue;
                    visited[current[0]][current[1]][z] = true;
                    if(arr[current[0]][current[1]][z] ==0){
                        arr[current[0]][current[1]][z] = arr[current[0]][current[1]][current[2]] +1;
                        q.offer(new int[]{current[0], current[1], z});
                    }
                }
            }
        }
    }
}
