import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2468 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0 ,-1};
    static int[][] arr;
    static boolean[][] visitied;
    static int N; //배열의 행 열
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;
        int maxHigh =0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                maxHigh = Math.max(maxHigh,tmp);
            }
        }//배열넣기
        // System.out.println(Arrays.deepToString(arr)); //배열 입력 테스트 코드
        ArrayList<Integer> max = new ArrayList<>();
        for(int i=0; i<=maxHigh; i++){ //높이에 따른 dfs갯수 확인
            int count =0;
            int high = i;
            visitied = new boolean[N][N]; //방문 배열 초기화
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(arr[j][k] >high && visitied[j][k] ==false){
                        count ++;
                        dfs(j ,k, high);
                    }
                }
            }
            max.add(count);
        }
        Collections.sort(max, Collections.reverseOrder());
        System.out.println(max.get(0));
    }
    public static void dfs(int i, int j, int high){
        visitied[i][j] =true;
        for(int k=0; k<4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >=0 && y>=0 && x<N && y<N){
                if(arr[x][y] >high && visitied[x][y] ==false){
                    dfs(x, y, high);
                }

            }
        }
    }

}
