import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_21736 {
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static boolean[][] visitied;
    static int N; //행
    static int M; //열
    static int count; // P친구만나는수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visitied = new boolean[N][M];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = tmp.charAt(j);
            }
        }
        //System.out.println(Arrays.deepToString(arr));
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] =='I'){
                     dfs(i,j);

                }
            }
        }
        if(count >0){
            System.out.println(count);
        }else System.out.println("TT");
    }
    public static void dfs(int i, int j){
        visitied[i][j] =true;
        for(int k=0; k<4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x<N && y<M){
                if((arr[x][y] =='O' || arr[x][y] =='P') && visitied[x][y] ==false){
                    if(arr[x][y] =='P') count++;
                    dfs(x, y);
                }

            }
        }
    }
}