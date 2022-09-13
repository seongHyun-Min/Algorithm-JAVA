import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1743 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visitied;
    static int N; //행
    static int M; //열

    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visitied = new boolean[N][M];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) -1; //배열의 인덱스를 맞추기 위해 -1
            int y = Integer.parseInt(st.nextToken()) -1;
            arr[x][y] =1;
        }
        int max =0; // 음식물의 최대값
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] !=0 && visitied[i][j] ==false){
                    count =1;
                    max = Math.max(max, dfs(i,j));
                }
            }
        }
        System.out.println(max);

    }
    public static int dfs(int i, int j){
        visitied[i][j] = true;
        for(int k=0; k<4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x>=0 && y>= 0 && x<N && y<M){
                if(arr[x][y] !=0 && visitied[x][y] ==false){
                    count++;
                    dfs(x,y);
                }
            }
        }
        return count;
    }
}
