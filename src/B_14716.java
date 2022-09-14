import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14716 {
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0 , -1, 1, -1, 1, -1};
    static int[][] arr;
    static boolean[][] visitied;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [N][M];
        visitied = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }// 배열생성완료
        }
        int count =0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 1  &&visitied[i][j] ==false){
                    count ++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);


    }
    public static void dfs(int i, int j){
        visitied[i][j] = true;
        for(int k=0; k<8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < N && y < M) {
                if (arr[x][y] == 1 && visitied[x][y] == false) {
                    dfs(x, y);
                }
            }
        }
    }
}