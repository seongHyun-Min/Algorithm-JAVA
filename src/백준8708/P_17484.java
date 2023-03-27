package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//브루스포스
public class P_17484 {

    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static int[][] arr;
    static int N, M;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = Integer.MAX_VALUE;
        for(int i=0; i<M; i++){
            DFS(0, i, 0, 4);
        }
        System.out.println(result);
    }

    static void DFS(int x, int y, int weight, int direction){
        weight += arr[x][y];
        if(x ==N-1){
            result = Math.min(weight, result);
        }else{
            for(int i=0; i<3; i++){
                if(direction == i) continue;
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >=0 && nx<N && ny>=0 && ny<M){
                    DFS(nx, ny, weight, i);
                }
            }
        }
    }

}
