import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576 {
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;

    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};

    static Queue<int[]> q;

    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());  //열
        n = Integer.parseInt(st.nextToken()); //행
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        ////1이 하나라는 것을 관과한 코드
/*        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] ==1){
                    bfs(i, j);
                    break;
                }
            }
        }*/
        q = new LinkedList<>();
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] ==1){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        bfs();


        int max =0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    System.exit(0);
                }
                if(arr[i][j] > max){
                    max = arr[i][j];
                }
            }
        }
        if(max ==1){
            System.out.println(0);
        }else System.out.println(max -1);





    }
    public static void bfs(){
        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int i=0; i<4; i++){
                int X = dx[i] + current[0];
                int Y = dy[i] + current[1];
                if(X>=0 && X<n && Y>=0 && Y<m){
                    if(visited[X][Y]) continue;
                    visited[X][Y] =true;
                    if(arr[X][Y] ==0){
                        arr[X][Y] = arr[current[0]][current[1]] +1;
                        q.offer(new int[]{X, Y});
                    }
                }
            }
        }

    }
}