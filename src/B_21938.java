import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_21938 {
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visitied;
    static int N; //행
    static int M; //열

    static int T; //평균치??
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visitied = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int red = Integer.parseInt(st.nextToken());
                int green = Integer.parseInt(st.nextToken());
                int blue = Integer.parseInt(st.nextToken());
                arr[i][j] = (red +green + blue) /3;
                }
            }

        T = Integer.parseInt(br.readLine());
        int count =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] >=T && visitied[i][j] ==false){
                    count ++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);

    }
    public static void dfs(int i, int j) {
        visitied[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < N && y < M) {
                if (arr[x][y] >= T && visitied[x][y] == false) {
                    dfs(x, y);
                }
            }
        }
    }
}
