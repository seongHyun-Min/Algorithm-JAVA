import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2589 {
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static char[][] arr;
    static boolean[][] visited;
    static int[][] dist; //거리배열 생성 dfs마다 생성??
    //거리 배열에서 또 최대값을 뽑아야해 ...
    static int N, M;
    static int answer = 0;

    static Queue<int[]> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = tmp.charAt(j);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 'L'){
                    answer = Math.max(answer, dfs(i, j));
                }
            }
        }
        System.out.println(answer);


    }
    public static int dfs(int i, int j){
        int max =0;
        visited = new boolean[N][M];
        dist = new int[N][M];
        visited[i][j] =true;
        q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int k=0; k<4; k++){
                int x = dx[k] + current[0];
                int y = dy[k] + current[1];
                if(x>=0 && x<N && y>=0 && y<M){
                    if(visited[x][y]) continue;
                    visited[x][y] =true;
                    if(arr[x][y] =='L'){
                        dist[x][y] = dist[current[0]][current[1]] +1;
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }
        for(int x=0; x<N; x++){
            for(int y=0; y<M; y++){
                max = Math.max(max, dist[x][y]);
            }
        }
        return max;
    }
}
