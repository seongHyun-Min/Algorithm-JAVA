import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13565 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visitied;
    static int N; //행5
    static int M; //열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visitied = new boolean[N][M];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(tmp.substring(j,j+1));
            }
        }
//        System.out.println(Arrays.deepToString(arr));

        for(int i=0; i<M; i++){ //0행의 모든열
            if(arr[0][i] ==0 && visitied[0][i] ==false){
                bfs(0, i); //outside에서만 전류를 보내(첫번째 행)
            }
        }
        String answer ="NO";
        for(int i=0; i<M; i++) { //M-1행의 모든열
            if (visitied[N - 1][i] == true){ //여기선 방문한 노드를 찾아야 하니까 true
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);
    }
    public static void bfs(int i, int j){
        visitied[i][j] =true;
        for(int k=0; k<4; k++){
            int x = i +dx[k];
            int y = j +dy[k];
            if(x>=0 && y>=0 && x<N && y<M){ //ArrayIndexOut
                if(arr[x][y] ==0 && visitied[x][y] ==false){
                    bfs(x, y);
                }
            }
        }
    }
}