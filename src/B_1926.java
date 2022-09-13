import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1926 {
    static int[] dx ={1, 0, -1, 0};
    static int[] dy ={0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visitied;
    static int n; //행
    static int m; //열
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visitied = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max =0;
        int cnt =0; //그림의 갯수
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] !=0 && visitied[i][j] ==false){
                    count =1; //count 초기화
                    cnt++;
                    max = Math.max(max, bfs(i, j));

                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
    public static int bfs(int i, int j){
        visitied[i][j] =true;
        for(int k=0; k<4; k++){
            int x = i+ dx[k];
            int y = j +dy[k];
            if(x>=0 && y>=0 && x<n && y<m){
                if(arr[x][y] !=0 && visitied[x][y]== false){
                    count++;
                    bfs(x,y);
                }
            }
        }
        return count;
    }
}