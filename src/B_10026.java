import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B_10026 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static boolean[][] visited;
    static int N;

    static Queue<int[]> q;

    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = tmp.charAt(j);
            }
        }
        int count = 0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]) {
                    dfs(i, j);
                    count ++;
                }
            }
        }
        System.out.print(count+ " ");


        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'R') {
                    arr[i][j] = 'G';
                }
            }
        }

        int acount =0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]) {
                    dfs(i, j);
                    acount ++;
                }
            }
        }
        System.out.print(acount);


    }
    public static void dfs(int i, int j){
        q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[] {i, j});
        char color = arr[i][j];

        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int k=0; k<4; k++){
                int x = dx[k] + current[0];
                int y = dy[k] + current[1];
                if(x>=0&& x<N && y>=0 && y<N){
                    if(arr[x][y] ==color && !visited[x][y]){
                        visited[x][y] = true;
                        q.offer(new int[]{x, y});
                    }
                }
            }

        }
    }
}
