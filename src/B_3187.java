import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3187 {
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static boolean[][] visitied;
    static int N; //세로 길이 (행)
    static int M; //열의 길이 (열)

    static int kCount; //양 카운트
    static int vCount; //늑대 카운트
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
        int totalVcount =0;
        int totalKcount =0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] !='#' &&visitied[i][j] ==false){
                    kCount=0; //카운트 초기화
                    vCount=0; //카운트 초기화
                    if(arr[i][j] =='k'){
                        kCount++;
                        dfs(i, j);
                    }else if(arr[i][j] == 'v'){
                        vCount++;
                        dfs(i, j);
                    }else dfs(i, j);

                    if(kCount >vCount){
                        totalKcount += kCount;
                    }else totalVcount +=vCount;
                }
            }
        }
        System.out.printf(totalKcount+" "+totalVcount);
    }
    public static void dfs(int i, int j){
        visitied[i][j] =true;
        for(int k=0; k<4; k++){
            int x = i +dx[k];
            int y = j +dy[k];
            if(x>=0 && y>=0 && x<N && y<M){
                if(arr[x][y] !='#' && visitied[x][y] ==false){
                    if(arr[x][y] =='v'){
                        vCount ++;
                        dfs(x,y);
                    }else if(arr[x][y] =='k'){
                        kCount++;
                        dfs(x,y);
                    }else dfs(x,y);
                }
            }
        }
    }
}
